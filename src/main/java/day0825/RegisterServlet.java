package day0825;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    List<User> users = new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        if (config.getServletContext().getAttribute("users") == null) {
            System.out.println("=== RegisterServlet@init ===");

            for (int i = 0; i < 10; i++) {
                users.add(User.builder().email("user"+i+"@example.com").password("password").name("user"+i).build());
            }
            users.add(User.builder().email("admin@example.com").password("password").name("admin").build());

            config.getServletContext().setAttribute("users", users);
        } else {
            users = (List<User>) config.getServletContext().getAttribute("users");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("day0825/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");

        boolean exist = false;
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                request.setAttribute("error", "邮箱已被使用");
                request.getRequestDispatcher("day0825/register.jsp").forward(request, response);
                exist = true;
                break;
            }
        }

        if (!exist) {
            String password = request.getParameter("password");
            User user = User.builder().email(email).password(password).name(email.substring(0, email.indexOf("@"))).build();
            users.add(user);

            Cookie cookie = new Cookie("email", email);
            response.addCookie(cookie);

            response.sendRedirect("login");
        }
    }
}
