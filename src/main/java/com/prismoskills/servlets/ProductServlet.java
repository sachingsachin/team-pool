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

public class ProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<UserEntity> users = UserManager.get().selectStar();
        List<ProductEntity> products = ProductManager.get().selectStar();
        List<TeamEntity> teams = TeamManager.get().selectStar();
        List<UserProductMappingEntity> upMappings = UserProductMappingManager.get().selectStar();
        List<ProductTeamMappingEntity> ptMappings = ProductTeamMappingManager.get().selectStar();

        // Serialize and send JSON
        Map objMap = Utils.createMap(new Object[]{
                "users", users,
                "products", products,
                "teams", teams,
                "UserProductMappings", upMappings,
                "ProductTeamMappings", ptMappings
            });
        Utils.sendJsonResponse(response, objMap, false);
    }
}
