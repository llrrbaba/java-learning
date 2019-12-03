package cn.rocker.juc.future.completablefuture1;

/**
 * @author rocker
 * @date 2019/12/01 20:10
 * @since V1.0
 */
public class Discount {

    public enum Code {
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);
        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static String applyDiscount(Quote quote) {
        return quote.getShopName() + " price is " + Discount.apply(quote.getPrice(), quote.getDiscountCode());
    }

    private static double apply(double price, Code code) {
        // 模拟Discount服务响应的延迟
        Shop.delay();
        return price * (100 - code.percentage) / 100;
    }

}
