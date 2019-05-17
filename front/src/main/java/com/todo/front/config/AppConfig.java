package com.todo.front.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@ComponentScan(basePackages = {"com.todo.common"})
@EntityScan(basePackages = {"com.todo.common.entity","com.todo.front"})
@EnableJpaRepositories(basePackages = {"com.todo.common.repo"})
public class AppConfig {
}
