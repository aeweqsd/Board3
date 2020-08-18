<%@include file="header.jsp"%>
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
					<div class ="col-xs-12">
						<div class="dropdown">
							<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">Command Comment</button>
								<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
									<li role="presentation" id="command_show"><a role="menuitem" tabindex ="-1">Show</a></li>
									<li role="presentation" id="command_disable"><a role="menuitem" tabindex ="-1">Disable</a></li>
								</ul>
						</div>
					</div>
					<div class="col-xs-12">
						<div id="insert_comment" style="display:none">
							<textarea class="form-control" rows="5" name="content" id="content" placeholder="Insert Comment" required></textarea>
							<button type="button" id="commit" class="btn btn-xs btn-success">Commit</button>
						</div>
					
					
					</div> 
					<div class="col-xs-12">
						<div id="comment"></div>
					
					</div>
				</div>
				<div class="col-xs-1"></div>
		</div>
</div>
<%@include file ="Footer.jsp"%>
  
<script>
$(document).ready(function(){


	var idboard =${board.idboard};
	$.ajax('/show_comment',{
		type:'get',
		data:{
			idboard:idboard
		},
	success:function(html){
		$("#comment").html(html);
	},
	error:function(request,status,error){
		
		
}
	
	

	
});
})
$(document).on('click', '.btn-idcomment', function () {
	var id = $(this).attr('idcomment');
	console.log($('#'+id).css('display'));
	$('#'+id).toggle();
	//$('#'+id).show(500);
	//$('#'+id).hide(500);
	
});
$(document).on('click','#command_show',function(){
	var con =document.getElementById('insert_comment');
	con.style.display="block";
});
$(document).on('click','#command_disable',function(){
	var con =document.getElementById('insert_comment');
	con.style.display="none";
});
</script>