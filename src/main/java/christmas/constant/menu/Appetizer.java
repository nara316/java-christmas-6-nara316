package christmas.constant.menu;

import java.util.Arrays;

public enum Appetizer {

    MUSHROOM_SOUP("양송이수프", 6_000),
    TAPAS("타파스", 5_500),
    CAESAR_SALAD("시저샐러드", 8_000);

    private final String name;
    private final int price;

    Appetizer(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static boolean isContainMenu(String menu) {
        return Arrays.stream(values())
                .anyMatch(appetizer -> appetizer.name.equals(menu));
    }
}
