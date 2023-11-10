package christmas.domain;

import static christmas.constant.StringConstant.DIVISION_MENU_AND_QUANTITY;
import static christmas.constant.StringConstant.DIVISION_ORDERS;
import static christmas.converter.StringConverter.strToInt;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Orders {

    private final List<Order> orders;

    private Orders(String userInput) {
        this.orders = generateOrders(userInput);
    }

    public static Orders from(String userInput) {
        return new Orders(userInput);
    }

    private static List<Order> generateOrders(String userInput) {
        return Arrays.stream(userInput.split(DIVISION_ORDERS.getMessage()))
                .map(orders -> orders.split(DIVISION_MENU_AND_QUANTITY.getMessage()))
                .map(order -> Order.of(order[0], strToInt(order[1])))
                .collect(Collectors.toList());
    }
}
