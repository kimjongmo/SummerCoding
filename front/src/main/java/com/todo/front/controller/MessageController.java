package com.todo.front.controller;

import com.todo.common.dto.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MessageController {
    @MessageMapping(value = "/send")
    @SendTo("/topic/message")
    public Message sendToMessage(String message) {
        log.info("message = {}", message);
        return new Message(message);
    }
}
