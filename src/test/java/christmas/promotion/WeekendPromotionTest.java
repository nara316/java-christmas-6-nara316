package christmas.promotion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.OrderResult;
import christmas.domain.order.Orders;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WeekendPromotionTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 9, 30})
    void 주말에_방문했을_경우_메인메뉴를_주문하면_개당_2023_할인(int visitDate) {
        String userInput = "티본스테이크-2,해산물파스타-1,샴페인-2"; //티본스테이크와 해산물파스타가 메인메뉴이므로 6069원 할인되어야 한다.
        Orders orders = Orders.from(userInput);
        OrderResult orderResult = OrderResult.from(orders);
        WeekendPromotion weekendPromotion = WeekendPromotion.of(orderResult.getOrderResult(), visitDate);

        assertThat(weekendPromotion.getWeekendDiscount()).isEqualTo(6_069);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 9, 30})
    void 주말에_방문했을_경우_메인메뉴를_주문하지_않으면_할인하지_않음(int visitDate) {
        String userInput = "아이스크림-3,레드와인-6";
        Orders orders = Orders.from(userInput);
        OrderResult orderResult = OrderResult.from(orders);
        WeekendPromotion weekendPromotion = WeekendPromotion.of(orderResult.getOrderResult(), visitDate);

        assertThat(weekendPromotion.getWeekendDiscount()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 11, 19, 27, 28})
    void 주말에_방문하지_않으면_할인하지_않음(int visitDate) {
        String userInput = "티본스테이크-1,제로콜라-2,타파스-14";
        Orders orders = Orders.from(userInput);
        OrderResult orderResult = OrderResult.from(orders);
        WeekendPromotion weekendPromotion = WeekendPromotion.of(orderResult.getOrderResult(), visitDate);

        assertThat(weekendPromotion.getWeekendDiscount()).isEqualTo(0);
    }
}