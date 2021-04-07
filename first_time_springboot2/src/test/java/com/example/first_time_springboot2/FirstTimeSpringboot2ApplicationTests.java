package com.example.first_time_springboot2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(
//        value = "value=test",  // 1
        properties = {"property.value = propertyTest", "prop = test2"}, // 2
        classes = {FirstTimeSpringboot2Application.class}, // 3
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT // 4
)
class FirstTimeSpringboot2ApplicationTests {

//    @Value("${value}")
    private String value;

    @Value("${property.value}")
    private String propertyValue;

    @Value("${prop}")
    private String propertyValue2;

    @Test
    void contextLoads() {
//        assertEquals(value, "test");
        assertEquals(propertyValue, "propertyTest");
        assertEquals(propertyValue2, "test2");
    }

}
