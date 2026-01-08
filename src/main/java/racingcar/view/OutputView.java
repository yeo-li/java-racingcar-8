package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public void printRacingStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.status());
        }
        System.out.println();
    }
}
