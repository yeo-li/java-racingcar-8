package racingcar.view;

import java.util.List;
import racingcar.domain.RacingCar;

public class OutputView {

    private static final String RACING_RESULT_HEADER = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public void printRacingResult(List<String> racingResult) {

        System.out.println(RACING_RESULT_HEADER);
        for (String round : racingResult) {
            System.out.println(round);
            System.out.println();
        }
    }

    public void printWinners(List<RacingCar> winners) {

        System.out.print(WINNER_MESSAGE);
        for (int i = 0; i < winners.size(); i++) {
            RacingCar winner = winners.get(i);
            System.out.print(winner.getName());
            if (i + 1 != winners.size()) {
                System.out.print(", ");
            }
        }
    }

}
