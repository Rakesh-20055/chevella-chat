package com.chat.chatapp;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class HomeController {

    private List<Map<String,String>> messages = new ArrayList<>();

    @GetMapping("/hello")
    public String home() {
        return "Chat App is Working! Welcome to Chevella Chat!";
    }

    @GetMapping("/api/messages")
    public List<Map<String,String>> getMessages() {
        return messages;
    }

    @PostMapping("/api/messages")
    public Map<String,String> sendMessage(@RequestBody Map<String,String> msg) {
        messages.add(msg);
        return msg;
    }

    @DeleteMapping("/api/messages")
    public String clearMessages() {
        messages.clear();
        return "Cleared";
    }
}