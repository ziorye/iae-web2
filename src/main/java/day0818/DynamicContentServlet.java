package day0818;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DynamicContentServlet")
public class DynamicContentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.write("<!DOCTYPE html>\n");
        writer.write("<html lang=\"zh\">\n");
        writer.write("    <head>\n");
        writer.write("        <meta charset=\"UTF-8\">\n");
        writer.write("        <title>Index</title>\n");
        writer.write("    </head>\n");
        writer.write("    <body>\n");
        writer.write("        <p>hi, xxx</p>\n");
        writer.write("    </body>\n");
        writer.write("</html>\n");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
