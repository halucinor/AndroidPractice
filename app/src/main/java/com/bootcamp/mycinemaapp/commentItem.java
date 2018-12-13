package com.bootcamp.mycinemaapp;

public class commentItem {
    String Id;
    int resId;
    String comment;

    public commentItem(String id, int resId, String comment) {
        this.Id = id;
        this.resId = resId;
        this.comment = comment;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "commentItem{" +
                "Id='" + Id + '\'' +
                ", resId=" + resId +
                ", comment='" + comment + '\'' +
                '}';
    }
}
