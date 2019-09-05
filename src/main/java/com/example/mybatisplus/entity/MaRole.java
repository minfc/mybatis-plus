package com.example.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author minfanchao
 * @since 2019-09-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("MA_ROLE")
@ApiModel(value="MaRole对象", description="角色表")
public class MaRole extends Model<MaRole> {

    private static final long serialVersionUID = 1L;

    @TableId("BSM")
    private String bsm;

    @ApiModelProperty(value = "名称")
    @TableField("NAME")
    private String name;

    @ApiModelProperty(value = "标识")
    @TableField("FLAG")
    private String flag;

    @ApiModelProperty(value = "角色英文名")
    @TableField("ROLE_NO")
    private String roleNo;


    @Override
    protected Serializable pkVal() {
        return this.bsm;
    }

}
