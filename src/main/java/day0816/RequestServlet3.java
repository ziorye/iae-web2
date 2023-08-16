package day0816;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RequestServlet3", value = "/RequestServlet3")
public class RequestServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = "getMethod=" + request.getMethod() + System.lineSeparator();
        result += "getContextPath=" + request.getContextPath() +  System.lineSeparator();
        result += "getRequestURL=" + request.getRequestURL() +  System.lineSeparator();
        result += "getRequestURI=" + request.getRequestURI() +  System.lineSeparator();
        result += "getQueryString=" + request.getQueryString() +  System.lineSeparator();
        result += "getHeader(\"user-agent\")=" + request.getHeader("user-agent") +  System.lineSeparator();
        response.getWriter().write(result);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String line = request.getReader().readLine();
        response.getWriter().write("===" + line);
    }
}
