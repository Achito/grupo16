<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
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
      <a class="navbar-brand" href="#">Principal</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Editar CVN</a></li>
        <li><a href="#">Importar CVN</a></li>
        <li><a href="#">Descargar CVN</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Tu datos</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container justify-content-center">

        <div class="container text-left">
                <h3>Estudios de 1� y 2� ciclo, y antiguos ciclos (Licenciados, Diplomados, Ingenieros Superiores, Ingenieros T�cnicos, Arquitectos)</h3>
            </div>

            <table class="table">
                    <thead>
                      <tr class="bg-primary">
                        <th scope="col">Nombre del t�tulo</th>
                        <th scope="col">Entidad de titulaci�n</th>
                        <th scope="col">Fecha de titulaci�n</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td scope="row">No posee ning�n t�tulo almacenado en el sistema.</td>
                      </tr>
                    </tbody>
                  </table>

                  <form>

                        <div class="form-row">

                                <div class="form-group col-md-8">
                                  <label for="inputName">Nombre del t�tulo</label>
                                  <input type="email" class="form-control" id="inputName" placeholder="Nombre del t�tulo">
                                </div>

                                <div class="form-group col-md-4">
                                  <label for="inputDate">Fecha de titulaci�n</label>
                                  <input type="date" class="form-control" id="inputPassword4" placeholder="Contrase�a nueva">
                                </div>

                              </div>

                              <div class="form-row">

                                    <div class="form-group col-md-2">
                                            <label for="inputType">Titulaci�n universitaria</label>
                                            <select id="inputType" class="form-control">
                                              <option></option>
                                              <option>Doctor</option>
                                              <option>Otros</option>
                                              <option>Titulado Medio</option>
                                              <option>Titulado Superior</option>
                    
                                            </select>
                                          </div>
    
                                    <div class="form-group col-md-10">
                                      <label for="inputEntity">Entidad de titulaci�n</label>
                                      <input type="text" class="form-control" id="inputEntity" placeholder="">
                                    </div>
    
                                  </div>

                                  <div class="form-row">

                                        <div class="form-group col-md-3">
                                            <button type="submit" class="btn btn-primary ">Guardar</button>
                                        </div>
                                        
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
                        <th scope="col">Entidad de titulaci�n</th>
                        <th scope="col">Fecha de titulaci�n</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td scope="row">No posee ning�n programa de doctorado almacenado en el sistema.</td>
                      </tr>
                    </tbody>
                  </table>

                  <form>

                        <div class="form-row">

                                <div class="form-group col-md-8">
                                  <label for="inputDoc">Programa de doctorado</label>
                                  <input type="email" class="form-control" id="inputDoc" placeholder="Nombre del t�tulo">
                                </div>

                                <div class="form-group col-md-4">
                                  <label for="inputDate">Fecha de titulaci�n</label>
                                  <input type="date" class="form-control" id="inputPassword4" placeholder="Contrase�a nueva">
                                </div>

                              </div>

                              <div class="form-row">

    
                                    <div class="form-group col-md-10">
                                      <label for="inputEntity">Entidad de titulaci�n</label>
                                      <input type="text" class="form-control" id="inputEntity" placeholder="">
                                    </div>
    
                                  </div>

                                  <div class="form-row">

                                        <div class="form-group col-md-3">
                                            <button type="submit" class="btn btn-primary ">Guardar</button>
                                        </div>
                                        
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
                        <th scope="col">Comprensi�n auditiva</th>
                        <th scope="col">Comprensi�n de lectura</th>
                        <th scope="col">Comprensi�n de lectura</th>
                        <th scope="col">Interacci�n oral</th>
                        <th scope="col">Expresi�n</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td scope="row">No posee ning�n t�tulo de idiomas almacenado en el sistema.</td>
                      </tr>
                    </tbody>
                  </table>

                  <form>

                        <div class="form-row">

                                <div class="form-group col-md-7">
                                  <label for="inputDoc">Idioma</label>
                                  <input type="text" class="form-control" id="inputLanguage" placeholder="">
                                </div>

                                <div class="form-group col-md-1">
                                        <label for="inputAudio">Comprensi�n auditiva</label>
                                        <select id="inputAudio" class="form-control">
                                          <option></option>
                                          <option>A1</option>
                                          <option>A2</option>
                                          <option>B1</option>
                                          <option>B2</option>
                                          <option>C1</option>
                                          <option>C2</option>
                                        </select>
                                      </div>


                                <div class="form-group col-md-1">
                                        <label for="inputAudio">Comprensi�n lectora</label>
                                        <select id="inputAudio" class="form-control">
                                          <option></option>
                                          <option>A1</option>
                                          <option>A2</option>
                                          <option>B1</option>
                                          <option>B2</option>
                                          <option>C1</option>
                                          <option>C2</option>
                                        </select>
                                      </div>

                                      <div class="form-group col-md-1">
                                            <label for="inputAudio">Interacci�n oral</label>
                                            <select id="inputAudio" class="form-control">
                                                    <option></option>
                                                    <option>A1</option>
                                                    <option>A2</option>
                                                    <option>B1</option>
                                                    <option>B2</option>
                                                    <option>C1</option>
                                                    <option>C2</option>
                                            </select>
                                          </div>

                                        <div class="form-group col-md-1">
                                                <label for="inputAudio">Expresi�n oral</label>
                                                <select id="inputAudio" class="form-control">
                                                        <option></option>
                                                        <option>A1</option>
                                                        <option>A2</option>
                                                        <option>B1</option>
                                                        <option>B2</option>
                                                        <option>C1</option>
                                                        <option>C2</option>
                                                </select>
                                            </div>

                                            <div class="form-group col-md-1">
                                                    <label for="inputAudio">Expresi�n escrita</label>
                                                    <select id="inputAudio" class="form-control">
                                                            <option></option>
                                                            <option>A1</option>
                                                            <option>A2</option>
                                                            <option>B1</option>
                                                            <option>B2</option>
                                                            <option>C1</option>
                                                            <option>C2</option>
                                                    </select>
                                                </div>

 

                            </div>

    

                                  <div class="form-row">

                                        <div class="form-group col-md-3">
                                            <button type="submit" class="btn btn-primary ">Guardar</button>
                                        </div>
                                        
                                      </div>

                  </form>


</div>
</body>
</html>