package com.atguigu.test;

/**
 * @author clh
 * @description  枚举齐国灭亡
 * @date 2020.10.26-21.13
 */
public enum CountryEnum {
    ONE(1, "齐"), TWO(2, "楚"),
    THREE(3, "燕"), FOUR(4, "赵"),
    FIVE(5, "魏"), SIX(6, "韩");
    private int code;
    private String message;

    CountryEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static CountryEnum foreach_CountryEnum(int index) {
        CountryEnum[] values = CountryEnum.values();
        for (CountryEnum c : values) {
            if (c.code == index) {
                return c;
            }
        }
        return null;
    }

}
