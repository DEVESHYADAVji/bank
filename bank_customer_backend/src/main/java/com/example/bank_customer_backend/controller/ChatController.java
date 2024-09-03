package com.example.bank_customer_backend.controller;

import com.example.bank_customer_backend.entity.Chat;
import com.example.bank_customer_backend.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

 
    @PostMapping("/{customerId}")
    public ResponseEntity<Chat> createChat(@PathVariable Integer customerId, @RequestBody String message) {
        Chat savedChat = chatService.saveChat(customerId, message);
        if (savedChat != null) {
            return ResponseEntity.ok(savedChat);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Chat>> getChatsByCustomerId(@PathVariable Integer customerId) {
        List<Chat> chats = chatService.getChatsByCustomerId(customerId);
        return ResponseEntity.ok(chats);
    }

    @GetMapping
    public ResponseEntity<List<Chat>> getAllChats() {
        List<Chat> chats = chatService.getAllChats();
        return ResponseEntity.ok(chats);
    }
}
