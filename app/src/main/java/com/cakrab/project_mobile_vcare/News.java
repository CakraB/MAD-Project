package com.cakrab.project_mobile_vcare;

public class News {

    private String articleName;
    private String articleDesc;
    private String articleDate;

    public News(String articleName, String articleDesc, String articleDate) {
        this.articleName = articleName;
        this.articleDesc = articleDesc;
        this.articleDate = articleDate;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleDesc() {
        return articleDesc;
    }

    public void setArticleDesc(String articleDesc) {
        this.articleDesc = articleDesc;
    }

    public String getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(String articleDate) {
        this.articleDate = articleDate;
    }
}
