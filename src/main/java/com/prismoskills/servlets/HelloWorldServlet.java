package com.prismoskills.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prismoskills.persistence.UserEntity;
import com.prismoskills.persistence.UserManager;
import com.prismoskills.util.Globals;

public class HelloWorldServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Put and get
        UserEntity user = new UserEntity("Michael", "Brown", "id1", "id2", "id3", "id4", null, "Engineer of awesome apps");
        UserManager.get().put(user);
        List<UserEntity> users = UserManager.get().selectStar();

        // Serialize
        String prettyJson = Globals.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);

        // Send response
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Hello there!</h1><BR>It is time: " + new Date() +
                "<BR><pre>" + prettyJson + "</pre>");
    }
}
