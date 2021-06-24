package com.joker.reflection;

public class Person {
    String name;
    private int age;
    public Person(){
        System.out.println("无参构造执行");
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("带参构造执行");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    //无参方法
    public void eat(){
        System.out.println(name + "正在吃东西");
    }
    //带参方法
    public void eat(String food){
        System.out.println(name + "吃" + food);
    }
    //私有方法
    private void privateMethod(){
        System.out.println("这是一个私有方法");
    }
    //静态方法
    public static void staticMethod(){
        System.out.println("静态方法");
    }
}
