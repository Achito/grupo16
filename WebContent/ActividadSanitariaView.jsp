<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Actividad sanitaria</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" href="pics/icon.png">
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
                <h3>Actividad sanitaria en instituciones de la UE </h3>
            </div>

            <table class="table">
                    <thead>
                      <tr class="bg-primary">
                        <th scope="col">Resultados relevantes</th>
                        <th scope="col">Entidad de realización</th>
                        <th scope="col">Fecha de inicio</th>
                        <th scope="col">Fecha de finalización</th>
                        <th scope="col">Editar</th>
        				<th scope="col">Eliminar</th>
                      </tr>
                    </thead>
                    <tbody>
                     
                     <c:if test="${fn:length(sanitarias) < 1}">
      					<tr>
      					<td>
      					No hay ninguna actividad sanitaria añadida.
      					</td>
      					</tr>
      					</c:if>
      					
      					<c:forEach items="${sanitarias}" var="san">
				<tr>
				<td>${san.resultados }</td>
				<td>${san.entidadRealizacion }</td>
				<td>${san.fechaInicio}</td>
				<td>${san.fechaFin }</td>
				
				
				<td>
				<a href="/eCV/ActividadSanitariaServlet?edit=${san.id}"   >
				<button type="submit" class="glyphicon glyphicon-edit"></button>
				</a>
				
				</td>
				
				<td>
				<form action="ActividadSanitariaServlet" method="POST"  >
				<button type="submit" name="delete" value="${ san.id}"class="glyphicon glyphicon-remove"></button>
				</form>
				
				</td>
				
				</tr>
			</c:forEach>
      </tbody>
    </table>

                  <form method="post" action="/eCV/ActividadSanitariaServlet">

                        <div class="form-row">

                                <div class="form-group col-md-12">
                                  <label for="inputName">Resultados relevantes</label>
                                  <input type="text" name="resultados" value="${sanitariaEdit.resultados }" class="form-control" id="inputName" placeholder="">
                                </div>



                              </div>


                              <div class="form-row">

                                <div class="form-group col-md-12">
                                  <label for="inputDate">Entidad de realización</label>
                                  <input type="text" name="entidadRealizacion" value="${sanitariaEdit.entidadRealizacion }"class="form-control" id="inputDate" >
                                </div>
    

    
                                  </div>

                                  <div class="form-row">

                                        <div class="form-group col-md-12">
                                      <label for="inputUni">Entidad de afiliciación</label>
                                      <input type="text" class="form-control" name="entidadAfiliacion" value="${sanitariaEdit.entidadAfiliacion }" id="inputUni" placeholder="">
                                    </div>
        
        
                                      </div>


                                  <div class="form-row">

                                    <div class="form-group col-md-6">
                                  <label for="inputUni">Fecha de inicio</label>
                                  <input type="date" name="fechaInicio" value="${sanitariaEdit.fechaInicio }" class="form-control" id="inputUni" placeholder="">
                                </div>

                                <div class="form-group col-md-6">
                                  <label for="inputUni">Fecha de finalización</label>
                                  <input type="date" class="form-control" name="fechaFin" value="${sanitariaEdit.fechaFin }" id="inputUni" placeholder="">
                                </div>
    
    
                                  <div class="form-row">

                                        <c:if test="${sanitariaEdit != null }">
                                  <div class="col text-left">
                                      <button type="submit" class="btn btn-primary ">Editar</button>
                                  </div>
                  					</c:if>
                  					
                  					<c:if test="${sanitariaEdit == null }">
                                  <div class="col text-left">
                                      <button type="submit" class="btn btn-primary ">Guardar</button>
                                  </div>
                  					</c:if>
                                        
                                      </div>
    

                  </form>


</div>
                

</div>
</div>
</body>
</html>