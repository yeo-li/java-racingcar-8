package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String RACING_RESULT_HEADER = "실행 결과";

    public void printRacingResult(List<String> racingResult) {

        System.out.println(RACING_RESULT_HEADER);
        for (String round : racingResult) {
            System.out.println(round);
            System.out.println();
        }
    }

}
