package ru.eltex;


import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/get_users")
public class Servlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("application/json");
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1,"Eugene","21323"));
        users.add(new User(2,"Alexey","324324"));
        ObjectMapper objectMapper = new ObjectMapper();
        PrintWriter printWriter = response.getWriter();
        String out_str = objectMapper.writeValueAsString(users);
        printWriter.println(out_str);
        printWriter.close();
    }
}
