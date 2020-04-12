package com.cq.demo.filter;


import com.cq.demo.util.MapUtil;
import com.cq.demo.util.StringUtil;
import com.cq.demo.util.YmlUtil;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ChengYangChang
 */
public class HttpUtil {
    private static final String ALLOWED_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_.!~*'()";

    /**
     * IP
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

    /**
     * 请求参数
     */
    public static Map<String, Object> getRequestParams(HttpServletRequest request) {
        Enumeration<String> paramNames = request.getParameterNames();
        Map<String, Object> returnMap = new HashMap<>();
        while (true) {
            String paramName;
            do {
                if (!paramNames.hasMoreElements()) {
                    return returnMap;
                }
                paramName = paramNames.nextElement();
            } while (paramName.equals("properties"));
            String[] strArray = paramName.split("\\.");
            String[] paramValue = request.getParameterValues(paramName);
            String value = null;
            for (String str : paramValue) {
                if (StringUtil.isNull(value)) {
                    value = str;
                } else {
                    value = value + "," + str;
                }
            }
            if (strArray.length > 1) {
                Map<String, Object> tempMap = new HashMap();
                if (returnMap.get(strArray[0]) != null) {
                    tempMap = (Map<String, Object>) returnMap.get(strArray[0]);
                }
                if (MapUtil.mapIsNotNull(tempMap)) {
                    tempMap.put(strArray[1], value);
                }
                returnMap.put(strArray[0], tempMap);
            } else {
                returnMap.put(paramName, value);
            }
        }
    }

