package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.message.ErrorMessage;

class CarNameValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "       ", " "})
    void 공백만_입력된_경우라면_예외를_발생_시켜야_한다(String input) {
        // when & then
        assertThatThrownBy(() -> {
            CarNameValidator.validate(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.BLANK_ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"azasss,pobi", "pobi,testss", "pobi,name,namesnames"})
    void 자동차_이름이_5자_초과라면_예외를_발생_시켜야_한다(String input) {
        // when & then
        assertThatThrownBy(() -> {
            CarNameValidator.validate(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.INVALID_INPUT_ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi", "he,hi,hi", "a,b,a"})
    void 자동차_이름이_중복되면_예외를_발생_시켜야_한다(String input) {
        // when & then
        assertThatThrownBy(() -> {
            CarNameValidator.validate(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(
                ErrorMessage.CAR_NAME_DUPLICATED_INPUT_ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,pobi1,pob2,pobi3,pobi4,pobi5,pobi6,pobi7,pobi8,pobi9,po10"})
    void 자동차가_10대를_초과하면_예외를_발생_시켜야_한다(String input) {
        // when & then
        assertThatThrownBy(() -> {
            CarNameValidator.validate(input);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ErrorMessage.CAR_COUNT_EXCESS_ERROR_MESSAGE.getMessage());
    }
}