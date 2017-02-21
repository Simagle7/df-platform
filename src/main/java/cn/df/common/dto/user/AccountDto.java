package cn.df.common.dto.user;

/**
 * Created by 郭旭辉 on 2016/3/22.
 * 用户信息dto
 */
public class AccountDto {
    private String uid;   //uid
    private String username; //账号
    private String password; //密码
    private String salt;        //加密盐
    private String token;   //数字签名
    private Integer userType; //当前身份

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}
