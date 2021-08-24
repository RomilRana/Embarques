<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <script type="text/javascript">
    jQuery(function($) {
     var path = window.location.href; // because the 'href' property of the DOM element is the absolute path

     var name = path.substring(path.indexOf("page="));
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
		<header class="clearfix" style="background-color: #183650 !important;">
			<div class="logo">
				<a href="index-2.html"><img src="resources/images/login.png"" alt="" height="100" width="250"></a>
			</div>

			<a class="elemadded responsive-link" href="#">Menu</a>

			<nav class="nav-menu" id="nav">
				<ul class="menu-list" style="border:3px solid black !important;">
					<li style="border-bottom:3px solid black !important;"><a class="active" href="HOME_CONTROL_TRANSPORTER">Home</a></li>
					<li style="border-bottom:3px solid black !important;"><a  href="HOME_CONTROL_TRANSPORTER?page=About">About</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="HOME_CONTROL_TRANSPORTER?page=Send_Quote">Send_Quote</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="HOME_CONTROL_TRANSPORTER?page=Add Package">Add Package</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="HOME_CONTROL_TRANSPORTER?page=View Profile">View Profile</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="HOME_CONTROL_TRANSPORTER?page=Contact">Contact</a></li>
					<li style="border-bottom:3px solid black !important;"><a href="HOME_CONTROL_TRANSPORTER?page=Register">Register</a></li>
					<li><a href="HOME_CONTROL_TRANSPORTER?page=Sign In">Sign In</a></li>
				</ul>
			</nav>
		</header>
		<!-- End Header -->