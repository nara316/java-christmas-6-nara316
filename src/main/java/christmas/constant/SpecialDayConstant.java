package christmas.constant;

import java.util.Arrays;

public enum SpecialDayConstant {

    FIRST_SUN(3),
    SECOND_SUN(10),
    THIRD_SUN(17),
    FOURTH_SUN(24),
    CHRISTMAS(25),
    FIFTH_SUN(31);

    private final int day;

    SpecialDayConstant(int day) {
        this.day = day;
    }

    public static boolean isSpecialDay(int date) {
        return Arrays.stream(values())
                .anyMatch(specialDayConstant -> specialDayConstant.day == date);
    }
}