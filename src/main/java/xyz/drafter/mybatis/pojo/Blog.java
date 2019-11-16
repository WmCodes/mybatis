package xyz.drafter.mybatis.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wangmeng
 * @date 2019/11/6
 * @desciption
 */
public class Blog {

    private int id;
    private String memo;
    private Boolean flag;

    // 入职时间 数据库中有
    private Date hireDate;

    //工作年限 数据库中午
    private int workAge;

    public Blog(Date hireDate) {
        this.hireDate = hireDate;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        this.workAge = Integer.valueOf(sdf.format(new Date()))- Integer.valueOf(sdf.format(hireDate));
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", memo='" + memo + '\'' +
                '}';
    }
}
