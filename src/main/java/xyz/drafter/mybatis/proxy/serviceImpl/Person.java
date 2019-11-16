package xyz.drafter.mybatis.proxy.serviceImpl;

import xyz.drafter.mybatis.proxy.service.BaseService;

/**
 * @author wangmeng
 * @date 2019/11/16
 * @desciption
 */
public class Person implements BaseService {



    @Override
    public void eat() {
        System.out.println("吃饭");
    }

    @Override
    public void wc() {
        System.out.println("上厕所");
    }
}
