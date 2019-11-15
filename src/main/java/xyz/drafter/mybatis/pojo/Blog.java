package xyz.drafter.mybatis.pojo;

/**
 * @author wangmeng
 * @date 2019/11/6
 * @desciption
 */
public class Blog {

    private int id;
    private String memo;
    private Boolean flag;


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
