package com.nhnacademy.student.Controller;

import com.nhnacademy.student.repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RequestMapping(value = "/student/delete.do", method = RequestMapping.Method.POST)
public class StudentDeleteController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        StudentRepository studentRepository = (StudentRepository) req.getServletContext().getAttribute("studentRepository");
        String id = req.getParameter("id");
        studentRepository.deleteById(id);
        //view를 return 합니다.
        return "redirect:/student/list.do";
    }
}
