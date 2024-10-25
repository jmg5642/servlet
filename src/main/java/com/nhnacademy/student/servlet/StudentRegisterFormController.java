package com.nhnacademy.student.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class StudentRegisterFormController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/student/register.jsp";
    }
}
