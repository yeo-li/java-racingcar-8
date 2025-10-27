package racingcar.view;

import java.util.List;
import racingcar.domain.RacingCar;

public class OutputView {

    public void printRacingStatus(List<RacingCar> racingCars) {

        for (RacingCar racingCar : racingCars) {
            System.out.println(racingCar.toString());
        }
    }

}
