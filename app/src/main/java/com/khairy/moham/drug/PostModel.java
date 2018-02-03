package com.khairy.moham.drug;

import java.util.Random;

/**
 * Created by moham on 1/28/2018.
 */

public class PostModel {

    private String drugType;
    private String drugName;
    private String drugConcentration;
    private String userKey;
    private PharmacyHave pharmaciesHave;

    public PostModel() {
    }

    public PostModel(String drugName, String type, String drugConcentration, String userKey) {

        this.drugType = type;
        this.drugName = drugName;
        this.drugConcentration = drugConcentration;
        this.userKey = userKey;
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String type) {
        this.drugType = type;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugConcentration() {
        return drugConcentration;
    }

    public void setDrugConcentration(String drugConcentration) {
        this.drugConcentration = drugConcentration;
    }

    public String generateKey() {
        return drugName + new Random().nextInt(1000000);
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public PharmacyHave getPharmaciesHave() {
        return pharmaciesHave;
    }

    public void setPharmaciesHave(PharmacyHave pharmacy) {
        this.pharmaciesHave = pharmacy;
    }

    public String getFullNameInPost() {
        return drugName + " " + drugConcentration + "mg   " + drugType;
    }
}
