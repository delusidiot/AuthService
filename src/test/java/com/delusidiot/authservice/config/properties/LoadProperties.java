package com.delusidiot.authservice.config.properties;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author : delusidiot
 * @fileName : LoadProperties
 * @date : 2022-06-21
 * Properties Test Reference
 * https://www.baeldung.com/spring-boot-testing-configurationproperties
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration(initializers = ConfigDataApplicationContextInitializer.class)
@EnableConfigurationProperties({
        AppProperties.class,
        CorsProperties.class
})
@ActiveProfiles("test")
public class LoadProperties {
    @Autowired
    private AppProperties appProperties;

    @Autowired
    private CorsProperties corsProperties;

    @Test
    void LoadAppProperties() {
        Assertions.assertThat(appProperties).isNotNull();
        Assertions.assertThat(appProperties.getAuth().getTokenSecret()).isEqualTo("testTokenSecret");
    }

    @Test
    void LoadCorsProperties() {
        Assertions.assertThat(corsProperties).isNotNull();
        Assertions.assertThat(corsProperties.getMaxAge()).isEqualTo(3600L);
    }
}
