package com.kangqing.common.constant;

/**
 * 自定义认证相关接口常量
 *
 * @author kangqing
 * @since 2021/5/17 13:01
 */
public interface AuthConstants {

    /**
     * 认证请求头 key
     */
    String AUTHORIZATION_KEY = "Authorization";

    /**
     * JWT 令牌前缀, 注意空格
     */
    String AUTHORIZATION_PREFIX = "bearer ";

    /**
     * Basic 认证前缀， 注意空格
     */
    String BASIC_PREFIX = "Basic ";

    /**
     * JWT载体key
     */
    String JWT_PAYLOAD_KEY = "payload";

    /**
     * JWT ID 唯一标识
     */
    String JWT_JTI = "jti";

    /**
     * JWT ID 唯一标识
     */
    String JWT_EXP = "exp";

    /**
     * Redis缓存权限规则key
     */
    String PERMISSION_ROLES_KEY = "auth:permission:roles";

    /**
     * 黑名单token前缀
     */
    String TOKEN_BLACKLIST_PREFIX = "auth:token:blacklist:";

    String CLIENT_DETAILS_FIELDS = "client_id, CONCAT('{noop}',client_secret) as client_secret, resource_ids, scope, "
            + "authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, "
            + "refresh_token_validity, additional_information, autoapprove";

    String BASE_CLIENT_DETAILS_SQL = "select " + CLIENT_DETAILS_FIELDS + " from oauth_client_details";

    String FIND_CLIENT_DETAILS_SQL = BASE_CLIENT_DETAILS_SQL + " order by client_id";

    String SELECT_CLIENT_DETAILS_SQL = BASE_CLIENT_DETAILS_SQL + " where client_id = ?";

    /**
     * 密码加密方式
     */
    String BCRYPT = "{bcrypt}";

    String USER_ID_KEY = "user_id";

    String USER_NAME_KEY = "username";

    String CLIENT_ID_KEY = "client_id";

    /**
     * JWT存储权限前缀
     */
    String AUTHORITY_PREFIX = "ROLE_";

    /**
     * JWT存储权限属性
     */
    String JWT_AUTHORITIES_KEY = "authorities";


    /**
     * 康晴商城后台管理客户端ID
     */
    String ADMIN_CLIENT_ID = "kq-admin";


    /**
     * 康晴商城微信小程序客户端ID
     */
    String WEBAPP_CLIENT_ID = "kq-mall-webapp";

    /**
     * 后台管理接口路径匹配
     */
    String ADMIN_URL_PATTERN = "**/api.admin/**";

    /**
     * 登出路径
     */
    String LOGOUT_PATH = "/kq-auth/oauth/logout";

    String GRANT_TYPE_KEY = "grant_type";

    String REFRESH_TOKEN = "refresh_token";

    // TODO yx
    String WEAPP_CLIENT_ID = "";
}
