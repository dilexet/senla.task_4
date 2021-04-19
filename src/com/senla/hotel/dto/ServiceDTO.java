package com.senla.hotel.dto;

public class ServiceDTO {
    private String serviceName;
    private double price;

    public ServiceDTO(String serviceName, double price) {
        this.serviceName = serviceName;
        this.price = price;
    }

    @Override
    public String toString() {
        return serviceName + "," + price + "\n";
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getPrice() {
        return price;
    }
}
