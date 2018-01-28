package com.khairy.moham.drug;

import java.util.Random;

/**
 * Created by moham on 1/28/2018.
 */

public class PostModel {
    private String type;
    private String name;
    private String concentration;

    public PostModel() {
    }

    public PostModel(String type, String name, String concentration) {

        this.type = type;
        this.name = name;
        this.concentration = concentration;
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
}
