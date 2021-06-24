package com.joker.classused;

public class Demo10 {
    public static void main(String[] args) {
//arraycopy() 数组的复制
        int[] arr1 = {1,2,3,4,5,6,7};
        int[] destArr = new int[8];

        System.arraycopy(arr1,0,destArr,0,arr1.length);
        for (int i=0;i < destArr.length;i++){
            System.out.println(destArr[i]);
        }
//currentTimeMillis()可以用来计算一个程序执行的时间
        System.out.println(System.currentTimeMillis());
        long start = System.currentTimeMillis();
        //代码段
        long end  = System.currentTimeMillis();

        //System.gc()告诉垃圾回收器回收垃圾
        //system.exit()
        System.exit(0);//后面的代码就不会执行了
        System.out.println("hello");

    }
}
