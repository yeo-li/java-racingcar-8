package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public String status() {
        return String.format("%s : %s", name, "-".repeat(distance));
    }

    public void moveForward() {
        if (canMove()) {
            distance++;
        }
    }

    private boolean canMove() {
        int random = Randoms.pickNumberInRange(0, 9);
        return random >= 4;
    }
}
