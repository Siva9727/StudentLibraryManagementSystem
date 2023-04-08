package com.example.Student_Library_Management_System.DTOs;

public class StudentUpdateMobRequestDto {

    // Dtos are depends upon the api call

    private int id;

    private String mobNo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    public StudentUpdateMobRequestDto() {
    }

    public StudentUpdateMobRequestDto(int id, String mobNo) {
        this.id = id;
        this.mobNo = mobNo;
    }
}
