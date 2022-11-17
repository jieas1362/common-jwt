package com.future.jwt.api.generator;

import com.future.jwt.api.conf.JwtConf;
import com.future.jwt.component.JwtProcessor;
import com.future.jwt.component.ProJwtProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JwtProcessor generator
 *
 * @author liuyunfei
 */
@SuppressWarnings("JavaDoc")
public final class ProJwtProcessorGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProJwtProcessorGenerator.class);

    /**
     * generate jwt processor
     *
     * @param jwtConf
     * @return
     */
    public static <T> JwtProcessor<T> generate(JwtConf<T> jwtConf) {
        LOGGER.info("<T> JwtProcessor<T> generate(JwtConf<T> jwtConf), jwtConf = {}", jwtConf);
        return new ProJwtProcessor<>(jwtConf);
    }

}
