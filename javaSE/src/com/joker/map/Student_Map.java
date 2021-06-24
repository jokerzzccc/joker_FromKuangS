package com.joker.map;

import java.util.Objects;

public class Student_Map implements Comparable<Student_Map>{

    private String name;
    private int stuNo;

    public Student_Map(){

    }

    public Student_Map(String name, int stuNo) {
        this.name = name;
        this.stuNo = stuNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    @Override
    public String toString() {
        return "Student_Map{" +
                "name='" + name + '\'' +
                ", stuNo=" + stuNo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student_Map that = (Student_Map) o;
        return stuNo == that.stuNo && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stuNo);
    }



    @Override
    public int compareTo(Student_Map o) {
        //先比姓名，再比学号
        int n1 = this.getName().compareTo(o.getName());
        int n2 = this.getStuNo() - o.getStuNo();
        return n1 == 0 ? n2:n1;
    }
}
