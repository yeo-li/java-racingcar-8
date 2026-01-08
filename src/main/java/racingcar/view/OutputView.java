package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public static final String STATUS_RESULT_MESSAGE = "실행 결과";
    public static final String PRINT_WINNER_PREFIX_MESSAGE = "최종 우승자 : ";
    public static final String PRINT_WINNER_LINK = ", ";

    public void printStatusResultMessage() {
        System.out.println(STATUS_RESULT_MESSAGE);
    }

    public void printRacingStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.status());
        }
        System.out.println();
    }

    public void printRacingWinners(List<Car> winners) {
        System.out.print(PRINT_WINNER_PREFIX_MESSAGE);
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i + 1 == winners.size()) {
                break;
            }
            System.out.print(PRINT_WINNER_LINK);
        }
    }
}
