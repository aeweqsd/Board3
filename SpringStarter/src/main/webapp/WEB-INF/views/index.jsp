<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
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
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-xs-1"></div>
				<div class="col-xs-10">
						<div class="col-xs-12">
							<table class="table table-striped">
								<tr>
									<th>number</th>
									<th>name</th>
									<th>content</th>
									<th>hit</th>
									<th>time</th>
									<th>idmember</th>
									
								</tr>
								<c:forEach var="list" items="${list}">
									<tr>
										<td>${list.rnum}</td>
										<td>${list.name}</td>
										<td>${list.content}</td>
										<td>${list.hit}</td>
										<td>${list.time}</td>
										<td>${list.idmember}</td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<div class="col-xs-12">
						<p class= "paging text-center"></p>
						</div>
				</div>
			<div class="col-xs-1"></div>
			
		</div>
	</div>
	
</body>
</html>
<script>
//$(document).ready(function(){
//	var maxnum = ${maxnum};
//	if(maxnum%5 !=0){
//		maxnum=maxnum+1;
//	}else{
//	}
//	$(#paging).
//	
//	
//	
//});
	



</script>
