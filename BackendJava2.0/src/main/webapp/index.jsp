<%-- 
    Document   : newjsp
    Created on : 04/03/2019, 17:13:56
    Author     : lucas
--%>

<%@page import="com.backend.infra.ConexaoBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
            <% 
            ConexaoBD.getConexaoMySQL();
            out.println(ConexaoBD.statusConection());
            %>
    </body>
</html>
