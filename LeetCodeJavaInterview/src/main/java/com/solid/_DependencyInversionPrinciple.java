package com.solid;


interface MessageService {
    void sendMessage(String message);
}

class EmailService implements MessageService {
    public void sendMessage(String message) {
        System.out.println("Email sent: " + message);
    }
}

class Notification {
    private final MessageService service;

    Notification(MessageService service) {
        this.service = service;
    }

    void send(String msg) {
        service.sendMessage(msg);
    }
}

public class _DependencyInversionPrinciple {
}
