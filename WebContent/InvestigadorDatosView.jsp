<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:formatDate var="investigadorBirth" value="${investigador.birth}" pattern="yyyy-MM-dd"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Identificación - eCV</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default rounded borders and increase the bottom margin */ 
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */ 
     .jumbotron {
      margin-bottom: 0;
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>
<body>

<div class="jumbotron">
  <div class="container text-center">
    <h1>eCV</h1>      
    <p>Gestor de Curriculum Vitae</p>
  </div>
</div>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="InvestigadorServlet">Principal</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Editar CVN</a></li>
        <li><a href="#">Importar CVN</a></li>
        <li><a href="#">Descargar CVN</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> ${investigador.name }</a></li>
        <li><a href="LogoutServlet"><span class="glyphicon glyphicon-off"></span> Salir</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container justify-content-center">

    <div class="container text-left">
        <h3>Identificación</h3>
    </div>
    

<form method="post" action="InvestigadorDatosServlet">
        <div class="form-row">
          <div class="form-group col-md-4">
            <label for="inputEmail4">Email</label>
            <input type="email" class="form-control" name="email" value="${investigador.email}">
          </div>
          <div class="form-group col-md-4">
            <label for="inputPassword4">Contraseña nueva</label>
            <input type="password" class="form-control" name="password1" placeholder="Contraseña nueva">
          </div>
          <div class="form-group col-md-4">
            <label for="inputPassword4">Repita nueva contraseña</label>
            <input type="password" class="form-control" name="password2" placeholder="Repita nueva contraseña">
            </div>
        </div>

        <div class="form-row">
          <div class="form-group col-md-12">
            <label for="inputEmail4">Nombre Completo</label>
            <input type="text" class="form-control" name="name" value="${investigador.name}">
          </div>
        </div>

        <div class="form-group col-md-12">
          <label for="inputAddress">Dirección principal</label>
          <input type="text" class="form-control" name="address1" value="${investigador.address1}" placeholder="Indique su calle">
        </div>
        <div class="form-group col-md-12">
          <label for="inputAddress2">Dirección Secundaria</label>
          <input type="text" class="form-control" name="address2" value="${investigador.address2}" placeholder="Piso o bajo">
        </div>
        <div class="form-row">
          <div class="form-group col-md-6">
            <label for="inputCity">Ciudad</label>
            <input type="text" class="form-control" value="${investigador.city }" name="city">
          </div>
          
           <div class="form-row">
          <div class="form-group col-md-4">
            <label for="inputCity">Provincia</label>
            <input type="text" class="form-control"  value="${investigador.provincia}" name="provincia">
          </div>
          
          <div class="form-group col-md-2">
            <label for="inputZip">Código Postal</label>
            <input type="number" name="zip" class="form-control" value="${investigador.zip }">
          </div>
        </div>
        
        <div class="form-row">
                <div class="form-group col-md-2">
                        <label for="inputDocument">DNI</label>
                        <select id="inputDocument" name="document"  class="form-control">
                          <option selected>Elija</option>
                          <option>DNI</option>
                          <option>Pasaporte</option>
                          <option>NIE</option>

                        </select>
                      </div>

                <div class="form-group col-md-4">
                        <label for="inputDNI">Número de documento</label>
                        <input type="text" class="form-control" value="${investigador.documentNumber }" name="documentNumber">
                      </div>
                      <div class="form-group col-md-3">
                            <label for="inputMovil1">Teléfono 1</label>
                            <input type="number" class="form-control" value="${investigador.phone1 }" name="phone1">
                          </div>
                          <div class="form-group col-md-3">
                                <label for="inputMovil2">Teléfono 2</label>
                                <input type="number" class="form-control"  value="${investigador.phone2 }" name="phone2">
                              </div>

        </div>
        <div class="form-row">
          <div class="form-group col-md-2">
            <label for="inputSexo">Sexo</label>
            <select name="sex" class="form-control">
              
				<c:if test="${investigador.sex == 0 }">				
              <option value="0" selected>Hombre</option>
              <option value="1">Mujer</option>
              </c:if>
              
              <c:if test="${investigador.sex == 1 }">				
              <option value="0">Hombre</option>
              <option value="1" selected>Mujer</option>
              </c:if>
              
              <c:if test="${investigador.sex == null }">				
              <option value="0">Hombre</option>
              <option value="1" selected>Mujer</option>
              </c:if>
              

            </select>
          </div>
          <div class="form-group col-md-4">
            <label for="inputDate">Fecha de Nacimiento</label>
            <input type="date" class="form-control" name="birth" value="${investigadorBirth}">
          </div>
          
  
    		
          
          
			


        </div>

        <div class="form-row" >

        <div class="form-group col-md-3" >
            <button type="submit" class="btn btn-primary" >Actualizar</button>
        </div>
        
      </div>

      </form>

    </div>
    
    
    <br>
    <hr>
<div>
	<c:if test="${investigador.photo == null }">
	<form method="post" action="UploadFileServlet"  enctype="multipart/form-data">
			<div class="form-row" >
    		<div class="form-group col-md-6">
         
            <label for="inputPicture">Foto Carnet</label>
            <input type="file"  class="form-control" name="photo">
            <button type="submit" class="btn btn-primary" >Actualizar foto</button>
            
            
          </div>
          </div>
			

	</form>
	</c:if>
	
	<c:if test="${investigador.photo != null }">
	<form action="ServeFileServlet">
								<input type="hidden"  />
								<button type="submit" class="btn btn-primary">Descargar foto</button>
							</form>
	<form action="ServeFileServlet" method="post">
								<input type="hidden"  />
								<button type="submit" class="btn btn-primary">Eliminar foto</button>
							</form>
							
	
	</c:if>
	
	
	</div>
    
    
    

</body>
</html>
