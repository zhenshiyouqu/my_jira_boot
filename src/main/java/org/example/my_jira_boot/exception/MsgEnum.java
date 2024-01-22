package org.example.my_jira_boot.exception;

import org.springframework.http.HttpStatus;

public enum MsgEnum {

    SUCCESS(HttpStatus.OK, "200", "成功", "成功"),
    FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "500", "失败", "失败"),
    LOGIN_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "500", "登录失败", "登录失败"),
    REGISTER_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "500", "注册失败", "注册失败"),
    USER_NOT_EXIST(HttpStatus.INTERNAL_SERVER_ERROR, "500", "用户不存在", "用户不存在"),
    USER_EXIST(HttpStatus.INTERNAL_SERVER_ERROR, "500", "用户已存在", "用户已存在"),
    USER_PASSWORD_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500", "密码错误", "密码错误"),
    USER_PASSWORD_NOT_SAME(HttpStatus.INTERNAL_SERVER_ERROR, "500", "两次密码不一致", "两次密码不一致"),
    USER_PASSWORD_NOT_NULL(HttpStatus.INTERNAL_SERVER_ERROR, "500", "密码不能为空", "密码不能为空"),
    USER_PASSWORD_NOT_NULL_OR_EMPTY(HttpStatus.INTERNAL_SERVER_ERROR, "500", "密码不能为空或空串", "密码不能为空或空串"),
    TOKEN_GET_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500", "token错误", "token错误"),
    USER_INSERT_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500", "用户插入失败", "用户插入失败"),
    USER_EXIST_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500", "用户已存在", "用户已存在");
    private MsgEnum(HttpStatus httpStatus, String code, String msg, String desc) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.msg = msg;
        this.desc = desc;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getDesc() {
        return this.desc;
    }

    final private HttpStatus httpStatus; // http 状态码
    final private String code; // 业务返回码
    final private String msg;  // 返回信息（给用户看）
    final private String desc; // 返回信息（给开发看）

}
