<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
	
<!DOCTYPE html>
<html class="no-js ajax-content" lang="en">
<head>
  <meta charset="utf-8">
  <title>Better Rating - jQuery Rating System</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <!--demo styles-->
  <link href="resources/gs/css/reset.css" rel="stylesheet" type="text/css" media="screen" />
  <link href="resources/gs/css/styles.css" rel="stylesheet" type="text/css" media="screen" />
  <link href="resources/gs/css/responsive.css" rel="stylesheet" type="text/css" media="screen" />
<link href="https://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
  <!--plugin styles-->
  <link href="resources/gs/css/better-rating.css" rel="stylesheet" type="text/css" media="screen" />

  <!--External fonts-->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
  <style>
  body { background-color: #fafafa; }
</style>
</head>

<body style="background-color: #ccccff !important;">
  <div id="jquery-script-menu">
<div class="jquery-script-center">

<div class="jquery-script-ads"><script type="text/javascript"><!--
google_ad_client = "ca-pub-2783044520727903";
/* jQuery_demo */
google_ad_slot = "2780937993";
google_ad_width = 728;
google_ad_height = 90;
//-->
</script>
<script type="text/javascript"
src="https://pagead2.googlesyndication.com/pagead/show_ads.js">
</script></div>
<div class="jquery-script-clear"></div>
</div>
</div>
  <h1 style="margin:150px auto 30px auto; text-align:center;">GIVE FEEDBACK AND RATING</h1>
  <!-- ... End Header -->
  <section id="demo-left">
      <div class="better-rating">
          <ul id="better-rating-list">
              <li>
                <div class="profile-rating-wrapper">
                <div class="profile-pic">
                    <img src="resources/gs/images/profile_pic.png" alt="" />
                  </div>
                  <div class="name">Malith Wrote:</div>
                  <div class="rating">
                    <i class="fa fa-star selected" data-rate="1"></i>
                    <i class="fa fa-star selected" data-rate="2"></i>
                    <i class="fa fa-star selected" data-rate="3"></i>
                    <i class="fa fa-star" data-rate="4"></i>
                    <i class="fa fa-star" data-rate="5"></i>
                  </div>
                  </div>
                  <div class="content">
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed vitae mi quis tortor convallis dignissim sit amet et nisi. Integer molestie sed tortor ut accumsan. Curabitur in est dignissim turpis lacinia suscipit vehicula vitae felis. Class aptent.
                    </p>
                  </div>
              </li>

          </ul>
      </div>
  </section>
  <section id="demo-right">
    <form action="#" method="get" id="better-rating-form">
      <input type="text" name="name" placeholder="Your Name" id="" required>
      <div class="rating">
        <i class="fa fa-star" data-rate="1"></i>
        <i class="fa fa-star" data-rate="2"></i>
        <i class="fa fa-star" data-rate="3"></i>
        <i class="fa fa-star" data-rate="4"></i>
        <i class="fa fa-star" data-rate="5"></i>
        <input type="hidden" id="rating-count" name="rating" value="0">
      </div>
      <textarea name="rate" id="" cols="30" rows="10" required></textarea>
      <button type="submit">Submit</button>
    </form>
  </section>
<!--  Javascript plugins -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="resources/gs/js/better-rating.js"></script>
<!--  local Javascript file -->
  <script src="resources/gs/js/main.js"></script>
</body>
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
</html>
