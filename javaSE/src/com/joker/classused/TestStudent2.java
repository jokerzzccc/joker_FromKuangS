package com.joker.classused;

public class TestStudent2  {
    public static void main(String[] args) {
        /**
        Student a = new Student("a", 10);
        Student b = new Student("b", 10);

        Student c = new Student("c", 10);

        Student d = new Student("d", 10);

        Student e = new Student("e", 10);
         */


        new Student("a", 10);
        new Student("b", 10);

        new Student("c", 10);

        new Student("d", 10);

        new Student("e", 10);

        System.gc();
        System.out.println("回收垃圾");

    }
}
