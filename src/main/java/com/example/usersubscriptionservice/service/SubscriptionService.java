package com.example.usersubscriptionservice.service;

import com.example.usersubscriptionservice.dto.SubscriptionDto;
import com.example.usersubscriptionservice.dto.TopSubscriptionDto;

import java.util.List;
import java.util.UUID;

public interface SubscriptionService {

    SubscriptionDto addSubscription(UUID userId, SubscriptionDto subscriptionDto);

    List<SubscriptionDto> getUserSubscriptions(UUID userId);

    void deleteSubscription(UUID userId, UUID subscriptionId);

    List<TopSubscriptionDto> getTopSubscriptions(int limit);
}
