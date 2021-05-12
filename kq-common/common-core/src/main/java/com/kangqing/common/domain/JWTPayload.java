package com.kangqing.common.domain;

import lombok.Data;

/**
 * JWT
 *
 * @author kangqing
 * @since 2021/5/12 13:05
 */
@Data
public class JWTPayload {

    private String jti;

    private Long exp;
}
