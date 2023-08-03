package com.lapvt.myapplication.recyclerviewb1;

public class Group {
    private String name;
    private double numOfFans;
    private int numOfLatestPosts;
    private String status;

    public Group(String name, double numOfFans, int numOfLatestPosts, String status) {
        this.name = name;
        this.numOfFans = numOfFans;
        this.numOfLatestPosts = numOfLatestPosts;
        this.status = status;
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
