package com.nhnacademy.student.Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RequestMapping(value = "/student/error.do", method = RequestMapping.Method.GET)
public class ErrorController implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("status_code", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        request.setAttribute("exception_type",request.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE));
        request.setAttribute("message",request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
        request.setAttribute("exception",request.getAttribute(RequestDispatcher.ERROR_EXCEPTION));
        request.setAttribute("request_uri", request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));

        return "/error.jsp";
    }
}
