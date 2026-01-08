package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.RacingCarService;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final RacingCarService racingCarService;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(RacingCarService racingCarService, InputView inputView,
        OutputView outputView) {
        this.racingCarService = racingCarService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        List<Car> cars = inputCarNames();
        int tryCount = inputTryCount();
        List<Car> endCars = race(cars, tryCount);
        List<Car> winners = racingCarService.judgeWinners(endCars);
        outputView.printRacingWinners(winners);
    }

    private List<Car> inputCarNames() {
        String input = inputView.inputCarName();
        CarNameValidator.validate(input);
        return racingCarService.parseCarNames(input);
    }

    private int inputTryCount() {
        String input = inputView.inputTryCount();
        TryCountValidator.validate(input);
        return Integer.parseInt(input);
    }

    private List<Car> race(List<Car> cars, int tryCnt) {
        outputView.printStatusResultMessage();
        for (int i = 0; i < tryCnt; i++) {
            racingCarService.race(cars);
            outputView.printRacingStatus(cars);
        }
        return cars;
    }
}
