package com.springapp.finalapp.data;

public class Studies {
    // Luokan Studies private-muuttujat
    private String studentName;
    private String courseName;
    private String teacher;
    private int grade;  //lukuvuosi muuttuja jota inkrementoidaan count muuttujalla
    private int classRoom;

    private static int count = 1;

    public Studies() {
        this("", "", "", 0);
    }


    public Studies(String studentName, String courseName, String teacher, int classRoom) {
        this.studentName = studentName;
        this.courseName = courseName;
        this.teacher = teacher;
        this.classRoom = classRoom;
        this.grade = count++;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacher() {
        return this.teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getGrade() {
        return this.grade;
    }

    public int getClassRoom() {
        return this.classRoom;
    }

    public void setClassRoom(int classRoom) {
        this.classRoom = classRoom;
    }
    
}
