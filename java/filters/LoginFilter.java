package filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import beans.*;

import java.util.*;

public class LoginFilter implements Filter {

    private String redirectUrl;
    private String needCheckedUrls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();

        redirectUrl = servletContext.getInitParameter("redirectPage");
        needCheckedUrls = servletContext.getInitParameter("needCheckedUrls");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String servletPath = httpRequest.getServletPath();

        List<String> urls = Arrays.asList(needCheckedUrls.split(","));
        if (urls.contains(servletPath)) {
            User user = (User) httpRequest.getSession().getAttribute("user");
            if (user == null) {
                httpResponse.sendRedirect(httpRequest.getContextPath() + redirectUrl);
                return;
            }
        }

        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {
    }

}