<%@page import="ir.ac.sbu.redisproject.dao.model.Item"%>
<%@page import="java.util.Map"%>
<%@page import="ir.ac.sbu.redisproject.service.impl.ItemManagerImpl"%>
<%@page import="ir.ac.sbu.redisproject.service.ItemManager"%>
<html dir="rtl" lang="fa">
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
        <%@ page 
            language="java"
            contentType="text/html; charset=UTF-8"
            pageEncoding="UTF-8"
            %>
        <link rel="stylesheet" type="text/css" href="css/table_style.css">
        <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
        <script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <body  class= "table-body">
        <%@ include file="menu.jsp" %> 
        <div style="height:50px;"></div>
        <div style="margin:20px auto" class="container" >
            <div class="table-responsive">
                <table id="itemsTable"class="table hover" collapsing="0" width="100%" >
                    <thead>
                        <tr>
                            <th style="text-align:right; padding-right:25px;">کلید&nbspمحصول</th>
                            <th style="text-align:right; padding-right:25px">نام&nbspمحصول</th>
                            <th style="text-align:right; padding-right:25px">امتیاز&nbspمحصول</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%  ItemManager manager = new ItemManagerImpl();
                                Map<Item, Double> items = manager.getAllItemsWithScores();
                                for (Item keyMap : items.keySet()) {
                        %>
                        <tr>
                            <td><%=keyMap.getItemId()%></td>
                            <td><%=keyMap.getItemName()%></td>
                            <td><%=items.get(keyMap)%></td>
                        </tr>

                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>
        <script type="text/javascript">
            $(document).ready(function () {
                var table = document.getElementById("itemsTable");
                var tbody = table.getElementsByTagName("tbody")[0];
                tbody.onclick = function (e) {
                    e = e || window.event;
                    var data = [];
                    var target = e.srcElement || e.target;
                    while (target && target.nodeName !== "TR") {
                        target = target.parentNode;
                    }
                    var cell0 = "";
                    if (target) {
                        var cells = target.getElementsByTagName("td");
                        for (var i = 0; i < cells.length; i++) {
                            data.push(cells[i].innerHTML);
                        }
                        cell0 = cells[0].innerHTML;
                    }
                    window.location.href = "item_details.jsp?itemId=" + cell0;
                };
            });
        </script>
    </body>
</html>