package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.order.Orders;
import org.junit.jupiter.api.Test;

class TotalOrderPriceTest {

    @Test
    void 주문과_맞는_총금액이_계산되는지_확인() {
        String userOrder = "양송이수프-1,샴페인-1"; //양송이수프 = 6,000원 샴페인-25,000원
        Orders orders = Orders.from(userOrder);
        OrderResult orderResult = OrderResult.from(orders);
        TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(orderResult);

        assertThat(totalOrderPrice.getTotalPrice()).isEqualTo(31000);
    }
}