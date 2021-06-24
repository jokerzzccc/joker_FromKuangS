package com.joker.threadPool;

/**
 * lambda 表达式的简化
 *
 * 前提是接口时函数式接口
 * 多个参数也可以去点参数类型，要去掉就都去掉，必须加上括号
 */
public class TestLambda2 {
    public static void main(String[] args) {
//        ILove love = (String a )->{
//            System.out.println("I love you" + a);
//
//        };
//        //简化1 ，去掉参数返回类型
//        love = (a)->{
//            System.out.println("I love you" + a);
//        };
//        //简化2 ，简化括号
//        love = a->{
//            System.out.println("I love you" + a);
//        };
//
        //简化3，简化花括号,lambda 表达式只有一行的情况下，才能简化为一行，如果有多行，就要用代码块包裹
         ILove love = a->System.out.println("I love you" + a);

        love.love("three thousand times 4");
    }
}
interface ILove{
    void love(String  str );
}