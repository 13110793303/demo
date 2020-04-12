package com.cq.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "soaconfig")
public class SoaConfig {
    private String soaUrl;
    private String soaCharset;
    private int soaTimeOut;

    public String getSoaUrl() {
        return soaUrl;
    }

    public void setSoaUrl(String soaUrl) {
        this.soaUrl = soaUrl;
    }

    public String getSoaCharset() {
        return soaCharset;
    }

    public void setSoaCharset(String soaCharset) {
        this.soaCharset = soaCharset;
    }

    public int getSoaTimeOut() {
        return soaTimeOut;
    }

    public void setSoaTimeOut(int soaTimeOut) {
        this.soaTimeOut = soaTimeOut;
    }

}
