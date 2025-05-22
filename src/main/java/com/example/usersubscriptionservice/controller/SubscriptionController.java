package com.example.usersubscriptionservice.controller;

import com.example.usersubscriptionservice.dto.SubscriptionDto;
import com.example.usersubscriptionservice.service.SubscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users/{userId}/subscriptions")
public class SubscriptionController {

    private static final Logger logger = LoggerFactory.getLogger(SubscriptionController.class);

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    // Добавить подписку пользователю
    @PostMapping
    public ResponseEntity<SubscriptionDto> addSubscription(@PathVariable UUID userId, @RequestBody SubscriptionDto subscriptionDto) {
        logger.info("Добавление подписки пользователю с id {}: {}", userId, subscriptionDto);
        SubscriptionDto createdSubscription = subscriptionService.addSubscription(userId, subscriptionDto);
        return new ResponseEntity<>(createdSubscription, HttpStatus.CREATED);
    }

    // Получить список подписок пользователя
    @GetMapping
    public ResponseEntity<List<SubscriptionDto>> getUserSubscriptions(@PathVariable UUID userId) {
        logger.info("Получение подписок пользователя с id {}", userId);
        List<SubscriptionDto> subscriptions = subscriptionService.getUserSubscriptions(userId);
        return ResponseEntity.ok(subscriptions);
    }

    // Удалить подписку пользователя
    @DeleteMapping("/{subscriptionId}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable UUID userId, @PathVariable UUID subscriptionId) {
        logger.info("Удаление подписки с id {} у пользователя с id {}", subscriptionId, userId);
        subscriptionService.deleteSubscription(userId, subscriptionId);
        return ResponseEntity.noContent().build();
    }
}
