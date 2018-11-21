package com.licq.springcloud.app.config;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.config.server.environment.EnvironmentController;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "spring.profiles.active=native" })
public class ConfigClientApplicationTest {

    @Autowired
    private EnvironmentController controller;

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }



}
