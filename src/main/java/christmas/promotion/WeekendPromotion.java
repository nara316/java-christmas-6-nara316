package christmas.promotion;

import static christmas.constant.NumberConstant.PROMOTION_NOT_QUALIFIED;

import christmas.constant.MenuConstant;
import christmas.constant.promotion.DayPromotionConstant;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.EnumMap;

public class WeekendPromotion {

    private final int weekendDiscount;

    private WeekendPromotion(EnumMap<MenuConstant, Integer> orderResult, int visitDate) {
        this.weekendDiscount = calculateWeekendSale(orderResult, visitDate);
    }

    public static WeekendPromotion of(EnumMap<MenuConstant, Integer> orderResult, int visitDate) {
        return new WeekendPromotion(orderResult, visitDate);
    }

    private int calculateWeekendSale(EnumMap<MenuConstant, Integer> orderResult, int visitDate) {
        if (isWeekendQualified(visitDate)) {
            return DayPromotionConstant.calculateWeekendPromotion(orderResult);
        }
        return PROMOTION_NOT_QUALIFIED.getNumber();
    }

    private boolean isWeekendQualified(int visitDate) {
        LocalDate December = LocalDate.of(2023, 12, 1);
        DayOfWeek today = December.plusDays(visitDate - 1).getDayOfWeek();

        return today == DayOfWeek.FRIDAY || today == DayOfWeek.SATURDAY;
    }

    public int getWeekendDiscount() {
        return weekendDiscount;
    }
}
