package com.lapvt.myapplication.recyclerviewb1;

import android.graphics.Bitmap;

public class Group {
    private Bitmap bitmap;
    private String name;
    private double numOfFans;
    private int numOfLatestPosts;
    private String status;

    public Group(Bitmap bitmap, String name, double numOfFans, int numOfLatestPosts, String status) {
        this.bitmap = bitmap;
        this.name = name;
        this.numOfFans = numOfFans;
        this.numOfLatestPosts = numOfLatestPosts;
        this.status = status;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNumOfFans() {
        return numOfFans;
    }

    public void setNumOfFans(float numOfFans) {
        this.numOfFans = numOfFans;
    }

    public int getNumOfLatestPosts() {
        return numOfLatestPosts;
    }

    public void setNumOfLatestPosts(int numOfLatestPosts) {
        this.numOfLatestPosts = numOfLatestPosts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
