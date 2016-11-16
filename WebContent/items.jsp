<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="model.bean.User" %>
<!DOCTYPE html>
<html lang="it">
<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all">
<link href="css/style.css" rel="stylesheet" type="text/css"
	media="all">
<script src="js/jquery-3.1.1.js"></script>

    <title>BuyDream Homepage - You best E-Commerce</title>

    <!-- Bootstrap Core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/queryAllCategories.js"></script>
<script type="text/javascript" src="js/queryAllItems.js"></script>
<script type="text/javascript" src="js/getParameterFromURL.js"></script>
<script type="text/javascript">

var category = $.urlParams('cat');
$(document).ready(function(){
	getAllItems(category);
});
</script>

</head>

<body>

    <jsp:include page="navBar.jsp"></jsp:include>
	
    <!-- Page Content -->
    <div class="container">

        <div class="row">
          <div class="col-md-2">
				<h1 class="lead">Categorie</h1>
				<div class="list-group" id="listCategories">
					
				</div>
			</div>

            <div class="col-md-10">
                <!-- Section items -->
				<div class="row" id="myThumbnail">
					<h1>Ultimi Prodotti</h1>
				</div>
				<!-- /Section items -->
				
            </div>

        </div>

    </div>
    
    <!-- /.container -->

    <div class="containerFooter">

        <hr>

        <!-- Footer -->
        <footer class="container-fluid text-center">
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright by Rocco_Lorenzo &copy; 2016</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.containerFooter -->

</body>

</html>