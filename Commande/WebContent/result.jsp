<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Insertion d'une librairie spéciale pour les tableaux -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%int numcom = (Integer)request.getAttribute("IDCom");
%>
<%int numetat = (Integer)request.getAttribute("IDEtat");
%>
La commande n° <%=numcom %> a été mise à jour avec le statut <%=numetat %>.
</body>
</html>