<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<meta charset="EUC-KR">
<Style>
[class*="col-"] {
  padding-top: 15px;
  padding-bottom: 15px;
   background-color: #eee;  
   background-color: rgba(86,61,124,.15); 
     border: 1px solid #ddd; 
   border: 1px solid rgba(86,61,124,.2); 
}


</Style>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" >Example Site</a>
			</div>
			<form class="navbar-form navbar-right" id="login">
            	<div class="form-group">
              		<input type="text" placeholder="Email" name="id" class="form-control">
            	</div>
            	<div class="form-group">
             		<input type="password" placeholder="Password"name="password" class="form-control">
            	</div>
           		<button type="submit" id="login_submit" class="btn btn-success">Sign in</button>
			</form>
			</div>
	</nav>

</body>