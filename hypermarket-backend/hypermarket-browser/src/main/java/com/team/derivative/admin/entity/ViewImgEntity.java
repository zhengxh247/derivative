package com.team.derivative.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author zhengxh
 */
@Data
@TableName(value = "view_img")
public class ViewImgEntity {

    @Id
    @ApiModelProperty(value = "主键id", example = "1")
    private Integer id;

    private String type;
    private String targetId;
    private String imgUrl;
    private String sort;
    private String creatime;
}
