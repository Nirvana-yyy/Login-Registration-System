package nirvana.web.filter;

import nirvana.web.servlet.FindUserServlet;
import nirvana.web.servlet.RegistServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/**
 * 登陆验证的过滤器
 */

/**
 * @author YJL
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //强制转换
        HttpServletRequest request = (HttpServletRequest) req;
        //获取请求路径
        String uri = request.getRequestURI();
        //判断是否包含登录资源路径,还要注意排除一些css、js、图片、验证码等资源
        if (uri.contains("/login.jsp") || uri.contains("/LoginServlet") || uri.contains("/css/") ||
                uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/checkCodeServlet") ||
                uri.contains("/regist.jsp") || uri.contains("/FindUserServlet") || uri.contains("/RegistServlet")){
            chain.doFilter(req, resp);
        } else{
            Object user = request.getSession().getAttribute("user");
            if (user != null){
                //登陆了，放行
                chain.doFilter(req,resp);
            } else{
                //没有登陆，跳转登陆页面
                request.setAttribute("msg","您尚未登陆，请登录");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }
        //
    }
}
