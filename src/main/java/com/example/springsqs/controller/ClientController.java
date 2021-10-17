package com.example.springsqs.controller;

import com.example.springsqs.comunication.SendMessageSqs;
import com.example.springsqs.model.ClientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/client")
public class ClientController {

    private final SendMessageSqs sendMessageSqs;

    @PostMapping
    public ResponseEntity<?> sendNewMessageForQueue(@RequestBody ClientDto clientDto){
        sendMessageSqs.sendMessageForSQS(clientDto);
        return ResponseEntity.ok().body("Message send for SQS");
    }
}
