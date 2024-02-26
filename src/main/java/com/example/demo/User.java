package com.example.demo;

public class User {
    private String status;
    private String imgUrl;

    private String username;    //weiyibiaoshi id userzhujian

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "imgUrl='" + imgUrl + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
