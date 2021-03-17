package com.kangqing.mallmbpg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统日志表
 * </p>
 *
 * @author yunqing
 * @since 2021-03-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysOperLog对象", description="系统日志表")
public class SysOperLog extends Model<SysOperLog> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "操作模块")
    private String operModule;

    @ApiModelProperty(value = "操作类型")
    private String operType;

    @ApiModelProperty(value = "操作描述")
    private String operDesc;

    @ApiModelProperty(value = "操作用户id")
    private Long userId;

    @ApiModelProperty(value = "操作开始时间")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "操作消耗时间")
    private Integer spendTime;

    @ApiModelProperty(value = "根路径")
    private String basePath;

    @ApiModelProperty(value = "方法路径")
    private String methodPath;

    @ApiModelProperty(value = "uri")
    private String uri;

    @ApiModelProperty(value = "url")
    private String url;

    @ApiModelProperty(value = "ip")
    private String ip;

    @ApiModelProperty(value = "方法请求类型")
    private String method;

    @ApiModelProperty(value = "请求参数")
    private String parameter;

    @ApiModelProperty(value = "请求结果")
    private String result;

    @ApiModelProperty(value = "异常名")
    private String exceptionName;

    @ApiModelProperty(value = "异常信息")
    private String exceptionMsg;

    @ApiModelProperty(value = "乐观锁版本号")
    private Long version;

    @ApiModelProperty(value = "逻辑删除，是否删除，1是 0否")
    private Integer delCode;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
