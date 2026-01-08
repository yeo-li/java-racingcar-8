package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class RacingCarServiceTest {

    private final RacingCarService racingCarService = new RacingCarService();

    public static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Nested
    class parseCarNamesTest {

        @Test
        void 입력값을_쉼표로_나누어_자동차_이름을_생성_해야_한다() {
            // given
            String input = "pobi,seyeo,hihi";

            // when
            List<Car> actual = racingCarService.parseCarNames(input);

            // then
            Assertions.assertEquals(3, actual.size());
            Assertions.assertEquals("pobi", actual.get(0).getName());
            Assertions.assertEquals("seyeo", actual.get(1).getName());
            Assertions.assertEquals("hihi", actual.get(2).getName());
        }
    }

    @Nested
    class RaceTest {

        @Test
        void 모든_자동차들을_랜덤으로_한_칸씩_전진_시켜야_한다() {
            // given
            List<Car> actual = racingCarService.parseCarNames("pobi,seyeo");

            // when
            assertRandomNumberInRangeTest(
                () -> {
                    racingCarService.race(actual);
                },
                MOVING_FORWARD, STOP
            );

            // then
            Assertions.assertEquals(1, actual.get(0).getDistance());
            Assertions.assertEquals(0, actual.get(1).getDistance());
        }
    }

    @Nested
    class judgeWinnersTest {

        @Test
        void 단독_우승자를_선별할_수_있어야_한다() {
            // given
            List<Car> cars = racingCarService.parseCarNames("pobi,seyeo");
            assertRandomNumberInRangeTest(
                () -> {
                    racingCarService.race(cars);
                },
                MOVING_FORWARD, STOP
            );

            // when
            List<Car> winner = racingCarService.judgeWinners(cars);

            // then
            Assertions.assertEquals(1, winner.size());
            Assertions.assertEquals("pobi", winner.getFirst().getName());
        }

        @Test
        void 여러명의_우승자를_선별할_수_있어야_한다() {
            // given
            List<Car> cars = racingCarService.parseCarNames("pobi,seyeo");
            assertRandomNumberInRangeTest(
                () -> {
                    racingCarService.race(cars);
                },
                MOVING_FORWARD, MOVING_FORWARD
            );

            // when
            List<Car> winner = racingCarService.judgeWinners(cars);

            // then
            Assertions.assertEquals(2, winner.size());
            Assertions.assertEquals("pobi", winner.getFirst().getName());
            Assertions.assertEquals("seyeo", winner.get(1).getName());
        }
    }
}
