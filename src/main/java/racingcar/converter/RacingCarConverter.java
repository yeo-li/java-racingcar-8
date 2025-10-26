package racingcar.converter;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;

public class RacingCarConverter {

    public List<RacingCar> convertRacingCarList(String[] carNames) {

        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(convertRacingCar(carName));
        }

        return racingCars;
    }

    public RacingCar convertRacingCar(String carName) {

        return new RacingCar(carName);
    }

}
