package nirvana.test;

import nirvana.dao.CarDao;
import nirvana.dao.UserDao;
import nirvana.dao.impl.CarDaoImpl;
import nirvana.dao.impl.UserDaoImpl;
import nirvana.domain.Car;
import nirvana.domain.User;
import nirvana.service.CarService;
import nirvana.service.impl.CarServiceImpl;
import nirvana.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author YJL
 */
public class DaoTest {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Test
    public void usernameMatch() {
        User loginUser = new User();
        loginUser.setUsername("晏佳乐");
        loginUser.setPassword("12345678");
        UserDao dao = new UserDaoImpl();
        User user = dao.usernameMatch(loginUser.getUsername(), loginUser.getPassword());
        System.out.println(user);
    }
    @Test
    public void userNameExist(){
        User loginUser = new User();
        loginUser.setUsername("晏佳乐");
//        loginUser.setPassword("12345678");
        UserDao dao = new UserDaoImpl();
        boolean exist = dao.userNameExist(loginUser.getUsername());
        System.out.println(exist);
    }
    @Test
    public void addUser(){
        User registUser = new User();
        registUser.setUsername("徐海洋");
        registUser.setPassword("12345678");
        UserDao dao = new UserDaoImpl();
        User user = dao.addUser(registUser.getUsername(), registUser.getPassword());
        System.out.println(user);
    }
    @Test
    public void findAll(){
        CarService service = new CarServiceImpl();
        List<Car> cars = service.findAll();
        for (Car car : cars) {
            System.out.println(car);
        }

    }
}
