package com.example.api_post_test2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Logins {

    @SerializedName("phone")
    @Expose
    private Long phone;

    @SerializedName("country_code")
    @Expose
    private String country_code;

    @SerializedName("imei")
    @Expose
    private String imei;

    public Logins(Long phone, String country_code, String imei) {
        this.phone = phone;
        this.country_code = country_code;
        this.imei = imei;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}
