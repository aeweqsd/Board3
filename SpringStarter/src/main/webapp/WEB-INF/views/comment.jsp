<%@include "header.jsp" %>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<c:forEach var="list" items="${list}">
					<table class="table table-striped">
					
						<tr><td>${list.content}</td></tr>
						<tr><td>${list.time} ${list.idmember}</td></tr>
				
				
					</table>
				</c:forEach>
			
			
			
			</div>
		</div>
	
	</div>
	
</body>
</html>