package com.joker.classused;

public class Student {
    private String name;
    private  int age;

    public Student() {
    }

    public Student(String name , int age) {
        super();
        this.name = name;
        this.age = age;
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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (obj instanceof Student){
            Student s = (Student) obj;
            if (this.name.equals(s.getName()) && this.age == s.getAge()){
                return true;
            }


        }
        return false;

    }


}
