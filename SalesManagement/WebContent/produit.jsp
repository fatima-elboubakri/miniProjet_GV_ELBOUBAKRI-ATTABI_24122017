<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="fr">

<head>

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
   <p><span><a href="ProduitWeb?action=listProduit">List clients >></a></span></p>
            <div class="container-fluid">


    <form method="POST" action='ProduitWeb' name="frmAddProduit" enctype="multipart/form-data">
        Produit ID : <input class="form-control" type="text" readonly="readonly" name="clientid"
            value="<c:out value="${client.idProd}" />" /> <br /> 
        Libelle : <input class="form-control" 
            type="text" name="libelle"
            value="<c:out value="${client.libelleProd}" />" /> <br /> 
        Category : <input class="form-control" 
            type="text" name="category"
            value="<c:out value="${client.catProd}" />" /> <br /> 
         Qantité : <input class="form-control"  type="text" name="qte"
            value="<c:out value="${client.qteProd}" />" /> <br />  
       Prix unitaire : <input class="form-control"  type="text" name="prix"
            value="<c:out value="${client.prixProd}" />" /> <br />
         Image :   <input type="file" class="form-control"  name="image" value="<c:out value="${client.file}" />" /><br />
            <input
            type="submit"  class="form-control" value="Submit" style="color:red"/>
    </form>
</div>
            <!-- /.container-fluid -->

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
        