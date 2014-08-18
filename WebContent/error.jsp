<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<jsp:include page="/WEB-INF/partial/langGet.jsp" />
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Studomat</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">


    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">

      <form action="j_security_check" method="POST" class="form-signin">
        <h2 class="form-signin-heading">Studomat - <fmt:message key="login.loginfront" /></h2>
        <input type="text" name="j_username" class="form-control" placeholder="<fmt:message key="login.username" />" required autofocus>
        <input type="password" name="j_password" class="form-control" placeholder="<fmt:message key="login.password" />" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message key="login.loginbutton" /></button>
      </form>
	  <div class="alert alert-danger"><fmt:message key="login.error" /></div>

     

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>