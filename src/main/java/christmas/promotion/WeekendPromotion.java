package christmas.promotion;

import christmas.constant.MenuConstant;
import christmas.constant.PromotionConstant;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.EnumMap;

public class WeekendPromotion {

    public int calculateWeekendSale(EnumMap<MenuConstant, Integer> orderResults, int date) {
        if (checkWeekendQualified(date)) {
            return PromotionConstant.calculateWeekendPromotion(orderResults);
        }
        return 0;
    }

    private boolean checkWeekendQualified(int date) {
        LocalDate December = LocalDate.of(2023, 12, 1);
        DayOfWeek today = December.plusDays(date - 1).getDayOfWeek();

        return today == DayOfWeek.FRIDAY || today == DayOfWeek.SATURDAY;
    }
}
