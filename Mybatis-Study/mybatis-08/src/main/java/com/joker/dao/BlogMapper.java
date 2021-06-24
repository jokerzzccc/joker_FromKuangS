package com.joker.dao;

import com.joker.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入数据
    int addBlog(Blog blog);

    List<Blog> queryBlogIf(Map map);

    List<Blog> queryBlogChoose(Map map);

    int updateBlog(Map map);
    List<Blog> queryForeach(Map map);
}
