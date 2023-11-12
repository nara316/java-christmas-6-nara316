package christmas.domain;

public class PromotionResult {

    private final int totalDiscount;

    private PromotionResult(int date, int totalPrice) {
        this.totalDiscount = generateTotalDiscount(date, totalPrice);
    }

    public static PromotionResult from(int date, int totalPrice) {
        return new PromotionResult(date, totalPrice);
    }

    private int generateTotalDiscount(int date, int totalPrice) {
        return 1;
    }
}
