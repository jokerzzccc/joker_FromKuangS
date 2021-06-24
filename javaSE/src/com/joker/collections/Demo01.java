package com.joker.collections;

import java.util.*;

/**
 * Collections工具类的使用
 * @author joker_chen
 *
 */
public class Demo01 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(10);
        list.add(30);
        list.add(44);
        list.add(66);

        //sort排序
        System.out.println("before sort: "  + list );
        Collections.sort(list);
        System.out.println("after sort:" + list);

        //bianrySearch()二分查找,排序之后才可以用
        int i = Collections.binarySearch(list,30);
        System.out.println(i);

        //copy()复制
        List<Integer> dest = new ArrayList<>();
        for (int k = 0;k < list.size();k++){
            dest.add(0);//使dest的空间大小与List一样
        }
        Collections.copy(dest,list);//要注意list，dest空间大小关系
        System.out.println(dest);

        //reverse() 反转
        Collections.reverse(list);
        System.out.println("reverse："+list);

        //shuffle() 打乱
        Collections.shuffle(list);
        System.out.println("shuffle: "+list );

        //补充，list转成数组
        Integer[] arr = list.toArray(new Integer[0]);//参数为0，是因为当参数小于list的长度时。arr的长度将于list 保持一致
//        当参数超过list 的长度时，arr的长度与参数一致，多余的为null
        System.out.println(arr.length);
        System.out.println(Arrays.toString(arr));

        //数组转成集合
        String[] names = {"zhao","qian","sun","li"};
        //转成后的集合，是一个受限集合，不能添加和删除，因为，数组本身长度时固定的
        List<String> list2 =  Arrays.asList(names);
        System.out.println(list2.toString());

        //把基本类型数组抓换成集合时，需要修改为包装类
        Integer[] nums = {1,2,3,4,5,6};//不能用int[]
        List<Integer>  list3 = Arrays.asList(nums);
        System.out.println(list3);
    }
}
