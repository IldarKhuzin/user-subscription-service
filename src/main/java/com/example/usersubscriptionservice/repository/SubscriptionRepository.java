package com.example.usersubscriptionservice.repository;

import com.example.usersubscriptionservice.entity.Subscription;
import com.example.usersubscriptionservice.dto.TopSubscriptionDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface SubscriptionRepository extends CrudRepository<Subscription, UUID> {

    List<Subscription> findByUserId(UUID userId);

    @Query("SELECT new com.example.usersubscriptionservice.dto.TopSubscriptionDto(s.serviceName, COUNT(s)) " +
            "FROM Subscription s GROUP BY s.serviceName ORDER BY COUNT(s) DESC")
    List<TopSubscriptionDto> findTopSubscriptions(Pageable pageable);
}
