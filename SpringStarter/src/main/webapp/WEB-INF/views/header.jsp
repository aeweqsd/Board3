<%@include file="Link.jsp" %>
<body>
	<nav class="navbar navbar-inverse navbar-fixed top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" >Example Site</a>
			</div>
			<div id="log">
				<form class="navbar-form navbar-right" action="login" id="login">
	            	<div class="form-group">
	              		<input type="text" placeholder="Email" name="id" id='id' class="form-control" required>
	            	</div>
	            	<div class="form-group">
	             		<input type="password" placeholder="Password"name="password" id='password' class="form-control" required>
	            	</div>
	           		<button type="button" id="login_submit" class="btn btn-success">Sign in</button>
						<button type ="button" id="Register"class="btn btn-info">Join us!</button>
				</form>
				<div id="qwe" class="navbar-right" style="display:none">
					<p class="navbar-text" id="qwer">WELCOME!  </p>
					<button type="button" id="logout_submit" class="btn btn-default">Log_out</button>
					</div>
			</div>
			</div>
	</nav>

</body>
<Script>

$('#login_submit').on('click',function(e){
	e.preventDefault();
	var form =$(this);
	var id = $('#id').val();
	var password =$('#password').val();
	$.ajax('login',{
		type:"get",
		dataType: "json",
		data: {id: id,
			   password: password
		},
		success:function(data){
			if(data.idmember){
				$('#login').css('display','none');
				$('#qwe').css('display','block');
				$('#qwer').append(data.name);
				
			}
		},
		error:function(request,status,error){
			console.log();
			
		}
	});
});
$('#logout_submit').on('click', function(){
	$('#qwer').remove();
	$('#qwe').css('display','none');
	$('#login').css('display','block');
	$('#id').val('');
	$('#password').val('');
});
$(document).on('click',"#Register",function(){
	window.open("Register","Register","width=800,height=700 location=yes");

	
})
</Script>
