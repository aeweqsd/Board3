<%@include file="Link.jsp" %>
<body>
	<div class="Container">
		<div class="row">
			<div class="col-xs-2"></div>
			<div class="col-xs-8">
				<div class="col-xs-12">
				 	<form id="Create_member" action="/Create_member" method='get'>
				 		<div class="col-xs-12">
					 		<label for="id">ID</label>
							<div class="form-group">
								<input type="text" placeholder="Email"name="id" id="id" class="form-control" required>				 	
					 		</div>
					 		<button type="button" class="btn btn-info" id="Check_overlap" >Check</button>
					 		<div id="check"></div>
					 	</div>
				 		<label for="password">Password</label>
				 		<div class="form-group">
				 			<input type="password" placeholder="Password" name="password" id="password"class="form-control"required>
				 		</div>
				 		<label for="check-password">check-password</label>
				 		<div class="form-group">
				 			<input type="password" placeholder="check_password" name="check_password" id="check-password" class="form-control"required>
				 		</div>
				 		<label for="name">Name</label>
				 		<div class="form-group">
				 			<input type="text" placeholder="name" name="name" id="name" class="form-control"required>
				 		</div>
				 		<label for="birthday">birthday</label>
					 		<div class="col-xs-12">
						 		<div class="form-group col-xs-4" id="birth">
						 			<input type="text" placeholder="year" name="birth_year" id="birth_year"class= "form-control"required>
						 		</div>
						 		<div class="form-group col-xs-3 col-xs-offset-1">
						 			<select class="form-control" id="birth_month" name="birth_month">
						 				<option>Month</option>
						 				<option>1</option>
						 				<option>2</option>
						 				<option>3</option>
						 				<option>4</option>
						 				<option>5</option>
						 				<option>6</option>
						 				<option>7</option>
						 				<option>8</option>
						 				<option>9</option>
						 				<option>10</option>
						 				<option>11</option>
						 				<option>12</option>
						 			</select>
						 		</div>
						 		<div class="form-group col-xs-3 col-xs-offset-1" id="birth">
						 			<input type="text" placeholder="day" name="birth_day" id="birth_day"class="form-control" required>
						 		</div>
					 		</div>
				 		<div class="col-xs-12">
					 		<label for="gender">gender</label>
					 		<div class="form-group">
					 			<select class="form-control"name="gender" id="gender">
					 				<option>Male</option>
					 				<option>Female</option>
					 			</select>
					 		</div>
				 		</div>
				 		<button type="button" id="Register_submit" class="btn btn-lg btn-primary btn-block">Submit</button>
				 	</form>
				</div>
			</div>
			<div class="col-xs-2"></div>
		</div>
	
	</div>

</body>
<script>
 $('#Register_submit').on('click',function(){
	
	var form = $(this);
	console.log(form.serialize());
	var id =$('#id').val();
	var password=$('#password').val();
	var check_pass=$('#check-password').val();
	var year=$('#birth_year').val();
	var month =$('#birth_month').val();
	var day=$('#birth_day').val();
	var regExpyear = /^(19|20)\d{2}$/;
    var regExpday = /^(0[1-9]|[12][0-9]|3[0-1])$/;
    var regExpmonth= /^(0?[1-9]|1[0-2])$/;
      if(password != check_pass){
        alert("plz check password")
         $('#check-password').val('');
        return;
    }
 	if(!regExpyear.test(year)){
         alert("Year");
         $('#birth_year').val('');
         return;
   }
   if(!regExpday.test(day)){
         alert("day");
         $('#birth_day').val('');
         return;
   }
   if(!regExpmonth.test(month)){
       alert("month");
       $('#birth_month').val('month');
       return;
 }  
    $('#Create_member').submit();
    

}); 
 $('#Check_overlap').on('click',function(){
	$('#check_info').remove();
	var id =$('#id').val();
	$.ajax('Check_overlap',{
		type:'get',
		dataType:"json",
		data:{
			id:id
			},
		success:function(msg){
			console.log(msg.overlap);
			if(!msg.overlap){
				$('#check').append('<div class="alert alert-success" id="check_info" role="alert">Possible</div>');
			}else{
				$('#check').append('<div class="alert alert-danger"id="check_info" role="alert">check id again</div>');
			}
			
		},
		error:function(request,status,error){
		}
			

		});



	 })

</script>