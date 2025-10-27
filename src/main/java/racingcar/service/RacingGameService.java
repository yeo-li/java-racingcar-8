package racingcar.service;

import java.util.List;
import racingcar.domain.RacingGame;

public class RacingGameService {

    public List<String> race(RacingGame game) {

        game.race();

        return game.getRoundResults();
    }
}
