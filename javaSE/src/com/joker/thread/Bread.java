package com.joker.thread;

/**
 * 生产者消费者
 * 产品类：面包类
 */
public class Bread {
    private int id;
    private String productName;

    public Bread() {
    }

    public Bread(int id, String productName) {
        this.id = id;
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Bread{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                '}';
    }
}
