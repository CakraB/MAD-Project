package com.cakrab.project_mobile_vcare;

public class Forum {

    private String forumName;
    private String forumDesc;
    private String forumDate;

    public Forum(String forumName, String forumDesc, String forumDate) {
        this.forumName = forumName;
        this.forumDesc = forumDesc;
        this.forumDate = forumDate;
    }

    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    public String getForumDesc() {
        return forumDesc;
    }

    public void setForumDesc(String forumDesc) {
        this.forumDesc = forumDesc;
    }

    public String getForumDate() {
        return forumDate;
    }

    public void setForumDate(String forumDate) {
        this.forumDate = forumDate;
    }
}
