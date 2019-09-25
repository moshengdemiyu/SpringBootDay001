package com.baizhi.entity;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode   // 提供equals和hashcode方法
public class Dep {
    private Integer id;
    private String number;
    private String department;
}
