package nirvana.dao.impl;

import nirvana.dao.CarDao;
import nirvana.domain.Car;
import nirvana.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CarDaoImpl implements CarDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Car> finAll() {
        String sql = "select * from cars";
        List<Car> cars = template.query(sql, new BeanPropertyRowMapper<Car>(Car.class));
        return cars;
    }

    @Override
    public Car findCar(int id) {
        String sql = "select * from cars where id = ?";
        Car car = template.queryForObject(sql, new BeanPropertyRowMapper<Car>(Car.class), id);
        return car;
    }
}
