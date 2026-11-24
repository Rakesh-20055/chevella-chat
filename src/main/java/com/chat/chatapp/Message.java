package com.chat.chatapp;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sender;
    private String receiver;
    private String content;
    private LocalDateTime scheduledTime;
    private LocalDateTime createdAt;
    private String status; // DELIVERED = Sad, READ = Happy
    private String hiddenFor; // Who hid this chat
    private String deletedFor; // Who deleted for me

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }
    public String getReceiver() { return receiver; }
    public void setReceiver(String receiver) { this.receiver = receiver; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public LocalDateTime getScheduledTime() { return scheduledTime; }
    public void setScheduledTime(LocalDateTime t) { this.scheduledTime = t; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime t) { this.createdAt = t; }
    public String getStatus() { return status; }
    public void setStatus(String s) { this.status = s; }
    public String getHiddenFor() { return hiddenFor; }
    public void setHiddenFor(String h) { this.hiddenFor = h; }
    public String getDeletedFor() { return deletedFor; }
    public void setDeletedFor(String d) { this.deletedFor = d; }
}