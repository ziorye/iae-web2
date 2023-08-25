package day0815;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request);
        System.out.println(response);

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        if ("admin".equals(username) && "secret".equals(password)) {
            System.out.println("登录成功");
            //response.sendRedirect("index.html");
            response.sendRedirect("hello");
        } else {
            System.out.println("登录失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("=== doPost ===");
        this.doGet(request, response);
    }
}
