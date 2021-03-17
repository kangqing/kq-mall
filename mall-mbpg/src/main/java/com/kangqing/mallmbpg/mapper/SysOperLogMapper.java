package com.kangqing.mallmbpg.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.kangqing.mallmbpg.dto.SysLogInputDTO;
import com.kangqing.mallmbpg.dto.SysLogOutDTO;
import com.kangqing.mallmbpg.pojo.SysOperLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 系统日志表 Mapper 接口
 * </p>
 *
 * @author yunqing
 * @since 2021-03-08
 */
public interface SysOperLogMapper extends BaseMapper<SysOperLog> {
    IPage<SysLogOutDTO> pageList(IPage<?> page, @Param("param") SysLogInputDTO sysLogInputDTO);
}
