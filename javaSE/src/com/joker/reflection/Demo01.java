package com.joker.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Demo01 {
    public static void main(String[] args) throws Exception {
//        getClazz();
        reflectOpe1();
//        reflectOpe2();
//        reflectOpe3();

//        //正常调用方法
//        Properties properties = new Properties();
////        properties.setProperty("username","joker");
////        System.out.println(properties.toString());
//        //使用反射通用方法
//        invokeAny(properties,"setProperty",new Class[]{String.class,String.class},"username","joker");
//        System.out.println(properties.toString());

//        reflectOpe4();
    }


    //获取类对象的三种方式
    public static void getClazz() throws ClassNotFoundException {
        //1.使用类的对象获取类对象
        Person person = new Person();
        Class class1  = person.getClass();
        System.out.println(class1.hashCode());//获取类对象的地址

        //2 通过类名获取类对象，类名.class
        Class class2 = Person.class;
        System.out.println(class2.hashCode());

        //3 使用 Class 的静态方法,推荐使用
        Class<?> class3 = Class.forName("com.joker.reflection.Person");
        System.out.println(class3.hashCode());

    }

    //1 使用反射获取类的名字、包名、父类、接口
    public static void reflectOpe1() throws Exception{
        Class<?> class1 = Class.forName("com.joker.reflection.Person");
        System.out.println(class1.getName());//获取类的名字（包名+类名）
        System.out.println(class1.getSimpleName());//获取类名
        System.out.println(class1.getPackage());//获取包名
        System.out.println(class1.getSuperclass());//获取父类名
        System.out.println(Arrays.toString(class1.getInterfaces()));//获取接口名

    }
    //2 使用反射获取类的构造方法，创建对象
    public static void reflectOpe2() throws Exception{
        //1 获取类的类对象
        Class<?> class1 = Class.forName("com.joker.reflection.Person");
        //2 获取类的构造方法
        Constructor<?>[] constructors = class1.getConstructors();

        for (Constructor<?> cons :
                constructors) {
            System.out.println(cons.toString());
        }
        //3 获取类中的无参构造
        Constructor<?> constructor = class1.getConstructor();
        Person person1 =(Person) constructor.newInstance();
        System.out.println(person1.toString());
        //简便方法：类对象.newInstance()
        Person person2 =(Person) class1.newInstance();//已经废弃
        System.out.println(person2.toString());

        //4 获取类带参构造
        Constructor<?> constructor1 = class1.getConstructor(String.class, int.class);
        Person person3 =(Person) constructor1.newInstance("joker", 20);
        System.out.println(person3.toString());

    }

    //3 使用反射获取类中的方法，并调用方法
    public static void reflectOpe3() throws Exception{
        //1 获取类对象
        //2 获取方法， Method 对象
        Class<?> class1 = Class.forName("com.joker.reflection.Person");
        //2.1 getMethos() 只能获取公开的方法，包括从父类继承的方法
//        Method[] methods = class1.getMethods();
        //2.2 getDeclaredMethods() 获取类中的所有方法，包括私有、默认、保护的方法，不包含继承的方法
//        Method[] declaredMethods = class1.getDeclaredMethods();
//        for (Method method :
//                declaredMethods) {
//            System.out.println(method.toString());
//        }
        //3 获取单个方法
        //3.1 eat()
        Method eatMethod = class1.getMethod("eat");
        //调用方法
        Person person1 =(Person) class1.newInstance();
        eatMethod.invoke(person1);
        System.out.println("==========");
        //3.2 toString()
        Method toStringMethod = class1.getMethod("toString");
        Object invoke = toStringMethod.invoke(person1);
        System.out.println(invoke);
        System.out.println("==========");
        //3.3 调用带参eat()
        Method eatMethod2 = class1.getMethod("eat", String.class);
        eatMethod2.invoke(person1, "炸鸡");
        //3.4 获取一个私有的方法 privateMethod()
        Method privateMethod = class1.getDeclaredMethod("privateMethod");
        //必须设置访问权限无效
        privateMethod.setAccessible(true);
        privateMethod.invoke(person1);
        //3.5 获取一个静态方法
        Method staticMethod = class1.getMethod("staticMethod");
        //因为正常调用静态方法是使用类名.方法，即Person.staticMethod(),所以对象就不用传递，直接写 null
        staticMethod.invoke(null);
    }

    //4 使用反射实现一个可以调用任何对象的通用方法
    //obj:表示调用的对象，methodName:表示方法名，types: 方法的参数类，args:参数值
    public static Object invokeAny (Object obj,String methodName,Class<?>[] types,Object...args ) throws Exception{
        //获取类对象
        Class<?> class1 = obj.getClass();
        //获取调用方法
        Method method = class1.getMethod(methodName, types);
        //调用
        return method.invoke(obj,args);
    }

    //5 使用反射来获取类中的属性
    public static void reflectOpe4() throws Exception{
        //1 获取类对象
        Class<?> class1 = Class.forName("com.joker.reflection.Person");
        //2 读取字段（属性）
        //getFields() 只能获取公开的字段，父类继承的字段
//        Field[] fields = class1.getFields();
        //getDeclaredFields() 可以获取所有的属性，包括私有，保护，默认，不包括继承的
        Field[] declaredFields = class1.getDeclaredFields();
        System.out.println(declaredFields.length);
        for (Field field:declaredFields
             ) {
            System.out.println(field.toString());
        }

        //3 只获取 name 属性
        Field name = class1.getDeclaredField("name");
        //3.1获取私有属性的时候，必须设置权限
        Field age = class1.getDeclaredField("age");
        age.setAccessible(true);

        //4 赋值
        Person person1 = (Person) class1.newInstance();
        name.set(person1,"joker");
        age.set(person1,20);
        //5 获取值
        System.out.println(name.get(person1));
        System.out.println(age.get(person1));
    }
}
