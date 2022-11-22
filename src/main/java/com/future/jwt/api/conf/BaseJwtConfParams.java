package com.future.jwt.api.conf;

import com.future.jwt.model.BasePayload;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * jwt params
 *
 * @author liuyunfei
 */
@SuppressWarnings({"unused", "AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc"})
@Data
public abstract class BaseJwtConfParams<T extends BasePayload> implements JwtConf<T> {

    protected transient Long maxExpiresMillis;
    protected transient Long minExpiresMillis;
    protected transient Long refreshExpiresMillis;

    protected transient String signKey;
    protected transient List<String> gammaSecrets;

    protected String issuer;
    protected String subject;
    protected String audience;

    public BaseJwtConfParams() {
    }

    public BaseJwtConfParams(Long maxExpiresMillis, Long minExpiresMillis, Long refreshExpiresMillis, String signKey, List<String> gammaSecrets) {
        this.maxExpiresMillis = maxExpiresMillis;
        this.minExpiresMillis = minExpiresMillis;
        this.refreshExpiresMillis = refreshExpiresMillis;
        this.signKey = signKey;
        this.gammaSecrets = gammaSecrets;
        this.issuer = "";
        this.subject = "";
        this.audience = "";
    }

    public BaseJwtConfParams(Long maxExpiresMillis, Long minExpiresMillis, Long refreshExpiresMillis, String signKey, List<String> gammaSecrets, String issuer, String subject, String audience) {
        this.maxExpiresMillis = maxExpiresMillis;
        this.minExpiresMillis = minExpiresMillis;
        this.refreshExpiresMillis = refreshExpiresMillis;
        this.signKey = signKey;
        this.gammaSecrets = gammaSecrets;
        this.issuer = issuer;
        this.subject = subject;
        this.audience = audience;
    }



}
