package com.team.derivative.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author zhengxh
 */
@Data
@TableName(value = "goods_category")
public class GoodsCategoryEntity {

    @Id
    @ApiModelProperty(value = "主键id", example = "1")
    private Integer id;

    private String name;
    private String keyword;
    private Integer correlation;
    private Integer sort;
}
