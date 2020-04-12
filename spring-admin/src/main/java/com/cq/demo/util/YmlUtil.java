package com.cq.demo.util;


import com.cq.demo.config.SoaConfig;
import com.cq.demo.config.SysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ChengYangChang
 */
@Component
public class YmlUtil {
    private static SoaConfig iSoaConfig;

    public static String getSoaUrl() {
        return iSoaConfig.getSoaUrl();
    }

    public static String getSoaCharset() {
        return iSoaConfig.getSoaCharset();
    }

    public static int getSoaTimeOut() {
        return iSoaConfig.getSoaTimeOut();
    }

    @Autowired
    public void setSoaConfig(SoaConfig soaConfig) {
        iSoaConfig = soaConfig;
    }

    public static Map<String, Map<String, Object>> userMap = new HashMap<>();

    private static SysConfig iSysConfig;

    public static int getTokenTime() {
        return iSysConfig.getTokenTime();
    }

    public static boolean isSwaggerEnable() {
        return iSysConfig.isSwaggerEnable();
    }

    public static List<String> getNoFilterUrl() {
        return iSysConfig.getNoFilterUrl();
    }

    public static String getUploadFileUrl() {
        return iSysConfig.getUploadFileUrl();
    }

    @Autowired
    public void setSystemConfig(SysConfig sysConfig) {
        iSysConfig = sysConfig;
    }
}
