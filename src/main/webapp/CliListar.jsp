<%@ page import="java.util.List" %>
<%@ page import="Modelos.Activo" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Ver Clientes - Gestion Activos</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
    <link href="css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>

    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.jsp">Gestion de Activos</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Buscar por.." aria-label="Buscar por.." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Actualizar Informacion</a></li>                  
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="nav-link" href="login.html">Salir</a></li> <!-- Corregido aquí -->
                    </ul>
                </li>
            </ul>
        </nav>
<div id="layoutSidenav">
    <div id="layoutSidenav_nav">
        <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
            <div class="sb-sidenav-menu">
                <div class="nav">
                    <div class="sb-sidenav-menu-heading">Menú</div>
                    
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseUsuarios" aria-expanded="false" aria-controls="collapseUsuarios">
                        <div class="sb-nav-link-icon"><i class="fas fa-users"></i></div>
                        Usuarios
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapseUsuarios" aria-labelledby="headingUsuarios" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionUsuarios">
                            <a class="nav-link" href="UsuRegistrar.jsp">Registrar Usuario</a>
                            <a class="nav-link" href="UsuActualizar.jsp">Actualizar Usuario</a>
                            <a class="nav-link" href="UsuListar.jsp">Ver Usuarios</a>
                        </nav>
                    </div>

                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseClientes" aria-expanded="false" aria-controls="collapseClientes">
                        <div class="sb-nav-link-icon"><i class="fas fa-people-carry"></i></div>
                        Clientes
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapseClientes" aria-labelledby="headingClientes" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionClientes">
                            <a class="nav-link" href="CliRegistrar.jsp">Registrar Cliente</a>
                            <a class="nav-link" href="CliActualizar.jsp">Actualizar Cliente</a>
                            <a class="nav-link" href="CliListar.jsp">Ver Clientes</a>
                        </nav>
                    </div>

                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseActivos" aria-expanded="false" aria-controls="collapseActivos">
                        <div class="sb-nav-link-icon"><i class="fas fa-cogs"></i></div>
                        Activos
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapseActivos" aria-labelledby="headingActivos" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionActivos">
                            <a class="nav-link" href="ActRegistrar.jsp">Registrar Activo</a>
                            <a class="nav-link" href="ActActualizar.jsp">Actualizar Activo</a>
                            <a class="nav-link" href="ActListar.jsp">Ver Activos</a>
                        </nav>
                    </div>

                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseFacturas" aria-expanded="false" aria-controls="collapseFacturas">
                        <div class="sb-nav-link-icon"><i class="fas fa-file-invoice"></i></div>
                        Facturas
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapseFacturas" aria-labelledby="headingFacturas" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionFacturas">
                            <a class="nav-link" href="FacRegistrar.jsp">Registrar Factura</a>
                            <a class="nav-link" href="FacActualizar.jsp">Actualizar Factura</a>
                            <a class="nav-link" href="FacListar.jsp">Ver Facturas</a>
                        </nav>
                    </div>

                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseCotizaciones" aria-expanded="false" aria-controls="collapseCotizaciones">
                        <div class="sb-nav-link-icon"><i class="fas fa-file-alt"></i></div>
                        Cotizaciones
                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                    </a>
                    <div class="collapse" id="collapseCotizaciones" aria-labelledby="headingCotizaciones" data-bs-parent="#sidenavAccordion">
                        <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionCotizaciones">
                            <a class="nav-link" href="CotRegistrar.jsp">Registrar Cotización</a>
                            <a class="nav-link" href="CotActualizar.jsp">Actualizar Cotización</a>
                            <a class="nav-link" href="CotListar.jsp">Ver Cotizaciones</a>
                        </nav>
                    </div>
                </div>
            </div>
        </nav>
    </div>
           
            
            
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Gestión de Clientes</h1>
                            <ol class="breadcrumb mb-4">
                                <li class="breadcrumb-item active">Ver Clientes</li>
                            </ol>

                        
  <div class="container mt-4">
        <h2>Buscar Clientes</h2>
        <!-- Barra de búsqueda -->
        <form action="ClienteServlet" method="GET">
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Buscar por nombre" name="nombreBuscar" required>
                <button class="btn btn-primary" type="submit">Buscar</button>
            </div>
        </form>

        <h3>Clientes Encontrados</h3>
        <!-- Mostrar mensaje si no se encuentran clientes -->
        <c:if test="${empty clientes}">
            <div class="alert alert-warning">No se encontraron clientes.</div>
        </c:if>

        <!-- Tabla de clientes -->
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID Cliente</th>
                    <th>Nombre</th>
                    <th>Correo</th>
                    <th>Teléfono</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <!-- Iterar sobre los clientes encontrados -->
                <c:forEach var="cliente" items="${clientes}">
                    <tr>
                        <td>${cliente.idCliente}</td>
                        <td>${cliente.nombre}</td>
                        <td>${cliente.email}</td>
                        <td>${cliente.telefono}</td>
                        <td>
                            <!-- Ver detalles del cliente -->
                            <a href="VerClienteDetalle.jsp?id=${cliente.idCliente}" class="btn btn-info">Ver Detalles</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Botón para descargar los registros -->
        <form action="ClienteServlet" method="POST">
            <button type="submit" class="btn btn-success" name="accion" value="descargar">Descargar Todos los Clientes</button>
        </form>
    </div>

    <!-- Agregar el script de Bootstrap JS si es necesario -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>


                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2023</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
                        <!-- Scripts JS de Bootstrap (opcional) -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- DataTables JS -->
    <script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#datatablesSimple').DataTable(); // Inicializa DataTables
        });
    </script>
    </body>
</html>
