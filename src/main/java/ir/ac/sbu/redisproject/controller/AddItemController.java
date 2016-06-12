package ir.ac.sbu.redisproject.controller;

import ir.ac.sbu.redisproject.dao.model.Item;
import ir.ac.sbu.redisproject.service.ItemManager;
import ir.ac.sbu.redisproject.service.UserManager;
import ir.ac.sbu.redisproject.service.impl.ItemManagerImpl;
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

@WebServlet(name = "AddItemController", urlPatterns = {"/AddItemController"})
public class AddItemController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Response.initialize(response);
        HttpSession session = request.getSession();

        String itemId = Helper.generateUniqueId();
        String itemName = Helper.getRequestString(request, Tag.ITEM_NAME);

        Item item = new Item();
        item.setItemId(itemId);
        item.setItemName(itemName);

        ItemManager manager = new ItemManagerImpl();
        if (manager.getItemScore(itemId) == null) {
            manager.insertItem(item);
            response.sendRedirect(Tag.FIRST_PAGE);
            return;
        }

        // TODO: serfan baraye test. Ba meghdare monaseb jaygozin beshe
        response.sendRedirect(Tag.CREATE_NEW_ITEM_PAGE);
    }

    @Override
    public String getServletInfo() {
        return "This Servlet is used to add items.";
    }

}
