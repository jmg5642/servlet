package com.nhnacademy.student.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@RequestMapping(value = "/student/register.do", method = RequestMapping.Method.GET)
public class StudentRegisterFormController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/student/register.jsp";
    }
}
