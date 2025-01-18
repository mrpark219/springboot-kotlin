package me.park.springbootkotlin.domain.configuration

import io.github.oshai.kotlinlogging.KotlinLogging
import org.assertj.core.api.Assertions.assertThat
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig
import org.junit.jupiter.api.Test

private val logger = KotlinLogging.logger { }

class JasyptConfigurationTest {

    @Test
    fun test() {

        // given
        val encryptor = PooledPBEStringEncryptor()
        val config = SimpleStringPBEConfig()
        config.password = "q1w2e3"
        config.algorithm = "PBEWithMD5AndDES"
        config.setKeyObtentionIterations("1000")
        config.setPoolSize("1")
        config.providerName = "SunJCE"
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator")
        config.setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator")
        config.stringOutputType = "base64"
        encryptor.setConfig(config)

        // when
        val plainPassword = "1234"
        val encryptedPassword = encryptor.encrypt(plainPassword)
        val decryptedPassword = encryptor.decrypt(encryptedPassword)

        // then
        logger.info { "plainPassword: $plainPassword" }
        logger.info { "encryptedPassword: $encryptedPassword" }
        logger.info { "decryptedPassword: $decryptedPassword" }

        assertThat(decryptedPassword).isEqualTo(plainPassword)
    }
}