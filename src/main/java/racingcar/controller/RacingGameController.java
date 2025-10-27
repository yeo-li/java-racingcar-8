package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;
import racingcar.dto.RacingGameInputDto;
import racingcar.service.RacingCarService;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingCarService racingCarService = new RacingCarService();
    private final RacingGameService racingGameService = new RacingGameService();

    public void run() {

        RacingGameInputDto input = readUserInputs();
        RacingGame game = racingGameService.createRacingGame(
            input.getRacingCars(), input.getAttemptCount()
        );
        List<String> gameResult = executeRace(game);
        printGameResult(gameResult, input.getRacingCars());
    }

    private RacingGameInputDto readUserInputs() {
        String carNames = inputView.inputCarNames();
        List<RacingCar> cars = racingCarService.registerCars(carNames);

        String tryCount = inputView.inputTryCount();
        int attemptCount = racingCarService.SaveAttemptCount(tryCount);

        return new RacingGameInputDto(cars, attemptCount);
    }

    private List<String> executeRace(RacingGame game) {
        return racingGameService.race(game);
    }

    private void printGameResult(List<String> gameResult, List<RacingCar> racingCars) {
        outputView.printRacingResult(gameResult);

        List<RacingCar> winners = racingGameService.calculateWinners(racingCars);
        outputView.printWinners(winners);
    }

}
