package com.clevertec.task5.dto.impl;

import com.clevertec.task5.dto.ApiData;
import com.google.gson.annotations.SerializedName;

public class AtmDto extends ApiData {

    private String area;

    @SerializedName("city_type")
    private String cityType;
    private String city;

    @SerializedName("address_type")
    private String addressType;
    private String address;
    private String house;

    @SerializedName("install_place")
    private String installPlace;

    @SerializedName("work_time")
    private String workTime;

    @SerializedName("gps_x")
    private String gpsX;

    @SerializedName("gps_y")
    private String gpsY;

    @SerializedName("install_place_full")
    private String installPlaceFull;

    @SerializedName("work_time_full")
    private String workTimeFull;

    @SerializedName("ATM_type")
    private String atmType;

    @SerializedName("ATM_error")
    private String atmError;
    private String currency;

    @SerializedName("cash_in")
    private String cashIn;

    @SerializedName("ATM_printer")
    private String atmPrinter;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCityType() {
        return cityType;
    }

    public void setCityType(String cityType) {
        this.cityType = cityType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getInstallPlace() {
        return installPlace;
    }

    public void setInstallPlace(String installPlace) {
        this.installPlace = installPlace;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
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

    public String getInstallPlaceFull() {
        return installPlaceFull;
    }

    public void setInstallPlaceFull(String installPlaceFull) {
        this.installPlaceFull = installPlaceFull;
    }

    public String getWorkTimeFull() {
        return workTimeFull;
    }

    public void setWorkTimeFull(String workTimeFull) {
        this.workTimeFull = workTimeFull;
    }

    public String getAtmType() {
        return atmType;
    }

    public void setAtmType(String atmType) {
        this.atmType = atmType;
    }

    public String getAtmError() {
        return atmError;
    }

    public void setAtmError(String atmError) {
        this.atmError = atmError;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCashIn() {
        return cashIn;
    }

    public void setCashIn(String cashIn) {
        this.cashIn = cashIn;
    }

    public String getAtmPrinter() {
        return atmPrinter;
    }

    public void setAtmPrinter(String atmPrinter) {
        this.atmPrinter = atmPrinter;
    }
}

