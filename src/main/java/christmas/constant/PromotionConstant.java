package christmas.constant;

import java.util.EnumMap;

public enum PromotionConstant {

    NOT_QUALIFIED("없음", 0),
    WEEKDAY_PROMOTION("dessert", 2_023),
    WEEKEND_PROMOTION("mainDish", 2_023);

    private final String message;
    private final int price;

    PromotionConstant(String message, int price) {
        this.message = message;
        this.price = price;
    }

    public static int calculateWeekDayPromotion(EnumMap<MenuConstant, Integer> orderResults) {
        return orderResults.entrySet().stream()
                .filter(entry -> entry.getKey().getType().equals(WEEKDAY_PROMOTION.message))
                .mapToInt(entry -> {
                    return entry.getValue() * WEEKDAY_PROMOTION.price;
                })
                .sum();
    }
}
