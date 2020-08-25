<%@include file="Link.jsp" %>
<body>
<c:set var="info" value="${info}"/>
<c:set var="sender" value="${sender}"/>
<div class="container">
	<div class="row">	
		<div class="col-sm-12">
			<form action="sending" method="get" class="form-horizontal">
				<div class="form-group">
					<input type="hidden" name="receiver" value="${info.memberid}">
					<input type="hidden" name="sender" value="${sender}">
					<label class="col-sm-2 control-label">Sender</label>
					<div class="col-sm-10">
						<p class="form-control-static">${sender}</p>
					</div>
					<label class="col-sm-2 control-label">RECEIVER</label>
					<div class="col-sm-10">
						<p class="form-control-static">${info.memberid}</p>
					</div>
					<label class="col-sm-2 control-label">Name</label>
					<div class="col-sm-10" >
						<input type="text" name= "name"class="form-control">
					</div>
					<label class="col-sm-2 control-label">Content</label>
					<textarea class="form-control"name="content" rows="3"></textarea>
					<button type="submit" class="btn btn-success">Send Message</button>
				</div>
			
			
			</form>
		</div>
	</div>
</div>
</body>
</html>