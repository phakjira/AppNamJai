package com.example.phakjira.namjai;

public class Tutor {
    String studentID;
    Boolean monday;
    Boolean tuesday;
    Boolean wednesday;
    Boolean thursday;
    Boolean friday;
    Boolean saturday;
    Boolean sunday;
    String time;
    String subject;
    String location;
    String price;
    String contact;
//    String nickName;

    public Tutor(String studentID, Boolean monday, Boolean tuesday, Boolean wednesday, Boolean thursday, Boolean friday, Boolean saturday, Boolean sunday, String time, String subject, String location, String price,String contact) {
        this.studentID = studentID;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
        this.time = time;
        this.subject = subject;
        this.location = location;
        this.price = price;
        this.contact=contact;
//        this.nickName = nickName;
    }

    public Tutor(){

    }

    public String getStudentID() {
        return studentID;
    }

    public Boolean getMonday() {
        return monday;
    }

    public Boolean getTuesday() {
        return tuesday;
    }

    public Boolean getWednesday() {
        return wednesday;
    }

    public Boolean getThursday() {
        return thursday;
    }

    public Boolean getFriday() {
        return friday;
    }

    public Boolean getSaturday() {
        return saturday;
    }

    public Boolean getSunday() {
        return sunday;
    }

    public String getTime() {
        return time;
    }

    public String getSubject() {
        return subject;
    }

    public String getLocation() {
        return location;
    }

    public String getPrice() {
        return price;
    }

    public String getContact() {return contact;}

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setMonday(Boolean monday) {
        this.monday = monday;
    }

    public void setTuesday(Boolean tuesday) {
        this.tuesday = tuesday;
    }

    public void setWednesday(Boolean wednesday) {
        this.wednesday = wednesday;
    }

    public void setThursday(Boolean thursday) {
        this.thursday = thursday;
    }

    public void setFriday(Boolean friday) {
        this.friday = friday;
    }

    public void setSaturday(Boolean saturday) {
        this.saturday = saturday;
    }

    public void setSunday(Boolean sunday) {
        this.sunday = sunday;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setContact(String contact) {this.contact=contact;}

//    public String getNickName() {
//        return nickName;
//    }
//
//    public void setNickName(String nickName) {
//        this.nickName = nickName;
//    }
}
