package com.example.demo.api;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Data
@Builder
public class ParamDTO implements Serializable {

    @NotNull // disallow null
    private String name;

    @Min(value = 18, message = "年龄错误")
    @Max(value = 100, message = "年龄错误")
    private int age;
}
