package com.kangqing.mallauth2.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangqing.mallauth2.user.service.MenuResourceService;
import com.kangqing.mallmbpg.mapper.MenuResourceMapper;
import com.kangqing.mallmbpg.pojo.MenuResource;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author yunqing
 * @since 2021-01-01
 */
@Service
public class MenuResourceServiceImpl extends ServiceImpl<MenuResourceMapper, MenuResource> implements MenuResourceService {

}
