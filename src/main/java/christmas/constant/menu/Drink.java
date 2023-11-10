package christmas.constant.menu;

import java.util.Arrays;

public enum Drink {

    ZERO_COKE("제로콜라", 3_000),
    RED_WINE("레드와인", 60_000),
    CHAMPAGNE("샴페인", 25_000);

    private final String name;
    private final int price;

    Drink(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static boolean isContainMenu(String menu) {
        return Arrays.stream(values())
                .anyMatch(drink -> drink.name.equals(menu));
    }
}
