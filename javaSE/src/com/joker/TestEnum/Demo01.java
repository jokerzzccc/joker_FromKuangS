package com.joker.TestEnum;

/**
 * 枚举与switch 结合使用
 */
public class Demo01 {
    public static void main(String[] args) {
        Season season = Season.SPRING;
        switch (season){//switch 的判断类型可以是byte short int char String 枚举，但不能是long
            case SUMMER -> {
                System.out.println("夏天");
                break;
            }
            case SPRING -> {
                System.out.println("春天");
                break;
            }
            case AUTUMN -> {
                System.out.println("秋天");
                break;
            }
            case WINTER -> {
                System.out.println("冬天");
                break;
            }
            default -> {
                break;
            }

        }
    }
}
