package io.miya.blog.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"io.miya.blog"})
public class BlogCoreServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogCoreServiceApplication.class, args);
    }
}
