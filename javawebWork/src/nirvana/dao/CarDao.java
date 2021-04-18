package nirvana.dao;

import nirvana.domain.Car;

import java.util.List;

/**
 * @author YJL
 */
public interface CarDao {
    /**
     * 查找出所有的车辆数据
     * @return
     */
    List<Car> finAll();

    /**
     * 查找一辆车
     * @param id
     * @return
     */
    Car findCar(int id);
}
