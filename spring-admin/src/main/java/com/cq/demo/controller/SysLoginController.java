package com.cq.demo.controller;

import com.cq.demo.common.core.LoginBean;
import com.cq.demo.common.core.http.HttpResult;
import com.cq.demo.entity.SysUser;
import com.cq.demo.security.JwtAuthenticatioToken;
import com.cq.demo.service.SysUserService;
import com.cq.demo.util.IOUtils;
import com.cq.demo.util.PasswordUtils;
import com.cq.demo.util.SecurityUtils;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * <p>
 * 登录控制器
 * </p>
 *
 * @author chenqu
 * @since 2019-12-28
 */
@Slf4j
@RestController
public class SysLoginController {

    @Autowired
    private Producer producer;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 生成图片数字/字母验证码
     *
     * @param response
     * @param request
     */
    @GetMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
        log.info("进入方法体：" + request + response);
        //禁止图像缓存。
        response.setHeader("Cache-Control", "no-store,no-cache");
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        log.info("producer值：" + producer);
        //生成文字验证码
        String text = producer.createText();
        log.info("text值：" + text);
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        log.info("image值：" + image);
        //保存验证码到 session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        log.info("request.getSession()：" + request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY));
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 登录接口
     *
     * @param loginBean
     * @param request
     * @return
     */
    @PostMapping(value = "/login")
    public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) throws IOException {
        String username = loginBean.getAccount();
        String password = loginBean.getPassword();
        String captcha = loginBean.getCaptcha();

        // 从session中获取之前保存的验证码跟前台传来的验证码进行匹配
        Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (kaptcha == null) {
            return HttpResult.error("验证码已失效");
        }
        if (!captcha.equals(kaptcha)) {
            return HttpResult.error("验证码不正确");
        }
        // 用户信息
        SysUser user = sysUserService.findByName(username);
        // 账号不存在、密码错误
        if (user == null) {
            return HttpResult.error("账号不存在");
        }
        if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
            return HttpResult.error("密码不正确");
        }
        JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
        return HttpResult.ok(token);
    }
}
