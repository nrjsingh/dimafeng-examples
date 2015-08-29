package com.dimafeng.examples.spring_config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ComponentFixedTest.Config.class})
public class ComponentFixedTest {

    @Autowired
    SimpleBeanConsumer consumer;

    @Test
    public void test() {
        assertNotNull(consumer);
    }

    @Component
    public static class Config {

        @Autowired
        SimpleBean simpleBean;

        @Bean
        public SimpleBean simpleBean() {
            return new SimpleBean();
        }

        @Bean
        public SimpleBeanConsumer simpleBeanConsumer() {
            return new SimpleBeanConsumer(simpleBean);
        }
    }
}
