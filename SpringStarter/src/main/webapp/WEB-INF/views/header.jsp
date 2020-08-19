<%@include file="Link.jsp" %>
<body>
	<nav class="navbar navbar-inverse navbar-fixed top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" >Example Site</a>
			</div>
			<form class="navbar-form navbar-right" id="login">
            	<div class="form-group">
              		<input type="text" placeholder="Email" name="id" id='id' class="form-control">
            	</div>
            	<div class="form-group">
             		<input type="password" placeholder="Password"name="password" id='password' class="form-control">
            	</div>
           		<button type="submit" id="login_submit" class="btn btn-success">Sign in</button>
					<button type ="button" id="Register"class="btn btn-info">Join us!</a></button>
			</form>
			</div>
	</nav>

</body>
<Script>

$('#login').submit(function(e){
	alert();
	e.preventDefault();
	var form =$(this);
	var url = form.attr('login');
	console.log(form.serialize());
	console.log($('#id').val());
	console.log($('#password').val());

	
	$.ajax({
		type:"get",
		url:url,
		data: {id:$(this).attr('id'),
			   password:$(this).attr('password')},
		dataType: json,
		success:function(data){
			console.log(data);
		},
		error:function(request,status,error){
			console.log();
			
		}
	});

	
});
$(document).on('click',"#Register",function(){
	window.open("Register","Register","width=800,height=700 location=yes");

	
})
</Script>
