package christmas.domain;

import christmas.constant.MenuConstant;
import christmas.domain.order.Order;
import christmas.domain.order.Orders;
import java.util.EnumMap;
import java.util.stream.Collectors;

public class OrderResult {

    private final EnumMap<MenuConstant, Integer> orderResult;

    private OrderResult(Orders orders) {
        this.orderResult = generateOrderResult(orders);
    }

    public static OrderResult from(Orders orders) {
        return new OrderResult(orders);
    }

    private EnumMap<MenuConstant, Integer> generateOrderResult(Orders orders) {
        EnumMap<MenuConstant, Integer> orderResult = new EnumMap<>(MenuConstant.class);

        for (Order order : orders.getOrders()) {
            MenuConstant.matchByMenuName(order.getMenu().getName())
                    .ifPresent(menuConstant -> orderResult.put(menuConstant, order.getQuantity().getValue()));
        }
        return orderResult;
    }

    public EnumMap<MenuConstant, Integer> getOrderResult() {
        return orderResult;
    }
}
