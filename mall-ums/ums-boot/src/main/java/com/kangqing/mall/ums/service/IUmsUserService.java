package com.kangqing.mall.ums.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kangqing.mall.ums.pojo.domain.UmsMember;

public interface IUmsUserService extends IService<UmsMember> {

    IPage<UmsMember> list(Page<UmsMember> page, UmsMember user);
}
