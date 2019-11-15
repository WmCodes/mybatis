package xyz.drafter.mybatis.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author wangmeng
 * @date 2019/11/15
 * @desciption   setParameter方法:
 *                              在生成SQL语句时被调用
 *               getResult：
 *                      查询结束之后，在将ResultSet数据行装换为实体类对象时
 *                      通知TypeHandler将当前数据行某个字段转换为何种类型
 */
public class MyTypeHandler implements TypeHandler {
    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {

            // java boolean
            // mysql int
            if (parameter == null){
                ps.setInt(i, 0);
                return;
            }
            Boolean flag = (Boolean)parameter;
            if (flag == true){
                ps.setInt(i, 1);
            }else {
                ps.setInt(i, 0);
            }


    }

    @Override
    public Object getResult(ResultSet rs, String columnName) throws SQLException {

        int flag = rs.getInt(columnName);
        Boolean myFlag = Boolean.FALSE;
        if (flag == 1){
            myFlag = Boolean.TRUE;
        }
        return myFlag;
    }

    @Override
    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
