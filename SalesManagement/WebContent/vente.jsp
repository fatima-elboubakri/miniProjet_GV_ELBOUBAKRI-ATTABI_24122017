<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="fr">

<head>
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SALES MANAGEMENT-UPM</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style rel="stylesheet">

</style>
</head>

<body>
 <script>
        $(function() {
            $('input[name=dat]').datepicker();
        });
    </script>
    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="">SM</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
         
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Admin <b class="caret"></b></a>
                   
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                        <a href="index.jsp"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
                    </li>
                    <li>
                        <a href="ProduitWeb?action=listProduit"><i class="fa fa-fw fa-table"></i></i> GESTION DE STOCK</a>
                    </li>
                    <li>
                        <a href="ClientWeb?action=listClient"><i class="fa fa-fw fa-table"></i> GESTION DES CLIENTS</a>
                    </li>
                    <li>
                        <a href="VenteWeb?action=list_vente"><i class="fa fa-fw fa-table"></i> GESTION DES VENTS</a>
                    </li>
                   
                    <li>
                        <a href="LoginWeb?action=logout"><i class=""></i> DECONNEXION</a>
                    </li>


                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">
   <p><span><a href="VenteWeb?action=listvente">Liste des Ventes >></a></span></p>
            <div class="container-fluid">


    <form method="POST" action='VenteWeb' name="frmAddVente">
        Vente ID : <input class="form-control" type="text" readonly="readonly" name="venteid"
            value="<c:out value="${client.idVente}" />" /> <br /> 
        Produit : <select class="form-control" 
            type="choice" name="produit"
             > 
            <c:forEach items="${prod}" var="produit">
               
            <option value="<c:out value="${produit.idProd}"></c:out>" >
             <c:out value="${produit.libelleProd}" /> </option>
            </c:forEach>
            </select>
            <br /> 
        Client : <select class="form-control" 
            type="choice" name="cltvente"
            value="<c:out value="${client.cltVente}" />" > 
             <c:forEach items="${clt}" var="client">
               
               
            <option value="<c:out value="${client.clientid}"/>">
            <c:out value="${client.firstName}" />_<c:out value="${client.lastName}" /></option>
            </c:forEach>
            </select>
            <br /> 
         Quantité : <input class="form-control"  type="text" name="qtevente"
            value="<c:out value="${client.qtevente}" />" /> <br />  
            Date : <input
            type="text" name="dat" class="form-control"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${client.datevente}" />" /> <br /> 
      
     <input
            type="submit"  class="form-control" value="Submit" style="background-color:orange"/>
    </form>
</div>
            <!-- /.container-fluid -->
           <p><span></span></p>
           <p><span></span></p><p><span></span></p>
  <table border=1 class="table table-striped">
     <legend>Journale du ventes</legend>
        <thead>
            <tr>
                <th>#</th>
                <th>Date</th>    
                <th>Quantité</th>  
                <th>Prix Total/DH</th>  
                <th>Client</th>  
                <th>Produit</th>  
                <th> Quantité Stock</th> 
              
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${clients}" var="client">
                <tr>


                    <td><c:out value="${client.idVente}"/></td>
                    <td><c:out value="${client.datevente}" /></td>
                    <td><c:out value="${client.qteVente}" /></td>
                    <td><c:out value="${client.prod.prixProd *client.qteVente}" /></td>
                    <td><a href="ClientWeb?action=listClient"><c:out value="${client.clt.firstName}-${client.clt.lastName}" /></a></td>
                    <td><a href="ProduitWeb?action=listProduit"><c:out value="${client.prod.libelleProd}" /></a></td>
                 <td><c:out value="${client.prod.qteProd}" /></td>
                    </tr>
            </c:forEach>
        </tbody>
    </table>
 
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->


    <!-- Morris Charts JavaScript -->
    <script src="js/plugins/morris/raphael.min.js"></script>
    <script src="js/plugins/morris/morris.min.js"></script>
    <script src="js/plugins/morris/morris-data.js"></script>


</body>

</html>
        