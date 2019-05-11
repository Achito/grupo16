<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Actividad cient�fica y tecnol�gica</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <link rel="icon" href="pics/icon.png">
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
        <li><a href="InvestigadorDatosServlet"><span class="glyphicon glyphicon-user"></span> ${investigador.name }</a></li>
        <li><a href="LogoutServlet"><span class="glyphicon glyphicon-off"></span> Salir</a></li>
      </ul>
    </div>
  </div>
</nav>


<div class="container justify-content-center">
  <div class="container text-left">
    <h3>Publicaciones, documentos cient�ficos y t�cnicos</h3>
  </div>

  <table class="table">
    <thead>
      <tr class="bg-primary">
        <th scope="col">T�tulo de la publicaci�n</th>
        <th scope="col">Nombre de la publicaci�n</th>
        <th scope="col">T�tulo de producci�n</th>
        <th scope="col">Fecha de publicaci�n</th>
        <th scope="col">Editar</th>
        <th scope="col">Eliminar</th>
      </tr>
    </thead>
    <tbody>
      
       <c:if test="${fn:length(publicaciones) < 1}">
      					<tr>
      					<td>
      					No hay ninguna publicacion a�adida.
      					</td>
      					</tr>
      					</c:if>
      					
      					<c:forEach items="${publicaciones}" var="publicacion">
				<tr>
				<td>${publicacion.tituloPublicacion }</td>
				<td>${publicacion.nombrePublicacion }</td>
				<td>${publicacion.tituloProduccion}</td>
				<td>${publicacion.fechaPublicacion }</td>
				
				
				<td>
				<a href="/eCV/PublicacionServlet?edit=${publicacion.id}"   >
				<button type="submit" class="glyphicon glyphicon-edit"></button>
				</a>
				
				</td>
				
				<td>
				<form action="PublicacionServlet" method="POST"  >
				<button type="submit" name="delete" value="${ publicacion.id}"class="glyphicon glyphicon-remove"></button>
				</form>
				
				</td>
				
				</tr>
			</c:forEach>
      </tbody>
    </table>

  <form method="post" action="/eCV/PublicacionServlet" >

    <div class="form-row">

      <div class="form-group col-md-8">
        <label for="inputName">T�tulo de producci�n</label>
        <select id="inputType" class="form-control" name="tituloProduccion" >
          <option value="${publicacion.tituloProduccion }"> ${publicacionEdit.tituloProduccion }</option>
          <option value="Art�culo cient�fico">Art�culo cient�fico</option>
          <option value="Art�culo de divulgaci�n">Art�culo de divulgaci�n</option>
          <option value="Art�culo de enciclopedia">Art�culo de enciclopedia</option>
          <option value="Cap�tulo de libro">Cap�tulo de libro</option>
          <option value="Diccionario cient�fico">Diccionario cient�fico</option>
          <option value="Diccionario com�n">Diccionario com�n</option>
          <option value="Edici�n cient�fica">Edici�n cient�fica</option>
          <option value="Informe cient�fico-t�cnico">Informe cient�fico-t�cnico</option>
          <option value="Libro de divulgaci�n">Libro de divulgaci�n</option>
          <option value="Libro o monograf�a cient�fica">Libro o monograf�a cient�fica</option>
          <option value="Otros">Otros</option>
          <option value="Rese�a">Rese�a</option>
          <option value="Revisi�n bibliogr�fica">Revisi�n bibliogr�fica</option>
          <option value="Traducci�n">Traducci�n</option>
        </select> 
      </div>

      <div class="form-group col-md-4">
        <label for="inputDate">Fecha de publicaci�n</label>
        <input type="date" class="form-control" name="fechaPublicacion" value="${publicacionEdit.fechaPublicacion }" id="inputPassword4" placeholder="Contrase�a nueva">
      </div>

    </div>

    <div class="form-row">

      <div class="form-group col-md-8">
        <label for="inputType">T�tulo de la publicaci�n</label>
        <input type="text" class="form-control" name="tituloPublicacion" value="${publicacionEdit.tituloPublicacion }" id="inputEntity" placeholder="">
      </div>
    
      <div class="form-group col-md-4">
        <label for="inputEntity">Tipo de soporte</label>
        <select id="inputType" name="tipoSoporte" class="form-control">
          <option value="${publicacionEdit.tipoSoporte }"> ${publicacionEdit.tipoSoporte }</option>
          <option value="Cat�logo de obra art�stica">Cat�logo de obra art�stica</option>
          <option value="Documento o informe cient�fico-t�cnico">Documento o informe cient�fico-t�cnico</option>
          <option value="Libro">Libro</option>
          <option value="Revista">Revista</option>
        </select> 
      </div>
    
    </div>

    <div class="form-row">

      <div class="form-group col-md-8">
        <label for="inputEntity">Nombre de la publicaci�n</label>
        <input type="text" class="form-control" name="nombrePublicacion" value="${publicacionEdit.nombrePublicacion }" id="inputEntity" placeholder="">
      </div>

      <div class="form-group col-md-4">
        <label for="inputEntity">Editorial</label>
        <input type="text" class="form-control" name="editorial" value="${publicacionEdit.editorial }" id="inputEntity" placeholder="">
      </div>
                                        
    </div>

    <div class="form-row">
      <div class=" panel panel-default col-md-6">     
        <h4>Volumen</h4>
        <div class="form-group col-md-8">
          <label for="inputEntity">Vol�men</label>
          <input type="text" class="form-control" name="volumen" value="${publicacionEdit.volumen }" id="inputEntity" placeholder="">
        </div>

        <div class="form-group col-md-4">
          <label for="inputEntity">N�mero</label>
          <input type="text" class="form-control" name="numero" value="${publicacionEdit.numero }" id="inputEntity" placeholder="">
        </div>
      </div> 

      <div class="panel panel-default col-md-6">
        <h4>P�gina inicial-final</h4>
        <div class="form-group col-md-8">
          <label for="inputEntity">Inicial</label>
          <input type="text" class="form-control" name="inicial" value="${publicacionEdit.inicial }" id="inputEntity" placeholder="">
        </div>

        <div class="form-group col-md-4">
          <label for="inputEntity">Final</label>
          <input type="text" class="form-control" name="fin" value="${publicacionEdit.fin }" id="inputEntity" placeholder="">
        </div>
      </div>                                  
    </div>

    <div class="form-row">
      <div class="panel panel-default col-md-12">
        <h4>Autor</h4>
        <div class="form-group col-md-9">
          <label for="inputEntity">Nombre</label>
          <input type="text" class="form-control" name="nombreAutor" value="${publicacionEdit.nombreAutor }" id="inputEntity" placeholder="">
        </div>
        <div class="form-group col-md-3">
          <label for="inputEntity">Posici�n</label>
          <input type="text" class="form-control" id="inputEntity" name="posicion" value="${publicacionEdit.posicion }" placeholder="">
        </div>
      </div>

    </div>   

    <div class="form-row">
      <div class="form-group col-md-3">
        <label for="inputEntity">Autor de correspondencia</label>
        <select id="inputType" name="autorCorrespondencia"  class="form-control">
          <option value="${publicacionEdit.autorCorrespondencia }">${publicacionEdit.autorCorrespondencia }</option>
          <option value="S�">S�</option>
          <option value="No">No</option>
        </select>
      </div>
    </div>

    <div class="form-row">

                                        <c:if test="${publicacionEdit != null }">
                                  <div class="col text-left">
                                      <button type="submit" class="btn btn-primary ">Editar</button>
                                  </div>
                  					</c:if>
                  					
                  					<c:if test="${publicacionEdit == null }">
                                  <div class="col text-left">
                                      <button type="submit" class="btn btn-primary ">Guardar</button>
                                  </div>
                  					</c:if>
                                        
                                      </div>
    

                  </form>


</div>


</body>
</html>