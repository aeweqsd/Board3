<%@include file="header.jsp"%>
<title></title>
<body>
<div class="container-fluid">
      <div class="row">
 			<div class="col-xs-1"></div>
 				<div class="col-xs-10">
 					<div class="col-xs-12">
	        			<table class="table table-striped">
		        				<c:set var="board" value="${board}"/>
		        				<tr>
		        				<td>number ${board.idboard}</td></tr>
		        				<tr><td>name      ${board.name}</td></tr>
		        				<tr><td>content     ${board.content}</td></tr>
		        				<tr><td>writer    ${board.idmember}</td></tr>
								<tr><td>time  		${board.time}</td></tr>
								<tr><td>hit 		${board.hit}</td></tr>
						</table>
					</div>
					<div class="col-xs-12">
						<div id="comment"></div>
					
					</div>
				</div>
				<div class="col-xs-1"></div>
		</div>
</div>		
  			
	
</body>
<script>
$(document).ready(function(){
	alert();
}
	var idboard =${board.idboard};
	alert();
	$.ajax('/show_comment',{
		type:'post',
		data:{
			idboard:idboard
		},
	success:function(html){
		alert();
		$("#comment").html(html);
	},
	error:function(request,status,error){
		alert();
		
}
	

	
});

	
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>