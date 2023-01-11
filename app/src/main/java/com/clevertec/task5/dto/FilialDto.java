package com.clevertec.task5.dto;

import com.google.gson.annotations.SerializedName;

public class FilialDto extends ApiData {

    @SerializedName("filial_name")
    private String filialName;

    @SerializedName("filial_num")
    private String filialNum;

    @SerializedName("cbu_num")
    private String cbuNum;

    @SerializedName("otd_num")
    private String otdNum;

    @SerializedName("city_type")
    private String cityType;

    private String name;

    @SerializedName("street_type")
    private String streetType;

    private String street;

    @SerializedName("home_number")
    private String homeNumber;

    @SerializedName("name_type_prev")
    private String nameTypePrev;

    @SerializedName("name_prev")
    private String namePrev;

    @SerializedName("street_type_prev")
    private String streetTypePrev;

    @SerializedName("street_prev")
    private String streetPrev;

    @SerializedName("home_number_prev")
    private String homeNumberPrev;

    @SerializedName("info_text")
    private String infoText;

    @SerializedName("info_worktime")
    private String infoWorktime;

    @SerializedName("info_bank_bik")
    private String infoBankBik;

    @SerializedName("info_bank_unp")
    private String infoBankUnp;

    @SerializedName("GPS_X")
    private String gpsX;

    @SerializedName("GPS_Y")
    private String gpsY;

    @SerializedName("bel_number_schet")
    private String belNumberSchet;

    @SerializedName("foreign_number_schet")
    private String foreignNumberSchet;

    @SerializedName("phone_info")
    private String phoneInfo;

    public String getFilialName() {
        return filialName;
    }

    public void setFilialName(String filialName) {
        this.filialName = filialName;
    }

    public String getFilialNum() {
        return filialNum;
    }

    public void setFilialNum(String filialNum) {
        this.filialNum = filialNum;
    }

    public String getCbuNum() {
        return cbuNum;
    }

    public void setCbuNum(String cbuNum) {
        this.cbuNum = cbuNum;
    }

    public String getOtdNum() {
        return otdNum;
    }

    public void setOtdNum(String otdNum) {
        this.otdNum = otdNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getNameTypePrev() {
        return nameTypePrev;
    }

    public void setNameTypePrev(String nameTypePrev) {
        this.nameTypePrev = nameTypePrev;
    }

    public String getNamePrev() {
        return namePrev;
    }

    public void setNamePrev(String namePrev) {
        this.namePrev = namePrev;
    }

    public String getStreetTypePrev() {
        return streetTypePrev;
    }

    public void setStreetTypePrev(String streetTypePrev) {
        this.streetTypePrev = streetTypePrev;
    }

    public String getStreetPrev() {
        return streetPrev;
    }

    public void setStreetPrev(String streetPrev) {
        this.streetPrev = streetPrev;
    }

    public String getHomeNumberPrev() {
        return homeNumberPrev;
    }

    public void setHomeNumberPrev(String homeNumberPrev) {
        this.homeNumberPrev = homeNumberPrev;
    }

    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }

    public String getInfoWorktime() {
        return infoWorktime;
    }

    public void setInfoWorktime(String infoWorktime) {
        this.infoWorktime = infoWorktime;
    }

    public String getInfoBankBik() {
        return infoBankBik;
    }

    public void setInfoBankBik(String infoBankBik) {
        this.infoBankBik = infoBankBik;
    }

    public String getInfoBankUnp() {
        return infoBankUnp;
    }

    public void setInfoBankUnp(String infoBankUnp) {
        this.infoBankUnp = infoBankUnp;
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

    public String getBelNumberSchet() {
        return belNumberSchet;
    }

    public void setBelNumberSchet(String belNumberSchet) {
        this.belNumberSchet = belNumberSchet;
    }

    public String getForeignNumberSchet() {
        return foreignNumberSchet;
    }

    public void setForeignNumberSchet(String foreignNumberSchet) {
        this.foreignNumberSchet = foreignNumberSchet;
    }

    public String getPhoneInfo() {
        return phoneInfo;
    }

    public void setPhoneInfo(String phoneInfo) {
        this.phoneInfo = phoneInfo;
    }
}
