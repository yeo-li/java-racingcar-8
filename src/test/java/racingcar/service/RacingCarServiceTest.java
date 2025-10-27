package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RacingCar;
import racingcar.exception.ExceptionMessage;

class RacingCarServiceTest {

    private final RacingCarService racingCarService = new RacingCarService();

    @Nested
    @DisplayName("RegisterCars() 메서드")
    class RegisterCarsTest {

        static Stream<Arguments> provideNameLists() {

            return Stream.of(
                Arguments.of("pobi,woni,jun", List.of("pobi", "woni", "jun")),
                Arguments.of("userA, userB, userC", List.of("userA", "userB", "userC"))
            );
        }

        @ParameterizedTest
        @DisplayName("자동차 등록 성공")
        @MethodSource("provideNameLists")
        void 자동차_등록_성공(String input, List<String> expectedNames) {

            // when
            List<RacingCar> racingCars = racingCarService.registerCars(input);

            List<String> resultNames = racingCars.stream()
                .map(RacingCar::getName)
                .toList();

            // then
            assertThat(resultNames).isEqualTo(expectedNames);
        }

        @Test
        @DisplayName("자동차 등록 실패 - 자동차 이름이 5자를 초과하는 경우")
        void 자동차_이름_다섯글자_초과() {
            // given
            String input = " pobi,name, seongyeol";

            // when & then
            assertThatThrownBy(() -> {
                racingCarService.registerCars(input);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.TOO_LONG_CAR_NAME.getMessage());
        }

        @Test
        @DisplayName("자동차 등록 실패 - 자동차 이름에 중복이 있는 경우")
        void 자동차_이름_중복() {
            // given
            String input = "pobi, pobi";

            // when & then
            assertThatThrownBy(() -> {
                racingCarService.registerCars(input);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.DUPLICATE_CAR_NAME.getMessage());
        }

        @Test
        @DisplayName("자동차 등록 실패 - 자동차 이름이 \"\"인 경우")
        void 자동차_이름_공백() {
            // given
            String input = ", pobi, ,";

            // when & then
            assertThatThrownBy(() -> {
                racingCarService.registerCars(input);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.BLANK_CAR_NAME.getMessage());
        }

        @Test
        @DisplayName("자동차 등록 실패 - \"\", \" \" 처럼 공백만 입력한 경우")
        void 공백만_입력() {
            // given
            String input = "    ";

            // when & then
            assertThatThrownBy(() -> {
                racingCarService.registerCars(input);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.EMPTY_CAR_NAME.getMessage());
        }

        @Test
        @DisplayName("자동차 등록 실패 - 알파벳, \",\"과 공백을 제외한 다른 문자가 들어온 경우")
        void 자동차_이름_알파벳_쉼표_외_입력() {
            // given
            String input = "pobi, user2, jun";

            // when & then
            assertThatThrownBy(() -> {
                racingCarService.registerCars(input);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_CAR_NAME.getMessage());
        }
    }

    @Nested
    @DisplayName("saveAttemptCount() 메서드")
    class SaveAttemptCountTest {

        @ParameterizedTest
        @DisplayName("시도 횟수 저장 - 성공")
        @CsvSource({
            "3, 3",
            "4, 4",
            "100, 100",
            "0, 0",
            "   10  , 10",
            "10000, 10000"
        })
        void 시도_횟수_저장_성공(String input, int expected) {

            // when
            int actual = racingCarService.SaveAttemptCount(input);

            // then
            Assertions.assertThat(actual).isEqualTo(expected);
        }

        @ParameterizedTest
        @DisplayName("시도 횟수 저장 - 시도 횟수 입력값에 숫자를 제외한 다른 값이 있는 경우")
        @ValueSource(strings = {"-1", "12 a3, 123a, 89=9, 5!, 1.5"})
        void 시도_횟수_입력값에_숫자를_제외한_다른_값이_있는_경우(String input) {
            // when & then
            assertThatThrownBy(() -> {
                racingCarService.SaveAttemptCount(input);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NON_NUMERIC_ATTEMPT_COUNT.getMessage());
        }

        @ParameterizedTest
        @DisplayName("시도 횟수 저장 - 입력 값이 0 미만 10,000 초과의 정수인 경우")
        @ValueSource(strings = {
            "10001", "10000000000000000000",
            "1000000000000000000000000000000000000000000000000000000"})
        void 입력_값이_범위를_초과하는_정수인_경우(String input) {
            // when & then
            assertThatThrownBy(() -> {
                racingCarService.SaveAttemptCount(input);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.OUT_OF_RANGE_ATTEMPT_COUNT.getMessage());
        }

        @ParameterizedTest
        @DisplayName("시도 횟수 저장 - \"\", \" \" 처럼 공백을 입력한 경우(아무것도 입력하지 않은 경우)")
        @ValueSource(strings = {"", " ", "  "})
        void 시도_횟수에_공백을_입력한_경우(String input) {
            // when & then
            assertThatThrownBy(() -> {
                racingCarService.SaveAttemptCount(input);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.EMPTY_ATTEMPT_COUNT.getMessage());
        }

    }

}