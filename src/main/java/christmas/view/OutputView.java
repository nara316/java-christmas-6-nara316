package christmas.view;

import static christmas.constant.NumberConstant.PROMOTION_NOT_APPLIED;

import christmas.constant.MenuConstant;
import christmas.constant.NumberConstant;
import christmas.constant.promotion.PromotionConstant;
import christmas.domain.Badge;
import java.util.EnumMap;

public class OutputView {

    private static final String DISCOUNT_PREVIEW_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String ORDER_MENU_MESSAGE = "<주문 메뉴>";
    private static final String TOTAL_ORDER_PRICE_MESSAGE = "<할인 전 총주문 금액>\n" + "%,d원\n";
    private static final String GIFT_MENU_MESSAGE = "<증정 메뉴>";
    private static final String BENEFITS_DETAILS_MESSAGE = "<혜택 내역>";
    private static final String TOTAL_BENEFIT_PRICE_MESSAGE = "<총혜택 금액>";
    private static final String TOTAL_ORDER_PRICE_AFTER_BENEFIT_MESSAGE = "<할인 후 예상 결제 금액>\n" + "%,d원\n";
    private static final String EVENT_BADGE_MESSAGE = "<12월 이벤트 배지>\n";


    public void printDiscountPreview(int visitDate) {
        System.out.printf(DISCOUNT_PREVIEW_MESSAGE, visitDate);
    }

    public void printOrderMenu(EnumMap<MenuConstant, Integer> orderResult) {
        System.out.println(ORDER_MENU_MESSAGE);
        orderResult.forEach((menu, quantity) ->
                System.out.println(menu.getName() + " " + quantity + "개"));
    }

    public void printTotalOrderPrice(int totalOrderPrice) {
        System.out.printf(TOTAL_ORDER_PRICE_MESSAGE, totalOrderPrice);
    }

    public void printGiftMenu(EnumMap<PromotionConstant, Integer> promotionResult) {
        System.out.println(GIFT_MENU_MESSAGE);
        System.out.println(PromotionConstant.checkGiftQualified(promotionResult));
    }

    public void printBenefitsDetails(EnumMap<PromotionConstant, Integer> promotionResult) {
        System.out.println(BENEFITS_DETAILS_MESSAGE);
        if (promotionResult.containsKey(PromotionConstant.NOT_APPLIED)) {
            System.out.printf("%s\n", PromotionConstant.NOT_APPLIED.getLabel());
            return;
        }
        promotionResult.forEach((promotion, value) ->
                System.out.printf("%s: -%,d원\n", promotion.getLabel(), value));
    }

    public void printTotalBenefitPrice(int totalDiscountPrice) {
        System.out.println(TOTAL_BENEFIT_PRICE_MESSAGE);
        if (totalDiscountPrice == PROMOTION_NOT_APPLIED.getNumber()) {
            System.out.printf("%,d원\n", totalDiscountPrice);
            return;
        }
        System.out.printf("-%,d원\n", totalDiscountPrice);
    }

    public void printTotalOrderPriceAfterBenefit(int totalOrderPriceAfterDiscount) {
        System.out.printf(TOTAL_ORDER_PRICE_AFTER_BENEFIT_MESSAGE, totalOrderPriceAfterDiscount);
    }

    public void printEventBadge(int totalDiscountPrice) {
        System.out.println(EVENT_BADGE_MESSAGE + Badge.from(totalDiscountPrice).getLabel());
    }
}
