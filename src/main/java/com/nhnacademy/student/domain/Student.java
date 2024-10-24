package com.nhnacademy.student.domain;

import lombok.Getter;

import java.time.LocalDateTime;

public class Student {
    public Student(String id, String name, Gender gender,  int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.id = id;
        createAt = LocalDateTime.now();

    }
    //아이디
    @Getter
    private String id;
    //이름
    @Getter
    private String name;
    //성별
    @Getter
    private Gender gender;
    //나이
    @Getter
    private int age;
    //생성일
    @Getter
    private LocalDateTime createAt;

    public String toString(){
        return "이름 :" + name + " 성 :" + gender + " 나이 :" + age + " 아이디 :" + id;
    }
}
