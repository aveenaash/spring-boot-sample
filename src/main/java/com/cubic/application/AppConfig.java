package com.cubic.application;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.cubic.controllers", "com.cubic.service"})
@EnableJpaRepositories({"com.cubic.repositories"})
@EntityScan("com.cubic.entities")
public class AppConfig {

}
