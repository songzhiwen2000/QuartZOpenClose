package cn.qk.timerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@ComponentScan("cn.qk")
@EnableCaching
public class TimerapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(TimerapiApplication.class, args);

    }
}


