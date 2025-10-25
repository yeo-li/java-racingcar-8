package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private final String name;
    private int distance;


    public RacingCar(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void moveForward() {
        int moveSignal = Randoms.pickNumberInRange(0, 9);
        if (canMove(moveSignal)) {
            this.distance += 1;
        }
    }

    private boolean canMove(int moveSignal) {
        return moveSignal >= 4;
    }
}
