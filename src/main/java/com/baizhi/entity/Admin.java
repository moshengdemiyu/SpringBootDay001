package com.baizhi.entity;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode   // 提供equals和hashcode方法
public class Admin {
    private Integer id;
    private String username;
    private String name;
    private String password;
    private String sex;
}
