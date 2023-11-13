package christmas.view;

import christmas.constant.promotion.PromotionConstant;
import christmas.domain.Badge;
import christmas.domain.OrderResult;
import christmas.domain.PromotionResult;
import christmas.domain.TotalOrderPrice;
import christmas.domain.VisitDate;

public class OutputView {

    private static final String DISCOUNT_PREVIEW_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String ORDER_MENU_MESSAGE = "<주문 메뉴>";
    private static final String TOTAL_ORDER_PRICE_MESSAGE = "<할인 전 총주문 금액>\n" + "%,d원\n";
    private static final String GIFT_MENU_MESSAGE = "<증정 메뉴>";
    private static final String BENEFITS_DETAILS_MESSAGE = "<혜택 내역>";
    private static final String TOTAL_BENEFIT_PRICE_MESSAGE = "<총혜택 금액>\n" + "-%,d원\n";
    private static final String TOTAL_ORDER_PRICE_AFTER_BENEFIT_MESSAGE = "<할인 후 예상 결제 금액>\n" + "%,d원\n";
    private static final String EVENT_BADGE_MESSAGE = "<12월 이벤트 배지>\n";


    public void printDiscountPreview(VisitDate visitDate) {
        System.out.printf(DISCOUNT_PREVIEW_MESSAGE, visitDate.getDate());
    }

    public void printOrderMenu(OrderResult result) {
        System.out.println(ORDER_MENU_MESSAGE);
        result.getOrderResult().forEach((menu, quantity) ->
                System.out.println(menu.getName() + " " + quantity + "개"));
    }

    public void printTotalOrderPrice(TotalOrderPrice totalOrderPrice) {
        System.out.printf(TOTAL_ORDER_PRICE_MESSAGE, totalOrderPrice.getTotalPrice());
    }

    public void printGiftMenu(PromotionResult promotionResult) {
        System.out.println(GIFT_MENU_MESSAGE);
        System.out.println(PromotionConstant.checkGiftQualified(promotionResult));
    }

    public void printBenefitsDetails(PromotionResult promotionResult) {
        System.out.println(BENEFITS_DETAILS_MESSAGE);
        promotionResult.getPromotionResult().forEach((promotion, value) ->
                System.out.printf("%s: -%,d원\n", promotion.getLabel(), value));
    }

    public void printTotalBenefitPrice(int totalDiscountPrice) {
        System.out.printf(TOTAL_BENEFIT_PRICE_MESSAGE, totalDiscountPrice);
    }

    public void printTotalOrderPriceAfterBenefit(PromotionResult promotionResult, TotalOrderPrice totalOrderPrice) {
        System.out.printf(TOTAL_ORDER_PRICE_AFTER_BENEFIT_MESSAGE,
                promotionResult.calculateTotalDiscountWithoutGift(promotionResult, totalOrderPrice.getTotalPrice()));
    }

    public void printEventBadge(int totalDiscountPrice) {
        System.out.println(EVENT_BADGE_MESSAGE + Badge.from(totalDiscountPrice).getLabel());
    }
}
