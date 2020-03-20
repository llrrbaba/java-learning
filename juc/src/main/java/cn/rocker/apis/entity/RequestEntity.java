package cn.rocker.apis.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

/**
 * 请求实体，包含两部分，一部分为固定参数，一部分为不固定参数(客户端自定义)
 *
 * @author: rocker
 * @create: 2019-12-18 16:50
 * @since:
 **/
@Getter
@Setter
@ToString
@Builder
public class RequestEntity {

    private String name;
    private int age;
    private boolean honest;
    private Map<String,String> selfDefinedParams;

}
