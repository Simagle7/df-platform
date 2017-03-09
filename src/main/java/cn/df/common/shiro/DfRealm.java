package cn.df.common.shiro;

import cn.df.common.dto.user.AccountDto;
import cn.df.common.exception.BizException;
import cn.df.common.utils.base.DataStatusEnum;
import cn.df.common.utils.base.ERRORCODE;
import cn.df.dao.auth.IAuthOperationDAO;
import cn.df.domain.auth.AuthOperation;
import cn.df.domain.user.User;
import cn.df.param.auth.AuthOperationParam;
import cn.df.param.user.UserParam;
import cn.df.service.auth.IAuthRoleService;
import cn.df.service.user.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 郭旭辉 on 2016/8/9.
 * 自定义realm
 */
public class DfRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;
    @Autowired
    private IAuthRoleService authRoleService;
    @Autowired
    private IAuthOperationDAO authOperationDAO;


    //设置realm的名称
    @Override
    public void setName(String name) {
        super.setName("customRealm");
    }

    //用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //从PrincipalCollection获取用户身份信息
//        User currentUser = (User) principals.getPrimaryPrincipal();
//
//        //从session中获取当前的用户信息
        AccountDto currentUser = (AccountDto) SecurityUtils.getSubject().getSession().getAttribute("CURRENTUSER");
//

//        //从数据库中获取到权限数据
        List<AuthOperation> authOperations = null;
        if(authRoleService.isSuper(currentUser.getUid())){
            authOperations = authOperationDAO.findList(AuthOperationParam.F_Status, DataStatusEnum.ENABLED, null, null);
        }else {
            authOperations = authOperationDAO.queryOperationsByUser(currentUser.getUid(),currentUser.getRoleCode() , null, null);
        }
        List<String> permission = new ArrayList<>();
       if(authOperations.size() > 0){
           for (AuthOperation authOperation: authOperations){
               permission.add(authOperation.getAuthCode());
           }
       }else{
           throw new BizException(ERRORCODE.AUTH_INSUFFICIENT.getCode(), ERRORCODE.AUTH_INSUFFICIENT.getMessage());
       }
        //查到权限数据，返回，授权信息
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //将查询到的授权信息填充到SimpleAuthorizationInfo中
//        simpleAuthorizationInfo.addStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    /**
     * 权限认证器
     * @param token  token
     * @return  返回，认证标识
     * @throws AuthenticationException  认证异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        User user = (User) userService.findOne(UserParam.F_Username, username);
        AccountDto currentUser;
        if (user != null){
            currentUser = new AccountDto();
            currentUser.setUid(user.getCode());
            currentUser.setUsername(user.getUsername());
            // 认证
            return new SimpleAuthenticationInfo(currentUser, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), this.getName());
        }
        return null;
    }

    /**
     * 清除认证
     * @param principal 认证字段
     */
    public void clearCachedAuthorizationInfo(String principal) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
        clearCachedAuthorizationInfo(principals);
    }

    /**
     * 清除缓存--此方法应该在修改权限的service中调用
     */
    public void clearCahced() {
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principalCollection);
    }
}
