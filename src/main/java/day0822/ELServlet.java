package day0822;

import day0821.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ELServlet")
public class ELServlet extends HttpServlet {
    List<User> users = new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        users.add(new User("Tom", 55.0));
        users.add(new User("John", 65.0));
        users.add(new User("Tim", 75.0));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", users);
        System.out.println(users);
        request.getRequestDispatcher("day0822/jsp4.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
