<%@page import="ir.ac.sbu.redisproject.util.Tag"%>
<%@page import="ir.ac.sbu.redisproject.service.impl.ItemManagerImpl"%>
<%@page import="ir.ac.sbu.redisproject.service.ItemManager"%>
<%@page import="ir.ac.sbu.redisproject.dao.model.Item"%>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="css/table_style.css">
    <link href="css/bootstrap.min.css" rel="stylesheet">   
    <script src="js/jquery-latest.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <%@ page 
        language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"
        %>
    <body style= " text-align: justify; text-justify: inter-word;">

        <%String itemId= request.getParameter(Tag.ITEM_ID);
        ItemManager itemManager = new ItemManagerImpl(); 
        Item item = itemManager.getItem(itemId);
        String itemScore = itemManager.getItemScore(itemId);
        %>
        
        <%@ include file="menu.jsp" %> 

        <div class = "container" dir="rtl">
            <hr>
            <div class = "row" >
                <% if (item != null && item.getItemId() != null) {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + item.getItemId()
                                + "</div>"
                        );
                    } else {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + "این فیلد پر نشده است."
                                + "</div>"
                        );
                    }
                %>
                <div class = "col-md-3 col-sm-3 col-xs-3">کلید محصول: </div>
            </div>

            <hr>

            <div class = "row" >
                <% if (item != null && item.getItemName()!= null) {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + item.getItemName()
                                + "</div>"
                        );
                    } else {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + "این فیلد پر نشده است."
                                + "</div>"
                        );
                    }
                %>
                <div class = "col-md-3 col-sm-3 col-xs-3">نام محصول: </div>
            </div>

            <hr>
            <div class = "row" >
                <% if (itemScore!= null && item != null) {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + itemScore
                                + "</div>"
                        );
                    } else {
                        out.println(
                                "<div class = 'col-md-9 col-sm-9 col-xs-9'>"
                                + "این فیلد پر نشده است."
                                + "</div>"
                        );
                    }
                %>
                <div class = "col-md-3 col-sm-3 col-xs-3">امتیاز محصول: </div>
            </div>

            <hr>


        </div>



    </body>
</html>


