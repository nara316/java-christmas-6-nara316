package christmas.domain;

import static christmas.constant.ExceptionConstant.WRONG_ORDER;
import static christmas.constant.NumberConstant.ORDER_QUANTITY_TOTAL_MAX;
import static christmas.constant.StringConstant.DIVISION_MENU_AND_QUANTITY;
import static christmas.constant.StringConstant.DIVISION_ORDERS;
import static christmas.converter.StringConverter.strToInt;

import christmas.constant.menu.Appetizer;
import christmas.constant.menu.Drink;
import christmas.constant.menu.MainDish;
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

    private void validateMaxQuantity() {
        int totalQuantity = orders.stream()
                .mapToInt(order -> order.getQuantity().getValue())
                .sum();

        if (totalQuantity < ORDER_QUANTITY_TOTAL_MAX.getNumber()) {
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

    private void validateOrderOnlyDrink(List<Order> orders) {
        boolean isOnlyDrink = orders.stream()
                .anyMatch(order -> checkOnlyDrink(order.getMenu().getName()));

        if (!isOnlyDrink) {
            throw new IllegalArgumentException(WRONG_ORDER.getMessage());
        }
    }

    private boolean checkOnlyDrink(String name) {
        return Appetizer.isContainMenu(name) ||
                Drink.isContainMenu(name) || MainDish.isContainMenu(name);
    }
}
