package com.prismoskills.servlets;

import java.io.IOException;
import java.util.ArrayList;
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

        String path = request.getRequestURI();
        System.out.println(path);

        if (path.equals("/product/detail")) {
            getDetail (request, response);
        } else if (path.equals("/product/summary")) {
            getSummary (request, response);
        } else {
            Utils.sendError(response, HttpServletResponse.SC_NOT_FOUND, path + " not found.");
        }
    }

    private void getDetail(HttpServletRequest request, HttpServletResponse response) {

        String name = (String) Utils.getRequestParamForGet(request, "name");
        if (name == null || name.length() == 0) {
            Utils.sendError(response, HttpServletResponse.SC_BAD_REQUEST, "Missing parameter: name");
            return;
        }
        ProductEntity product = ProductManager.get().getByName(name.replaceAll("-", " "));
        if (product == null) {
            Utils.sendError(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "No product found for " + name);
            return;
        }

        List<UserProductMappingEntity> upMappings = UserProductMappingManager.get().withProductId(product.getId());
        List<ProductTeamMappingEntity> ptMappings = ProductTeamMappingManager.get().withProductId(product.getId());

        List<String> userIds = new ArrayList<>();
        List<String> teamIds = new ArrayList<>();
        upMappings.forEach(upMapping -> userIds.add(upMapping.getUserId()));
        ptMappings.forEach(ptMapping -> teamIds.add(ptMapping.getTeamId()));

        List<UserEntity> users = UserManager.get().getByIds(userIds);
        List<TeamEntity> teams = TeamManager.get().getByIds(teamIds);

        // Serialize and send JSON
        Map objMap = Utils.createMap(new Object[]{
                "product", product,
                "users", users,
                "teams", teams,
                "UserProductMappings", upMappings,
                "ProductTeamMappings", ptMappings
            });
        Utils.sendJsonResponse(response, objMap, false);
    }

    private void getSummary(HttpServletRequest request, HttpServletResponse response) {

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
