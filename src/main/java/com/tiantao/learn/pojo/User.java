package com.tiantao.learn.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by tiantao on 2018/6/4.
 */
@Data
public class User implements Serializable{

    private  Long serialVersionUID = 1L;

    private Long id;

    private String name;

}
