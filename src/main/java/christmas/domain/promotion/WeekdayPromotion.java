package christmas.domain.promotion;

import static christmas.constant.NumberConstant.PROMOTION_NOT_APPLIED;

import christmas.constant.MenuConstant;
import christmas.constant.promotion.DayPromotionConstant;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.EnumMap;

public class WeekdayPromotion {

    private final int weekdayDiscount;

    private WeekdayPromotion(EnumMap<MenuConstant, Integer> orderResult, int visitDate) {
        this.weekdayDiscount = calculateWeekdaySale(orderResult, visitDate);
    }

    public static WeekdayPromotion of(EnumMap<MenuConstant, Integer> orderResult, int visitDate) {
        return new WeekdayPromotion(orderResult, visitDate);
    }

    private int calculateWeekdaySale(EnumMap<MenuConstant, Integer> orderResult, int visitDate) {
        if (isWeekdayQualified(visitDate)) {
            return DayPromotionConstant.calculateWeekDayPromotion(orderResult);
        }
        return PROMOTION_NOT_APPLIED.getNumber();
    }

    private boolean isWeekdayQualified(int visitDate) {
        LocalDate December = LocalDate.of(2023, 12, 1);
        DayOfWeek today = December.plusDays(visitDate - 1).getDayOfWeek();

        return today == DayOfWeek.SUNDAY || today == DayOfWeek.MONDAY || today == DayOfWeek.TUESDAY ||
                today == DayOfWeek.WEDNESDAY || today == DayOfWeek.THURSDAY;
    }

    public int getWeekdayDiscount() {
        return weekdayDiscount;
    }
}
