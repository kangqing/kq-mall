package com.kangqing.auth.service;

import com.kangqing.admin.api.UserFeignClient;
import com.kangqing.admin.pojo.dto.UserDTO;
import com.kangqing.auth.domain.User;
import com.kangqing.common.constant.AuthConstants;
import com.kangqing.common.result.Result;
import com.kangqing.common.result.ResultCode;
import com.kangqing.common.web.util.RequestUtils;
import com.kangqing.mall.ums.api.MemberFeignClient;
import com.kangqing.mall.ums.pojo.dto.AuthMemberDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 自定义用户认证和授权
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserFeignClient userFeignClient;
    private final MemberFeignClient memberFeignClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String clientId = RequestUtils.getAuthClientId();

        User user = null;

        Result<?> result;
        switch (clientId) {
            case AuthConstants.ADMIN_CLIENT_ID: // 后台用户
                result = userFeignClient.getUserByUsername(username);
                log.info("获取用户信息：{}", result.toString());
                if (ResultCode.SUCCESS.getCode().equals(result.getCode())) {
                    UserDTO userDTO = (UserDTO) result.getData();
                    user = new User(userDTO);
                }
                break;
            case AuthConstants.WEAPP_CLIENT_ID: // 小程序会员
                result = memberFeignClient.getUserByOpenid(username);
                if (ResultCode.SUCCESS.getCode().equals(result.getCode())) {
                    AuthMemberDTO authMemberDTO = (AuthMemberDTO) result.getData();
                    user = new User(authMemberDTO);
                }
                break;
        }
        if (user == null || user.getId() == null) {
            throw new UsernameNotFoundException(ResultCode.USER_NOT_EXIST.getMsg());
        } else if (!user.isEnabled()) {
            throw new DisabledException("该账户已被禁用!");
        } else if (!user.isAccountNonLocked()) {
            throw new LockedException("该账号已被锁定!");
        } else if (!user.isAccountNonExpired()) {
            throw new AccountExpiredException("该账号已过期!");
        }
        return user;
    }

}
