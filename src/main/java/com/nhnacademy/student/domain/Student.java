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
    public Student(){}
    //아이디
    @Getter
    private String id;

    public String getId() {
        return id;
    }

    //이름
    @Getter
    private String name;
    public String getName() {
        return name;
    }
    //성별
    @Getter
    private Gender gender;
    public Gender getGender() {
        return gender;
    }
    //나이
    @Getter
    private int age;
    public int getAge() {
        return age;
    }
    //생성일
    @Getter
    private LocalDateTime createAt;
    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public String toString(){
        return "이름 :" + name + " 성 :" + gender + " 나이 :" + age + " 아이디 :" + id;
    }
}
