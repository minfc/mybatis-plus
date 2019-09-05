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
 * 用户角色表
 * </p>
 *
 * @author minfanchao
 * @since 2019-09-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("MA_USER_ROLE")
@ApiModel(value="MaUserRole对象", description="用户角色表")
public class MaUserRole extends Model<MaUserRole> {

    private static final long serialVersionUID = 1L;

    @TableId("BSM")
    private String bsm;

    @ApiModelProperty(value = "角色BSM")
    @TableField("ROLE_BSM")
    private String roleBsm;

    @ApiModelProperty(value = "用户BSM")
    @TableField("UER_BSM")
    private String uerBsm;

    @ApiModelProperty(value = "标记")
    @TableField("FLAG")
    private String flag;


    @Override
    protected Serializable pkVal() {
        return this.bsm;
    }

}
