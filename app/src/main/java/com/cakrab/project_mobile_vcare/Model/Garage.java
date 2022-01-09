package com.cakrab.project_mobile_vcare.Model;

public class Garage {
    private String garageName;
    private String garageBranch;

    public Garage(String garageName, String garageBranch){
        this.garageName = garageName;
        this.garageBranch = garageBranch;
    }

    public String getGarageName(){
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    public String getGarageBranch(){
        return garageBranch;
    }

    public void setGarageBranch(String garageBranch) {
        this.garageBranch = garageBranch;
    }

}