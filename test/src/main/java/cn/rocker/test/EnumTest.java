package cn.rocker.test;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EnumTest {

    SPRING("春季", "C"),
    SUMMER("暑假", "S"),
    AUTUMN("秋季", "Q"),
    WINTER("寒假", "H");

    @Getter
    private final String desc;
    @Getter
    public final String textbookCode;

}
