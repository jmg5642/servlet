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
import java.util.Objects;

@Slf4j
@WebServlet(name = "StudentRegisterServlet", urlPatterns = "/student/register")
public class StudentRegisterServlet extends HttpServlet {

  private StudentRepository studentRepository;

  @Override
  public void init(ServletConfig config) throws ServletException {
    //todo  init studentRepository
    studentRepository = (StudentRepository) config.getServletContext().getAttribute("studentRepository");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
    //todo  /student/register.jsp forward 합니다.
//    req.getRequestDispatcher("/student/register.jsp").forward(req,resp);

    req.setAttribute("view","/student/register.jsp");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    //todo null check
    String id = req.getParameter("id");
    log.info("id:{}",id);
    if(Objects.isNull(id))
      throw new IllegalArgumentException("id is required");
    String name = req.getParameter("name");
    log.info("name:{}",name);
    if(Objects.isNull(name))
      throw new IllegalArgumentException("name is required");


    Gender gender = Gender.valueOf(req.getParameter("gender"));
    log.info("gender:{}",gender);
    if(Objects.isNull(gender))
      throw new IllegalArgumentException("gender is required");

    int age = Integer.parseInt(req.getParameter("age"));
    log.info("age:{}",age);


      //todo save 구현
    Student student = new Student(id,name,gender,age);
    studentRepository.save(student);

    //todo redirect /student/view?id=student1
//    resp.sendRedirect(req.getContextPath() + "/student/view?id=" + id)

    req.setAttribute("view","redirect:/student/view.do?id=" + student.getId());
  }

}
