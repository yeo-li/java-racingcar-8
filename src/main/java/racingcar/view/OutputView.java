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

    public void printRacingWinners(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i + 1 == winners.size()) {
                break;
            }
            System.out.print(", ");
        }
    }
}
