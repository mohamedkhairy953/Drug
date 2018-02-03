package com.khairy.moham.drug;

/**
 * Created by moham on 1/29/2018.
 */

class PharmacyHave {

    private String pharmacy1;

    public PharmacyHave() {
    }

    public PharmacyHave(String pharmacyKey) {
        this.pharmacy1 = pharmacyKey;
    }

    public String getPharmacyKey() {
        return pharmacy1;
    }

    public void setPharmacyKey(String pharmacyKey) {
        this.pharmacy1 = pharmacyKey;
    }
}
