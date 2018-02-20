<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>New Candidate Registration</title>

<!-- Bootstrap CSS CDN -->
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet" />
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/dcalendar.picker.css"
	rel="stylesheet" />
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css"
	rel="stylesheet" />
<!-- Our Custom CSS -->

<script
	src="<%=request.getContextPath()%>/resources/js/jquery-1.12.4.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/dcalendar.picker.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
<script type='text/javascript'>
	$(function() {
		//calendar call function
		$('.datepicker').dcalendar();
		$('.datepicker').dcalendarpicker();

		var max_fields = 10; //maximum input boxes allowed
		var x = 1; //initlal text box count

		$('#add')
				.click(
						function() {
							if (x < max_fields) { //max input box allowed
								x++; //text box increment
								$("#addblock")
										.before(
												'<div class="col-md-12 col-sm-12" id="deceased">	<a href="#" class="remove_field" title="Remove">X</a>	<div class="form-group col-md-3 col-sm-3">            <label for="name">Name*</label>            <input type="text" class="form-control input-sm" id="name" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="gender">Gender*</label>            <input type="text" class="form-control input-sm" id="gender" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="age">Age*</label>            <input type="text" class="form-control input-sm" id="age" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="DOB">Date of Birth or Exact Birth Year*</label>            <input type="text" class="form-control input-sm datepicker" id="DOB'+x+'" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="DOD">Date of Death or Exact Death Year*</label>             <input type="text" class="form-control input-sm datepicker" id="DOD'+x+'" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="mother">Deceased Person\'s Mother Name*</label>            <input type="text" class="form-control input-sm" id="mother" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">            <label for="father">Deceased Person\'s Father Name*</label>            <input type="text" class="form-control input-sm" id="father" placeholder="">        </div>	<div class="form-group col-md-3 col-sm-3">	    <label for="photo">Upload Photo*</label>	    <input type="file" id="photo">	    <p class="help-block">Please upload individual photo. Group photo is not acceptable.</p>	</div></div>');

								$('.datepicker').dcalendarpicker();
							} else {
								alert("Only 10 Names Allowed");
							}
						});
		$(document).on('click', '.remove_field', function(e) {
			e.preventDefault();
			$(this).parent('div').remove();
			x--;
		});

	});
</script>
</head>
<body>
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<c:url value="/technology/save" var="saveNewTechnology" />
	<c:url value="../home" var="homePage" />
	<div style="margin-right: 60px;margin-top: 10px;" align="right">
		<a href="<c:url value='${homePage}' />">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<c:url value='${logoutUrl}' />">Logout</a>
	</div>
	<div class="panel panel-primary" style="margin-left: 60px;margin-right: 60px;margin-top:10px;">
		<div class="panel-heading">
			<h3 class="panel-title">New Technology Details</h3>
		</div>
		<div class="panel-body">
			<form:form id="newSkillForm" method="post" action="${saveNewTechnology}"
				modelAttribute="skill">
				<div class="col-md-12 col-sm-12">
					<div class="form-group col-md-6 col-sm-6">
						<form:label for="name" path="name">Name * </form:label>
						<form:input type="text" class="form-control input-sm" id="name"
							placeholder="" path="name" />
					</div>
					<div class="form-group col-md-6 col-sm-6">
						<form:label for="description" path="description">Description *</form:label>
						<form:textarea class="form-control input-sm" id="description" rows="3"
							path="description"></form:textarea>
					</div>
					<div class="form-group col-md-6 col-sm-6">&nbsp;</div>
					<div class="form-group col-md-6 col-sm-6">
						<input type="submit" class="btn btn-primary" value="Submit" />
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>