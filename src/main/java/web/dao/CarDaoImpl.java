package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDaoImpl implements CarDao {
    private final List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("Tesla", 3, 2020));
        cars.add(new Car("BMW", 5, 2023));
        cars.add(new Car("Subaru", 12, 2021));
        cars.add(new Car("Lada", 6, 2005));
        cars.add(new Car("Kamaz", 54, 2018));
    }

    public List<Car> getCars(Integer count) {
        if (count == null) {
            return cars;
        }
        return cars.stream().limit(count).toList();
    }

}
