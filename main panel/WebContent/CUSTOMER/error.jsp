<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>404</title>
<link href="https://fonts.googleapis.com/css?family=Montserrat:300,500" rel="stylesheet">
	 <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
 
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Manrope:wght@200&display=swap');

html,
body {
    height: 100%
}

body {
    display: grid;
    place-items: center;
    font-family: 'Manrope', sans-serif;
    background: linear-gradient(234deg, #0540f9, #1c1d21);
    background-size: 400% 400%;
    -webkit-animation: animbackground 18s ease infinite;
    -moz-animation: animbackground 18s ease infinite;
    animation: animbackground 18s ease infinite;
    color: #fff
}

@-webkit-keyframes animbackground {
    0% {
        background-position: 82% 0%
    }

    50% {
        background-position: 19% 100%
    }

    100% {
        background-position: 82% 0%
    }
}

@-moz-keyframes animbackground {
    0% {
        background-position: 82% 0%
    }

    50% {
        background-position: 19% 100%
    }

    100% {
        background-position: 82% 0%
    }
}

@keyframes animbackground {
    0% {
        background-position: 82% 0%
    }

    50% {
        background-position: 19% 100%
    }

    100% {
        background-position: 82% 0%
    }
}

.not-found {
    font-size: 186px;
    font-weight: 700
}

.send {
    color: #fff;
    background-color: #083ad6;
    border-color: #083ad6
}

.send:hover {
    color: #fff;
    background-color: #083ad6;
    border-color: #083ad6
}
</style>
</head>
<div class="container-fluid text-center">
    <div class="px-5 py-5">
        <h1 class="not-found">404</h1>
        <h3>We couldn't seem to find the page you are looking for!</h3>
        <div class="text-center mt-4 mb-5"> <button class="btn btn-success send px-3"><i class="fa fa-long-arrow-left mr-1"></i> Return to main page</button> </div>
    </div>
</div>
</html>