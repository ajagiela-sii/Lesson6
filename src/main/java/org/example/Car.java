package org.example;

public class Car {
    private String producer;
    private boolean isAutomatic;

    public Car(String producer, boolean isAutomatic) {
        this.producer = producer;
        this.isAutomatic = isAutomatic;
    }

    public Car() {
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(boolean automatic) {
        isAutomatic = automatic;
    }

    public int add(int a, int b){
        return a + b;
    }
}
