package christmas.view;

import static christmas.constant.ExceptionConstant.INPUT_IS_ESSENTIAL;

import camp.nextstep.edu.missionutils.Console;
import christmas.converter.StringConverter;

public class InputView {

    private static final String REQUEST_VISIT_DATE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n"
            + "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String REQUEST_MENU_AND_AMOUNT = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. "
            + "(e.g. 해산물파스타-2,레드와인-1,초코케이스-1)";

    public int inputVisitDate() {
        String visitDate = printMessageAndGetInput(REQUEST_VISIT_DATE);
        return StringConverter.strToInt(visitDate);
    }

    public String inputOrders() {
        return printMessageAndGetInput(REQUEST_MENU_AND_AMOUNT);
    }

    private String printMessageAndGetInput(String message) {
        System.out.println(message);
        String userInput = Console.readLine();
        validateBlank(userInput);
        return userInput;
    }

    private void validateBlank(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(INPUT_IS_ESSENTIAL.getMessage());
        }
    }
}
