package xyz.drafter.mybatis.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author wangmeng
 * @date 2019/11/16
 * @desciption
 */
public class Invocation implements InvocationHandler {

    private SqlSession obj; //具体监控对象
    Connection connection;
    PreparedStatement ps;

    public Invocation(SqlSession param){
        this.obj = param;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object value;

        // 执行JDBC初始次要业务
        init();
        // 执行JDBC主要业务
        Field psField = obj.getClass().getDeclaredField("ps");
        psField.setAccessible(true);
        psField.set(obj,ps);

        value = method.invoke(obj, args);
        //执行JDBC结束次要业务
        close();
        return value;
    }

    // 次要业务
    private void init() throws Exception{

        Class.forName("com.mysql.jdbc.Driver");
         connection = DriverManager.getConnection("jdbc:mysql://xxx.xxx.xxx.xxx:3306/xxx","root","password");
         ps = connection.prepareStatement("");
    }

    //关闭
    private void close() throws Exception{
        if (ps!=null){
            ps.close();
        }

        if (connection != null){

            connection.close();
        }

    }
}