    /**
     * GET
     */
    public static String doGet(String strUrl) {
        String responseJSON = "";
        CloseableHttpClient httpclient = HttpClients.createDefault();// 创建默认的httpClient实例.
        try {
            URL url = new URL(strUrl);
            URI realurl = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);
            HttpGet httpget = new HttpGet(realurl);// 创建httpget
            //log.info("执行get请求:{}", httpget.getURI());

            CloseableHttpResponse clientResponse = httpclient.execute(httpget);
            HttpEntity entity = clientResponse.getEntity();
            if (entity != null) {
                responseJSON = EntityUtils.toString(entity, "UTF-8");
                //log.info("执行get响应:{}", responseJSON);

                return responseJSON;
            }
        } catch (Exception e) {
            // log.error("Exception", e);
        } finally {
            try {
                httpclient.close();
            } catch (Exception e) {
                // log.error("Exception", e);// 关闭连接,释放资源
            }
        }
        return responseJSON;
    }

    /**
     * POST
     */
    public static String doPost(String url, List<NameValuePair> formParams) {
        String responseJSON = "";
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30000).build();// 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.custom().setDefaultRequestConfig(requestConfig).build();
        HttpPost httppost = new HttpPost(url);// 创建httppost
        UrlEncodedFormEntity uefEntity;
        try {
            uefEntity = new UrlEncodedFormEntity(formParams, "UTF-8");
            httppost.setEntity(uefEntity);
            //log.info("执行post请求:{},参数:{}", httppost.getURI(), formParams);

            CloseableHttpResponse clientResponse = httpclient.execute(httppost);
            HttpEntity entity = clientResponse.getEntity();
            if (entity != null) {
                responseJSON = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (Exception e) {
            //log.error("Exception", e);
        } finally {
            try {
                httpclient.close();// 关闭连接,释放资源
            } catch (Exception e) {
                // log.error("Exception", e);
            }
        }
        //log.info("执行post响应:{}", responseJSON);

        return responseJSON;
    }

    public static String doSoaPost(String classPath, String jsonParams) {
        HttpClient client = new HttpClient();
        int TIME_OUT = YmlUtil.getSoaTimeOut();// 超时时间，单位毫秒
        client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, YmlUtil.getSoaCharset());// 设置字符集
        client.getHttpConnectionManager().getParams().setSoTimeout(TIME_OUT);// 设置超时时间

        InputStream responseStream = null;
        BufferedReader rd;
        //"YmlUtil.getSoaUrl()";
        String url = "http://10.210.1.33:8618" + "/SOAServer/callFunctionAction";
        PostMethod post = new PostMethod(url);
        post.addParameter("interface_id", classPath);// interface_id底层类路径
        post.addParameter("condition", jsonParams);// 接口条件
        String returnContent = "";// 返回信息  json格式的字符串
        try {
            int status = client.executeMethod(post);// 执行结果状态
            responseStream = post.getResponseBodyAsStream();
            rd = new BufferedReader(new InputStreamReader(responseStream, "GBK"));
            returnContent = rd.readLine();
            System.out.println("值：" + returnContent);
        } catch (Exception e) {
            // log.error("Exception", e);
        } finally {
            try {
                post.releaseConnection();//关闭资源
                if (responseStream != null) {
                    responseStream.close();
                }
            } catch (Exception e) {
                // log.error("Exception", e);
            }
        }
        return returnContent;
    }

    /**
     * 编码
     */
    public static String encodeURIComponent(String input) {
        if (input == null || "".equals(input)) {
            return input;
        }
        int l = input.length();
        StringBuilder o = new StringBuilder(l * 3);
        for (int i = 0; i < l; i++) {
            String e = input.substring(i, i + 1);
            if (!ALLOWED_CHARS.contains(e)) {
                byte[] b = e.getBytes(StandardCharsets.UTF_8);
                o.append(getHex(b));
                continue;
            }
            o.append(e);
        }
        return o.toString();
    }

    /**
     * 解码
     */
    public static String decodeURIComponent(String encodedURI) {
        char actualChar;
        StringBuilder buffer = new StringBuilder();
        int bytePattern, sumb = 0;
        for (int i = 0, more = -1; i < encodedURI.length(); i++) {
            actualChar = encodedURI.charAt(i);
            switch (actualChar) {
                case '%': {
                    actualChar = encodedURI.charAt(++i);
                    int hb = (Character.isDigit(actualChar) ? actualChar - '0' : 10 + Character.toLowerCase(actualChar) - 'a') & 0xF;
                    actualChar = encodedURI.charAt(++i);
                    int lb = (Character.isDigit(actualChar) ? actualChar - '0' : 10 + Character.toLowerCase(actualChar) - 'a') & 0xF;
                    bytePattern = (hb << 4) | lb;
                    break;
                }
                case '+': {
                    bytePattern = ' ';
                    break;
                }
                default: {
                    bytePattern = actualChar;
                }
            }
            if ((bytePattern & 0xc0) == 0x80) { // 10xxxxxx
                sumb = (sumb << 6) | (bytePattern & 0x3f);
                if (--more == 0)
                    buffer.append((char) sumb);
            } else if ((bytePattern & 0x80) == 0x00) { // 0xxxxxxx
                buffer.append((char) bytePattern);
            } else if ((bytePattern & 0xe0) == 0xc0) { // 110xxxxx
                sumb = bytePattern & 0x1f;
                more = 1;
            } else if ((bytePattern & 0xf0) == 0xe0) { // 1110xxxx
                sumb = bytePattern & 0x0f;
                more = 2;
            } else if ((bytePattern & 0xf8) == 0xf0) { // 11110xxx
                sumb = bytePattern & 0x07;
                more = 3;
            } else if ((bytePattern & 0xfc) == 0xf8) { // 111110xx
                sumb = bytePattern & 0x03;
                more = 4;
            } else { // 1111110x
                sumb = bytePattern & 0x01;
                more = 5;
            }
        }
        return buffer.toString();
    }

    private static String getHex(byte[] buf) {
        StringBuilder o = new StringBuilder(buf.length * 3);
        for (byte b : buf) {
            int n = (int) b & 0xff;
            o.append("%");
            if (n < 0x10) {
                o.append("0");
            }
            o.append(Long.toString(n, 16).toUpperCase());
        }
        return o.toString();
    }

    public static boolean validateUri(String uriRule, String validateUri) {
        if (StringUtil.isNotNull(uriRule) && StringUtil.isNotNull(validateUri)) {
            uriRule = parseUrl(uriRule);
            validateUri = parseUrl(validateUri);
            if (uriRule.equals(validateUri)) {
                return true;
            }
            char[] strsc = uriRule.toCharArray();
            char[] strc = validateUri.toCharArray();
            int cl = strc.length;
            int scl = strsc.length;
            int cli = 0;
            int i = 0;
            boolean next = false;
            boolean prOk = false;
            for (int ni = 0; i < scl; ++i) {
                char n = strsc[i];
                char bn = strc[cli];
                if (n == '*') {
                    if (!prOk) {
                        return false;
                    }
                    if (i == scl - 1) {
                        return true;
                    }
                    ni = i;
                    next = true;
                    prOk = false;
                } else {
                    if (!(prOk = bn == n) && !next) {
                        return false;
                    }
                    if (next && !prOk) {
                        i = ni;
                    }
                    ++cli;
                    if (cli >= cl) {
                        return prOk && i + 1 == scl;
                    }
                }
            }
            return prOk && cli == cl;
        } else {
            return false;
        }
    }

    private static String parseUrl(String url) {
        if (null != url && url.trim().length() != 0) {
            String[] ps = url.split("/");
            StringBuilder sb = new StringBuilder();
            for (String p : ps) {
                if (StringUtil.isNotNull(p.trim())) {
                    sb.append("/").append(p);
                }
            }
            if (StringUtil.isNull(sb)) {
                return "";
            } else {
                return sb.toString();
            }
        } else {
            return "";
        }
    }

}
