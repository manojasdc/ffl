<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script src="admin/layout_file/js/changepassword.js"></script>

<div id="chnagepassworddiv">
	<div class="container mt-4">
		<div class="col-12">
			<div
				class="col-6 col-lg-4 mt-3 mb-3 w3-border w3-padding ws-lightgreen form-heading">
				<h5 class="m-0">Change Password</h5>
			</div>
		</div>
		<div
			class="container-fluid w3-border w3-round w3-padding  ws-grey mb-3 main-form">
			<div class="row">
				<form action="/AFMS/logout" method="post" id="logoutForm"></form>
				<label for="passid"><strong style="color: red;"> <b>1)
							Password should be a mix of alphabets, numerals and special
							characters ( $#^@\%_.~!*) without any space in between.</b><br>
						<b>2) Password must contain both upper and lowercase letters.</b><br>
						<b>3) Password length should be between 8 to 28 characters.</b></strong> </label>

			</div>
			<div class="row"></div>
			<div class="row">

				<div class="col-12 col-md-6">
					<input type="hidden" id="firsttimechange" name="firsttimechange"
						value="${firsttimechange}">
					<div class="mb-3">
						<label for="">User Name</label> <input type="text"
							class="form-control" id="name" placeholder="Please Enter Name"
							name="name" autocomplete="off" tabindex="1" readonly="readonly"
							value="${username}">
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">OLD Password <strong style="color: red;">*</strong></label>
						<input type="password" id="old_pass" name="old_pass"
							class="form-control" maxlength="28" autocomplete="off" required>
					</div>
				</div>

			</div>
			<div class="row">
				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">New Password <strong style="color: red;">*</strong></label>
						<input id="new_pass" type="password" maxlength="28"
							name="new_pass"
							pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%!^\\&_.~*]).{8,28}$"
							class="form-control" autocomplete="off"
							title="Must contain at least one number and one uppercase and lowercase letter and one special character and at least 8 or 28 characters"
							autocomplete="off" required>
					</div>
				</div>

				<div class="col-12 col-md-6">
					<div class="mb-3">
						<label for="">Confirm Password <strong style="color: red;">*</strong></label>
						<input id="c_password" type="password" maxlength="28"
							name="c_password"
							pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%!^\\&_.~*]).{8,28}$"
							class="form-control" autocomplete="off" required>
					</div>
				</div>

			</div>


			<div class="row m-0">
				<div
					class="col-12 mt-3 mb-3 w3-border w3-round w3-footer-padding ws-lightgreen text-center">
					<button type="button" class="btn btn-primary"
						onclick="return ChangePassword();" id="chnagepasswordbtn"
						name="chnagepasswordbtn">Change Password</button>
					<input type="reset" class="btn btn-success btn-sm" value="Clear"
						onclick="ResetInput();">

				</div>
			</div>

		</div>

	</div>

	<div class="container mt-3">
		<div class="table-wrapper">
			<table id="coursemastertbl"
				class="table no-margin table-striped table-hover table-bordered ">
				<thead>
					<tr>
						<th>No</th>
						<th>Institute Name</th>
						<th>Course Name</th>
						<th>Number of Seats</th>
						<th>Year</th>
						<th>Action</th>

					</tr>
				</thead>
				<tbody></tbody>

			</table>
		</div>
	</div>
</div>