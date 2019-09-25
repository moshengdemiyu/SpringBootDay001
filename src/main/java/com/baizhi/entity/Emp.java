package com.baizhi.entity;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode   // 提供equals和hashcode方法
public class Emp {
    private Integer id;
    private String picture;
    private String username;
    private Double salary;
    private Integer age;
    private Integer depid;
    private Dep dep;
}
