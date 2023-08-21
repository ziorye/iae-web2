package day0822;

import day0821.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/JSTLForEachServlet")
public class JSTLForEachServlet extends HttpServlet {
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
        request.getRequestDispatcher("day0822/jsp6.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
