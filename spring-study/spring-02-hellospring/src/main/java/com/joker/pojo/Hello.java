package com.joker.pojo;

public class Hello {
    private String Str;

    public String getStr() {
        return Str;
    }

    public void setStr(String str) {
        Str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "Str='" + Str + '\'' +
                '}';
    }
}
