package com.kangqing.mallauth2.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangqing.mallauth2.user.service.UserService;
import com.kangqing.mallmbpg.mapper.UserMapper;
import com.kangqing.mallmbpg.pojo.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author yunqing
 * @since 2020-05-12
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MyUserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
