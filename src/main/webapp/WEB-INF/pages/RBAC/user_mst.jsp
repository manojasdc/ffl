<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script src="js/JS_CSS/jquery-2.2.3.min.js"></script>
<link rel="stylesheet" href="js/autoComplate/autoComplate.css">
<link href="js/Calender/jquery-ui.css" rel="Stylesheet"></link>
<script src="js/Calender/jquery-ui.js" type="text/javascript"></script>
<link href="js/dropDown/select2.min.css" rel="Stylesheet"></link>
<script src="js/dropDown/select2.min.js" type="text/javascript"></script>
	<form:form name="user_mst" id="user_mst" action="user_mstAction" method='POST' modelAttribute="user_mstCMD">
<div class="container">
  <div class="card" >
     <div class="card-header"> <h5>User Master</h5></div> <!-- end of card-header -->
   		<div class="card-body card-block">
  		  <div class="row mb-3">
			<div class="col-md-2">
					<label for="text-input" >User Name  <strong style="color: red;">*</strong> </label> 
			</div>
			<div class="col-md-3">
					<input type="text" id="login_name" name="login_name" maxlength="70" class="form-control" autocomplete="off" required>
		   </div>
        </div>
  		<div class="row mb-3">
         	<div class="col-md-2">
           	  <label for="text-input" >User ID  <strong style="color: red;">*</strong> </label> 
         	</div>
         	<div class="col-md-3">
           	  <input type="text" id="user_name" name="user_name" maxlength="30" class="form-control" autocomplete="off" required>
		</div>
      </div>
      <div class="row mb-3">
         <div class="col-md-2">
           	 <label for="text-input" >ID No  <strong style="color: red;">*</strong> </label> 
         </div>
         <div class="col-md-3">
             <input type="text" id="army_no" name="army_no" maxlength="9"  onkeyup="this.value = this.value.toUpperCase();" placeholder="Ex. IC123456A" class="form-control" autocomplete="off" required>
		</div>
	</div>
    <div class="row mb-3">
       <div class="col-md-2">
           <label for="text-input" >Password  <strong style="color: red;">*</strong> </label> 
       </div>
        <div class="col-md-3">
           	<input id="user_password" type="password" maxlength="28" name="user_password"  class="form-control" autocomplete="off" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" >
	  </div>	 					
   </div>
    <div class="row mb-3"> 
         <div class="col-md-2">
           	<label for="text-input" >Re-Password <strong style="color: red;">*</strong> </label> 
         </div>
         <div class="col-md-3">
           	<input  id="user_re_password" type="password" maxlength="28"  name="user_re_password"   class="form-control" autocomplete="off" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" > <!--  -->
		</div>
    </div>
     <div class="row mb-3"> 
		<div class="col-md-2">
				<label for="text-input"  >Role <strong style="color: red;">*</strong> </label> 
		</div>
		<div class="col-md-3">
				<select name="user_role_id" id ="user_role_id" style="width: 100%;" class="select2 narrow wrap ">
					<option value="0">--Select--</option>
				<c:forEach var="item" items="${getRoleNameList}" varStatus="num" >
					<option value="${item.roleId}">${item.role}</option>
				</c:forEach>					                
      	</select>
	</div>
	</div>
		<div class="row mb-3">
         <label for="passid">
             <b>1) Password should be a mix of alphabets, numerals and special characters ($#^@%_.~!*) without any space in between.</b><br>
			<b>2) Password must contain both upper and lowercase letters.</b><br>
			<b>3) Password length should be between 8 to 28 characters.</b>
		</label>
	</div>	
</div> <!-- end of card-body -->

  		<div class="card-footer">
  	            <input type="reset" class="btn btn-success btn-sm" value="Clear" onclick="clearall();">    	
        		    <input type="submit" class="btn btn-primary btn-sm" value="Save" onclick="return isValid();">
        	</div> <!-- end of card-footer -->
         	
   	    <input id="access_lve" name="access_lve1" type="hidden" />
<input id="sub_access_lve" name="sub_access_lve1"  type="hidden" /> 		 	
<input id="formation_code" name="user_formation_no"  type="hidden"/>
 				
  </div> <!-- end of card -->
</div> <!-- end of container -->
	</form:form>
 
<script>
	function isValid()
	{	
		
		if($("#login_name").val()==""){
			alert("Please Enter User Name");
			$("#login_name").focus();
			return false;
		} 
		if($("#user_name").val()==""){
			alert("Please Enter User ID");
			$("#user_name").focus();
			return false;
		} 
		if($("#army_no").val()==""){
			alert("Please Enter Army No");
			$("#army_no").focus();
			return false;
		}
		if($("#user_password").val()==""){
			alert("Please Enter User Password");
			$("#user_password").focus();
			return false;
		} 
		if($("#user_password").val().length < 8 | $("#user_password").val().length > 28){
			alert("Please Enter Password at least 8 to 28 digit");
			$("#user_password").focus();
			return false;
		} 
		if($("#user_re_password").val()==""){
			alert("Please Enter User Re-Password");
			$("#user_re_password").focus();
			return false;
		} 
		if($("#user_re_password").val().length < 8 | $("#user_re_password").val().length > 28){
			alert("Please Enter Re-Password at least 8 to 28 digit");
			$("#user_re_password").focus();
			return false;
		}
		if($("select#user_role_id").val()=="0"){
			alert("Please Select Role Id");
			$("select#user_role_id").focus();
			return false;
		} 
		return true;
	} 

	$(document).ready(function () {
		$("input#login_name").val("");
		$("#user_name").val("");
		$("#army_no").val("");
		$("#user_password").val("");
		$("#user_re_password").val("");
		
		
	});	
</script>