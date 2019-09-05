package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 综合词表
 * </p>
 *
 * @author minfanchao
 * @since 2019-09-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("DI_ZHCB")
@ApiModel(value="DiZhcb对象", description="综合词表")
public class DiZhcb extends Model<DiZhcb> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableField("ID")
    private Long id;

    @ApiModelProperty(value = "父节点")
    @TableField("PARENT_ID")
    private Long parentId;

    @ApiModelProperty(value = "名称")
    @TableField("NAME")
    private String name;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
