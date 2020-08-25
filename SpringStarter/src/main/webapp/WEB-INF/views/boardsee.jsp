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
		        				<tr><td>writer   <a href="#" id="showbox" class="showclass"> ${board.idmember}</a></td></tr>
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
<div class="dropdown" style="display:none" id="show">
	<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown"aria-expanded="true">
		show</button>
			<ul class="dropdown-menu"role="menu"  aria-labelledby="dropdownMenu2">
				<li role="presentation"><a role="menuitem" tabindex="-1" id="Memberinfo">MemberInfo</a></li>
				<li role="presentation"><a role="menuitem" tabindex="-1" id="Send_Message">send a message</a></li>
			</ul>
</div>
<%@include file ="Footer.jsp"%>
  
<script>
$('#Memberinfo').on('click',function(){
	var idmember =${board.idmember};
	window.open('memberinfo?idmember='+idmember,'memberinfo',"width=800 height=600");
});

$('#Send_Message').on('click',function(){
	var receiver = ${board.idmember};
	var sender = '${user}';
	window.open('SendMessage?receiver='+receiver+'&&sender='+sender,'SendMessage',"width=800 height=600");	
});

$(document).on('click', '.showclass', function (event) {
	var cursorX = event.clientX;
	var cursorY = event.clientY;

	var a = document.getElementById('show');
	a.style.display ='block';
	a.style.position = "absolute";
	a.style.left=cursorX+'px';
	a.style.top=cursorY+'px';
});

 $(document).on('click', 'body', function (event) {
	if(!($(event.target).hasClass('showclass'))) {
		var cursorX = event.clientX;
		var cursorY = event.clientY;
		console.log(cursorX);
		console.log(cursorY);
		var a = document.getElementById('show');
		a.style.display ='none';
		a.style.position = "absolute";
		a.style.left=cursorX+'px';
		a.style.top=cursorY+'px';
	}
});
 

/* document.addEventListener('click',function(){
document.addEventListener('mousemove', show, false);
function show(event){
	
	var cursorX = event.clientX;
	var cursorY = event.clientY;
	console.log(cursorX);
	console.log(cursorY);
	var a = document.getElementById('show');
	a.style.display ='block';
	a.style.position = "absolute";
	a.style.left=cursorX+'px';
	a.style.top=cursorY+'px';
}
}); */
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
});
$('#commit').on('click',function(e){
	var content =$('#content').val();
	var id = ${board.idboard};
	var writer = '${user}';
	$.ajax('insert_comment',{
		type:"get",
		dataType: "html",
		data: {id: id,
			   writer:writer,
			   content:content
		},
		success:function(html){
			$("#comment").html(html);
			$('#content').val('');
			alert("Complete!")
		},
		error:function(request,status,error){
			console.log();
			
		}
	});
})

$(document).on('click','.btn-commit',function(){
	var idcomment= $(this).attr('idcomment');
	var content =$('#'+idcomment+'>textarea').val();
	console.log(content);
	var id = ${board.idboard};
	var writer = '${user}';
	var selfkey = $('.btn-commit').attr('idcomment');
	$.ajax('insert_comment',{
		type:"get",
		dataType: "html",
		data: {id: id,
			   writer: writer,
			   content: content,
			   selfkey : selfkey
		},
		success:function(html){
			$("#comment").html(html);
			$('#'+idcomment+'>textarea').val('');
			alert("Complete2!")
		},
		error:function(request,status,error){
			console.log();
			
		}
	});
})

$(document).on('click', '.btn-idcomment', function () {
	var id = $(this).attr('idcomment');
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