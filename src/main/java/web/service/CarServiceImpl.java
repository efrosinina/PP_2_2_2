package web.service;

import web.models.Car;
import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {
    public List<Car> showList(List<Car> list, int count) {
        if (count >= 5) { return list; }
        return list.stream().limit(count).collect(Collectors.toList());
    }
}
