package com.senla.entity;

public class Service {
    private final String serviceName;
    private double price;

    public Service(String serviceName, double price) throws Exception {
        this.serviceName = serviceName;
        if (price < 0.0) {
            throw new Exception("incorrect price");
        }
        this.price = price;
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

    @Override
    public String toString() {
        return "\nserviceName: " + serviceName +
                "\nPrice: " + price;
    }
}
