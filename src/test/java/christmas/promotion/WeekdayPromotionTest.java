package christmas.promotion;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.OrderResult;
import christmas.domain.order.Orders;
import christmas.domain.promotion.WeekdayPromotion;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WeekdayPromotionTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 11, 19, 27, 28})
    void 평일에_방문했을_경우_디저트를_주문하면_개당_2023_할인(int visitDate) {
        String userInput = "티본스테이크-1,아이스크림-2"; //아이스크림이 디저트이므로 4046원이 할인되어야 한다.
        Orders orders = Orders.from(userInput);
        OrderResult orderResult = OrderResult.from(orders);
        WeekdayPromotion weekdayPromotion = WeekdayPromotion.of(orderResult.getOrderResult(), visitDate);

        assertThat(weekdayPromotion.getWeekdayDiscount()).isEqualTo(4_046);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 11, 19, 27, 28})
    void 평일에_방문했을_경우_디저트를_주문하지_않으면_할인하지_않음(int visitDate) {
        String userInput = "티본스테이크-1,타파스-3";
        Orders orders = Orders.from(userInput);
        OrderResult orderResult = OrderResult.from(orders);
        WeekdayPromotion weekdayPromotion = WeekdayPromotion.of(orderResult.getOrderResult(), visitDate);

        assertThat(weekdayPromotion.getWeekdayDiscount()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 9, 30})
    void 평일에_방문하지_않으면_할인하지_않음(int visitDate) {
        String userInput = "티본스테이크-1,아이스크림-2,샴페인-7";
        Orders orders = Orders.from(userInput);
        OrderResult orderResult = OrderResult.from(orders);
        WeekdayPromotion weekdayPromotion = WeekdayPromotion.of(orderResult.getOrderResult(), visitDate);

        assertThat(weekdayPromotion.getWeekdayDiscount()).isEqualTo(0);
    }
}