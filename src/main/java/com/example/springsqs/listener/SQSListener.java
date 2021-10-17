package com.example.springsqs.listener;

import com.example.springsqs.model.ClientDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class SQSListener {

    @JmsListener(destination = "${aws.sqs.queue.name}")
    public void receiveProductEvent(String input)
            throws IOException {
        var message = new ObjectMapper().readValue(input, ClientDto.class);
        log.info("message received =" + message.toString());
    }
}
