package com.clevertec.task5.model;

public class Markers {

    private String typeObject;
    private String addressType;
    private String address;
    private String house;
    private String gpsX;
    private String gpsY;
    private double distance;

    public Markers(String typeObject, String addressType, String address, String house, String gpsX, String gpsY) {
        this.typeObject = typeObject;
        this.addressType = addressType;
        this.address = address;
        this.house = house;
        this.gpsX = gpsX;
        this.gpsY = gpsY;
    }

    public String getTypeObject() {
        return typeObject;
    }

    public void setTypeObject(String typeObject) {
        this.typeObject = typeObject;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getGpsX() {
        return gpsX;
    }

    public void setGpsX(String gpsX) {
        this.gpsX = gpsX;
    }

    public String getGpsY() {
        return gpsY;
    }

    public void setGpsY(String gpsY) {
        this.gpsY = gpsY;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(double x1, double y1) {
        this.distance = Math.sqrt(Math.pow(Math.abs(Double.parseDouble(this.getGpsX()) - x1), 2) + Math.pow(Math.abs(Double.parseDouble(this.getGpsY()) - y1), 2));
    }
}

