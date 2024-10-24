package com.nhnacademy.student.servlet;

import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.repository.StudentRepository;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
@WebServlet(name = "StudentListServlet", urlPatterns = "/student/list")
public class StudentListServlet extends HttpServlet {

    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
        log.info("studentRepository: {}", studentRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //student list 구하기
        List<Student> studentList = studentRepository.getStudents();

        req.setAttribute("studentList",studentList);

//        req.setAttribute("view","/student/list.jsp");
//        req.setAttribute("view", "redirect:/student/lis");

        // /student/list.jsp <- forward 하기\
//        System.out.println("Forwarding to: /student/list.jsp");
//        req.getRequestDispatcher("/student/list.jsp").forward(req, resp);

        req.setAttribute("view","/student/list.jsp");
    }

}
