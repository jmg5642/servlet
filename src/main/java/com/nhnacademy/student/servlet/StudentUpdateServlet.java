package com.nhnacademy.student.servlet;

import com.nhnacademy.student.domain.Gender;
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

@Slf4j
@WebServlet(name = "studentUpdateServlet", urlPatterns = "/student/update")
public class StudentUpdateServlet extends HttpServlet {
    private StudentRepository studentRepository;
    @Override
    public void init(ServletConfig config) throws ServletException {
        //todo init studentRepository
        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //todo 학생조회
        String id = req.getParameter("id");
        Student student = studentRepository.getStudentById(id);
        log.info(student.toString());
        req.setAttribute("student", student);

        //todo forward : /student/register.jsp
//        req.getRequestDispatcher("/student/register.jsp").forward(req, resp);

        req.setAttribute("view", "/student/register.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //todo null check
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        Gender gender = Gender.valueOf(req.getParameter("gender"));
        Student student = new Student(id,name,gender,age);
        //todo student 저장
        studentRepository.update(student);

        //todo /student/view?id=student1 <-- redirectpackage com.nhnacademy.student.servlet;
        //
        //import com.nhnacademy.student.domain.Student;
        //import com.nhnacademy.student.repository.StudentRepository;
        //import jakarta.servlet.ServletConfig;
        //import jakarta.servlet.ServletException;
        //import jakarta.servlet.annotation.WebServlet;
        //import jakarta.servlet.http.HttpServlet;
        //import jakarta.servlet.http.HttpServletRequest;
        //import jakarta.servlet.http.HttpServletResponse;
        //import lombok.extern.slf4j.Slf4j;
        //
        //import java.io.IOException;
        //import java.util.Objects;
        //
        //@Slf4j
        //@WebServlet(name = "studentViewServlet", urlPatterns = "/student/view")
        //public class StudentViewServlet extends HttpServlet {
        //    private StudentRepository studentRepository;
        //
        //    @Override
        //    public void init(ServletConfig config) throws ServletException {
        //        studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
        //    }
        //
        //    @Override
        //    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        //todo id null check
        //
        //        String id = req.getParameter("id");
        //        if(Objects.isNull(id))
        //            throw new IllegalArgumentException("id is required");
        //
        //        Student student = studentRepository.getStudentById(id);
        //        if(Objects.isNull(student))
        //            throw new IllegalArgumentException("student is required");
        //        log.info("student: {}",student);
        //
        //        //todo student 조회
        //        req.setAttribute("student",student);
        //
        //        //todo /student/view.jsp <-- forward
        ////        req.getRequestDispatcher("/student/view.jsp").forward(req,resp);
        //
        //        req.setAttribute("view","student/view.jsp");
        //    }
        //
        //}
//        resp.sendRedirect("/student/view?id=" + id);

        req.setAttribute("view","redirect:/student/view.do?id="+id);
    }
}