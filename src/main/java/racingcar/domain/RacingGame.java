package racingcar.domain;

import java.util.List;

public class RacingGame {

    private final List<RacingCar> racingCars;
    private final int attemptCount;

    public RacingGame(List<RacingCar> racingCars, int attemptCount) {

        this.racingCars = racingCars;
        this.attemptCount = attemptCount;
    }

    public void moveAllCars() {

        for (RacingCar racingCar : racingCars) {
            racingCar.moveForward();
        }
    }

    @Override
    public String toString() {

        String status = "";
        for (RacingCar racingCar : racingCars) {
            status += racingCar.toString() + "\n";
        }

        return status;
    }
}
