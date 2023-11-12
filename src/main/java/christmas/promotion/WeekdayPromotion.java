package christmas.promotion;

import christmas.constant.MenuConstant;
import christmas.constant.PromotionConstant;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.EnumMap;

public class WeekdayPromotion {

    private final int weekdayDiscount;

    private WeekdayPromotion(EnumMap<MenuConstant, Integer> orderResults, int date) {
        this.weekdayDiscount = calculateWeekdaySale(orderResults, date);
    }

    public static WeekdayPromotion of(EnumMap<MenuConstant, Integer> orderResults, int date) {
        return new WeekdayPromotion(orderResults, date);
    }

    private int calculateWeekdaySale(EnumMap<MenuConstant, Integer> orderResults, int date) {
        if (isWeekdayQualified(date)) {
            return PromotionConstant.calculateWeekDayPromotion(orderResults);
        }
        return PromotionConstant.getNotQualifiedPrice();
    }

    private boolean isWeekdayQualified(int date) {
        LocalDate December = LocalDate.of(2023, 12, 1);
        DayOfWeek today = December.plusDays(date - 1).getDayOfWeek();

        return today == DayOfWeek.SUNDAY || today == DayOfWeek.MONDAY || today == DayOfWeek.TUESDAY ||
                today == DayOfWeek.WEDNESDAY || today == DayOfWeek.THURSDAY;
    }
}
