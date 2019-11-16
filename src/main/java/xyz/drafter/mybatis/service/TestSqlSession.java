package xyz.drafter.mybatis.service;

import xyz.drafter.mybatis.service.impl.DeptMapper;

import java.sql.SQLException;

/**
 * @author wangmeng
 * @date 2019/11/16
 * @desciption
 */
public class TestSqlSession {

    public static void main(String[] args) {

        try {
            SqlSession dao = SqlSessionFactory.builder(DeptMapper.class);
            String sql = "insert * XXX";
            dao.save(sql);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
