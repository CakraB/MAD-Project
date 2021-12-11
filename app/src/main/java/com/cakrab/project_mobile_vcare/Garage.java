package com.cakrab.project_mobile_vcare;

public class Garage {
    private String garageName;
    private String garageCabang;

    public Garage(String garageName, String garageCabang){
        this.garageName = garageName;
        this.garageCabang = garageCabang;
    }

    public String getGarageName(){
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    public String getGarageCabang(){
        return garageCabang;
    }

    public void setGarageCabang(String garageCabang) {
        this.garageCabang = garageCabang;
    }

}