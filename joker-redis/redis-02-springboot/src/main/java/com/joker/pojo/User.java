package com.joker.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
//企业中，所有的pojo都序列化了
public class User implements Serializable {
    private String name;
    private int age;
}
