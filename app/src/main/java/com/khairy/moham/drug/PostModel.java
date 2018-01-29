package com.khairy.moham.drug;

import java.util.Random;

/**
 * Created by moham on 1/28/2018.
 */

public class PostModel {
    private String type;
    private String name;
    private String concentration;
    private String userKey;
    private PharmacyHave pharmacy;
    private String fullNameInPost = name + " " + concentration + "   " + type;

    public PostModel() {
    }

    public PostModel(String name, String type, String concentration, String userKey) {

        this.type = type;
        this.name = name;
        this.concentration = concentration;
        this.userKey = userKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConcentration() {
        return concentration;
    }

    public void setConcentration(String concentration) {
        this.concentration = concentration;
    }

    public String generateKey() {
        return name + new Random().nextInt(1000000);
    }

    public String getUserKey() {
        return userKey;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public PharmacyHave getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(PharmacyHave pharmacy) {
        this.pharmacy = pharmacy;
    }

    public String getFullNameInPost() {
        return name + " " + concentration + "   " + type;
    }
}
