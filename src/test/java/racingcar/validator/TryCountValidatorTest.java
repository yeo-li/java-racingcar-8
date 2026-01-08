package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.message.ErrorMessage;

class TryCountValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "       ", " "})
    void 공백만_입력된_경우라면_예외를_발생_시켜야_한다(String input) {
        // when & then
        assertThatThrownBy(() -> {
            TryCountValidator.validate(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.BLANK_ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1A", "123adg3"})
    void 입력값이_숫자가_아니라면_예외를_발생_시켜야_한다(String input) {
        // when & then
        assertThatThrownBy(() -> {
            TryCountValidator.validate(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.TRY_COUNT_IS_NOT_NUMBER_ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1001", "1000000000", "124082358024953"})
    void 입력값이_1000을_초과하면_예외를_발생_시켜야_한다(String input) {
        // when & then
        assertThatThrownBy(() -> {
            TryCountValidator.validate(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.TRY_COUNT_EXCESS_ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1000", "-1000000000", "-3"})
    void 입력값이_음수라면_예외를_발생_시켜야_한다(String input) {
        // when & then
        assertThatThrownBy(() -> {
            TryCountValidator.validate(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.TRY_COUNT_IS_NOT_NUMBER_ERROR_MESSAGE.getMessage());
    }
}