package com.kangqing.mall.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kangqing.mall.ums.pojo.domain.UmsAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UmsAddressMapper extends BaseMapper<UmsAddress> {

    @Select("<script>" +
            " SELECT * from ums_address where member_id =#{userId} " +
            "</script>")
    List<UmsAddress> listByUserId(Long userId);

}
