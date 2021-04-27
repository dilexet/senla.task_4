package com.senla.hotel.entity;

public class Service {
    private String id;
    private final String serviceName;
    private double price;

    public Service(String serviceName, double price) throws Exception {
        this.serviceName = serviceName;
        if (price < 0.0) {
            throw new Exception("incorrect price");
        }
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setPrice(double price) throws Exception {
        if (price < 0.0) {
            throw new Exception("incorrect price");
        }
        this.price = price;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getPrice() {
        return price;
    }
}
