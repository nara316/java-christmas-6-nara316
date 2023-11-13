package christmas.domain;

import static christmas.constant.ExceptionConstant.WRONG_ORDER;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import christmas.domain.order.Menu;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuTest {

    @ParameterizedTest
    @ValueSource(strings = {"마라탕", "고구마피자", "엽기떡볶이", "먹고싶다"})
    void 레스토랑_메뉴판에_없는메뉴_주문시_예외발생(String menuName) {
        assertThatThrownBy(() -> Menu.from(menuName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WRONG_ORDER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"티본스테이크", "타파스", "제로콜라", "아이스크림"})
    void 레스토랑_있는메뉴_주문시_정상작동(String menuName) {
        assertThatCode(() -> Menu.from(menuName))
                .doesNotThrowAnyException();
    }
}