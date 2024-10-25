package com.nhnacademy.student.Controller;

import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
@RequestMapping(value = "/student/view.do", method = RequestMapping.Method.GET)
public class StudentViewController  implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");
        String id = request.getParameter("id");
        if(Objects.isNull(id))
            throw new IllegalArgumentException("id is required");

        Student student = studentRepository.getStudentById(id);
        if(Objects.isNull(student))
            throw new IllegalArgumentException("student is required");

        request.setAttribute("student",student);
        log.info("student:{}",student);

        return "/student/view.jsp";
    }
}
