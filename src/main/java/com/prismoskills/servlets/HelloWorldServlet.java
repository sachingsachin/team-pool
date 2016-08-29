package com.prismoskills.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prismoskills.persistence.ProductEntity;
import com.prismoskills.persistence.ProductManager;
import com.prismoskills.persistence.TeamEntity;
import com.prismoskills.persistence.TeamManager;
import com.prismoskills.persistence.UserEntity;
import com.prismoskills.persistence.UserManager;
import com.prismoskills.util.Utils;

public class HelloWorldServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Put and get users
        UserEntity user = new UserEntity("Michael", "Brown", "id1", "id2", "id3", "id4", null, "Engineer of awesome apps");
        UserManager.get().put(user);
        List<UserEntity> users = UserManager.get().selectStar();

        // Put and get product
        ProductEntity product = new ProductEntity("Database Access Layer", new Date(), "Abstracts DB operations",
                "dal@prismoskills.com", "#dal-support", "DAL Scrumboard", "http://docs.prismoskills.com/dal",
                "github-links", "quick-start-links");
        ProductManager.get().put(product);
        List<ProductEntity> products = ProductManager.get().selectStar();

        // Put and get team
        TeamEntity team = new TeamEntity("database-experts", new Date(), "Brief description", "DB experts home");
        TeamManager.get().put(team);
        List<TeamEntity> teams = TeamManager.get().selectStar();

        // Serialize and send JSON
        Map objMap = Utils.createMap(new Object[]{"users", users, "prodcuts", products, "teams", teams});
        Utils.sendJsonResponse(response, objMap, true);

        // Delete each new entity
        //UserManager.get().deleteAll(users.toArray());
        UserManager.get().deleteById(user.getId());

        //ProductManager.get().deleteAll(products.toArray());
        ProductManager.get().deleteById(product.getId());

        //TeamManager.get().deleteAll(teams.toArray());
        TeamManager.get().deleteById(team.getId());
    }
}
