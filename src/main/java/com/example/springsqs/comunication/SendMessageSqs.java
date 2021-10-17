package com.example.springsqs.comunication;

import com.example.springsqs.model.ClientDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
public class SendMessageSqs {


    @Value("${aws.sqs.queue.name}")
    private String sqsTarget;

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessageForSQS(ClientDto clientDto)  {
        try {
            var sendSqs = new ObjectMapper().writeValueAsString(clientDto);
            jmsTemplate.convertAndSend(sqsTarget,sendSqs);
            log.info("message send =" + sendSqs);
        }catch (Exception ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }


    }
}
