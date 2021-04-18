package nirvana.web.servlet;

import nirvana.domain.Car;
import nirvana.service.CarService;
import nirvana.service.impl.CarServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * @author YJL
 */
@WebServlet(name = "FindCarsServlet", value = "/FindCarsServlet")
public class FindCarsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //调用service层方法
        CarService service = new CarServiceImpl();
        List<Car> cars = service.findAll();
        //发送数据
        request.setAttribute("list",cars);
        //转发
        request.getRequestDispatcher("cars.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
