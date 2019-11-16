package xyz.drafter.mybatis.service;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author wangmeng
 * @date 2019/11/16
 * @desciption
 */
public class SqlSessionFactory {

    /**
     * JDK动态代理模式下，代理对象的数据类型，应该有监控行为来描述
     *
     * 参数 Class文件，监控类
     *
     *
     */
    public static SqlSession builder(Class classFile) throws IllegalAccessException, InstantiationException {
        //1.创建被监控实例对象
        SqlSession obj = (SqlSession)classFile.newInstance();
        //2.创建一个通知对象
        InvocationHandler adviser = new Invocation(obj);
        //3.向JVM申请负责监控obj对象指定行为的监控对象(代理对象)
        /**
         *
         * loader :被监控对象隶属的类文件在内存中真是地址
         * interfaces:被监控对象隶属的类文件实现接口
         * h:监控对象发现 人 要执行被监控行为，应该有哪一个通知对象进行辅助
         *
         */
        SqlSession proxy = (SqlSession) Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),adviser);
        return proxy;
    }
}
