package com.kangqing.mallauth2.oauth2;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kangqing.mallauth2.constant.MessageConstant;
import com.kangqing.mallauth2.user.dto.SecurityUser;
import com.kangqing.mallmbpg.mapper.UserMapper;
import com.kangqing.mallmbpg.pojo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 用户管理业务实现类
 * @author kangqing
 * @since 2021/2/24 11:06
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {

    private List<UserDTO> userList;

    private final PasswordEncoder passwordEncoder;

    private final HttpServletRequest request;

    private final UserMapper userMapper;


    /* 自定义用户
    @PostConstruct
    public void initData() {
        String password = passwordEncoder.encode("123456");
        userList = new ArrayList<>();
        userList.add(new UserDTO(1L,"kangqing", password,1, CollUtil.toList("ADMIN")));
        userList.add(new UserDTO(2L,"kk", password,1, CollUtil.toList("TEST")));
    }*/

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        /*List<UserDTO> findUserList = userList.stream().filter(item -> item.getUsername().equals(s))
                .collect(Collectors.toList());*/
        /**
         * 根据应用 clientId 获取不同的用户信息
         */
        String clientId = request.getParameter("client_id");
        UserDTO userDto = selectUserByName(s);

        /* clientId 分为前台商城用户和后台管理用户，目前我只做了一个用户表
        if(AuthConstant.ADMIN_CLIENT_ID.equals(clientId)){
            userDto = adminService.loadUserByUsername(username);
        }else{
            userDto = memberService.loadUserByUsername(username);
        }*/

        if (userDto == null) {
            throw new UsernameNotFoundException(MessageConstant.USERNAME_PASSWORD_ERROR.getMsg());
        }
        Objects.requireNonNull(userDto).setClientId(clientId);
        SecurityUser securityUser = new SecurityUser(userDto);
        //SecurityUser securityUser = new SecurityUser(findUserList.get(0));
        if (!securityUser.isEnabled()) {
            throw new DisabledException(MessageConstant.ACCOUNT_DISABLED.getMsg());
        } else if (!securityUser.isAccountNonLocked()) {
            throw new LockedException(MessageConstant.ACCOUNT_LOCKED.getMsg());
        } else if (!securityUser.isAccountNonExpired()) {
            throw new AccountExpiredException(MessageConstant.ACCOUNT_EXPIRED.getMsg());
        } else if (!securityUser.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(MessageConstant.CREDENTIALS_EXPIRED.getMsg());
        }
        return securityUser;
    }

    /**
     * 根据用户名查询
     * @param name
     */
    private UserDTO selectUserByName(String name) {
        User user = userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getUsername, name));
        if (user != null) {
            UserDTO dto = new UserDTO();
            BeanUtils.copyProperties(user, dto);
            List<String> roles = userMapper.selectRoleByUserId(name);
            if (CollUtil.isNotEmpty(roles)) {
                dto.setRoles(roles);
            }
            return dto;
        }
        return null;
    }
}
