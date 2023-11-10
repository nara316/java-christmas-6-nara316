package christmas.domain;

import christmas.constant.MenuConstant;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map.Entry;
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
            orderResult.put(MenuConstant.matchOrders(order.getMenu().getName()), order.getQuantity().getValue());
        }
        return orderResult;
    }
}
