package day0825;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    List<User> users = new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        if (config.getServletContext().getAttribute("users") == null) {
            System.out.println("=== LoginServlet@init ===");

            for (int i = 0; i < 10; i++) {
                users.add(User.builder().email("user"+i+"@example.com").password("password").name("user"+i).build());
            }
            users.add(User.builder().email("admin@example.com").password("password").name("admin").build());

            config.getServletContext().setAttribute("users", users);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/day0825/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = User.builder().email(email).password(password).name(email.substring(0, email.indexOf("@"))).build();

        if (!users.contains(user)) {
            request.setAttribute("error", "用户名或密码错误");
            request.getRequestDispatcher("/day0825/login.jsp").forward(request, response);
            return;
        }

        request.setAttribute("user", user);

        if ("admin@example.com".equals(email)) {
            request.setAttribute("users", users);
            request.getRequestDispatcher("/backend/users").forward(request, response);
        } else {
            request.getRequestDispatcher("/user").forward(request, response);
        }
    }
}
