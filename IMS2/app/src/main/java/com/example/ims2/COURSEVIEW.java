package com.example.ims2;


public class COURSEVIEW {

    private String courseID;
    private String courseName;
    private String courseDuration;
    private int courseFee;

    public COURSEVIEW(String courseId,String courseName,String courseDuration,int courseFee){
        this.courseID=courseId;
        this.courseName=courseName;
        this.courseDuration=courseDuration;
        this.courseFee=courseFee;

    }

    public String getCourseID() {

        return courseID;
    }


    public String getCourseName() {

        return courseName;
    }


    public String getCourseDuration() {

        return courseDuration;
    }


    public int getCourseFee() {
        return courseFee;
    }


}
