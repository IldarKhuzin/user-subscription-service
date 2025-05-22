package com.example.usersubscriptionservice.service;

import com.example.usersubscriptionservice.dto.SubscriptionDto;
import com.example.usersubscriptionservice.dto.TopSubscriptionDto;
import com.example.usersubscriptionservice.entity.Subscription;
import com.example.usersubscriptionservice.entity.User;
import com.example.usersubscriptionservice.repository.SubscriptionRepository;
import com.example.usersubscriptionservice.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;

    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository,
                                   UserRepository userRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public SubscriptionDto addSubscription(UUID userId, SubscriptionDto subscriptionDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id " + userId));

        Subscription subscription = new Subscription();
        subscription.setServiceName(subscriptionDto.getServiceName());
        subscription.setUser(user);

        Subscription savedSubscription = subscriptionRepository.save(subscription);

        return entityToDto(savedSubscription);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SubscriptionDto> getUserSubscriptions(UUID userId) {
        List<Subscription> subscriptions = subscriptionRepository.findByUserId(userId);
        return subscriptions.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteSubscription(UUID userId, UUID subscriptionId) {
        Subscription subscription = subscriptionRepository.findById(subscriptionId)
                .orElseThrow(() -> new RuntimeException("Subscription not found with id " + subscriptionId));

        if (!subscription.getUser().getId().equals(userId)) {
            throw new RuntimeException("Subscription does not belong to user with id " + userId);
        }

        subscriptionRepository.delete(subscription);
    }

    @Override
    public List<TopSubscriptionDto> getTopSubscriptions(int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return subscriptionRepository.findTopSubscriptions(pageable);
    }

    private SubscriptionDto entityToDto(Subscription subscription) {
        SubscriptionDto dto = new SubscriptionDto();
        dto.setUserId(subscription.getId());
        dto.setServiceName(subscription.getServiceName());
        dto.setUserId(subscription.getUser().getId());
        return dto;
    }
}
