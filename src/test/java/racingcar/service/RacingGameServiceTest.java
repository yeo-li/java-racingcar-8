package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;

class RacingGameServiceTest {

    private RacingGameService racingGameService = new RacingGameService();

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Nested
    @DisplayName("race() 테스트")
    class raceTest {

        @Test
        @DisplayName("자동차 경주 - 정상 실행")
        void 자동차_경주_정상_실행() {
            // given
            List<RacingCar> cars = List.of(
                new RacingCar("pobi"),
                new RacingCar("woni"),
                new RacingCar("jun")
            );
            int attemptCount = 2;
            RacingGame game = new RacingGame(cars, attemptCount);
            List<String> expected = List.of("pobi : -\nwoni : -\njun : -\n",
                "pobi : --\nwoni : --\njun : --\n");

            // when
            assertRandomNumberInRangeTest(
                () -> {
                    List<String> actual = racingGameService.race(game);

                    // then
                    assertThat(actual).hasSize(attemptCount);
                    assertThat(actual).containsExactlyElementsOf(expected);
                },
                MOVING_FORWARD
            );
        }
    }
}