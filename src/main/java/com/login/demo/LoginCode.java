package com.login.demo;

public enum LoginCode {
    LOGIN_SUCCESS("50001","登录成功"),
    USERNAME_NOTFOUND("50002","用户名不存在"),
    PASSWORD_NOTFOUND("50003","密码错误"),
    PASSWORD_CHANGE_SUCCESS("51001","密码修改成功");
    private String status;
    private String message;

    LoginCode(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "STATUS='" + status + '\'' +
                ", MSG='" + message;
    }
}
