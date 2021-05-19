package com.kangqing.mall.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kangqing.mall.ums.pojo.domain.UmsMember;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface UmsUserMapper extends BaseMapper<UmsMember> {


    @Select("<script>" +
            " SELECT * from ums_member " +
            " <if test ='user.nickname !=null and user.nickname.trim() neq \"\" ' >" +
            "       AND nickname like concat('%',#{user.nickname},'%')" +
            " </if>" +
            " ORDER BY gmt_modified DESC, gmt_create DESC" +
            "</script>")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "addressList", column = "id", many = @Many(select = "com.kq.mall.ums.mapper.UmsAddressMapper.listByUserId"))
    })
    List<UmsMember> list(Page<UmsMember> page, UmsMember user);


}
