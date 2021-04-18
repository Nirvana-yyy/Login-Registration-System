package nirvana.service;

import nirvana.domain.Car;

import java.util.List;

/**
 * @author YJL
 */
public interface CarService {
    /**
     * 查找出所有的车辆信息
     * @return
     */
    List<Car> findAll();

    /**
     * 查找出一辆车的信息
     * @return
     */
    Car findACar(int id);

    /**
     * 计算最终租金
     * @param days
     * @return
     */
    int rent(int id,int days);
}
