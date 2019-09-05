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
 * 用户表
 * </p>
 *
 * @author minfanchao
 * @since 2019-09-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("MA_USER")
@ApiModel(value="MaUser对象", description="用户表")
public class MaUser extends Model<MaUser> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId("BSM")
    private String bsm;

    @ApiModelProperty(value = "用户名")
    @TableField("USERNAME")
    private String username;

    @ApiModelProperty(value = "密码")
    @TableField("PASSWORD")
    private String password;

    @ApiModelProperty(value = "标识")
    @TableField("FLAG")
    private String flag;


    @Override
    protected Serializable pkVal() {
        return this.bsm;
    }

}
