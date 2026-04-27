package com.ayush.chatBotApp.controller;

import com.ayush.chatBotApp.model.MessageRequest;
import com.ayush.chatBotApp.model.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class ChatController {
    @PostMapping
    public ResponseEntity<MessageResponse> receiveMessage(@RequestBody MessageRequest messageRequest) {
        String incomingRequest =  messageRequest.getMessage();

        System.out.println("Incoming message: " + incomingRequest);
        String reply = null;
        if(incomingRequest  == null){
            return (ResponseEntity<MessageResponse>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        else if(incomingRequest.equalsIgnoreCase("Hi")){
            reply = "Hello";
        }
        else if(incomingRequest.equalsIgnoreCase("Bye")){
            reply = "Goodbye";
        }
        else {
            reply = "Sorry! I don't understand.";
        }
        return ResponseEntity.ok(new MessageResponse(reply));
    }
}
