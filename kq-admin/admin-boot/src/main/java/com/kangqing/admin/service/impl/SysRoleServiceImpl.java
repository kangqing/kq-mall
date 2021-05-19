package com.kangqing.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangqing.admin.mapper.SysRoleMapper;
import com.kangqing.admin.pojo.entity.SysRole;
import com.kangqing.admin.pojo.entity.SysRoleMenu;
import com.kangqing.admin.pojo.entity.SysRolePermission;
import com.kangqing.admin.pojo.entity.SysUserRole;
import com.kangqing.admin.service.ISysRoleMenuService;
import com.kangqing.admin.service.ISysRolePermissionService;
import com.kangqing.admin.service.ISysRoleService;
import com.kangqing.admin.service.ISysUserRoleService;
import com.kangqing.common.web.exception.BizException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    private final ISysRoleMenuService iSysRoleMenuService;
    private final ISysUserRoleService iSysUserRoleService;
    private final ISysRolePermissionService iSysRolePermissionService;


    @Override
    public boolean delete(List<Long> ids) {
        Optional.ofNullable(ids).orElse(new ArrayList<>()).forEach(id -> {
            int count = iSysUserRoleService.count(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getRoleId, id));
            if (count > 0) {
                throw new BizException("该角色已分配用户，无法删除");
            }
            iSysRoleMenuService.remove(new LambdaQueryWrapper<SysRoleMenu>().eq(SysRoleMenu::getRoleId, id));
            iSysRolePermissionService.remove(new LambdaQueryWrapper<SysRolePermission>().eq(SysRolePermission::getRoleId,id));
        });
        return this.removeByIds(ids);
    }

}
