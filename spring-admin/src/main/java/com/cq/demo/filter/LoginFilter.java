package com.cq.demo.filter;

import com.alibaba.fastjson.JSONObject;
import com.cq.demo.config.BaseConfig;
import com.cq.demo.controller.BaseController;
import lombok.extern.slf4j.Slf4j;

import javax.security.auth.login.LoginException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Author: CQ
 */
@Slf4j
public class LoginFilter extends BaseController implements javax.servlet.Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            String requestUri = httpRequest.getRequestURI();
            ServletRequest requestWrapper = null;
            if (request instanceof HttpServletRequest) {
                requestWrapper = new RequestReaderHttpServletRequestWrapper((HttpServletRequest) request);
            }

            //获取请求中的流如何，将取出来的字符串，再次转换成流，然后把它放入到新request对象中。
            // 在chain.doFiler方法中传递新的request对象

            log.info("======== 请求开始-[URL : {}]，[IP : {}] ========", requestUri, getIpAddress(httpRequest));
            log.info("get请求参数：" + getRequestParams(httpRequest));
            // requestWrapper = new RequestWrapper((HttpServletRequest) request);
            log.info("pos请求参数：" + requestWrapper.getInputStream());
            log.info(httpRequest.getHeader("Content-Type"));
            log.info("getCharacterEncoding:" + requestWrapper.getCharacterEncoding());
            // 不过滤类型
            if (requestUri.matches(".*(js|css|woff|woff2|html|ico|eot|svg|ttf|map|txt|exe|jpg|jpeg|png|bmp|gif|doc|docx|xls|xlsx|ppt|pdf)")) {
                log.info("requestWrapper值：" + requestWrapper);
                if (requestWrapper == null) {
                    chain.doFilter(request, response);
                } else {
                    chain.doFilter(requestWrapper, response);
                }
                return;
            }
            boolean needFilter = true;
            /*List<String> list = YmlUtil.getNoFilterUrl();
            for (String s : list) {
                if (HttpUtil.validateUri(s, requestUri)) {
                    needFilter = false;
                    break;
                }
            }*/
            if (needFilter) {
                //String token = httpRequest.getHeader(BaseConfig.TOKEN);
                //LoginService loginService = (LoginService) SpringUtil.getBean("loginServiceImpl");
                try {
                    if (1 == 1) {
                        // loginService.checkToken(token);
                    } else {
                        throw new LoginException(BaseConfig.USER_NULL);
                    }
                } catch (LoginException e) {
                    log.info("======== 被拦截-[URL : {}]，[IP : {}] ========", requestUri, getIpAddress(httpRequest));

                    //YmlUtil.userMap.remove(token);

                    JSONObject json = new JSONObject();
                    json.put("success", false);
                    json.put("code", BaseConfig.CODE_FAIL_USER);
                    json.put("message", BaseConfig.USER_NULL);

                    httpResponse.setCharacterEncoding("UTF-8");
                    httpResponse.setContentType("application/json; charset=utf-8");
                    PrintWriter writer = httpResponse.getWriter();
                    writer.write(json.toJSONString());
                    writer.flush();
                    return;
                }
            }
            if (requestWrapper == null) {
                chain.doFilter(request, response);
            } else {
                chain.doFilter(requestWrapper, response);
            }
        } catch (Exception e) {
            log.info("Exception", e);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

}
