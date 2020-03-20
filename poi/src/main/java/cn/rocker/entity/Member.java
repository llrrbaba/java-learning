package cn.rocker.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author: chengzc
 * @create: 2019-12-30 20:39
 * @since:
 **/
@Data
public class Member {

    private Integer code;
    private String name;
    private Integer age;
    private Date birth;

    public Member(Integer code, String name, Integer age, Date birth) {
        super();
        this.code = code;
        this.name = name;
        this.age = age;
        this.birth = birth;
    }

}
