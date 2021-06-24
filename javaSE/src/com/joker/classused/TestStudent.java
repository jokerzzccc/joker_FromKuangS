package com.joker.classused;

public class TestStudent {

    public static void main(String[] args) {
        //getClass()
        Student s1 = new Student("aaa",20);
        Student s2 = new Student("bbb",22);

        Class class1 = s1.getClass();
        Class class2 = s2.getClass();

        System.out.println(class1 == class2);
        System.out.println(class1);

        //hashCode()
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        //toString(),及重写它
        System.out.println(s1.toString());

        //equals()
        System.out.println(s1.equals(s2));

        Student s3 = new Student("ccc", 10);
        Student s4 = new Student("ccc", 10);
        System.out.println(s3.equals(s4));


    }
}
