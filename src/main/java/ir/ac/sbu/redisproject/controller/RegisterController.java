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

@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

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
        
        UserManager manager = new UserManagerImpl();
        manager.insertUser(user);
        
        // TODO: serfan baraye test. Ba meghdare monaseb jaygozin beshe
        response.sendRedirect(Tag.REGISTER_PAGE);

    }

}
