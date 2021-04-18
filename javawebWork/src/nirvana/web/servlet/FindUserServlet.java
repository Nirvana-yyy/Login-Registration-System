package nirvana.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import nirvana.service.UserService;
import nirvana.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "FindUserServlet", value = "/FindUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名
        String username = request.getParameter("username");
        //调用service层来判断用户名是否存在

//        {”userExist“：true，”msg“:"此用户名已存在，请更换用户名"}
        //                            {”userExist“：false，”msg“:"用户名可用"}
        response.setContentType("application/json;charset=utf-8");
        Map<String, Object> map = new HashMap<String,Object>();
        UserService userService = new UserServiceImpl();

        if (userService.userNameExist(username)){
            //存在
            map.put("userExist",true);
            map.put("msg","用户名可用");
            map.put("msg_regist","此用户已存在!");
        }else{
            //不存在
            map.put("userExist",false);
            map.put("msg","用户名不存在,注册一个？");
            map.put("msg_regist","用户名可用");
        }
        //将map转为 json，并且写到页面上
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
