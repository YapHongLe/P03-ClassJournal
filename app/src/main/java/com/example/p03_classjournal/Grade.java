package com.example.p03_classjournal;

import java.io.Serializable;

public class Grade implements Serializable {

    private String module;
    private int week;
    private String grade;

    public Grade(String module, int week, String grade) {
        this.module = module;
        this.week = week;
        this.grade = grade;
    }

    public String getModule() {
        return module;
    }

    public int getWeek() {
        return week;
    }

    public String getGrade() {
        return grade;
    }
}