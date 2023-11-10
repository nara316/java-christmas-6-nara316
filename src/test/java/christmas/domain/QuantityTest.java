package christmas.domain;

import static christmas.constant.ExceptionConstant.WRONG_ORDER;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class QuantityTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -123})
    void 주문수량이_1미만일_경우_예외발생(int quantity) {
        assertThatThrownBy(() -> Quantity.from(quantity))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_ORDER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 15})
    void 값이_유효하면_예외가_발생하지_않음(int quantity) {
        assertThatCode(() -> Quantity.from(quantity))
                .doesNotThrowAnyException();
    }
}