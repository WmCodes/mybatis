package xyz.drafter.mybatis.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @author wangmeng
 * @date 2019/11/16
 * @desciption mybatis自定义拦截器，可以拦截的只有四种
 *                 Executor.class,StatementHandler.class,ParameterHandler.class,ResultSetHandler.class
 */
@Intercepts(
        {
                @Signature(type = Executor.class,method = "query",args = {
                        MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class
                })
        }
)
public class SimpleInterceptor implements Interceptor {


    /**
     *
     *
     * @author wangmeng
     * @date 2019/11/16 15:37
     * @param invocation :{代理对象，被监控方法对象，当前被监控方法运行时需要的实参
     * @return java.lang.Object
     * @Instructions
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        System.out.println("被拦截方法执行之前，做的服务******************");

        Object obj = invocation.proceed();// 执行被拦截的方法

        System.out.println("被拦截方法执行之后，做的服务******************");
        return obj;
    }

    /**
     *
     *
     * @author wangmeng
     * @date 2019/11/16 15:35
     * @param    o: 表示被拦截的对象，应该是Executor接口实例对象
     *            作用: 如果被拦截对象所在的类有实现接口，就为当前拦截对象生成一个[$Proxy]
     *                  如果被拦截对象所在的类没有指定接口，这个对象之后就不会有被代理对象
     * @return
     * @Instructions
     */


    @Override
    public Object plugin(Object o) {
        return  Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
