package com.cakrab.project_mobile_vcare.Model;

import com.google.firebase.firestore.Exclude;

public class Garage {

    // getter method for our id
    public String getId() {
        return id;
    }

    // setter method for our id
    public void setId(String id) {
        this.id = id;
    }

    // we are using exclude because
    // we are not saving our id
    @Exclude
    private String id;

    private String garageName;
    private String garageDesc;
    private String garageImage;

    public Garage() {
        // For Firebase
    }

    public Garage(String garageName, String garageDesc, String garageImage) {
        this.garageName = garageName;
        this.garageDesc = garageDesc;
        this.garageImage = garageImage;
    }

    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    public String getGarageDesc() {
        return garageDesc;
    }

    public void setGarageDesc(String garageDesc) {
        this.garageDesc = garageDesc;
    }

    public String getGarageImage() {
        return garageImage;
    }

    public void setGarageImage(String garageImage) {
        this.garageImage = garageImage;
    }

}