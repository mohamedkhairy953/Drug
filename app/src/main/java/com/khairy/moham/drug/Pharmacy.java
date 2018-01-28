package com.khairy.moham.drug;

import android.databinding.Observable;

/**
 * Created by moham on 1/23/2018.
 */

public class Pharmacy  {
    public  String pharmacyName;
    public  String pharmacyPhone;
    public  String pharmacyLicence;
    public  String pharmacyPassword;


    public String getPharmacyName() {
        return pharmacyName;
    }

    public Pharmacy() {
    }

    public Pharmacy(String pharmacyName, String pharmacyPhone, String pharmacyLicence, String pharmacyPassword) {
        this.pharmacyName = pharmacyName;
        this.pharmacyPhone = pharmacyPhone;
        this.pharmacyLicence = pharmacyLicence;
        this.pharmacyPassword = pharmacyPassword;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getPharmacyPhone() {
        return pharmacyPhone;
    }

    public void setPharmacyPhone(String pharmacyPhone) {
        this.pharmacyPhone = pharmacyPhone;
    }

    public String getPharmacyLicence() {
        return pharmacyLicence;
    }

    public void setPharmacyLicence(String pharmacyLicence) {
        this.pharmacyLicence = pharmacyLicence;
    }

    public String getPharmacyPassword() {
        return pharmacyPassword;
    }

    public void setPharmacyPassword(String pharmacyPassword) {
        this.pharmacyPassword = pharmacyPassword;
    }



    @Override
    public String toString() {
        return "Pharmacy{" +
                "pharmacyName='" + pharmacyName + '\'' +
                ", pharmacyPhone='" + pharmacyPhone + '\'' +
                ", pharmacyLicence='" + pharmacyLicence + '\'' +
                ", pharmacyPassword='" + pharmacyPassword + '\'' +
                '}';
    }


}
