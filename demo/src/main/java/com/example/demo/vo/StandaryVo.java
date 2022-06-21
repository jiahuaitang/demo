package com.example.demo.vo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class StandaryVo {

    @NotNull(message = "id不能为空")
    private Integer id;
    @NotBlank(message = "name不能为空")
    private String name;
    @Min(value = 0, message = "商品价格不允许为负数")
    private BigDecimal price;
}
