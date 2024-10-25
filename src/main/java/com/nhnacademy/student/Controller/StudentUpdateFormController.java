package com.nhnacademy.student.Controller;

import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RequestMapping(value = "/student/update.do", method = RequestMapping.Method.GET)
public class StudentUpdateFormController implements Command {

@Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");
        String id = request.getParameter("id");
        Student student = studentRepository.getStudentById(id);

        request.setAttribute("student", student);

        return "/student/register.jsp";
    }
}
