<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script src="../javascript/jquery-2.1.4.js"  type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>Register!</h1>
	<br />
	<br />
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js "></script>
	<script type="text/javascript">
	
          $(document).ready(function(){  
        //	  alert("ready");
        //	  if ($('input[name="username"]').length>0) {
      	//   	alert("exist");
      	//}else
      	//	{
      	//		alert("not exist");		
      	//	}
              $('input[name="username"]').on("change keyup paste",function(){
                  var username = $(this).val();  
                  if(username.length >= 3){  
                        
                       $.ajax({  
                          type: "POST",  
                          url: "/TestWebProject/CheckUsernameServlet",  
                          data: "username="+ username,  
                          success: function(msg){ 
                        	  	if(msg!=null && msg!="0")
                        		{
                        		  	document.getElementById("usernameMessage").innerHTML = msg;
                        		}
                        	  	else
                        		{
                        	  		document.getElementById("usernameMessage").innerHTML = msg;
                        		}
                              $(".status").ajaxComplete(function(event, request, settings){  
                                     
                                  $(".status").html(msg);
                              });  
                          }  
                      });   
                  }  
                  else{  
                         
                      $(".status").html("<font color=red>Username should be <b>3</b> character long.</font>");  
                  }  
                    
              });  
          });
          
   	</script>  
   	<font color="red"><label id="usernameMessage"></label></font>
	<font color="red">${errorMessage}</font>
	<form action="/TestWebProject/RegisterServlet" method="post">
		<span>Username:</span><input type="text" name="username"/>
		<br /> 
		<span>Fullname:</span><input type="text" name="fullname" />
		<br />
		<span>Email:</span><input type="text" name="email" />
		<br /> 
		<span>Password:</span><input type="password" name="password" />
		<br />
		<span>Confirm Password:</span><input type="password" name="confirmPassword" />
		<br />
		<input type="submit" value="Register" />
	</form>
</body>
</html>