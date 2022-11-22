package com.future.jwt.model;

import lombok.*;

import java.io.Serializable;

/**
 * user payload in jwt
 *
 * @author liuyunfei
 */
@SuppressWarnings("AliControlFlowStatementWithoutBraces")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasePayload implements Serializable {


    /**
     * random gamma
     */
    private String gamma;

    /**
     * auth keyId for redis
     */
    private String redisId;

    /**
     * member id
     */
    private String id;


    /**
     * session time stamp
     */
    private String loginTime;

}
