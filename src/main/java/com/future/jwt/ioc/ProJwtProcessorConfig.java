package com.future.jwt.ioc;

import com.future.jwt.api.conf.JwtConf;
import com.future.jwt.component.JwtProcessor;
import com.future.jwt.component.ProJwtProcessor;
import com.future.jwt.model.BasePayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;

@ConditionalOnBean(value = {JwtConf.class})
@AutoConfiguration
public class ProJwtProcessorConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProJwtProcessorConfig.class);

    @Bean
    JwtProcessor<?> jwtProcessor(JwtConf<?> jwtConf) {
        LOGGER.info("ProJwtProcessor proIdentityProcessor(JwtConf jwtConf), jwtConf = {}", jwtConf);
        return new ProJwtProcessor<>(jwtConf);
    }
}
