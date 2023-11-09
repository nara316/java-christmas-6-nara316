package christmas.constant.menu;

public enum Drink {

    ZERO_COKE("초코케이크", 15_000),
    RED_WINE("아이스크림", 5_000),
    CHAMPAGNE("샴페인", 25_000);

    private final String name;
    private final int price;

    Drink(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
