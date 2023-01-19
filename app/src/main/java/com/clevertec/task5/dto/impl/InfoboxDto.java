package com.clevertec.task5.dto.impl;

import com.clevertec.task5.dto.ApiData;
import com.google.gson.annotations.SerializedName;

public class InfoboxDto extends ApiData {

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

    @SerializedName("location_name_desc")
    private String locationNameDesc;

    @SerializedName("work_time")
    private String workTime;

    @SerializedName("time_long")
    private String timeLong;

    @SerializedName("gps_x")
    private String gpsX;

    @SerializedName("gps_y")
    private String gpsY;
    private String currency;

    @SerializedName("type_cash_in")
    private String typeCashIn;

    @SerializedName("cash_in_exist")
    private String cashInExist;

    @SerializedName("cash_in")
    private String cashIn;

    @SerializedName("inf_type")
    private String inf_Type;

    @SerializedName("inf_printer")
    private String infPrinter;

    @SerializedName("region_platej")
    private String regionPlatej;

    @SerializedName("popolnenie_platej")
    private String popolneniePlatej;

    @SerializedName("inf_status")
    private String infStatus;

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

    public String getLocationNameDesc() {
        return locationNameDesc;
    }

    public void setLocationNameDesc(String locationNameDesc) {
        this.locationNameDesc = locationNameDesc;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getTimeLong() {
        return timeLong;
    }

    public void setTimeLong(String timeLong) {
        this.timeLong = timeLong;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTypeCashIn() {
        return typeCashIn;
    }

    public void setTypeCashIn(String typeCashIn) {
        this.typeCashIn = typeCashIn;
    }

    public String getCashInExist() {
        return cashInExist;
    }

    public void setCashInExist(String cashInExist) {
        this.cashInExist = cashInExist;
    }

    public String getCashIn() {
        return cashIn;
    }

    public void setCashIn(String cashIn) {
        this.cashIn = cashIn;
    }

    public String getInf_Type() {
        return inf_Type;
    }

    public void setInf_Type(String inf_Type) {
        this.inf_Type = inf_Type;
    }

    public String getInfPrinter() {
        return infPrinter;
    }

    public void setInfPrinter(String infPrinter) {
        this.infPrinter = infPrinter;
    }

    public String getRegionPlatej() {
        return regionPlatej;
    }

    public void setRegionPlatej(String regionPlatej) {
        this.regionPlatej = regionPlatej;
    }

    public String getPopolneniePlatej() {
        return popolneniePlatej;
    }

    public void setPopolneniePlatej(String popolneniePlatej) {
        this.popolneniePlatej = popolneniePlatej;
    }

    public String getInfStatus() {
        return infStatus;
    }

    public void setInfStatus(String infStatus) {
        this.infStatus = infStatus;
    }
}
