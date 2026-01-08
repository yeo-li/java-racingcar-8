package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public void printStatusResultMessage() {
        System.out.println("실행 결과");
    }

    public void printRacingStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.status());
        }
        System.out.println();
    }
}
