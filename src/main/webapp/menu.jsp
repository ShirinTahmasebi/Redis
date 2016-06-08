<%@page import="ir.ac.sbu.springponisha.utils.Tag"%>
<%@page import="ir.ac.sbu.springponisha.dao.model.User"%>
<%@page import="ir.ac.sbu.springponisha.utils.Tag"%>
<html>
    <head>
        <link rel="stylesheet" href="css/menu_style.css">
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    </head>
    <body style= "margin:0">
        <div id = "mySidenav" class = "sidenav">
            <a href="javascript:void(0)" class="closebtn menu-item-line" onclick="closeNav()">x</a>
            <%
                if (session.getAttribute(Tag.USER) != null) {
                    out.println("<a href='user_profile_editable.jsp' class='firstitem menu-item-line'>پروفایل</a>");
                } else {
                    out.println("<a href='login.jsp' class='firstitem menu-item-line'>ورود</a>");
                }
            %>
            <a href="projects_list.jsp" class="seconditem menu-item-line">پروژه&nbsp;ها</a>
            <a href="contact-us.jsp" class="thirditem menu-item-line">ارتباط&nbsp;با&nbsp;ما</a>
            <a href="about_us.jsp" class="forthitem menu-item-line">درباره&nbsp;ما</a>
            <a href="creat_new_project.jsp" class="fifthitem menu-item-line">ایجاد&nbsp;پروژه</a>
            <%if (session.getAttribute(Tag.USER) != null) {
                    out.println("<a href='LogoutController' class='sixthitem menu-item-line'>خروج</a>");
                }
            %>
        </div>
        <div id="header">
            <span style="box-shadow: 0 1px 6px rgba(0, 0, 0, 0.12), 0 1px 4px rgba(0, 0, 0, 0.24); font-size:15px;cursor:pointer;position: absolute;right:10px;top:5px; border:1px solid black; margin: 5px; padding: 0px 8px 0px 8px; border-radius: 5px; background:#ffffff;" onclick="openNav()">
                <img src="img/menu-black.png"/> 
            </span>
            <span dir="rtl" style="cursor:pointer;position: absolute;right:100px;top:0;  margin: 3px; padding: 0px 8px 0px 8px; border-radius: 5px; background:#903;">
                <%if (session.getAttribute(Tag.USER) != null) {
                        out.println(
                                "<span id='header_text' style='cursor:pointer;position: absolute;right:50px;top:20px;  margin: 3px; padding: 0px 8px 0px 8px; border-radius: 5px; background:#903;' onclick='openProfileLink();'>سلام،" + (((User) session.getAttribute(Tag.USER)).getUsername()) + "</span>");
                    } else {
                        out.println(
                                "<span id='header_text' style='cursor:pointer;position: absolute;right:50px;top:20px;  margin: 3px; padding: 0px 8px 0px 8px; border-radius: 5px; background:#903;' onclick='openLoginLink();'>وارد&nbspشوید</span>");
                    }
                %>			
            </span>
            <span style="cursor:pointer;position: absolute;left:10px;top:0;  margin: 3px; padding: 0px 8px 0px 8px; border-radius: 5px; background:#903;">
                <a href="first_page.jsp" id="logo"></a>
            </span>
            <span id="header_text" style="cursor:pointer;position: absolute;left:110px;top:20px;  margin: 3px; padding: 0px 8px 0px 8px; border-radius: 5px; background:#903;" onclick="openLink();">وب سایت کاریابی پونیشا</span>
        </div>
        <!-- Slidebars -->
        <script src="js/menu_functions.js"></script>
    </body>
</html>