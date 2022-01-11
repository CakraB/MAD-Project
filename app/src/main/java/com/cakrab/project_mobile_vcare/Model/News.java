package com.cakrab.project_mobile_vcare.Model;

import com.google.firebase.firestore.Exclude;

public class News {

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

    private String newsTitle;
    private String newsDesc;
    private String newsImage;

    public News() {
        // For Firebase
    }

    public News(String newsTitle, String newsDesc, String newsImage) {
        this.newsTitle = newsTitle;
        this.newsDesc = newsDesc;
        this.newsImage = newsImage;
    }

    public String getNewsName() {
        return newsTitle;
    }

    public void setNewsName(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDesc() {
        return newsDesc;
    }

    public void setNewsDesc(String newsDesc) {
        this.newsDesc = newsDesc;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }
}
