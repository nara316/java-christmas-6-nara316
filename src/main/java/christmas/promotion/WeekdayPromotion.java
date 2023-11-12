package christmas.promotion;

import static christmas.constant.NumberConstant.PROMOTION_NOT_QUALIFIED;

import christmas.constant.MenuConstant;
import christmas.constant.DayPromotionConstant;
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
            return DayPromotionConstant.calculateWeekDayPromotion(orderResults);
        }
        return PROMOTION_NOT_QUALIFIED.getNumber();
    }

    private boolean isWeekdayQualified(int date) {
        LocalDate December = LocalDate.of(2023, 12, 1);
        DayOfWeek today = December.plusDays(date - 1).getDayOfWeek();

        return today == DayOfWeek.SUNDAY || today == DayOfWeek.MONDAY || today == DayOfWeek.TUESDAY ||
                today == DayOfWeek.WEDNESDAY || today == DayOfWeek.THURSDAY;
    }

    public int getWeekdayDiscount() {
        return weekdayDiscount;
    }
}
