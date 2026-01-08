package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.constant.StringConstant;
import racingcar.domain.Car;
import racingcar.util.Parser;

public class RacingCarService {

    public List<Car> parseCarNames(String input) {
        List<String> names = Parser.parseInput(input, StringConstant.DELIMITER.getConstant());
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void race(List<Car> cars) {
        for (Car car : cars) {
            car.moveForward();
        }
    }

    public List<Car> judgeWinners(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        cars.sort((car1, car2) -> car2.getDistance() - car1.getDistance());
        int max = cars.getFirst().getDistance();
        for (Car car : cars) {
            if (max == car.getDistance()) {
                winners.add(car);
            }
        }
        return winners;
    }
}
