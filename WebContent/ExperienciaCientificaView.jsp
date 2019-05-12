<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Experiencia científica y tecnológica</title>
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

        <li><a href="DescargarCVServlet">Descargar CVN</a></li>
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
                <h3>Proyectos de I+D+i financiados en convocatorias competitivas de Administraciones o entidades públicas y privadas</h3>
            </div>

            <table class="table">
                    <thead>
                      <tr class="bg-primary">
                        <th scope="col">Nombre del proyecto</th>
                        <th scope="col">Entidad de realización</th>
                        <th scope="col">Fecha de inicio</th>
                        <th scope="col">Fecha de finalización</th>
                        <th scope="col">Editar</th>
                        <th scope="col">Eliminar</th>
                        
                      </tr>
                    </thead>
                    <tbody>
                     
                     <c:if test="${fn:length(proyectos) < 1}">
      					<tr>
      					<td>
      					No hay ningún proyecto añadido.
      					</td>
      					</tr>
      					</c:if>
      					
      					<c:forEach items="${proyectos}" var="proyecto">
				<tr>
				<td>${proyecto.nombreProyecto }</td>
				<td>${proyecto.entidadRealizacion }</td>
				<td>${proyecto.fechaInicio }</td>
				<td>${proyecto.fechaFin }</td>
				
				
				<td>
				<a href="/eCV/ProyectoServlet?edit=${proyecto.id}"   >
				<button type="submit" class="glyphicon glyphicon-edit"></button>
				</a>
				
				</td>
				
				<td>
				<form action="ProyectoServlet" method="POST"  >
				<button type="submit" name="delete" value="${ proyecto.id}"class="glyphicon glyphicon-remove"></button>
				</form>
				
				</td>
				
				</tr>
			</c:forEach>
      </tbody>
    </table>

                  <form method="post" action="/eCV/ProyectoServlet" >

                        <div class="form-row">

                                <div class="form-group col-md-8">
                                  <label for="inputName">Nombre del proyecto</label>
                                  <input type="text" class="form-control" id="inputName" name="nombreProyecto" value="${proyectoEdit.nombreProyecto }" placeholder="Nombre del proyecto">
                                </div>

                                <div class="form-group col-md-4">
                                  <label for="inputDate">Nº de investigadores/as</label>
                                  <input type="number" class="form-control" name="numeroInvestigadores" value="${proyectoEdit.numeroInvestigadores }" id="inputPassword4">
                                </div>

                              </div>

                              <div class="form-row">

                                        
                                    <div class="form-group col-md-10">
                                            <label for="inputType">Nombre </label>
                                            <input type="text" class="form-control" name="nombreInvestigador" value="${proyectoEdit.nombreInvestigador }" >                                      
                                          </div> 
                                    
                                    <div class="form-group col-md-2">
                                        <label for="inputAudio"> Posicion   </label>
                                        <input type="text" class="form-control" name="posicion" value="${proyectoEdit.posicion }" > 
                                                                             
                                          </div> 
                                        </div>
                                          
                                        <div class="form-row">

                                    <div class="form-group col-md-12">
                                      <label for="inputEntity">Entidad de realización</label>
                                      <input type="text" class="form-control"name="entidadRealizacion" value="${proyectoEdit.entidadRealizacion }" id="inputEntity" placeholder="">
                                    </div>
                                     </div>

                                    <div class="form-row">

                                    <div class="form-group col-md-4">
                                        <label for="inputEntity">Ciudad entidad de realización</label>
                                        <input type="text" class="form-control" name="ciudad" value="${proyectoEdit.ciudad }" id="inputEntity" placeholder="">
                                      </div>

                                     <div class="form-group col-md-4">
                                          <label for="inputEntity">País entidad de realización</label>
                                          <input type="text" class="form-control" name="pais" value="${proyectoEdit.pais }" id="inputEntity" placeholder="">
                                        </div>

                                      <div class="form-group col-md-4">
                                          <label for="inputAudio">C. Autón./Reg. entidad realización </label>
                                          <input type="text"  name="region" value="${proyectoEdit.region }" id="inputAudio" class="form-control">
                                                                                      
                                          
                                          </div>

                                        </div>

                                        <div class="form-row">
                                        
                                      <div class="form-group col-md-4">
                                          <label for="inputDate">Fecha de inicio</label>
                                          <input type="date" class="form-control" name="fechaInicio" value="${proyectoEdit.fechaInicio }" id="inputPassword4" >
                                        </div>

                                        <div class="form-group col-md-4">
                                            <label for="inputDate">Fecha de finalización</label>
                                            <input type="date" class="form-control" name="fechaFin" value="${proyectoEdit.fechaFin }" id="inputPassword4" >
                                          </div>

                                        <div class="form-group col-md-4">
                                            <label for="inputDate">Cuantia total (Euros)</label>
                                            <input type="text" class="form-control" name="cuantia" value="${proyectoEdit.cuantia }" id="inputPassword4" >
                                          </div>
                                          
                                        </div>
                                        

                                          <div class="form-row">

                                        <c:if test="${proyectoEdit != null }">
                                  <div class="col text-left">
                                      <button type="submit" class="btn btn-primary ">Editar</button>
                                  </div>
                  					</c:if>
                  					
                  					<c:if test="${proyectoEdit == null }">
                                  <div class="col text-left">
                                      <button type="submit" class="btn btn-primary ">Guardar</button>
                                  </div>
                  					</c:if>
                                        
                                      </div>
    

                  </form>


