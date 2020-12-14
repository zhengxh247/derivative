package com.team.derivative.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @author zhengxh
 */
@Data
@TableName(value = "goods_details")
public class GoodsDetailsEntity {

    @Id
    @ApiModelProperty(value = "主键id", example = "1")
    private Integer id;
    private String goodsName;
    private String publishStatus;
    private String goodsStatus;
    private Float price;
    private Integer storeCunt;
    private String shortBrief;
    private String goodsDescription;
    private Date createTime;
    private Date updateTime;
    private String imgSrc;
    private Long goodsCategoryId;
    private String size;
}
