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
                <h3>Proyectos de I+D+i financiados en convocatorias competitivas de Administraciones o entidades públicas y privadas</h3>
            </div>

            <table class="table">
                    <thead>
                      <tr class="bg-primary">
                        <th scope="col">Nombre del proyecto</th>
                        <th scope="col">Entidad de realización</th>
                        <th scope="col">Fecha de inicio</th>
                        <th scope="col">Editar</th>
                        <th scope="col">Eliminar</th>
                        
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td scope="row">No posee ningún proyecto almacenado en el sistema.</td>
                      </tr>
                    </tbody>
                  </table>

                  <form>

                        <div class="form-row">

                                <div class="form-group col-md-8">
                                  <label for="inputName">Nombre del proyecto</label>
                                  <input type="email" class="form-control" id="inputName" name="nombreProyecto" value="${proyecto.nombreProyecto }" placeholder="Nombre del proyecto">
                                </div>

                                <div class="form-group col-md-4">
                                  <label for="inputDate">Nº de investigadores/as</label>
                                  <input type="number" class="form-control" id="inputPassword4">
                                </div>

                              </div>

                              <div class="form-row">

                                        
                                    <div class="form-group col-md-10">
                                            <label for="inputType">Nombre </label>
                                            <input type="text" class="form-control" >                                      
                                          </div> 
                                    
                                    <div class="form-group col-md-2">
                                        <label for="inputAudio"> Posicion   </label>
                                        <input type="text" class="form-control" > 
                                                                             
                                          </div> 
                                        </div>
                                          
                                        <div class="form-row">

                                    <div class="form-group col-md-10">
                                      <label for="inputEntity">Entidad de realización</label>
                                      <input type="text" class="form-control" id="inputEntity" placeholder="">
                                    </div>
                                     </div>

                                    <div class="form-row">

                                    <div class="form-group col-md-4">
                                        <label for="inputEntity">ciudad entidad de realización</label>
                                        <input type="text" class="form-control" id="inputEntity" placeholder="">
                                      </div>

                                     <div class="form-group col-md-4">
                                          <label for="inputEntity">País entidad de realización</label>
                                          <input type="text" class="form-control" id="inputEntity" placeholder="">
                                        </div>

                                      <div class="form-group col-md-4">
                                          <label for="inputAudio">C. Autón./Reg. entidad realización </label>
                                          <select id="inputAudio" class="form-control">
                                            <option></option>                                          
                                          </select>  
                                          </div>

                                        </div>

                                        <div class="form-row">
                                      <div class="form-group col-md-4">
                                          <label for="inputDate">Fecha de inicio</label>
                                          <input type="date" class="form-control" id="inputPassword4" placeholder="Contraseña nueva">
                                        </div>

                                        <div class="form-group col-md-4">
                                            <label for="inputDate">Fecha de finalización</label>
                                            <input type="date" class="form-control" id="inputPassword4" placeholder="Contraseña nueva">
                                          </div>

                                        <div class="form-group col-md-4">
                                            <label for="inputDate">Cuantia total (€)</label>
                                            <input type="date" class="form-control" id="inputPassword4" placeholder="Contraseña nueva">
                                          </div>
                                        </div>

                                          <div class="form-row">

                                        <div class="form-group col-md-3">
                                            <button type="submit" margin-right:6px class="btn btn-primary " style="float:left;">Guardar</button>
                                        </div>
                                        
                                      </div>
    
                                  </div>

                                 
                                      

                  </form>


</div>

<hr>

