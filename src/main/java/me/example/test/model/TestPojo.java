package me.example.test.model;


import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "table1")
public class TestPojo {
    @Id
    private Integer id;
    private Integer num;
    private Integer status;

    public TestPojo(Integer id, Integer num, Integer status) {
        this.id = id;
        this.num = num;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
