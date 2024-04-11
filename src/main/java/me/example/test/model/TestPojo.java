package me.example.test.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
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

}
