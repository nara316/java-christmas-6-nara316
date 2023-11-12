package christmas.promotion;

import christmas.constant.MenuConstant;
import christmas.constant.PromotionConstant;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.EnumMap;

public class WeekendPromotion {

    private final int weekendDiscount;

    private WeekendPromotion(EnumMap<MenuConstant, Integer> orderResults, int date) {
        this.weekendDiscount = calculateWeekendSale(orderResults, date);
    }

    public static WeekendPromotion of(EnumMap<MenuConstant, Integer> orderResults, int date) {
        return new WeekendPromotion(orderResults, date);
    }

    private int calculateWeekendSale(EnumMap<MenuConstant, Integer> orderResults, int date) {
        if (isWeekendQualified(date)) {
            return PromotionConstant.calculateWeekendPromotion(orderResults);
        }
        return PromotionConstant.getNotQualifiedPrice();
    }

    private boolean isWeekendQualified(int date) {
        LocalDate December = LocalDate.of(2023, 12, 1);
        DayOfWeek today = December.plusDays(date - 1).getDayOfWeek();

        return today == DayOfWeek.FRIDAY || today == DayOfWeek.SATURDAY;
    }
}
