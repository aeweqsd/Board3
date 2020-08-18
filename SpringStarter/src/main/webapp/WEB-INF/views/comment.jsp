<%@include file="header.jsp" %>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<c:forEach var="list" items="${list}">
					<table class="table table-striped">
					
						<tr><td>${list.content}</td></tr>
						<tr><td>${list.time} <p class="text-right">${list.idmember}</p></td></tr>
						<tr><td>	<button type ="button"class="btn btn-xs btn-default btn-idcomment" idcomment="${list.idcomment}"  >Show Command</button>
										<div id="${list.idcomment}"  style="display:none">
										<textarea class="form-control" rows="5" name="content" id="content" placeholder="Insert Comment" required></textarea>
										<button type="button" id="commit" class="btn btn-xs btn-success">Commit</button>
										</div>
						</td></tr>
					</table>
				</c:forEach>
			
			
			
			</div>
		</div>
	
	</div>
	
</body>
</html>