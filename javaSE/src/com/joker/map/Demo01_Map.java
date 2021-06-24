package com.joker.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map接口的使用
 * 特点：
 * （1）存储键值对
 * （2）键不能重复，值可以重复
 * （3）无序
 * @author joker_chen
 */
public class Demo01_Map {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        //1. put(),添加元素
        map.put("apple","苹果");
        map.put("orange","橘子");
        map.put("durian","榴莲");
        map.put("apple","pingguo");//当键值相同时，后添加的会把以前添加的键值替换

        System.out.println("sum: " + map.size());
        System.out.println(map);

//        //remove() 删除
//        map.remove("apple");
//        System.out.println(map.size());
//        System.out.println(map);

        //遍历
        //3.1 使用keySet(),一个Set集合，只包含键值key
        System.out.println("============keySet()===========");
//        Set<String> keySet = map.keySet();
        for (String key :
                map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }
        //3.2 使用entrySet(),返回的是一个包含entry的Set集合，一个entry 就是一个键值对key-value
        //entrySet()效率高于keySet()
        System.out.println("============entrySet()==========");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry:
        entries){
            System.out.println(entry.getKey() + "-" + entry.getValue());

        }
        //判断
        System.out.println(map.containsKey("apple"));
        System.out.println(map.containsValue("榴莲"));

    }
}
