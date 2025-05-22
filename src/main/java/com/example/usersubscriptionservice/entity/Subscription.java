package com.example.usersubscriptionservice.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "service_name", nullable = false)
    private String serviceName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Subscription() {
        this.id = UUID.randomUUID();
    }

    public Subscription(String serviceName) {
        this.id = UUID.randomUUID();
        this.serviceName = serviceName;
    }

    public UUID getId() {
        return id;
    }

    // сеттер для id не делаем

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
