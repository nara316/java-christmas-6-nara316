package christmas.domain;

import static christmas.constant.ExceptionConstant.WRONG_ORDER;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.order.Orders;
import org.junit.jupiter.api.Test;

class OrdersTest {

    @Test
    void 주문형식에_맞지않을경우_예외발생() {
        String userOrder = "티본스테이크-10,타파스-a";

        assertThatThrownBy(() -> Orders.from(userOrder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_ORDER.getMessage());
    }

    @Test
    void 총주문수량이_20초과일_경우_예외발생() {
        String userOrder = "티본스테이크-10,타파스-10,제로콜라-10";

        assertThatThrownBy(() -> Orders.from(userOrder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_ORDER.getMessage());
    }

    @Test
    void 총주문수량이_20이하일_경우_예외발생_하지않음() {
        String userOrder = "해산물파스타-5,크리스마스파스타-5,시저샐러드-10";

        assertThatCode(() -> Orders.from(userOrder))
                .doesNotThrowAnyException();
    }

    @Test
    void 메뉴를_중복주문할_경우_예외발생() {
        String userOrder = "바비큐립-1,바비큐립-2";

        assertThatThrownBy(() -> Orders.from(userOrder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_ORDER.getMessage());
    }

    @Test
    void 음료만_주문할_경우_예외발생() {
        String userOrder = "제로콜라-1,레드와인-1";

        assertThatThrownBy(() -> Orders.from(userOrder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_ORDER.getMessage());
    }

    @Test
    void 입력값이_유효할경우_정상작동() {
        String userOrder = "해산물파스타-5,타파스-1,제로콜라-3";

        assertThatCode(() -> Orders.from(userOrder))
                .doesNotThrowAnyException();
    }
}