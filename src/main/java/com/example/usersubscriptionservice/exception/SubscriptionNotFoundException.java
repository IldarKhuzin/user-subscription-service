package com.example.usersubscriptionservice.exception;

public class SubscriptionNotFoundException extends RuntimeException {
    public SubscriptionNotFoundException(String message) {
        super(message);
    }

    public SubscriptionNotFoundException() {
        super("Подписка не найдена");
    }
}
