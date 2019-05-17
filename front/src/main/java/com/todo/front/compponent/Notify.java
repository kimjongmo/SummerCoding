package com.todo.front.compponent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.Socket;

@Component
@Slf4j
public class Notify {
    @Scheduled(fixedRate = 10000)
    public void run() {
        Socket socket;
        try {
            socket = new Socket("localhost", 8080);

        } catch (Exception e) {
            log.error("[Notify]에러 : {}", e);
        }
    }

}
