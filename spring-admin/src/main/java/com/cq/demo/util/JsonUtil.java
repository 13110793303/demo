package com.cq.demo.util;


import com.cq.demo.config.BaseResult;

/**
 * @Author: ChengYangChang
 */
public class JsonUtil {

    /**
     * 失败
     */
    public static BaseResult failJson(int code, String msg) {
        BaseResult resultObj = new BaseResult();
        resultObj.setSuccess(false);
        resultObj.setCode(code);
        resultObj.setMessage(msg);
        return resultObj;
    }

    /**
     * 成功
     */
    public static BaseResult successJson(int code, String msg) {
        BaseResult resultObj = new BaseResult();
        resultObj.setSuccess(true);
        resultObj.setCode(code);
        resultObj.setMessage(msg);
        return resultObj;
    }

    /**
     * 成功
     */
    public static <T> BaseResult<T> successJson(int code, String msg, T data) {
        BaseResult<T> resultObj = new BaseResult<>();
        resultObj.setSuccess(true);
        resultObj.setCode(code);
        resultObj.setData(data);
        resultObj.setMessage(msg);
        return resultObj;
    }

}
