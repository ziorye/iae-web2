package day0818;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ServletDemo")
public class ServletDemo extends HttpServlet {
    List<String> users = new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        users.add("u1");
        users.add("u2");
        users.add("u3");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(users);

        JDBCDemo jdbcTest = new JDBCDemo();
        Connection connection = jdbcTest.getConnection();
        jdbcTest.testStatement(connection);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
