package christmas.domain;

import static christmas.constant.ExceptionConstant.WRONG_ORDER;

import christmas.constant.menu.Appetizer;
import christmas.constant.menu.Dessert;
import christmas.constant.menu.Drink;
import christmas.constant.menu.MainDish;

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
        return Appetizer.isContainMenu(name) || Dessert.isContainMenu(name) ||
                Drink.isContainMenu(name) || MainDish.isContainMenu(name);
    }

    public String getName() {
        return name;
    }
}
