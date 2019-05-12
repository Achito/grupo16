<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Situación Profesional</title>
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

    <h1>Situación profesional actual</h1> 
    <table class="table">
      <thead>
        <tr class="bg-primary">
          <th scope="col">Categoría profesional</th>
          <th scope="col">Entidad empleadora</th>
          <th scope="col">Fecha de inicio</th>
          <th scope="col">Fecha de finalización</th>
          <th scope="col">Editar</th>
          <th scope="col">Eliminar</th>
          	
        </tr>
      </thead>
      <tbody>
      
      <c:if test="${fn:length(situacionesProfesionales) < 1}">
      	<tr>
      	<td>
      	No hay ninguna situación profesional añadida.
      	</td>
      	</tr>
      </c:if>
      
      <c:forEach items="${situacionesProfesionales}" var="sp">
				<tr>
				<td>${sp.categoriaProfesional }</td>
				<td>${sp.entidadEmpleadora }</td>
				<td>${sp.fechaInicio }</td>
				
				<c:if test="${sp.fechaFinal == null}">
					<td>Actualidad</td>
				</c:if>
				
			
				<c:if test="${sp.fechaFinal != null}">
				<td>${sp.fechaFinal }</td>
				</c:if>
				
				<td>
				<a href="/eCV/SituacionProfesionalServlet?edit=${sp.id}"   >
				<button type="submit" class="glyphicon glyphicon-edit"></button>
				</a>
				
				</td>
				
				<td>
				<form action="SituacionProfesionalServlet" method="POST"  >
				<button type="submit" name="delete" value="${sp.id}"class="glyphicon glyphicon-remove"></button>
				</form>
				
				</td>
				
				</tr>
			</c:forEach>
       
       
       
		
       
      </tbody>
    </table>
    
    
    <form method="post" action="/SituacionProfesionalServlet">
        <div class="form-row">
          <div class="form-group col-md-8">
            <label for="inputEmail4">Entidad empleadora</label>
            <input type="text" class="form-control" name="entidadEmpleadora" value="${spEdit.entidadEmpleadora }" required="true" placeholder="Nombre oficial de la entidad donde desarrolla su actividad laboral y/o profesional actualmente.">
          </div>
          <div class="form-group col-md-4">
              <label for="inputState">Tipo de entidad</label>
              <select name="tipoEntidad" class="form-control">
                <option value="${spEdit.entidadEmpleadora }" selected>${spEdit.entidadEmpleadora }</option>
                <option value="Agencia Estatal">Agencia Estatal</option>
                <option value="Asociaciones y Agrupaciones">Asociaciones y Agrupaciones</option>
                <option value="Centro de I+D">Centro de I+D</option>
                <option value="Centro Tecnológico">Centro Tecnológico</option>
                <option value="Centro de Inovación y Tecnología">Centro de Inovación y Tecnología</option>
                <option value="Centros y Estructuras Universitarios y Asimilados">Centros y Estructuras Universitarios y Asimilados</option>
                <option value="CIBER">CIBER</option>
                <option value="Departamento Universitario">Departamento Universitario</option>
                <option value="Entidad Empresarial">Entidad Empresarial</option>
                <option value="Entidad Gestora del Sistema Nacional de Salud">Entidad Gestora del Sistema Nacional de Salud</option>
                <option value="Fundación">Fundación</option>
                <option value="Instituciones Sanitarias">Instituciones Sanitarias</option>
                <option value="Instituto  Universitario de Investigación">Instituto  Universitario de Investigación</option>
                <option value="Organismo Público de Investigación" >Organismo Público de Investigación</option>
                <option value="Organismo, Otros">Organismo, Otros</option>
                <option value="Universidad">Universidad</option>
              </select>
            </div>
        </div>

        <div class="form-row">
        <div class="form-group col-md-8">
          <label for="inputAddress">Categoria profesional</label>
          <input type="text" required="true" name="categoriaProfesional" value="${spEdit.categoriaProfesional }" class="form-control" placeholder="Nivel de cualificación del puesto que ocupa dentro de la clasificación profesional.">
        </div>
        
        <div class="form-group col-md-4">
          <label for="inputDate">Fecha de Inicio</label>
          <input type="date" class="form-control" name="fechaInicio" value="${spEdit.fechaInicio }">
        </div>
      </div>
        
        <div class="form-row">
            <div class="form-group col-md-8">
                <label for="inputState">Modalidad de contrato
                  </label>
                <select name="modalidadContrato" class="form-control">
                  <option value="${spEdit.modalidadContrato }" selected>${spEdit.modalidadContrato }</option>
                  <option value="Becario/a (pre o posdoctoral, otros)">Becario/a (pre o posdoctoral, otros)</option>
                  <option value="Contrato laboral indefinido">Contrato laboral indefinido</option>
                  <option value="Contrato laboral temporal">Contrato laboral temporal</option>
                  <option value="Emérito/a">Emérito/a</option>
                  <option value="Estatuario/a">Estatuario/a</option>
                  <option value="Funcionario/a">Funcionario/a</option>
                  <option value="Interino/a">Interino/a</option>
                  <option value="Otros">Otros</option>
                </select>
              </div> 
              
           <div class="form-group col-md-4">
          <label for="inputDate">Fecha de Finalización (No indicar si está actualmente)</label>
          <input type="date" class="form-control" name="fechaFinal" value="${spEdit.fechaFinal }">
        	</div>
                          
          </div>

        
        <div class="form-row">
        
                <div class="form-group col-md-8">
                        <label for="inputDocument">Primaria (Cód. Unesco) </label>
                        <input type="text" class="form-control" name="primaria" value="${spEdit.primaria }">
                      </div>
                <div class="form-group col-md-8">
                        <label for="inputDNI">Secundaria (Cód. Unesco)</label>
                        <input type="text" class="form-control" name="secundaria" value="${spEdit.secundaria }">
                      </div>
                <div class="form-group col-md-8">
                            <label for="inputMovil1">Terciaria (Cód. Unesco)</label>
                            <input type="text" class="form-control" name="terciaria" value="${spEdit.terciaria }">
                      </div>
                <div class="form-group col-md-8">
                          <label for="inputMovil1">Régimen de dedicación</label>
                          <select name="dedicacion" class="form-control">                        
                            <option value="${spEdit.dedicacion }" selected>${spEdit.dedicacion }</option>
                            <option value="Tiempo completo">Tiempo completo</option>
                            <option value="Tiempo parcial">Tiempo parcial</option>
                          </select>
                       </div>
                <div class="form-group col-md-8">
                              <label for="inputMovil1">Identificar palabras clave</label>
                              <input type="text" class="form-control" name="palabrasClave" value="${spEdit.palabrasClave }">
                       </div>
                       <div class="form-group col-md-12">
                          <label for="inputMovil1">Funciones desempeñadas</label>
                      <textarea class="form-control" name="funciones" rows="9" value="${spEdit.funciones }"></textarea>
                          </div>
							
							
							
                          <div class="form-row" >
                              <div class="form-group col-md-3">
                  					<c:if test="${spEdit != null }">
                                  <div class="col text-left">
                                      <button type="submit" class="btn btn-primary ">Editar</button>
                                  </div>
                  					</c:if>
                  					
                  					<c:if test="${spEdit == null }">
                                  <div class="col text-left">
                                      <button type="submit" class="btn btn-primary ">Guardar</button>
                                  </div>
                  					</c:if>
                  					
                              </div>
                            </div>
					</form>
               </div>



        </div>
 
        
      
    
    </div>
  </div>
  
  
  
  
  
  
  
  
  
  
  
  
  





</body>
</html>