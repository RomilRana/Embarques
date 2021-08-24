<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <script type="text/javascript">
    jQuery(function($) {
     var path = window.location.href; // because the 'href' property of the DOM element is the absolute path
     $('ul a').each(function() {
      if (this.href === path) {

          $('li a').removeClass("active");
       $(this).addClass('active');
      }
     });
    });
</script>
<!-- Header
		    ================================================== -->

		<header class="clearfix">
			<div class="logo">
				<a href="index-1.jsp"><img src="resources/images/logo_g.jpg" alt="" height="100" width="250" style="border-radius: 5%;"></a>
			</div>

			<a class="elemadded responsive-link" href="#">Menu</a>

			<nav class="nav-menu">
				<ul class="menu-list">
					<li><a class="active" href="index.jsp">Home</a></li>
					<li><a href="about.jsp">About</a></li>
					<li><a href="login.jsp">Get Quote</a></li>
					<li><a href="login.jsp">View Profile</a></li>
					<li><a href="login.jsp">Tracking</a></li>
					<li><a href="login.jsp">View Quote</a></li>
					<li><a href="contact.jsp">Contact</a></li>
					<li><a href="register.jsp">Register</a></li>
					<li><a href="login.jsp">Sign In</a></li>
				</ul>
			</nav>
		</header>
		<!-- End Header -->