package com.cq.demo.common.core;

/**
 * @Description 登录接口封装对象
 * @Author chen
 * @Date 2020/1/1 23:07
 **/
public class LoginBean {

    private String account;
    private String password;
    private String captcha;

    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getCaptcha() {
        return captcha;
    }
    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
