package com.xjliang.bootlaunch.model.yaml;

import java.util.List;
import lombok.Data;

@Data
public class Child {

    private String name;

    private Integer age;

    private List<Friend> friends;
}
