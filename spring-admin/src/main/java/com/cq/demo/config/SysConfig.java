package com.cq.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: ChengYangChang
 */
@Component
@ConfigurationProperties(prefix = "sysconfig")
public class SysConfig {
    private int tokenTime;// token时效（小时）
    private boolean swaggerEnable;// 接口文档开关
    private List<String> noFilterUrl;// 不过滤地址
    private String uploadFileUrl;// 附件上传地址

    public int getTokenTime() {
        return tokenTime;
    }

    public void setTokenTime(int tokenTime) {
        this.tokenTime = tokenTime;
    }

    public boolean isSwaggerEnable() {
        return swaggerEnable;
    }

    public void setSwaggerEnable(boolean swaggerEnable) {
        this.swaggerEnable = swaggerEnable;
    }

    public List<String> getNoFilterUrl() {
        return noFilterUrl;
    }

    public void setNoFilterUrl(List<String> noFilterUrl) {
        this.noFilterUrl = noFilterUrl;
    }

    public String getUploadFileUrl() {
        return uploadFileUrl;
    }

    public void setUploadFileUrl(String uploadFileUrl) {
        this.uploadFileUrl = uploadFileUrl;
    }

}
