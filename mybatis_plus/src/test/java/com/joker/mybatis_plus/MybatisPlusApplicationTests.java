package com.joker.mybatis_plus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.joker.mybatis_plus.mapper.UserMapper;
import com.joker.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {
    //继承 了BaseMapper ，所有的方法都来自于它，也可以编写自己的扩展方法。
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        //查询所有用户
        //selectList() 参数是一个 Wrapper 。条件构造器。这里先不用，写为null
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test//测试插入
    public void testInsert() {
        User user = new User();
        user.setName("joker 自动填充—代码级别");
        user.setAge(3);
        user.setEmail("fdsfasf@qq.com");
        int result = userMapper.insert(user); // 帮我们自动生成id
        System.out.println(result); // 受影响的行数
        System.out.println(user); // 发现，id会自动回填
    }

    @Test//测试更新
    public void testUpdate() {
        User user = new User();
        //通过条件，自动拼接动态SQL
        user.setId(1379445215932407810L);
        user.setName("joker_update");
        user.setAge(20);
        //updateById 参数是一个对象
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    // 测试乐观锁成功！这是在单线程情况下，一定可以成功修改。
    @Test
    public void testOptimisticLocker() {
        // 1、查询用户信息
        User user = userMapper.selectById(1L);
        // 2、修改用户信息
        user.setName("joker");
        user.setEmail("wulawulawula@qq.com");
        // 3、执行更新操作
        userMapper.updateById(user);
    }

    // 测试乐观锁失败！多线程下
    @Test
    public void testOptimisticLocker2() {
        // 线程 1
        User user = userMapper.selectById(1L);
        user.setName("joker111111");
        user.setEmail("wahhhhhhhh@qq.com");
        // 模拟另外一个线程执行了插队操作
        User user2 = userMapper.selectById(1L);
        user2.setName("joker222");
        user2.setEmail("wullllllll@qq.com");
        userMapper.updateById(user2);
        // 自旋锁来多次尝试提交
        userMapper.updateById(user); // 如果没有乐观锁就会覆盖插队线程的值！
    }


    //测试查询 selectById
    @Test
    public void testSelectById(){
        User user = userMapper.selectById(1379445215932407810L);
        System.out.println(user);
    }
    // 测试批量查询！ selectBatchIds
    @Test
    public void testSelectByBatchId(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }
    // 按条件查询之一 使用map操作 selectByMap
    @Test
    public void testSelect(){
        HashMap<String, Object> map = new HashMap<>();
        //自定义查询
        map.put("name","joker");
        map.put("age","3");
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    //测试分页查询
    @Test
    public void testPage(){
        //参数一：当前页
        //参数二：页面大小
        //使用过了分页插件，所有的分页都变简单了。
        Page<User> page = new Page<>(2,5);
        userMapper.selectPage(page,null);

        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());

    }

    //测试删除 delete
    @Test
    public void testDeleteById(){
        userMapper.deleteById(1379445215932407810L);
    }
    //批量删除
    @Test
    public void testDeleteBatchIds(){
        int batchIds = userMapper.deleteBatchIds(Arrays.asList(1379439563847753729L, 1379444113316921345L));
    }
    //通过map删除
    @Test
    public void testDeleteByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","joker");
        int batchIds = userMapper.deleteByMap(map);
    }
}
