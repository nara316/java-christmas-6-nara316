package christmas.service;

import christmas.domain.OrderResult;
import christmas.domain.Orders;
import christmas.domain.VisitDate;

public class OrderService {

    private VisitDate visitDate;
    private OrderResult orderResult;

    public VisitDate generateVisitDate(int date) {
        return visitDate = VisitDate.of(date);
    }

    public OrderResult generateOrders(String userInput) {
        Orders orders = Orders.from(userInput);
        return orderResult = OrderResult.from(orders);
    }
}
