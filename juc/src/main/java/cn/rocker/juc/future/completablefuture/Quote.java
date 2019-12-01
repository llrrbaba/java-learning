package cn.rocker.juc.future.completablefuture;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author rocker
 * @date 2019/12/01 20:19
 * @since V1.0
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Quote {

    private final String shopName;
    private final double price;
    private final Discount.Code discountCode;

    public static Quote parse(String s){
        String[] split = s.split(":");
        String shopName = split[0];
        double price = Double.parseDouble(split[1]);
        Discount.Code discountCode = Discount.Code.valueOf(split[2]);
        return new Quote(shopName, price, discountCode);
    }

}
