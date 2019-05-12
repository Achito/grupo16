<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="pics/icon.png">

    <title>Signin</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    
    

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
  </head>

  <body class="text-center">
    <form class="form-signin" method="post" action="LoginServlet">
      <img class="mb-4" src="pics/icon.png" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">eCV</h1>
      <label for="email" class="sr-only">Email address</label>
      <input type="email" name="email" class="form-control" placeholder="Introduzca su correo" required autofocus>
      <label for="password" class="sr-only">Password</label>
      <input type="password" name="password" class="form-control" placeholder="Introduzca su contraseña" required>
      
      <div class="checkbox mb-3">
        <a href="SignUpServlet"> Registrarse</a>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Acceder</button>
      <p class="mt-5 mb-3 text-muted">&copy; 2018-2019</p>
    </form>

	

	
	

	<shiro:user>
    Welcome back <shiro:principal />! Click <a href="LogoutServlet">here</a> to logout.
</shiro:user>
</body>
</html>