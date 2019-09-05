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
 * 角色菜单关联表
 * </p>
 *
 * @author minfanchao
 * @since 2019-09-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("MA_ROLE_MENU")
@ApiModel(value="MaRoleMenu对象", description="角色菜单关联表")
public class MaRoleMenu extends Model<MaRoleMenu> {

    private static final long serialVersionUID = 1L;

    @TableId("BSM")
    private String bsm;

    @ApiModelProperty(value = "菜单主键")
    @TableField("MENU_BSM")
    private String menuBsm;

    @ApiModelProperty(value = "角色主键")
    @TableField("ROLE_BSM")
    private String roleBsm;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "删除标志")
    @TableField("DELETE_FLAG")
    private String deleteFlag;


    @Override
    protected Serializable pkVal() {
        return this.bsm;
    }

}
