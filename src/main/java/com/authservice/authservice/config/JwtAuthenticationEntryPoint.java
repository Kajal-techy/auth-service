package com.authservice.authservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);

    /**
     * It is use to throw the error message and handle exception if provided JWT token is not valid
     * @param request
     * @param response
     * @param authException
     * @throws ServletException
     * @throws IOException
     * @throws IllegalArgumentException
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException)
            throws ServletException, IOException, IllegalArgumentException {
        logger.debug("Entering JwtAuthenticationEntryPoint.commence with parameters request {}, response {}, authException {} ", request, response, authException);
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getOutputStream().println("{\n" + " error :" + authException.getMessage() + "\n }");
    }
}