package xyz.drafter.mybatis.service.impl;

import xyz.drafter.mybatis.service.SqlSession;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author wangmeng
 * @date 2019/11/16
 * @desciption
 */
public class DeptMapper implements SqlSession {


    // JDBC主要业务与次要业务分析
    // 1.加载驱动[次]
    // 2.建立链接通道[次]
    // 3.建立PreparedStament[次]
    // 4.输送sql命令到数据库执行，并带回运行结果[主]
    // 5.销毁链接通道，PreparedStament[次]

    private PreparedStatement ps;



    @Override
    public int save(String sql) throws SQLException {
        //jdbc主要业务，输送sql

        int num = ps.executeUpdate(sql);
        return num;
    }
}
