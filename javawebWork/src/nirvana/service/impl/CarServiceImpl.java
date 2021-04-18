package nirvana.service.impl;

import nirvana.dao.CarDao;
import nirvana.dao.impl.CarDaoImpl;
import nirvana.domain.Car;
import nirvana.service.CarService;

import java.util.List;

/**
 * @author YJL
 */
public class CarServiceImpl implements CarService {
    CarDao dao = new CarDaoImpl();
    @Override
    public List<Car> findAll() {
        return dao.finAll();
    }

    @Override
    public Car findACar(int id) {
        return dao.findCar(id);
    }

    @Override
    public int rent(int id,int days) {
        if (id == 1 || id == 5 || id == 7 ||id == 9){
            return days * 800;
        }else if (id == 2 || id == 4){
            return days * 600;
        }else if (id == 6 || id == 8){
            return days * 1500;
        }else if (id == 4){
            return days * 300;
        }else {
            return days * 700;
        }

    }
}
