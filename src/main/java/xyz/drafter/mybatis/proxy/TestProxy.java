package xyz.drafter.mybatis.proxy;

import xyz.drafter.mybatis.proxy.service.BaseService;
import xyz.drafter.mybatis.proxy.serviceImpl.Person;

/**
 * @author wangmeng
 * @date 2019/11/16
 * @desciption
 */
public class TestProxy {

    public static void main(String[] args) {


        try {
           BaseService mike =  ProxyFactory.builder(Person.class);
           mike.eat();
           mike.wc();




        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
