package com.todo.batch.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class BatchProccessor {

    @Scheduled(fixedRate = 10000)
    public void handle(){
        log.info("현재 시간 = {}", LocalDateTime.now());
    }

}
