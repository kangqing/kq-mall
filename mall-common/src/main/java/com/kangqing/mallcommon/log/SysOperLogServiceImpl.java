package com.kangqing.mallcommon.log;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.StyleSet;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangqing.mallcommon.aop.PageParam;
import com.kangqing.mallmbpg.dto.SysLogInputDTO;
import com.kangqing.mallmbpg.dto.SysLogOutDTO;
import com.kangqing.mallmbpg.mapper.SysOperLogMapper;
import com.kangqing.mallmbpg.pojo.SysOperLog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * <p>
 * 系统日志表 服务实现类
 * </p>
 *
 * @author yunqing
 * @since 2021-01-07
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog> implements SysOperLogService {

    private final SysOperLogMapper sysOperLogMapper;

    /**
     * 分页查询操作日志
     * @param sysLogInputDTO 筛选条件
     * @param pageParam 分页信息
     * @return
     */
    @Override
    public IPage<SysLogOutDTO> pageList(SysLogInputDTO sysLogInputDTO, PageParam pageParam) {
        IPage<SysLogOutDTO> page = PageParam.buildPageCondition(pageParam);
        return sysOperLogMapper.pageList(page, sysLogInputDTO);
    }

    /**
     * 导出操作日志
     * @param sysLogInputDTO 筛选条件
     * @param response 响应
     */
    @Override
    public void export(SysLogInputDTO sysLogInputDTO, HttpServletResponse response) throws IOException {
        // 输出xlsx格式, 默认xls格式
        ExcelWriter writer = ExcelUtil.getWriter(true);

        // 重命名当前sheet
        writer.renameSheet("操作日志列表");

        // 设置标题样式
        StyleSet style = writer.getStyleSet();
        CellStyle headCellStyle = style.getHeadCellStyle();
        //水平居中
        headCellStyle.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        headCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        //设置内容字体
        Font font = writer.createFont();
        //加粗
        font.setBold(true);
        //设置标题字体大小
        font.setFontHeightInPoints((short)12);
        headCellStyle.setFont(font);

        final IPage<SysLogOutDTO> sysLogOutDTOIPage = this.pageList(sysLogInputDTO, new PageParam());
        // 获取操作日志列表
        List<SysLogOutDTO> rows = sysLogOutDTOIPage.getRecords();

        //自定义标题别名, 注意列中的值要和返回的SysLogOutDTO属性一直，属性只返回需要列表显示的字段
        String[] title = {"id", "operModule", "operType", "operDesc", "username", "logIp", "logMethod", "spendTime", "exceptionName", "exceptionMsg", "createTime"};
        String[] alias = {"日志id", "操作模块", "操作类型", "操作描述", "操作人", "ip", "请求类型", "消耗时间", "异常名", "异常信息", "创建时间"};
        int[] width = {20, 15, 10, 20, 10, 15, 10, 10, 30, 40, 20};
        for (int i = 0; i < title.length; i++) {
            writer.addHeaderAlias(title[i], alias[i]);
        }

        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(title.length - 1, "操作日志列表导出");
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(rows, true);

        //合并单元格
        //writer.merge(2, 3, 2, 2, "kangqing", false);
        // 获取当前行
        //Sheet sheet = writer.getSheet();
        // 合并同一列上相同值的行
        //MergedRegionUtil.mergedRegion(sheet, 2, 2, 3);

        // 切换sheet页
        // writer.setSheet("sheet2");

        // 设置列宽度 (单位为一个字符的宽度，例如传入width为10，表示10个字符的宽度）
        for (int i = 0; i < width.length; i++) {
            writer.setColumnWidth(i, width[i]);
        }

        //导出数据
        try {

            response.setContentType("application/octet-stream;charset=iso-8859-1");
            //中文编码
            String fileName = URLEncoder.encode("操作日志", String.valueOf(StandardCharsets.UTF_8));
            //设置Http响应头告诉浏览器下载这个附件
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
            writer.flush(response.getOutputStream(), true);
            writer.close();

        } catch (Exception ex) {
            log.info("导出Excel异常，异常信息");
            throw new IOException("导出Excel异常，异常信息：" + ex.getMessage());
        } finally {
            //清理资源
            try {
                IoUtil.close(response.getOutputStream());
            } catch (IOException e) {
                log.info("清理资源错误");
            }
        }
    }
}
