package com.kangqing.mallauth2.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangqing.mallauth2.user.service.RoleService;
import com.kangqing.mallmbpg.mapper.RoleMapper;
import com.kangqing.mallmbpg.pojo.Role;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author yunqing
 * @since 2021-01-01
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
