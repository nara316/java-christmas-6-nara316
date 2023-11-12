package christmas.service;

import christmas.domain.OrderResult;
import christmas.domain.order.Orders;
import christmas.domain.TotalOrderPrice;
import christmas.domain.VisitDate;

public class OrderService {

    private VisitDate visitDate;
    private OrderResult orderResult;
    private TotalOrderPrice totalOrderPrice;

    public VisitDate generateVisitDate(int date) {
        return visitDate = VisitDate.of(date);
    }

    public OrderResult generateOrders(String userInput) {
        Orders orders = Orders.from(userInput);
        return orderResult = OrderResult.from(orders);
    }

    public int generateTotalPrice(OrderResult orderResult) {
        totalOrderPrice = TotalOrderPrice.from(orderResult);
        return totalOrderPrice.getTotalPrice();
    }
}
