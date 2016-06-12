<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/create_new_project_style.css">

        <script src="js/jquery-latest.min.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet"> 
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <%@ page 
            language="java"
            contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8"
            %>
    </head>

    <body>
        <%@ include file="menu.jsp" %> 
        <div id="form-div">
            <form class="form" id="inserItem"  role="form" method="post" action="AddItemController">
                <div class = "container" dir="rtl">
                    <div class = "row" >
                        <div class = "col-md-9 col-sm-9 col-xs-9">
                            <p class="text" >
                                <input name="itemName" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="نام محصول مورد نظر را وارد کنید" id="itemName" />
                            </p>
                        </div>
                        <div class = "col-md-3 col-sm-3 col-xs-3 lables">نام پروژه:</div>
                    </div>

                    <div class = "row" >
                        <div class = "col-md-4 col-sm-4 col-xs-4 lables">
                            <div class="submit" >
                                <input type="submit" value="اضافه کردن محصول" id="button-red"/>
                                <div class="ease"></div>
                            </div>
                        </div>
                        <div class = "col-md-4 col-sm-4 col-xs-4"></div>

                    </div>
                </div>
            </form>
        </div>
    </body>
</html>

