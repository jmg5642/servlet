package com.nhnacademy.student.servlet;

import com.nhnacademy.student.domain.Gender;
import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class StudentRegisterController implements Command {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) {
    StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");
    // 요청 파라미터를 검증합니다.
    String id = request.getParameter("id");
    log.info("id: {}", id);
    if (Objects.isNull(id)) {
      throw new IllegalArgumentException("id is required");
    }

    String name = request.getParameter("name");
    log.info("name: {}", name);
    if (Objects.isNull(name)) {
      throw new IllegalArgumentException("name is required");
    }

    Gender gender = Gender.valueOf(request.getParameter("gender"));
    log.info("gender: {}", gender);
    if (Objects.isNull(gender)) {
      throw new IllegalArgumentException("gender is required");
    }

    int age = Integer.parseInt(request.getParameter("age"));
    log.info("age: {}", age);

    // 학생 정보를 저장합니다.
    Student student = new Student(id, name, gender, age);
    studentRepository.save(student);
    request.setAttribute("student", student);

    // 리다이렉트 설정
    return "redirect:/student/view.do?id=" + student.getId();
  }
}