</div>

<hr>




<div class="container justify-content-center">

    <div class="container text-left">
            <h3>Propiedad industrial e intelectual</h3>
        </div>

        <table class="table">
                <thead>
                  <tr class="bg-primary">
                    <th scope="col">Título propiedad industrial registrada</th>
                    <th scope="col">Entidad titular de derechos</th>
                    <th scope="col">Fecha de registro</th>
                    <th scope="col">Editar</th>
                    <th scope="col">Eliminar</th>
                    
                  </tr>
                </thead>
                <tbody>
                
                <c:if test="${fn:length(propiedades) < 1}">
      					<tr>
      					<td>
      					No hay ninguna propiedad intelectual añadida.
      					</td>
      					</tr>
      					</c:if>
      					
      					<c:forEach items="${propiedades}" var="prop">
				<tr>
				<td>${prop.tituloPropiedad }</td>
				<td>${prop.entidadDerechos }</td>
				<td>${prop.fechaRegistro }</td>
				
				
				<td>
				<a href="/eCV/PropiedadIntelectualServlet?edit=${prop.id}"   >
				<button type="submit" class="glyphicon glyphicon-edit"></button>
				</a>
				
				</td>
				
				<td>
				<form action="PropiedadIntelectualServlet" method="POST"  >
				<button type="submit" name="delete" value="${prop.id}"class="glyphicon glyphicon-remove"></button>
				</form>
				
				</td>
				
				</tr>
			</c:forEach>
      </tbody>
    </table>
      					
      					

              <form method="post" action="/eCV/PropiedadIntelectualServlet">

                    <div class="form-row">

                            <div class="form-group col-md-6">
                              <label for="inputName">Título propiedad industrial registrada</label>
                              <input type="text" class="form-control" id="inputName" name="tituloPropiedad" value="${propiedadEdit.tituloPropiedad }" placeholder="Título propiedad industrial registrada">
                            </div>

                            <div class="form-group col-md-3">
                                <label for="inputDate">Fecha de registro</label>
                                <input type="date" class="form-control" id="inputPassword4" name="fechaRegistro" value="${propiedadEdit.fechaRegistro }">
                              </div>
                            <div class="form-group col-md-3">
                                <label for="inputDate">Fecha de concesión</label>
                                <input type="date" class="form-control" id="inputPassword4" name="fechaConcesion" value="${propiedadEdit.fechaConcesion }">
                              </div>
                          </div>

                          <div class="form-row">

                                <div class="form-group col-md-4">
                                        <label for="inputType">Nº de solicitud </label>
                                        <input type="text" class="form-control" name="numeroSolicitud" value="${propiedadEdit.numeroSolicitud }" id="inputPassword4">                                      
                                      </div>
                                      
                                <div class="form-group col-md-4">
                                        <label for="inputType">Pais de inscripción </label>
                                        <input type="text" class="form-control" id="inputName" name="pais" value="${propiedadEdit.pais }" placeholder="País de inscripción">                                    
                                      </div> 
                                      
                                <div class="form-group col-md-4">
                                        <label for="inputType">C. Autón./Reg. de inscripción</label>
                                        <input type="text" class="form-control" id="inputName" name="region" value="${propiedadEdit.region }">                                         
                                      </div> 
                                      
                                      </div>
                                      
                                      <div class="form-row">
                                      
                                      
                                        
                                  <div class="form-group col-md-8">
                                          <label for="inputType">Nombre </label>
                                          <input type="text" class="form-control" name="nombre" value="${propiedadEdit.nombre}" id="inputPassword4">                                      
                                        </div> 
                                  
                                  <div class="form-group col-md-4">
                                      <label for="inputAudio"> Posicion   </label>
                                      <input type="text" class="form-control" name="posicion" value="${propiedadEdit.posicion }" id="inputPassword4">                                   
                                        </div>
                                        
                                        </div>
                                      
										<div class="form-row">
										
                                      <div class="form-group col-md-6">
                                        <label for="inputAudio"> Entidad titular de derechos </label>
                                        <input type="text" class="form-control" name="entidadDerechos" value="${propiedadEdit.entidadDerechos }" id="inputPassword4">                                    
                                          </div> 

                                <div class="form-group col-md-6">
                                    <label for="inputEntity">Filtro</label>
                                    <input type="text" class="form-control" id="inputEntity" name="filtro" value="${propiedadEdit.filtro }" placeholder="">
                                  </div>                                

                              </div>

                              <div class="form-row">

                                        <c:if test="${propiedadEdit != null }">
                                  <div class="col text-left">
                                      <button type="submit" class="btn btn-primary ">Editar</button>
                                  </div>
                  					</c:if>
                  					
                  					<c:if test="${ propiedadEdit  == null }">
                                  <div class="col text-left">
                                      <button type="submit" class="btn btn-primary ">Guardar</button>
                                  </div>
                  					</c:if>
                                        
                                      </div>

              </form>


</div>
</body>
</html>