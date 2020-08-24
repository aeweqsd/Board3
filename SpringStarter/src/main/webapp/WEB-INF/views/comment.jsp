<%@include file="Link.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<c:forEach var="list" items="${list}">
					<c:set var="selfkey" value ="${list.selfkey}"/>
						<c:choose> 
							<c:when test="${selfkey !=0}" >
								<div class ="col-xs-11 col-xs-offset-1"></c:when>
							<c:otherwise>
								<div class ="col-xs-12"></c:otherwise>
						</c:choose>
					<table class="table table-striped">
					
						<tr><td>${list.content}</td></tr>
						<tr><td>${list.time} <p class="text-right">${list.idmember}</p></td></tr>
						<tr><td>	<button type ="button"class="btn btn-xs btn-default btn-idcomment" idcomment="${list.idcomment}"  >Show Command</button>
										<div id="${list.idcomment}"  style="display:none">
										<textarea class="form-control" rows="5" name="content" id="${list.idcomment}" placeholder="Insert Comment" required></textarea>
										<button type="button" idcomment="${list.idcomment}" id="commit-2" class="btn btn-xs btn-success btn-commit">Commit</button>
										</div>
						</td></tr>
					</table>
					</div>
				</c:forEach>
			
			
			
			</div>
		</div>
	
	</div>


	