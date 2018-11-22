
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="pt">
    <head>
        <title>Motoboy</title>

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body>


        <div class="container">
            <h1>Motoboys Cadastrados</h1><br>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Id</th>                        
                        <th>Nome</th>
                        <th>E-mail</th>

                        <th>Endereço</th>      
                        <th>Placa</th>  

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${motoboys}" var="motoboy">
                        <tr>
                            <td><c:out value="${motoboy.id}"/></td>
                            <td><c:out value="${motoboy.nome}"/></td>
                            <td><c:out value="${motoboy.email}"/></td>
                            <td><c:out value="${motoboy.endereco}"/>
                            <td><c:out value="${motoboy.placa}"/> <br /></td>                        
                        </tr>                        
                    </c:forEach>          
                </tbody>						
            </table>					        
        </div>
    </body>
</html>