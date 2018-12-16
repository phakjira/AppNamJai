package com.example.phakjira.namjai;

public class User {
    String firstName;
    String lastName;
    String studentID;
    String faculty;
    String year;
    String gender;
    String nickName;
    String email;

    public User(){

    }

    public User(String firstName, String lastName, String nickName, String studentID, String faculty, String year, String gender, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.faculty = faculty;
        this.year = year;
        this.gender = gender;
        this.nickName = nickName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getYear() {
        return year;
    }

    public String getGender() {
        return gender;
    }

    public String getNickName() {
        return nickName;
    }
    public String getEmail() {
        return email;
    }
}
