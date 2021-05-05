package com.kangqing.mallmbpg.mapper;

import com.kangqing.mallmbpg.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author yunqing
 * @since 2021-03-09
 */
public interface UserMapper extends BaseMapper<User> {

    List<String> selectRoleByUserId(String name);

}
