package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author minfanchao
 * @since 2019-09-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("MA_MENU")
@ApiModel(value="MaMenu对象", description="菜单表")
public class MaMenu extends Model<MaMenu> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId("BSM")
    private String bsm;

    @ApiModelProperty(value = "路径")
    @TableField("PATH")
    private String path;

    @ApiModelProperty(value = "标题")
    @TableField("TITLE")
    private String title;

    @ApiModelProperty(value = "父BSM")
    @TableField("PARENT_BSM")
    private String parentBsm;

    @ApiModelProperty(value = "排序")
    @TableField("ORDER_NO")
    private Integer orderNo;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;


    @Override
    protected Serializable pkVal() {
        return this.bsm;
    }

}
