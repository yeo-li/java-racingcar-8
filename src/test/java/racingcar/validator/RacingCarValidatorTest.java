package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.ExceptionMessage;

class RacingCarValidatorTest {

    @Nested
    @DisplayName("validateCarNames() 테스트")
    class ValidateCarNamesTest {

        @Test
        @DisplayName("자동차 이름이 5자를 초과하는 경우")
        void 자동차_이름_다섯글자_초과() {
            // given
            String[] input = {"pobi", "name", "seong", "seongyeol"};

            // when & then
            assertThatThrownBy(() -> {
                RacingCarValidator.validateCarNames(input);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.TOO_LONG_CAR_NAME.getMessage());
        }

        @Test
        @DisplayName("자동차 이름에 중복이 있는 경우")
        void 자동차_이름_중복() {
            // given
            String[] input = {"seyeo", "pobi", "seyeo"};

            // when & then
            assertThatThrownBy(() -> {
                RacingCarValidator.validateCarNames(input);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.DUPLICATE_CAR_NAME.getMessage());
        }

        @Test
        @DisplayName("자동차 이름이 \"\"인 경우")
        void 자동차_이름_공백() {
            // given
            String[] input = {"", "pobi", "", ""};

            // when & then
            assertThatThrownBy(() -> {
                RacingCarValidator.validateCarNames(input);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.BLANK_CAR_NAME.getMessage());
        }

        @Test
        @DisplayName("\"\", \" \" 처럼 공백만 입력한 경우")
        void 공백만_입력() {
            // given
            String[] input = {""};

            // when & then
            assertThatThrownBy(() -> {
                RacingCarValidator.validateCarNames(input);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.EMPTY_CAR_NAME.getMessage());
        }

        @Test
        @DisplayName("알파벳, \",\"과 공백을 제외한 다른 문자가 들어온 경우")
        void 자동차_이름_알파벳_쉼표_외_입력() {
            // given
            String[] input = {"pobi", "user-", "jun"};

            // when & then
            assertThatThrownBy(() -> {
                RacingCarValidator.validateCarNames(input);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_CAR_NAME.getMessage());
        }
    }

    @Nested
    @DisplayName("validateAttemptCount() 테스트")
    class ValidateAttemptCountTest {

        @ParameterizedTest
        @DisplayName("숫자를 제외한 다른 값이 있는 경우")
        @ValueSource(strings = {"-1", "12 a3, 123a, 89=9, 5!, 1.5"})
        void 입력값에_숫자를_제외한_다른_값이_있는_경우(String input) {
            // when & then
            assertThatThrownBy(() -> {
                RacingCarValidator.validateAttemptCount(input);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.NON_NUMERIC_ATTEMPT_COUNT.getMessage());
        }

        @ParameterizedTest
        @DisplayName("입력 값이 0 미만 10,000 초과의 정수인 경우")
        @ValueSource(strings = {
            "10001", "10000000000000000000",
            "1000000000000000000000000000000000000000000000000000000"})
        void 범위를_초과하는_정수인_경우(String input) {
            // when & then
            assertThatThrownBy(() -> {
                RacingCarValidator.validateAttemptCount(input);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.OUT_OF_RANGE_ATTEMPT_COUNT.getMessage());
        }

        @ParameterizedTest
        @DisplayName("\"\", \" \" 처럼 공백을 입력한 경우(아무것도 입력하지 않은 경우)")
        @ValueSource(strings = {"", " ", "  "})
        void 공백을_입력한_경우(String input) {
            // when & then
            assertThatThrownBy(() -> {
                RacingCarValidator.validateAttemptCount(input);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.EMPTY_ATTEMPT_COUNT.getMessage());
        }
    }

}