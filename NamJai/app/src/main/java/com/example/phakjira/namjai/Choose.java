package com.example.phakjira.namjai;

public class Choose {
    String tutorID;
    String tutorName;

    public void Choose(){

    }

    public Choose(String tutorID, String tutorName) {
        this.tutorID = tutorID;
        this.tutorName = tutorName;
    }

    public String getTutorID() {
        return tutorID;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorID(String tutorID) {
        this.tutorID = tutorID;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }
}
