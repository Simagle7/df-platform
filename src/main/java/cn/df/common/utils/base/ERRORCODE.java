package cn.df.common.utils.base;

/**
 * Created by 郭旭辉 on 2016/3/16.
 */
public enum ERRORCODE {
    /**
     * 参数异常
     */
    ILLEGAL_LOGIN("0100000","登录超时"),
    QUERYJSON_ISNULL("0100001", "查询参数为空"),
    PARAM_ISERROR("0100002", "参数错误"),
    PARAM_ISNULL("0100003", "参数不能为空"),
    PARAM_ISTOLONG("0100004", "参数长度超过限制"),
    OPERATION_FAIL("0100005", "操作失败"),
    RESULT_ISNULL("0100006", "查询结果为空"),
    ACCOUNT_ILLEGAL("0100007","账号不合法"),
    ACCOUNT_PASSWD_UNMATCH("0100008","账号密码不正确"),
    SENDSMS_FAILED("0100009","验证码发送失败"),
    ACCOUNT_EXISTS("0100010","用户已存在"),
    ACCOUNT_NOT_ACTIVE("0100011","当前账号还未激活"),
    VERIFIEDCODE_ILLEGAL("0100012","该验证码不合法"),
    TOKEN_INVALID("0100013", "凭证已过期"),
    GET_VERIFYCODE_FAILED("0100014", "获取验证码失败"),
    DEFAULT_ROLE_EXIST("0100015", "默认角色已存在"),
    ROLE_EXIST("0100016", "角色已存在"),
    REPEAT_CODE("0100017", "代码已存在"),
    MODULE_NOT_EXIST("0100018", "模块不存在"),
    INITIAL_EXC("0100019", "初始化异常"),
    AUTH_INSUFFICIENT("0100020", "权限不足"),
    MODULEURL_EXIST("0100021", "模块地址已存在"),
    ENABLE_EXC("0100022", "启用异常"),
    OPERATION_EXIST("0100023", "操作已存在"),
    AUTHCODE_EXIST("0100024", "权限代码已存在")
    ;

    /**
     * 操作码
     */
    private final String code;
    /**
     * 信息内容
     */
    private final String message;

    /**
     * 单例话操作码
     * @param code
     * @param message
     */
    private ERRORCODE(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取操作码
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * 获取信息内容
     * @return
     */
    public String getMessage() {
        return message;
    }
}
