package com.kangqing.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangqing.admin.mapper.OauthClientDetailsMapper;
import com.kangqing.admin.pojo.entity.OauthClientDetails;
import com.kangqing.admin.service.IOauthClientDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author kangqing
 * @since 2020-11-06
 */
@Service
public class OauthClientDetailsServiceImpl extends ServiceImpl<OauthClientDetailsMapper, OauthClientDetails> implements IOauthClientDetailsService {
}
