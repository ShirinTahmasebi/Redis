package ir.ac.sbu.redisproject.controller;

import ir.ac.sbu.redisproject.dao.model.User;
import ir.ac.sbu.redisproject.service.UserManager;
import ir.ac.sbu.redisproject.service.impl.UserManagerImpl;
import ir.ac.sbu.redisproject.util.Helper;
import ir.ac.sbu.redisproject.util.Response;
import ir.ac.sbu.redisproject.util.Tag;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Response.initialize(response);
        HttpSession session = request.getSession();

        String userName = Helper.getRequestString(request, Tag.USER_NAME);
        String password = Helper.getRequestString(request, Tag.USER_PASSWORD);
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);

        response.setContentType("text/html;charset=UTF-8");
        String forwardPage = checkUserAuthentication(user, request, session);

        response.sendRedirect(forwardPage);
    }

    @Override
    public String getServletInfo() {
        return "This servlet is used to authenticate users in this site login process.";
    }

    private String checkUserAuthentication(User user, HttpServletRequest request, HttpSession session) {
        UserManager manager = new UserManagerImpl();
        String userFound = manager.getUser(user);
        if (userFound != null && userFound.equals(user.getPassword())) {
            request.setAttribute(Tag.USER, user);
            session.setAttribute(Tag.USER, user);
            return Tag.FIRST_PAGE;
        }
        return Tag.LOGIN_PAGE;
    }

}
