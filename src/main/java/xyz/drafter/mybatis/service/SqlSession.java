package xyz.drafter.mybatis.service;

import java.sql.SQLException;

/**
 * @author wangmeng
 * @date 2019/11/16
 * @desciption
 */
public interface SqlSession {

    int save(String sql) throws SQLException;
}
