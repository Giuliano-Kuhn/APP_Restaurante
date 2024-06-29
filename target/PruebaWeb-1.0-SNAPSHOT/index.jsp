    <%@page contentType="text/html" pageEncoding="UTF-8"%><%--Cofiguracion del JSP--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido a Lo De Maria!</h1>
        <% String icm = "Introduce el codigo de la mesa";%> <%--Declara una variable icm y le asigna una cadena de caracteres --%>
        <%=icm%>    <%--Imprime la variable icm--%>
        <form action="Iniciar_Orden" method="GET"> <%--Crea un formulario que manda la informacion a Iniciar_Orden por medio de GET--%>
            <p><label>Codigo de Mesa:</label></p> <input type="number" name="COD"><%--input numerico con nombre "COD"--%>
            <button type="submit"> Enviar</button>
        </form>
        
        
    </body>
</html>
