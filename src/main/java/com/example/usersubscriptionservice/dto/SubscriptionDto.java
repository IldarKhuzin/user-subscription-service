package com.example.usersubscriptionservice.dto;

import java.util.UUID;

public class SubscriptionDto {

    private UUID id;
    private String serviceName;  // например: YouTube Premium, Netflix и т.п.

    public SubscriptionDto() {
    }

    public SubscriptionDto(UUID id, String serviceName) {
        this.id = id;
        this.serviceName = serviceName;
    }

    public UUID getId() {
        return id;
    }

    public void setUserId(UUID id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return "SubscriptionDto{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                '}';
    }
}
