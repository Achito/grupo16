<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Formacion Academica</title>
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
        <li><a href="InvestigadorDatosServlet"><span class="glyphicon glyphicon-user"></span> ${investigador.name }</a></li>
        <li><a href="LogoutServlet"><span class="glyphicon glyphicon-off"></span> Salir</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container justify-content-center">


           <h1>Estudios de 1º y 2º ciclo, y antiguos ciclos (Licenciados, Diplomados, Ingenieros Superiores, Ingenieros Técnicos, Arquitectos)</h1> 
    <table class="table">
      <thead>
        <tr class="bg-primary">
          <th scope="col">Nombre del título</th>
          <th scope="col">Entidad de titulación</th>
          <th scope="col">Fecha de titulación</th>
          <th scope="col">Editar</th>
          <th scope="col">Eliminar</th>
        </tr>
      </thead>
      <tbody>
      
      <c:if test="${fn:length(titulosAcademicos) < 1}">
      	<tr>
      	<td>
      	No hay ningun título académico añadido.
      	</td>
      	</tr>
      </c:if>
        
      <c:forEach items="${titulosAcademicos}" var="ta">
				<tr>
				<td>${ta.nombreTitulo }</td>
				<td>${ta.entidadTitulacion }</td>
				<td>${ta.fechaTitulacion }</td>
				
				
				<td>
				<a href="/eCV/TituloAcademicoServlet?edit=${ta.id}"   >
				<button type="submit" class="glyphicon glyphicon-edit"></button>
				</a>
				
				</td>
				
				<td>
				<form action="TituloAcademicoServlet" method="POST"  >
				<button type="submit" name="delete" value="${ta.id}"class="glyphicon glyphicon-remove"></button>
				</form>
				
				</td>
				
				</tr>
			</c:forEach>
      </tbody>
    </table>

                  <form method="post" action="/eCV/TituloAcademicoServlet">

                        <div class="form-row">

                                <div class="form-group col-md-8">
                                  <label for="inputName">Nombre del título</label>
                                  <input type="text"  required="true" class="form-control" name="nombreTitulo" value="${taEdit.nombreTitulo }" id="inputName" placeholder="Nombre del título">
                                </div>

                                <div class="form-group col-md-4">
                                  <label for="inputDate">Fecha de titulación</label>
                                  <input type="date" class="form-control" required="true" name="fechaTitulacion" value="${taEdit.fechaTitulacion }"placeholder="Contraseña nueva">
                                </div>

                              </div>

                              <div class="form-row">

                                    <div class="form-group col-md-2">
                                            <label for="inputType">Titulación universitaria</label>
                                            <select id="inputType" name="tipoTitulacion" class="form-control">
                                              <option></option>
                                              <option>Doctor</option>
                                              <option>Otros</option>
                                              <option>Titulado Medio</option>
                                              <option>Titulado Superior</option>
                    
                                            </select>
                                          </div>
    
                                    <div class="form-group col-md-10">
                                      <label for="inputEntity">Entidad de titulación</label>
                                      <input type="text" class="form-control" required="true" name="entidadTitulacion" value="${taEdit.entidadTitulacion }" id="inputEntity" placeholder="">
                                    </div>
    
                                  </div>

                                  <div class="form-row">

                                        <c:if test="${taEdit != null }">
                                  <div class="col text-left">
                                      <button type="submit" class="btn btn-primary ">Editar</button>
                                  </div>
                  					</c:if>
                  					
                  					<c:if test="${taEdit == null }">
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
                <h3>Doctorados</h3>
            </div>

            <table class="table">
                    <thead>
                      <tr class="bg-primary">
                        <th scope="col">Programa de doctorado</th>
                        <th scope="col">Entidad de titulación</th>
                        <th scope="col">Fecha de titulación</th>
                        <th scope="col">Editar</th>
                        <th scope="col">Eliminar</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:if test="${fn:length(doctorados) < 1}">
      	<tr>
      	<td>
      	No hay ningun título académico añadido.
      	</td>
      	</tr>
      </c:if>
        
      <c:forEach items="${doctorados}" var="doc">
				<tr>
				<td>${doc.programaDoctorado }</td>
				<td>${doc.entidadTitulacion }</td>
				<td>${doc.fechaTitulacion }</td>
				
				
				<td>
				<a href="/eCV/DoctoradoServlet?edit=${doc.id}"   >
				<button type="submit" class="glyphicon glyphicon-edit"></button>
				</a>
				
				</td>
				
				<td>
				<form action="DoctoradoServlet" method="POST"  >
				<button type="submit" name="delete" value="${doc.id}"class="glyphicon glyphicon-remove"></button>
				</form>
				
				</td>
				
				</tr>
			</c:forEach>
      </tbody>
    </table>

                  <form method="post" action="/eCV/DoctoradoServlet">

                        <div class="form-row">

                                <div class="form-group col-md-8">
                                  <label for="inputDoc">Programa de doctorado</label>
                                  <input type="text" class="form-control"  required="true" id="inputDoc" name="programaDoctorado" value="${docEdit.programaDoctorado }" placeholder="Nombre del título">
                                </div>

                                <div class="form-group col-md-4">
                                  <label for="inputDate">Fecha de titulación</label>
                                  <input type="date" class="form-control"  required="true" name="fechaTitulacion" value="${docEdit.fechaTitulacion }" id="inputPassword4" placeholder="Contraseña nueva">
                                </div>

                              </div>

                              <div class="form-row">

    
                                    <div class="form-group col-md-10">
                                      <label for="inputEntity">Entidad de titulación</label>
                                      <input type="text" class="form-control" required="true" name="entidadTitulacion" value="${docEdit.entidadTitulacion }"id="inputEntity" placeholder="">
                                    </div>
    
                                  </div>

                                  <div class="form-row">

                                       <c:if test="${docEdit != null }">
                                  <div class="col text-left">
                                      <button type="submit" class="btn btn-primary ">Editar</button>
                                  </div>
                  					</c:if>
                  					
                  					<c:if test="${docEdit == null }">
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
                <h3>Conocimiento de idiomas</h3>
            </div>

            <table class="table">
                    <thead>
                      <tr class="bg-primary">
                        <th scope="col">Idioma</th>
                        <th scope="col">Comprensión auditiva</th>
                        <th scope="col">Comprensión de lectura</th>
                        <th scope="col">Interacción oral</th>
                        <th scope="col">Expresión oral</th>
                        <th scope="col">Expresión escrita</th>
                        <th scope="col">Editas</th>
                        <th scope="col">Eliminar</th>
                      </tr>
                    </thead>
                    <tbody>
                    
                     <c:if test="${fn:length(idiomas) < 1}">
                      <tr>
                        <td scope="row">No posee ningún título de idiomas almacenado en el sistema.</td>
                      </tr>
                      </c:if>
                      
                      
                 <c:forEach items="${idiomas}" var="idio">
				<tr>
				<td>${idio.idioma }</td>
				<td>${idio.compAuditiva }</td>
				<td>${idio.compLectora }</td>
				<td>${idio.intOral }</td>
				<td>${idio.expOral }</td>
				<td>${idio.expEscrita}</td>
				
				
				
				<td>
				<a href="/eCV/IdiomaServlet?edit=${idio.id}"   >
				<button type="submit" class="glyphicon glyphicon-edit"></button>
				</a>
				
				</td>
				
				<td>
				<form action="IdiomaServlet" method="POST"  >
				<button type="submit" name="delete" value="${idio.id}"class="glyphicon glyphicon-remove"></button>
				</form>
				
				</td>
				
				</tr>
			</c:forEach>
      </tbody>
    </table>

                  <form action="/eCV/IdiomaServlet" method="post">

                        <div class="form-row">

                                <div class="form-group col-md-7">
                                  <label for="inputDoc">Idioma</label>
                                  <input type="text" class="form-control" name="idioma" value="${idiomaEdit.idioma}"required="true" id="inputLanguage" placeholder="">
                                </div>

                                <div class="form-group col-md-1">
                                        <label for="inputAudio">Comprensión auditiva</label>
                                        <select id="inputAudio" name="compAuditiva"  class="form-control">
                                          <option value="${idiomaEdit.compAuditiva}"> ${idiomaEdit.compAuditiva}</option>
                                          <option value="A1">A1</option>
                                          <option value="A2">A2</option>
                                          <option value="B1">B1</option>
                                          <option value="B2">B2</option>
                                          <option value="C1">C1</option>
                                          <option value="C2">C2</option>
                                        </select>
                                      </div>


                                <div class="form-group col-md-1">
                                        <label for="inputAudio">Comprensión lectora</label>
                                        <select id="inputAudio" name="compLectora" class="form-control">
                                          <option value="${idiomaEdit.compLectora}"> ${idiomaEdit.compLectora}</option>
                                          <option value="A1">A1</option>
                                          <option value="A2">A2</option>
                                          <option value="B1">B1</option>
                                          <option value="B2">B2</option>
                                          <option value="C1">C1</option>
                                          <option value="C2">C2</option>
                                        </select>
                                      </div>

                                      <div class="form-group col-md-1">
                                            <label for="inputAudio">Interacción oral</label>
                                            <select id="inputAudio" name="intOral" class="form-control">
                                                    <option value="${idiomaEdit.intOral}"> ${idiomaEdit.intOral}</option>
                                          			<option value="A1">A1</option>
                                          			<option value="A2">A2</option>
                                          			<option value="B1">B1</option>
                                          			<option value="B2">B2</option>
                                          			<option value="C1">C1</option>
                                          			<option value="C2">C2</option>
                                            </select>
                                          </div>

                                        <div class="form-group col-md-1">
                                                <label for="inputAudio">Expresión oral</label>
                                                <select id="inputAudio" name="expOral" class="form-control">
                                                    <option value="${idiomaEdit.expOral}"> ${idiomaEdit.expOral}</option>
                                          			<option value="A1">A1</option>
                                          			<option value="A2">A2</option>
                                          			<option value="B1">B1</option>
                                          			<option value="B2">B2</option>
                                          			<option value="C1">C1</option>
                                          			<option value="C2">C2</option>
                                                </select>
                                            </div>

                                            <div class="form-group col-md-1">
                                                    <label for="inputAudio">Expresión escrita</label>
                                                    <select id="inputAudio"  name="expEscrita" class="form-control">
                                                    <option value="${idiomaEdit.expEscrita}"> ${idiomaEdit.expEscrita}</option>
                                          			<option value="A1">A1</option>
                                          			<option value="A2">A2</option>
                                          			<option value="B1">B1</option>
                                          			<option value="B2">B2</option>
                                          			<option value="C1">C1</option>
                                          			<option value="C2">C2</option>
                                                    </select>
                                                </div>

 

                            </div>

    

                                  <div class="form-row">

                                        <c:if test="${idiomaEdit != null }">
                                  <div class="col text-left">
                                      <button type="submit" class="btn btn-primary ">Editar</button>
                                  </div>
                  					</c:if>
                  					
                  					<c:if test="${idiomaEdit == null }">
                                  <div class="col text-left">
                                      <button type="submit" class="btn btn-primary ">Guardar</button>
                                  </div>
                  					</c:if>
                                        
                                      </div>

                  </form>


</div>
</body>
</html>