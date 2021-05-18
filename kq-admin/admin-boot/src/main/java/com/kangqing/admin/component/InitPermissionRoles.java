package com.kangqing.admin.component;

import com.kangqing.admin.service.ISysPermissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 容器启动完成时加载角色权限规则至Redis缓存
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class InitPermissionRoles implements CommandLineRunner {

    private final ISysPermissionService iSysPermissionService;

    @Override
    public void run(String... args) {
        iSysPermissionService.refreshPermissionRolesCache();
    }
}
