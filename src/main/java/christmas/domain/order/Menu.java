package christmas.domain.order;

import static christmas.constant.ExceptionConstant.WRONG_ORDER;

import christmas.constant.MenuConstant;

public class Menu {

    private final String name;

    private Menu(String menuName) {
        checkContainsRestaurant(menuName);
        this.name = menuName;
    }

    public static Menu from(String menuName) {
        return new Menu(menuName);
    }

    private void checkContainsRestaurant(String menuName) {
        MenuConstant.matchByMenuName(menuName).orElseThrow(
                () -> new IllegalArgumentException(WRONG_ORDER.getMessage()));
    }

    public String getName() {
        return name;
    }
}
