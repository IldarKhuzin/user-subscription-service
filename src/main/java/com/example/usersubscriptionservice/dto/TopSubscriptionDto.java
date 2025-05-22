package com.example.usersubscriptionservice.dto;

public class TopSubscriptionDto {

    private String serviceName;
    private Long count;

    public TopSubscriptionDto(String serviceName, Long count) {
        this.serviceName = serviceName;
        this.count = count;
    }
    

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
