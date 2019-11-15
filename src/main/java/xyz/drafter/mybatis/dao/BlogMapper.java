package xyz.drafter.mybatis.dao;

import xyz.drafter.mybatis.pojo.Blog;

/**
 * @author wangmeng
 * @date 2019/11/6
 * @desciption
 */
public interface BlogMapper {

    Blog selectBlog(int id);
}
