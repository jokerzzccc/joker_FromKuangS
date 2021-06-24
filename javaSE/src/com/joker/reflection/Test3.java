package com.joker.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 反射获取泛型信息
 * 得到泛型信息后，可以给它增加约束，以及修改等
 */
public class Test3 {
    public void test01(Map<String,Person> map, List<Person> list){
        System.out.println("test01");
    }

    public Map<String,Person> test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        //返回参数类型的泛型
        Method method = Test3.class.getMethod("test01", Map.class, List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
//            System.out.println(genericParameterType);
            if (genericParameterType instanceof ParameterizedType){//判断是不是参数化类型
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();//获得真实的参数
                for (Type actualTypeArgument :
                        actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }

        //获取返回值类型的泛型
        Method method1 = Test3.class.getMethod("test02");
        Type genericReturnType = method1.getGenericReturnType();

        if (genericReturnType instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument :
                    actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }
    }
}
