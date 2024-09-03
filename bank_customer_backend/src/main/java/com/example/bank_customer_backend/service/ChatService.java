package com.example.bank_customer_backend.service;

import com.example.bank_customer_backend.entity.Chat;
import com.example.bank_customer_backend.entity.Customer;
import com.example.bank_customer_backend.repository.ChatRepository;
import com.example.bank_customer_backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private CustomerRepository customerRepository;

    // Save a new chat message
    public Chat saveChat(Integer customerId, String message) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Chat chat = new Chat();
            chat.setCustomer(customerOptional.get());
            chat.setMessage(message);
            chat.setChatDate(LocalDateTime.now());
            return chatRepository.save(chat);
        }
        return null;
    }

    // Get all chats by customer ID
    public List<Chat> getChatsByCustomerId(Integer customerId) {
        return chatRepository.findByCustomer_CustomerId(customerId);
    }

    // Get all chat messages
    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }
}

