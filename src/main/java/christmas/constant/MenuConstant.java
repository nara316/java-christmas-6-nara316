package christmas.constant;

import static christmas.constant.NumberConstant.GIFT_APPLIED_STANDARD;
import static christmas.constant.NumberConstant.PROMOTION_NOT_APPLIED;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Optional;

public enum MenuConstant {

    MUSHROOM_SOUP("appetizer", "양송이수프", 6_000),
    TAPAS("appetizer", "타파스", 5_500),
    CAESAR_SALAD("appetizer", "시저샐러드", 8_000),
    CHOCO_CAKE("dessert", "초코케이크", 15_000),
    ICE_CREAM("dessert", "아이스크림", 5_000),
    ZERO_COKE("drink", "제로콜라", 3_000),
    RED_WINE("drink", "레드와인", 60_000),
    CHAMPAGNE("drink", "샴페인", 25_000),
    T_BONE_STEAK("mainDish", "티본스테이크", 55_000),
    BARBECUE_LIP("mainDish", "바비큐립", 54_000),
    SEAFOOD_PASTA("mainDish", "해산물파스타", 35_000),
    CHRISTMAS_PASTA("mainDish", "크리스마스파스타", 25_000);

    private final String type;
    private final String name;
    private final int price;

    MenuConstant(String type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static Optional<MenuConstant> matchByMenuName(String menuName) {
        return Arrays.stream(values())
                .filter(menuConstant -> menuConstant.name.equals(menuName))
                .findFirst();
    }

    public static boolean isContainDrink(String menuName) {
        return Arrays.stream(values())
                .allMatch(menu -> menu.type.equals("drink") && menu.name.equals(menuName));
    }

    public static int calculateTotalOrderPrice(EnumMap<MenuConstant, Integer> orderResult) {
        return orderResult.entrySet().stream()
                .mapToInt(entry -> entry.getKey().price * entry.getValue())
                .sum();
    }

    public static int calculateGiftPrice(int totalPrice) {
        if (GIFT_APPLIED_STANDARD.getNumber() <= totalPrice) {
            return CHAMPAGNE.price;
        }
        return PROMOTION_NOT_APPLIED.getNumber();
    }

    public static String getGiftName() {
        return CHAMPAGNE.name;
    }

    public static int getGiftPrice() {
        return CHAMPAGNE.price;
    }
}
