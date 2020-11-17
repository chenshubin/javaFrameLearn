package cn.murphy.springbootLearning.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Demo {
    @Id
    @GeneratedValue
    private Long id;//id
    private String name;//名称
    private Integer age;







}
