<%@include file="header.jsp"%>
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
										<td><a href="/boardsee?boardnumber=${list.idboard}">${list.name}</a></td>
										<td>${list.content}</td>
										<td>${list.hit}</td>
										<td>${list.time}</td>
										<td>${list.idmember}</td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<div class="col-xs-12 text-center">
								<c:forEach var="pagenum" begin="1" end="${pagenumber}">
								<a href="/board?pagenum=${pagenum}"><c:out value="${pagenum}" /></a>
								</c:forEach>
						</div>
						<div class="col-xs-12">
								<p class="text-right"><a href="/write">Write</a></p>
						</div>
						
						
				</div>
			<div class="col-xs-1"></div>
			
		</div>
	</div>
	
</body>
</html>
