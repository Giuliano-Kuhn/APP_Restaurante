<%@page import="Modelo.Item"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MENÚ</title>
    </head>
    <body>
        <h1>MENÚ</h1>
          <%--Inyeccion de codigo java en el HTML del JSP--%>
        <%
           List<List> MENU = (List) request.getSession().getAttribute("Menu");  //trae el menu asignado al menu
           
                for(List<Item> categorias : MENU){                              //Itera la lista MENU
                  for(Item item : categorias){                                  //Itera las lista de categorias del MENU
        %>
        <form action="Generar_Orden" method="POST"> 
           <p><input type="checkbox" name="items" value= "<%=item.ID%>"> <b><%= item.nombre_Item %>   (<%= item.descripcion%>) --------------- <%= item.precio %></b></p>
            <p> </p>  <%--EL form hace que se muestre los items del menu y y se puedan seleccionar--%>
            <p> </p>  <%--EL form hace que se muestre los items del menu y y se puedan seleccionar--%>
             <% }
                    } %>

            <button type="submit"> Enviar</button>
        </form>
    </body>
</html>
