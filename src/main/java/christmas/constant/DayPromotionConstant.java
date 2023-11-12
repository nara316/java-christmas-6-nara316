package christmas.constant;

import java.util.EnumMap;

public enum DayPromotionConstant {

    WEEKDAY_PROMOTION("dessert", 2_023),
    WEEKEND_PROMOTION("mainDish", 2_023);

    private final String message;
    private final int price;

    DayPromotionConstant(String message, int price) {
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

    public static int calculateWeekendPromotion(EnumMap<MenuConstant, Integer> orderResults) {
        return orderResults.entrySet().stream()
                .filter(entry -> entry.getKey().getType().equals(WEEKEND_PROMOTION.message))
                .mapToInt(entry -> {
                    return entry.getValue() * WEEKEND_PROMOTION.price;
                })
                .sum();
    }
}
