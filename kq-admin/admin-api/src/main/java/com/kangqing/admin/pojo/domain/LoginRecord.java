package com.kangqing.admin.pojo.domain;

import com.kangqing.common.base.BaseDocument;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author kangqing
 * @since 2021-5/18
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LoginRecord extends BaseDocument {

    private String clientIP;

    private long elapsedTime;

    private Object message;

    private String token;

    private String username;

    private String loginTime;

    private String region;

    /**
     * 会话状态 0-离线 1-在线
     */
    private Integer status;

}
