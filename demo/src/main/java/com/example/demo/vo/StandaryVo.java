package com.example.demo.vo;

import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
public class StandaryVo {

    @NotNull(message = "id不能为空")
    private Integer id;
    @NotBlank(message = "name不能为空")
    private String name;
    @Min(value = 0, message = "商品价格不允许为负数")
    private BigDecimal price;
    @NotNull(message = "密码不能为空")
    @Size(min = 6,max = 18,message = "密码必须为6-18位字符")
    private String password;
    @NotNull(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;
}
