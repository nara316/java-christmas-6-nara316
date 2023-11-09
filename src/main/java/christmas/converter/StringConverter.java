package christmas.converter;

import static christmas.constant.ExceptionConstant.INPUT_IS_NUMBER;

public class StringConverter {

    public static int strToInt(String input) {
        return validateInteger(input);
    }

    private static int validateInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_IS_NUMBER.getMessage());
        }
    }
}
