<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
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
							<li><a href="fileUpLoad.jsp">文件上传测试</a></li>
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
				<!--banner-->
				<div class="banner">
					<div class="jumbotron banner-text">
						<h2>lockTP</h2>
						<p>这只是一个用来娱乐玩耍的网站</p>
						<a class="btn btn-primary" href="#" role="button">更多信息</a>
					</div>
				</div>
				<!--//banner-->
				<!--main-text-->
				<div class="main-text">
					<div class="welcome">
						<h3>传说中的午餐</h3>
						<div class="col-md-4 welcome-left">
							<img src="images/myPic/Legendary_lunch.jpg" alt="">
						</div>
						<div class="col-md-8 welcome-right">
							<h4>这个来源于暗黑破坏神</h4>
						</div>
						<div class="clearfix"> </div>
					</div>			
					<!--features-->
					<div class="features">
						<div class="col-md-6 feature-right">
							<h3>扩充列表</h3>
							<ul class="menu">
								<li class="item1"><a href="#">爱心<span class="icon"> </span></a>
									<ul>
										<li class="subitem1"><a href="love.html">love</a></li>										
									</ul>
								</li>
								<li class="item2"><a href="#">气泡<span class="icon"> </span></a>
									<ul>
										<li class="subitem1"><a href="bubble.html">bubble</a></li>
									</ul>
								</li>
								<li class="item2"><a href="#">字体<span class="icon"> </span></a>
									<ul>
										<li class="subitem1"><a href="wordblow.html">wordblow</a></li>
									</ul>
								</li>
							</ul>
						</div>						
						<div class="clearfix"> </div>
						<!-- script for tabs -->
						<script type="text/javascript">
							$(function() {
							
								var menu_ul = $('.menu > li > ul'),
									   menu_a  = $('.menu > li > a');
								
								menu_ul.hide();
							
								menu_a.click(function(e) {
									e.preventDefault();
									if(!$(this).hasClass('active')) {
										menu_a.removeClass('active');
										menu_ul.filter(':visible').slideUp('normal');
										$(this).addClass('active').next().stop(true,true).slideDown('normal');
									} else {
										$(this).removeClass('active');
										$(this).next().stop(true,true).slideUp('normal');
									}
								});
							
							});
						</script>
						<!-- script for tabs -->
					</div>
					<!--features-->
				</div>
				<div class="footer">
					<p>lockTP的Self-Site</p>
				</div>
			</div>
			<div class="clearfix"> </div>
		</div>	
	</div>	
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/bootstrap.js"> </script>
</body>
</html>