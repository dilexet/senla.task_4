package com.senla.hotel.dto;

public class ServiceDTO {
    private final String serviceName;
    private final double price;

    public ServiceDTO(String serviceName, double price) {
        this.serviceName = serviceName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ServiceDTO{" +
                "serviceName='" + serviceName + '\'' +
                ", price=" + price +
                '}';
    }
}
