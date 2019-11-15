package com.itheima.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import xyz.drafter.mybatis.dao.BlogMapper;
import xyz.drafter.mybatis.pojo.Blog;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangmeng
 * @date 2019/11/6
 * @desciption
 */
public class TestMain {

    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Blog blog = null;
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
             blog = mapper.selectBlog(1);
        }

        System.out.println(blog);

    }
}
