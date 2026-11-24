package com.chat.chatapp;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDateTime;

@RestController
@CrossOrigin
public class ChatController {
    private final MessageRepository repo;
    public ChatController(MessageRepository repo) { this.repo = repo; }

    @PostMapping("/api/messages")
    public Message saveMessage(@RequestBody Message msg) {
        if(msg.getCreatedAt()==null) msg.setCreatedAt(LocalDateTime.now());
        if(msg.getStatus()==null) msg.setStatus("DELIVERED");
        return repo.save(msg);
    }
    @GetMapping("/api/messages")
    public List<Message> getMessages() { return repo.findAll(); }

    @PutMapping("/api/messages/{id}/read")
    public Message markRead(@PathVariable Long id) {
        Message m = repo.findById(id).orElseThrow();
        m.setStatus("READ");
        return repo.save(m);
    }
    @DeleteMapping("/api/messages/{id}")
    public void deleteMessage(@PathVariable Long id) { repo.deleteById(id); }

    @PutMapping("/api/messages/{id}/deleteforme")
    public Message deleteForMe(@PathVariable Long id, @RequestParam String user) {
        Message m = repo.findById(id).orElseThrow();
        m.setDeletedFor(user);
        return repo.save(m);
    }
}