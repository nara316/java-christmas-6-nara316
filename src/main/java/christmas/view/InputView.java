package christmas.view;

import static christmas.constant.ExceptionConstant.INPUT_IS_ESSENTIAL;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {

    private static final String REQUEST_VISIT_DATE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n"
            + "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String REQUEST_MENU_AND_AMOUNT = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. "
            + "(e.g. 해산물파스타-2,레드와인-1,초코케이스-1)";

    public String inputVisitDate() {
        return printMessageAndGetInput(REQUEST_VISIT_DATE);
    }

    public String inputMenuAndAmount() {
        return printMessageAndGetInput(REQUEST_MENU_AND_AMOUNT);
    }

    private String printMessageAndGetInput(String message) {
        System.out.println(message);
        String userInput = Console.readLine();
        return userInput;
    }
}
