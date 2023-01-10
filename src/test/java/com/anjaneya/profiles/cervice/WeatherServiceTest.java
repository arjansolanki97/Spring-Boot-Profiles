package com.anjaneya.profiles.cervice;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("raining")
class WeatherServiceTest {

    @Autowired
    WeatherService weatherService;

    @Test
    public void testRainingProfile() {
        String output = weatherService.forecast();
        assertThat(output).contains("Today is raining day!");
    }
}