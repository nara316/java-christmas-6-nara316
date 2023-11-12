package christmas.domain;

import christmas.constant.MenuConstant;

public class TotalOrderPrice {

    private final int totalPrice;

    private TotalOrderPrice(OrderResult orderResult) {
        this.totalPrice = generateOrderResult(orderResult);
    }

    public static TotalOrderPrice from(OrderResult orderResult) {
        return new TotalOrderPrice(orderResult);
    }

    private int generateOrderResult(OrderResult orderResult) {
        return MenuConstant.calculateTotalPrice(orderResult.getOrderResult());
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
