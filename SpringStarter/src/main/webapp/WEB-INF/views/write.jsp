<%@include file="header.jsp"%>
<body>
<div class="container">
		<div class="row">
		<div class="col-xs-1"></div>
			<div class="col-xs-10">
				<form action="/writing"method ="get">
					<input type="hidden" name="num" value="">
					<input type="text" name="name" class="form-control mt-4 mb-2"
						placeholder="Insert Name." required>
					<div class="form-group">
						<textarea class="form-control"rows="10" name="content"
						placeholder="Insert Content" required></textarea>
					</div>
						<button type="submit" class="btn btn-secondary mb-3">Submit</button>	
				</form>
		</div>
		<div class="col-xs-1"></div>
	</div>
	</div>
</body>
</html>