package me.example.test.service;

public interface NotifyService {
    /**
     * 短信通知
     */
    void sms(String msg);
    /**
     * 钉钉通知
     */
    void dingding(String msg);
    /**
     * 微信通知
     */
    void wechat(String msg);
    /**
     * 邮件通知
     */
    void email(String msg);
}
