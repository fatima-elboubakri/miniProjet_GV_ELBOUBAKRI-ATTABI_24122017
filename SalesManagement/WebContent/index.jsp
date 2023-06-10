<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

        <%
        
        String nom =(String)session.getAttribute("name");
        if(nom==null){
        	response.getWriter().print("<script>alert('Sorry, vous devez connecter! ')</script>");
            request.getRequestDispatcher("login.jsp").include(request, response); 
        }
        else{
        	
        
        %>
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
body{
background-image:url('IMAGES/img_26.jpg');
}
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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>  ${name}<b class="caret"></b></a>
                   
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

            <div class="container-fluid">

        
                <h1>GESTION DES VENTES</h1> <BR>
              <h4></h4>  Application JEE reéalisé par :<BR><A>* FATIMA EL BOUBAKRI<br> * JAMILA ATTABI<BR>5eme Année NTIC</A> </h4><BR>
              <h6>UNIVERSITE PRIVEE DE MARRAKECH</H6>
         
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
<% 

        }
        %>
        