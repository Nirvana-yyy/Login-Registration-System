package nirvana.web.servlet;

import nirvana.domain.Car;
import nirvana.service.CarService;
import nirvana.service.impl.CarServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author YJL
 */
@WebServlet(name = "FindACarServlet", value = "/FindACarServlet")
public class FindACarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取选中的id days
        int uid = Integer.parseInt(request.getParameter("uid"));
        int days = Integer.parseInt(request.getParameter("days"));
        CarService service = new CarServiceImpl();
        //调用service查找
        Car car = service.findACar(uid);
        int rent = service.rent(car.getId(), days);
        request.setAttribute("rent",rent);
        request.setAttribute("number",car.getNumber());
        request.getRequestDispatcher("rent.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
