package com.prismoskills.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

public class Utils {
    static Logger logger = LoggerFactory.getLogger(Utils.class);

    /**
     * Parameter {@code ParamType} identifies the type of request-pojo
     */
    public static <ParamType> ParamType getRequestParamForPost(
            HttpServletRequest request, String paramName, Class<ParamType> clazz) {

        String [] paramValueArray = request.getParameterMap().get(paramName);
        Preconditions.checkArgument(paramValueArray!=null,
                "Could not find param=\"" + paramName + "\" in the request: " + request.getParameterMap());
        if (clazz == String.class)
            return (ParamType) paramValueArray[0];
        try {
            return Globals.mapper.readValue (paramValueArray[0], clazz);
        }
        catch (Exception e) {
            throw new RuntimeException ("Unable to parse param=\"" + paramValueArray[0] + "\"", e);
        }
    }

    /**
     * Helps read List<ParamType> type variables
     */
    public static <ParamType> List<ParamType> getRequestParamForPost(
            HttpServletRequest request, String paramName,
            TypeReference<List<ParamType>> typeReference) {

        String [] paramValueArray = request.getParameterMap().get(paramName);
        Preconditions.checkArgument(paramValueArray!=null, "Could not find param=\"" + paramName + "\" in the request");
        try {
            return Globals.mapper.readValue (paramValueArray[0], typeReference);
        }
        catch (Exception e) {
            throw new RuntimeException ("Unable to parse param=\"" + paramValueArray[0] + "\"", e);
        }
    }

    /**
     */
    public static Object getRequestParamForGet(HttpServletRequest request, String paramName) {
        String [] paramValueArray = request.getParameterMap().get(paramName);
        if (paramValueArray != null)
            return paramValueArray[0];
        return null;
    }

    public static Map<String, Object> createMap(Object []arr) {

        Preconditions.checkNotNull(arr, "Input array cannot be null");
        Preconditions.checkArgument(arr.length%2 == 0, "Input array must have an even number of elements");

        Map<String, Object> m = Maps.newHashMap();
        for (int i=0; i<arr.length; i=i+2) {
            Object key = arr[i];
            Object value = arr[i+1];
            Preconditions.checkArgument(key.getClass() == String.class,
                    "Element at position {} is not a string", i);
            m.put((String)key, value);
        }
        return m;
    }

    public static <T> void sendJsonResponse (HttpServletResponse response, T obj, boolean pretty) {

        response.setStatus(HttpServletResponse.SC_OK);
        try {
            if (pretty) {
                response.setContentType("text/html");
                response.getWriter().println("<pre>" + Globals.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj) + "</pre>");
            } else {
                response.setContentType("application/json");
                response.getWriter().println(Globals.mapper.writeValueAsString(obj));
            }
        }
        catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
        }
    }
}
