package com.cq.demo.controller;


import com.cq.demo.config.BaseConfig;
import com.cq.demo.config.BaseResult;
import com.cq.demo.filter.HttpUtil;
import com.cq.demo.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: CQ
 */
@Slf4j
public class BaseController {

    /**
     * 公共异常处理
     */
    protected BaseResult handleException(Exception e) {
        if (e instanceof LoginException) {
            return loginJson(e.getMessage());
        } else if (e instanceof Exception) {
            return msgJson(e.getMessage());
        } else {
            log.error("Exception", e);

            return msgJson(e.getMessage());
        }
    }

    // -------- HttpUtil --------
    protected String getIpAddress(HttpServletRequest request) {
        return HttpUtil.getIpAddress(request);
    }

    protected Map<String, Object> getRequestParams(HttpServletRequest request) {
        return HttpUtil.getRequestParams(request);
    }

    private BaseResult loginJson(String msg) {
        return JsonUtil.failJson(BaseConfig.CODE_FAIL_USER, msg);
    }

    protected BaseResult msgJson(String msg) {
        return JsonUtil.failJson(BaseConfig.CODE_FAIL, msg);
    }
}
