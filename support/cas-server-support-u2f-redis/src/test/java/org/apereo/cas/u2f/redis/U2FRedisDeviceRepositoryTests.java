package org.apereo.cas.u2f.redis;

import org.apereo.cas.adaptors.u2f.storage.AbstractU2FDeviceRepositoryTests;
import org.apereo.cas.adaptors.u2f.storage.U2FDeviceRepository;
import org.apereo.cas.config.U2FConfiguration;
import org.apereo.cas.config.U2FRedisConfiguration;
import org.apereo.cas.config.support.CasWebApplicationServiceFactoryConfiguration;
import org.apereo.cas.util.junit.EnabledIfContinuousIntegration;

import lombok.Getter;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.test.context.TestPropertySource;

/**
 * This is {@link U2FRedisDeviceRepositoryTests}.
 *
 * @author Misagh Moayyed
 * @since 6.1.0
 */
@SpringBootTest(classes = {
    U2FRedisConfiguration.class,
    U2FConfiguration.class,
    CasWebApplicationServiceFactoryConfiguration.class,
    RefreshAutoConfiguration.class
})
@TestPropertySource(properties = {
    "cas.authn.mfa.u2f.redis.host=localhost",
    "cas.authn.mfa.u2f.redis.port=6379",
})
@Tag("Redis")
@Getter
@EnabledIfContinuousIntegration
public class U2FRedisDeviceRepositoryTests extends AbstractU2FDeviceRepositoryTests {
    @Autowired
    @Qualifier("u2fDeviceRepository")
    private U2FDeviceRepository deviceRepository;
}

