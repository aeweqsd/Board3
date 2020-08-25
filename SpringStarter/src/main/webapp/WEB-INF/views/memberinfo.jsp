<%@include file="Link.jsp" %>
<body>
	<div class="container">
		<c:set var="info" value="${info}"/>
		<c:set var="is_login" value="${info.islogin}"/>
		<table class="table striped">
			<tr><td>Member info</td></tr>
			<tr><td>Member id   ${info.memberid}</td></tr>
			<tr><td>Member birthday ${info.birthday}</td></tr>
			<tr><td>Member name ${info.name}</td></tr>
			<tr><td>Member gender ${info.gender}</td></tr>
		
</table>
	
	
	</div>

</body>

</html>