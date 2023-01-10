package com.anjaneya.profiles;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OutputCaptureExtension.class)
class ProfilesApplicationTest {

    private Logger logger = LoggerFactory.getLogger(ProfilesApplicationTest.class);

    @Test
    public void testDefaultProfile(CapturedOutput output) {

        logger.error("Logger: testDefaultProfile");

        ProfilesApplication.main(new String[0]);
        assertThat(output).contains("Today is sunny day!");
    }

    @Test
    public void testRainingProfile(CapturedOutput output) {

        System.setProperty("spring.profiles.active", "raining");
        ProfilesApplication.main(new String[0]);

        logger.error("Logger: testRainingProfile");

        assertThat(output).contains("Today is raining day!");
    }

    @Test
    public void testRainingProfile_withDoption(CapturedOutput output) {
        ProfilesApplication.main(new String[]{"--spring.profiles.active=raining"});

        logger.error("Logger: testRainingProfile_withDoption");

        assertThat(output).contains("Today is raining day!");
    }

    @After
    public void after() {
        System.clearProperty("spring.profiles.active");
    }


}