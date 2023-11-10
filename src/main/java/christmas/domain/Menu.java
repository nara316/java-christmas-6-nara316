package christmas.domain;

import static christmas.constant.ExceptionConstant.WRONG_ORDER;

import christmas.constant.MenuConstant;

public class Menu {

    private final String name;

    private Menu(String name) {
        this.name = name;
        validateContainsMenuConstant();
    }

    public static Menu from(String name) {
        return new Menu(name);
    }

    private void validateContainsMenuConstant() {
        if (checkContainsMenuConstant() == false) {
            throw new IllegalArgumentException(WRONG_ORDER.getMessage());
        }
    }

    private boolean checkContainsMenuConstant() {
        return MenuConstant.isContainMenu(name);
    }

    public String getName() {
        return name;
    }
}