<div class="container justify-content-center">

    <div class="container text-left">
            <h3>Contratos, convenios o proyectos de I+D+i no competitivos con Administraciones o entidades públicas o privadas </h3>
        </div>

        <table class="table">
                <thead>
                  <tr class="bg-primary">
                    <th scope="col">Nombre del proyecto</th>
                    <th scope="col">Entidad/es financiadora/s</th>
                    <th scope="col">Fecha de inicio</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td scope="row">No posee ningún título almacenado en el sistema.</td>
                  </tr>
                </tbody>
              </table>

              <form>

                    <div class="form-row">

                            <div class="form-group col-md-8">
                              <label for="inputName">Nombre del proyecto</label>
                              <input type="email" class="form-control" id="inputName" placeholder="Nombre del proyecto">
                            </div>

                            <div class="form-group col-md-4">
                              <label for="inputDate">Nº de investigadores/as</label>
                              <input type="number" class="form-control" id="inputPassword4">
                            </div>

                          </div>

                          <div class="form-row">

                                <div class="form-group col-md-2">
                                        <label for="inputType">Firma </label>
                                        <input type="text" class="form-control" id="inputPassword4">                                      
                                      </div>
                                      
                                <div class="form-group col-md-2">
                                        <label for="inputType">Nombre </label>
                                        <input type="text" class="form-control" id="inputPassword4">                                      
                                      </div> 
                                <div class="form-group col-md-2">
                                        <label for="inputType">Primer Apellido </label>
                                        <input type="text" class="form-control" id="inputPassword4">                                      
                                      </div> 
                                <div class="form-group col-md-2">
                                        <label for="inputType">Segundo Apellido </label>
                                        <input type="text" class="form-control" id="inputPassword4">                                      
                                      </div> 
                                <div class="form-group col-md-1">
                                    <label for="inputAudio"> Posicion   </label>
                                    <select id="inputAudio" class="form-control">
                                      <option></option>                                          
                                    </select>                                     
                                      </div> 
                                      

                                      <div class="form-group col-md-5">
                                        <label for="inputAudio"> Grado de contribución   </label>
                                        <select id="inputAudio" class="form-control">
                                          <option></option>
                                          <option>Coordinador del proyecto total, red o consorcio</option>     
                                          <option>Coordinador/a científico/a</option>
                                          <option>Coordinador/a gerente</option> 
                                          <option>Investigador/a</option> 
                                          <option>Otros</option> 
                                          <option>Técnico/a</option> 
                                          <option>Titulado/a universitario/a en formación</option>                                                                            
                                        </select>                                     
                                          </div> 

                                <div class="form-group col-md-6">
                                    <label for="inputEntity">Filtro</label>
                                    <input type="text" class="form-control" id="inputEntity" placeholder="">
                                  </div>

                                  <div class="form-group col-md-4">
                                      <label for="inputDate">Fecha de inicio</label>
                                      <input type="date" class="form-control" id="inputPassword4" placeholder="Contraseña nueva">
                                    </div>

                                    <div class="form-group col-md-2">
                                        <label for="inputEntity">Años</label>
                                        <input type="text" class="form-control" id="inputEntity" placeholder="">
                                      </div>

                                    <div class="form-group col-md-2">
                                        <label for="inputEntity">Meses</label>
                                        <input type="text" class="form-control" id="inputEntity" placeholder="">
                                      </div>
                                    <div class="form-group col-md-2">
                                        <label for="inputEntity">días</label>
                                        <input type="text" class="form-control" id="inputEntity" placeholder="">
                                      </div>

                                    <div class="form-group col-md-2">                                            
                                        <label for="inputDate">Cuantía total</label>                                          
                                        <input type="text" class="text-right" placeholder="   ">
                                     </div>

                              </div>

                              <div class="form-row">

                                    <div class="form-group col-md-3">
                                        <button type="submit" margin-right:6px class="btn btn-primary ">Guardar</button>
                                    </div>
                                    
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
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <td scope="row">No posee ningún título almacenado en el sistema.</td>
                  </tr>
                </tbody>
              </table>

              <form>

                    <div class="form-row">

                            <div class="form-group col-md-5">
                              <label for="inputName">Título propiedad industrial registrada</label>
                              <input type="email" class="form-control" id="inputName" placeholder="Título propiedad industrial registrada">
                            </div>

                            <div class="form-group col-md-3">
                                <label for="inputDate">Fecha de registro</label>
                                <input type="date" class="form-control" id="inputPassword4" placeholder="Contraseña nueva">
                              </div>
                            <div class="form-group col-md-3">
                                <label for="inputDate">Fecha de concesión</label>
                                <input type="date" class="form-control" id="inputPassword4" placeholder="Contraseña nueva">
                              </div>
                          </div>

                          <div class="form-row">

                                <div class="form-group col-md-4">
                                        <label for="inputType">Nº de solicitud </label>
                                        <input type="text" class="form-control" id="inputPassword4">                                      
                                      </div>
                                      
                                <div class="form-group col-md-4">
                                        <label for="inputType">Pais de inscripción </label>
                                        <select id="inputAudio" class="form-control">
                                            <option></option>                                          
                                          </select>                                        
                                      </div> 
                                <div class="form-group col-md-4">
                                        <label for="inputType">C. Autón./Reg. de inscripción</label>
                                        <select id="inputAudio" class="form-control">
                                            <option></option>                                          
                                          </select>                                        
                                      </div> 
                                      <div class="form-group col-md-2">
                                          <label for="inputType">Firma </label>
                                          <input type="text" class="form-control" id="inputPassword4">                                      
                                        </div>
                                        
                                  <div class="form-group col-md-2">
                                          <label for="inputType">Nombre </label>
                                          <input type="text" class="form-control" id="inputPassword4">                                      
                                        </div> 
                                  <div class="form-group col-md-2">
                                          <label for="inputType">Primer Apellido </label>
                                          <input type="text" class="form-control" id="inputPassword4">                                      
                                        </div> 
                                  <div class="form-group col-md-2">
                                          <label for="inputType">Segundo Apellido </label>
                                          <input type="text" class="form-control" id="inputPassword4">                                      
                                        </div> 
                                  <div class="form-group col-md-1">
                                      <label for="inputAudio"> Posicion   </label>
                                      <select id="inputAudio" class="form-control">
                                        <option></option>                                          
                                      </select>                                     
                                        </div>
                                      

                                      <div class="form-group col-md-5">
                                        <label for="inputAudio"> Entidad titular de derechos </label>
                                        <input type="text" class="form-control" id="inputPassword4">                                    
                                          </div> 

                                <div class="form-group col-md-6">
                                    <label for="inputEntity">Filtro</label>
                                    <input type="text" class="form-control" id="inputEntity" placeholder="">
                                  </div>                                

                              </div>

                              <div class="form-row">

                                    <div class="form-group col-md-3">
                                        <button type="submit" margin-right:6px class="btn btn-primary ">Guardar</button>
                                    </div>
                                    
                                  </div>

              </form>


</div>
</body>
</html>