package christmas.promotion;

import christmas.constant.MenuConstant;
import christmas.constant.PromotionConstant;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.EnumMap;

public class WeekdayPromotion {

    public int calculateWeekdaySale(EnumMap<MenuConstant, Integer> orderResults, int date) {
        if (checkWeekdayQualified(date)) {
            return PromotionConstant.calculateWeekDayPromotion(orderResults);
        }
        return 0;
    }

    private boolean checkWeekdayQualified(int date) {
        LocalDate December = LocalDate.of(2023, 12, 1);
        DayOfWeek today = December.plusDays(date - 1).getDayOfWeek();

        return today == DayOfWeek.SUNDAY || today == DayOfWeek.MONDAY || today == DayOfWeek.TUESDAY ||
                today == DayOfWeek.WEDNESDAY || today == DayOfWeek.THURSDAY;
    }
}
