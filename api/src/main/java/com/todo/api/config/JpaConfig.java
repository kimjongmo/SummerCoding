package com.todo.api.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaAuditing
@ComponentScan(basePackages = {"com.todo.common"})
@EntityScan(basePackages = {"com.todo.common.entity"})
@EnableJpaRepositories(basePackages = {"com.todo.common.repo"})
public class JpaConfig {
}
