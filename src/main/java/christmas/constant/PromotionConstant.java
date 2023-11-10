package christmas.constant;

public enum PromotionConstant {

    NOT_QUALIFIED("없음", 0);

    private final String message;
    private final int price;

    PromotionConstant(String message, int price) {
        this.message = message;
        this.price = price;
    }
}
