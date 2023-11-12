package christmas.service;

import christmas.domain.OrderResult;
import christmas.domain.order.Orders;
import christmas.domain.TotalOrderPrice;
import christmas.domain.VisitDate;

public class OrderService {

    public VisitDate generateVisitDate(int date) {
        return VisitDate.from(date);
    }

    public OrderResult generateOrders(String userInput) {
        Orders orders = Orders.from(userInput);
        return OrderResult.from(orders);
    }

    public int generateTotalPrice(OrderResult orderResult) {
        TotalOrderPrice totalOrderPrice = TotalOrderPrice.from(orderResult);
        return totalOrderPrice.getTotalPrice();
    }
}