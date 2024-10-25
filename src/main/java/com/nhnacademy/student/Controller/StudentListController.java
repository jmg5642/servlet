package com.nhnacademy.student.Controller;

import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequestMapping(value = "/student/list.do", method = RequestMapping.Method.GET)
public class StudentListController implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        List<Student> studentList = studentRepository.getStudents();
        req.setAttribute("studentList", studentList);
        log.info("studentList: {}",studentList.toString());

        // Return the view path
        return "/student/list.jsp";
    }
}

