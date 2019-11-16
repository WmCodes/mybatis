package xyz.drafter.mybatis.proxy;

import xyz.drafter.mybatis.proxy.service.BaseService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wangmeng
 * @date 2019/11/16
 * @desciption
 */
public class Invocation implements InvocationHandler {

    private BaseService obj;//具体被监控对象

    public Invocation(BaseService param){
        this.obj = param;
    }
    /**
     *
     *
     * @author wangmeng
     * @date 2019/11/16 17:20
     * @param [proxy, method, args]
     * @return java.lang.Object
     * @Instructions  被监控行为将要执行时，会被JVM拦截
     *                  被监控行为和行为实现方会被作为参数输送invoke
     *                  通知JVM，这个拦截方法是如何与当前次要业务方法绑定实现
     *
     *              invoke方法三个参数:
     *                      人.eat();//JVM拦截
     *                      eat方法封装为Method类型对象
     *                      eat方法运行时接收所有的实参封装到Object[]
     *                      将负责监控 人 的代理对象作为invoke方法第一个参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //0.局部变量，接收主要业务方法执行完毕后返回值
        Object value;
        System.out.println("=========="+method.getName()+"=============");
        //1.确认当前被拦截行为
        String methodName = method.getName();
        //2.根据被拦截行为不同，决定主要业务和次要业务如何去绑定
        if ("eat".equals(methodName)){
            wash();
            value = method.invoke(this.obj, args);
        }else if ("wc".equals(methodName)){
            value = method.invoke(this.obj, args);
            wash();
        }else {
            // IDEA工具类在debug模式下单步调用的时候会调用代理类的toString方法
            value = method.invoke(this.obj, args);
            wash();
        }

        return value;
    }


    // 次要业务
    public void wash(){
        System.out.println("洗手");
    }

}
