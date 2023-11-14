package christmas.constant.promotion;

import java.util.Arrays;

public enum SpecialPromotionConstant {

    FIRST_SUN(3),
    SECOND_SUN(10),
    THIRD_SUN(17),
    FOURTH_SUN(24),
    CHRISTMAS(25),
    FIFTH_SUN(31);

    private final int day;

    SpecialPromotionConstant(int day) {
        this.day = day;
    }

    public static boolean isSpecialDay(int date) {
        return Arrays.stream(values())
                .anyMatch(specialDayConstant -> specialDayConstant.day == date);
    }
}
