package nirvana.web.servlet;

import nirvana.domain.User;
import nirvana.service.UserService;
import nirvana.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置统一编码
        request.setCharacterEncoding("utf-8");
        //获取session
        HttpSession session = request.getSession();
        String checkCode = request.getParameter("checkCode");

        //验证码
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");
        if (!(checkcode_server.equalsIgnoreCase(checkCode))){
            request.setAttribute("msg","验证码错误!");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return ;
        }
        //检验用户名和密码是否存在
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        UserService service = new UserServiceImpl();

        User user1 = service.login(user.getUsername(), user.getPassword());
        System.out.println(user);

            if (user1 == null){
                request.setAttribute("msg","用户名或密码错误");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else{
                session.setAttribute("user",user1);
                //重定向
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
