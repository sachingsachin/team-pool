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
import com.prismoskills.persistence.ProductTeamMappingEntity;
import com.prismoskills.persistence.ProductTeamMappingManager;
import com.prismoskills.persistence.TeamEntity;
import com.prismoskills.persistence.TeamManager;
import com.prismoskills.persistence.UserEntity;
import com.prismoskills.persistence.UserManager;
import com.prismoskills.persistence.UserProductMappingEntity;
import com.prismoskills.persistence.UserProductMappingManager;
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

        // Put and get User_Product_Mapping
        UserProductMappingEntity upMapping = new UserProductMappingEntity(user.getId(), product.getId());
        UserProductMappingManager.get().put(upMapping);
        List<UserProductMappingEntity> upMappings = UserProductMappingManager.get().selectStar();

        // Put and get Product_Team_Mapping
        ProductTeamMappingEntity ptMapping = new ProductTeamMappingEntity(product.getId(), team.getId());
        ProductTeamMappingManager.get().put(ptMapping);
        List<ProductTeamMappingEntity> ptMappings = ProductTeamMappingManager.get().selectStar();

        // Serialize and send JSON
        Map objMap = Utils.createMap(new Object[]{
                "users", users,
                "products", products,
                "teams", teams,
                "UserProductMappings", upMappings,
                "ProductTeamMappings", ptMappings
            });
        Utils.sendJsonResponse(response, objMap, true);

        //UserProductMappingManager.get().deleteAll(upMappings.toArray());
        UserProductMappingManager.get().deleteById(upMapping.getId());

        //ProductTeamMappingManager.get().deleteAll(ptMappings.toArray());
        ProductTeamMappingManager.get().deleteById(ptMapping.getId());

        //UserManager.get().deleteAll(users.toArray());
        UserManager.get().deleteById(user.getId());

        //ProductManager.get().deleteAll(products.toArray());
        ProductManager.get().deleteById(product.getId());

        //TeamManager.get().deleteAll(teams.toArray());
        TeamManager.get().deleteById(team.getId());
    }
}
