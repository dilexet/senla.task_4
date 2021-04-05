package com.senla.dataaccessobject;

public class ServiceDTO {
    private int id;
    private String serviceName;
    private double price;

    @Override
    public String toString() {
        return "\n" + id + "," + serviceName + "," + price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getPrice() {
        return price;
    }
}
