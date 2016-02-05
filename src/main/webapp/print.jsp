<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
	<head>
	<title>print</title>
	<link href="css/bootstrap.css" type="text/css" rel="stylesheet" media="all">
	<link href="css/style.css" type="text/css" rel="stylesheet" media="all">
	<!--web-font-->
	<link href='http://fonts.useso.com/css?family=Marvel:400,400italic,700,700italic' rel='stylesheet' type='text/css'>
	<link href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	<!--//web-font-->
	<!-- Custom Theme files -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Plot Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
		Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<!-- //Custom Theme files -->
	<!-- js -->
	<script src="js/jquery-1.11.1.min.js"></script> 
	<!-- //js -->	
	<!-- start-smoth-scrolling-->
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>	
	<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
	</script>
	<!--//end-smoth-scrolling-->
	</head>
	<body>  
		 
		<div class="container-fluid">
		<div class="row">
			<!--side-bar-->
			<div class="col-sm-3 col-md-2 sidebar">
				<div class="logo">
					<a href="index.html"><img src="images/logo.png" alt="logo"/></a>
				</div>
				<div class="top-nav">
					<span class="menu-icon"><img src="images/menu-icon.png" alt=""/></span>	
					<div class="nav1">
						<ul class=" nav nav-sidebar">
							<li><a href="main.jsp">主页测试</a></li>
 							<li><a href="backend.jsp">后台测试</a></li>
							<li><a href="mongoDB.jsp">mongoDB测试</a></li>
							<li><a href="fileUpLoad.jsp">文件 上传测试</a></li>
							<li><a href="print.jsp">pdf测试</a></li>
<!--							<li><a href="gallery.html">Gallery</a></li>
							<li><a href="testmonials.html">Testmonials</a></li>
							<li><a href="contact.html">Contact</a></li> -->
						</ul> 
						<div class="social-icons">
							<ul>
<!-- 								<li><a href="#"></a></li>
								<li><a href="#" class="fb"></a></li>
								<li><a href="#" class="be"></a></li>
								<li><a href="#" class="gg"></a></li> -->
							</ul>	
						</div>						
					</div>	
					<!-- script-for-menu -->
						 <script>
						   $( "span.menu-icon" ).click(function() {
							 $( ".nav1" ).slideToggle( 300, function() {
							 // Animation complete.
							  });
							 });
						</script>
						<!-- /script-for-menu -->
				</div>
				<div class="clearfix"> </div>				
				<p>lockTP的Self-Site</p>
			</div>
			<!--//side-bar-->
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h2>letter</h2>  
				<form role="form" method="get" action="<%=request.getContextPath() %>/print/printByInput.do">  
				你的姓名:<input type="text" class="form-control" name="from" id="from">
				<br>
				<textarea name="content" id="content" style="width:1000px;height:100px;">请在这里输入内容</textarea>  
				<br>
				<br>
				对方的姓名:<input type="text" class="form-control" name="to" id="to">  
				<input type="submit" class="btn btn-default" value="确定">  		
				</form> 
			</div>
			
			
			<div class="clearfix"> </div>
		</div>	
	</div>	
    <script src="js/bootstrap.js"> </script>
	</body>  
</html>  