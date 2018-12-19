package com.example.phakjira.namjai;

public class NamJai {
    String studentID;
    String otherName;
    String otherDescription;
    String imageURL;

    public NamJai(String studentID, String otherName, String otherDescription, String imageURL) {
        this.studentID = studentID;
        this.otherName = otherName;
        this.otherDescription = otherDescription;
        this.imageURL = imageURL;
    }

    public NamJai(){

    }

    public String getStudentID() {
        return studentID;
    }

    public String getOtherName() {
        return otherName;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
