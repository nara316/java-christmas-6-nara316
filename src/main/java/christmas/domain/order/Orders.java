package christmas.domain.order;

import static christmas.constant.ExceptionConstant.WRONG_ORDER;
import static christmas.constant.NumberConstant.ORDER_QUANTITY_TOTAL_MAX;
import static christmas.constant.StringConstant.DIVISION_MENU_AND_QUANTITY;
import static christmas.constant.StringConstant.DIVISION_ORDERS;
import static christmas.converter.StringConverter.strToInt;

import christmas.constant.MenuConstant;
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
        validateMenuNameDuplicated();
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

    private void validateMenuNameDuplicated() {
        Set<String> menusNotDuplicated = new HashSet<>();
        boolean isDuplicated = orders.stream()
                .map(order -> order.getMenu().getName())
                .anyMatch(orderMenu -> !menusNotDuplicated.add(orderMenu));

        if (isDuplicated) {
            throw new IllegalArgumentException(WRONG_ORDER.getMessage());
        }
    }

    private void validateOrderOnlyDrink() {
        boolean hasOnlyDrink = orders.stream()
                .allMatch(order -> MenuConstant.isContainDrink(order.getMenu().getName()));

        if (hasOnlyDrink) {
            throw new IllegalArgumentException(WRONG_ORDER.getMessage());
        }
    }

    public List<Order> getOrders() {
        return orders;
    }
}
