package com.wanke.nanjidao.filter.manage;

import com.wanke.nanjidao.config.SessionManage;
import com.wanke.nanjidao.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * *******************************************
 * Author: 56
 * Data:   3/18/16 10:36 AM
 * E-mail: mysherrymyqueen@outlook.com
 * *******************************************
 * Function:过滤器
 */
public class CheckUserInfo implements Filter {

    private String LOGIN_URL; // 登陆页面url

    private List<String> notFilterURIs; // 不过滤的url

    private List<Pattern> notFilterPatterns = new ArrayList<Pattern>(); // 不过滤规则

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.notFilterURIs = new ArrayList<>();
        String notFilterURIStr = filterConfig.getInitParameter("notFilterURIs");
        LOGIN_URL = filterConfig.getInitParameter("loginURL");
        if (LOGIN_URL != null) {
            this.notFilterURIs.add(LOGIN_URL);
            this.notFilterPatterns.add(Pattern.compile(LOGIN_URL));
        }
        if (notFilterURIStr != null) {
            String[] strs = notFilterURIStr.split(",");
            for (String str : strs) {
                this.notFilterURIs.add(str);
                this.notFilterPatterns.add(Pattern.compile(str));
            }
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String path = request.getContextPath();
        String requestURI = request.getRequestURI();

        // 获取url连接
        requestURI = requestURI.substring(requestURI.indexOf(path) + path.length());

        if (isNeedFilter(requestURI)) {
            if (requestURI.indexOf("/manage/") == 0) {
                User user = SessionManage.getUser(session);
                if (user == null) {
                    redirectTo(request, response, LOGIN_URL);
                    return;
                }
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    /**
     * *******************************************
     * Author: 56
     * Data:   3/18/16 10:49 AM
     * E-mail: mysherrymyqueen@outlook.com
     * *******************************************
     * Function: 重定向
     */
    private void redirectTo(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
        if (url.startsWith("http")) {
            response.sendRedirect(url);
        } else {
            String path = request.getContextPath();
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
            response.sendRedirect(basePath + url);
        }
    }

    private boolean isNeedFilter(String requestURI) {
        for (Pattern pattern : notFilterPatterns) {
            if (pattern.matcher(requestURI).matches()) {
                return false;
            }
        }
        return true;
    }

}
