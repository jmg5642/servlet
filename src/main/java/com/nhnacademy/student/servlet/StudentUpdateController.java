package com.nhnacademy.student.servlet;

import com.nhnacademy.student.domain.Gender;
import com.nhnacademy.student.domain.Student;
import com.nhnacademy.student.repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class StudentUpdateController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");

        // 요청 파라미터를 가져옵니다.
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        Gender gender = Gender.valueOf(request.getParameter("gender"));

        // 학생 정보를 업데이트합니다.
        Student student = new Student(id, name, gender, age);
        studentRepository.update(student);

        // 학생 상세보기 페이지로 리다이렉트합니다.
        return "redirect:/student/view.do?id="+id;
    }
}
