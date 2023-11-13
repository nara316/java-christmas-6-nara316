package christmas.service;

import christmas.domain.OrderResult;
import christmas.domain.order.Orders;
import christmas.domain.TotalOrderPrice;
import christmas.domain.VisitDate;

public class OrderService {

    public VisitDate generateVisitDate(String userInput) {
        return VisitDate.from(userInput);
    }

    public OrderResult generateOrders(String userInput) {
        Orders orders = Orders.from(userInput);
        return OrderResult.from(orders);
    }

    public TotalOrderPrice generateTotalPrice(OrderResult orderResult) {
        TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(orderResult);
        return totalOrderPrice;
    }
}
