package christmas.domain.order;

import static christmas.constant.NumberConstant.ORDER_QUANTITY_MIN;

import christmas.constant.ExceptionConstant;

public class Quantity {

    private final int value;

    private Quantity(int value) {
        validateMinValue(value);
        this.value = value;
    }

    public static Quantity from(int value) {
        return new Quantity(value);
    }

    private void validateMinValue(int value) {
        if (value < ORDER_QUANTITY_MIN.getNumber()) {
            throw new IllegalArgumentException(ExceptionConstant.WRONG_ORDER.getMessage());
        }
    }

    public int getValue() {
        return value;
    }
}
