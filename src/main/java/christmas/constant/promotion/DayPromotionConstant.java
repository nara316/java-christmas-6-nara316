package christmas.constant.promotion;

import christmas.constant.MenuConstant;
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
        return calculateDayPromotion(orderResults, WEEKDAY_PROMOTION);
    }

    public static int calculateWeekendPromotion(EnumMap<MenuConstant, Integer> orderResults) {
        return calculateDayPromotion(orderResults, WEEKEND_PROMOTION);
    }

    private static int calculateDayPromotion(
            EnumMap<MenuConstant, Integer> orderResults, DayPromotionConstant dayPromotionConstant) {
        return orderResults.entrySet().stream()
                .filter(entry -> entry.getKey().getType().equals(dayPromotionConstant.message))
                .mapToInt(entry -> entry.getValue() * dayPromotionConstant.price)
                .sum();
    }
}
