package com.kangqing.mallcommon.log;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kangqing.mallcommon.aop.PageParam;
import com.kangqing.mallmbpg.dto.SysLogInputDTO;
import com.kangqing.mallmbpg.dto.SysLogOutDTO;
import com.kangqing.mallmbpg.pojo.SysOperLog;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kangqing
 * @since 2021/3/9 15:21
 */
public interface SysOperLogService extends IService<SysOperLog> {

    IPage<SysLogOutDTO> pageList(SysLogInputDTO sysLogInputDTO, PageParam pageParam);

    void export(SysLogInputDTO sysLogInputDTO, HttpServletResponse response) throws IOException;

}
