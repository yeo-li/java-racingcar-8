package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;
import racingcar.dto.RacingGameInputDto;
import racingcar.service.RacingGameInputService;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameInputService racingGameInputService;
    private final RacingGameService racingGameService;

    public RacingGameController(InputView inputView, OutputView outputView,
        RacingGameInputService racingGameInputService, RacingGameService racingGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGameInputService = racingGameInputService;
        this.racingGameService = racingGameService;
    }

    public void run() {
        RacingGameInputDto input = readUserInputs();
        RacingGame game = racingGameService.createRacingGame(
            input.getRacingCars(), input.getAttemptCount()
        );
        List<String> gameResult = executeRace(game);
        printGameResult(gameResult, input.getRacingCars());
    }

    private RacingGameInputDto readUserInputs() {
        String racingCarsInput = inputView.inputCarNames();
        List<RacingCar> racingCars = racingGameInputService.registerCars(racingCarsInput);

        String attemptCountInput = inputView.inputTryCount();
        int attemptCount = racingGameInputService.saveAttemptCount(attemptCountInput);

        return new RacingGameInputDto(racingCars, attemptCount);
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
