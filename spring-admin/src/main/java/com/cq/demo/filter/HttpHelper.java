package com.cq.demo.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

@Slf4j
public class HttpHelper {
    public static String getBodyString(HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            // Map<String, Object> company = HttpUtil.getRequestParams(request);
            String charType = "UTF-8";
            inputStream = request.getInputStream();
            // log.info("开始转换" + charType + ":" + inputStream.toString());
            reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName(charType)));
            //log.info("转换" + charType + "后:" + reader.toString());
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        log.info("post参数:" + sb.toString());
        return sb.toString();
    }
}