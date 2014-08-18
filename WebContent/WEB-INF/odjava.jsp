<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<jsp:include page="/WEB-INF/partial/langGet.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Bootstrap core CSS -->
    <link href="<%=response.encodeURL(request.getContextPath() +"/css/bootstrap.min.css") %>" rel="stylesheet">


    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<title><fmt:message key="logoff" /></title>
</head>
<body>
<div class="jumbotron">
  <h3><fmt:message key="logoff.title" /> <a href="kolegij.html?locale=${param.locale}" class="btn btn-primary btn-lg"><fmt:message key="logoff.button" /></a></h3>
</div>
</body>
</html>