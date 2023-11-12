package christmas.domain.order;

import static christmas.constant.ExceptionConstant.WRONG_ORDER;
import static christmas.constant.NumberConstant.ORDER_QUANTITY_TOTAL_MAX;
import static christmas.constant.StringConstant.DIVISION_MENU_AND_QUANTITY;
import static christmas.constant.StringConstant.DIVISION_ORDERS;
import static christmas.converter.StringConverter.strToInt;

import christmas.constant.ExceptionConstant;
import christmas.constant.MenuConstant;
import christmas.converter.StringConverter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Orders {

    private final List<Order> orders;

    private Orders(String userInput) {
        this.orders = generateOrders(userInput);
        validateMaxQuantity();
        validateMenuDuplicated();
        validateOrderOnlyDrink();
    }

    public static Orders from(String userInput) {
        return new Orders(userInput);
    }

    private List<Order> generateOrders(String userInput) {
        return Arrays.stream(userInput.split(DIVISION_ORDERS.getMessage()))
                .map(orders -> orders.split(DIVISION_MENU_AND_QUANTITY.getMessage()))
                .map(order -> Order.of(order[0], strToInt(order[1], WRONG_ORDER.getMessage())))
                .collect(Collectors.toList());
    }

    private void validateMaxQuantity() {
        int totalQuantity = orders.stream()
                .mapToInt(order -> order.getQuantity().getValue())
                .sum();

        if (totalQuantity > ORDER_QUANTITY_TOTAL_MAX.getNumber()) {
            throw new IllegalArgumentException(WRONG_ORDER.getMessage());
        }
    }

    private void validateMenuDuplicated() {
        Set<String> menus = new HashSet<>();
        boolean isDuplicated = orders.stream()
                .map(order -> order.getMenu().getName())
                .anyMatch(orderMenu -> !menus.add(orderMenu));

        if (isDuplicated) {
            throw new IllegalArgumentException(WRONG_ORDER.getMessage());
        }
    }

    private void validateOrderOnlyDrink() {
        boolean isOnlyDrink = orders.stream()
                .anyMatch(order -> checkOnlyDrink(order.getMenu().getName()));

        if (!isOnlyDrink) {
            throw new IllegalArgumentException(WRONG_ORDER.getMessage());
        }
    }

    private boolean checkOnlyDrink(String name) {
        return MenuConstant.isContainMenu(name);
    }

    public List<Order> getOrders() {
        return orders;
    }
}