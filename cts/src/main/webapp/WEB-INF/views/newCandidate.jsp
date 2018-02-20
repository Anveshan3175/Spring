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
<script src="<%=request.getContextPath()%>/resources/js/multiselect.js"></script>
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
	
	jQuery(document).ready(function($) {
    $('#lstview').multiselect({
        search: {
            left: '<input type="text" name="q" class="form-control" placeholder="Search..." />',
            right: '<input type="text" name="q" class="form-control" placeholder="Search..." />',
        }
    });
});
</script>
</head>
<body>
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<c:url value="/candidate/submit" var="submitNewCandidate" />
	<c:url value="../home" var="homePage" />
	<div style="margin-right: 60px;margin-top: 10px;" align="right">
		<a href="<c:url value='${homePage}' />">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="<c:url value='${logoutUrl}' />">Logout</a>
	</div>
	<div class="panel panel-primary" style="margin-left: 60px;margin-right: 60px;margin-top:10px;">
	<font color="red"> <form:errors path="candidate.*" />
		<c:if test="${not empty errMsg}">
            ${errMsg}
        </c:if>
       </font>
		<div class="panel-heading">
			<h3 class="panel-title">New Candidate Details</h3>
		</div>
		<div class="panel-body" style="background: #fafafa;">
			<form:form id="newCandidateForm" method="post" action="${submitNewCandidate}"
				modelAttribute="candidate">
				<div class="form-group col-md-12 col-sm-12">
					<div class="form-group col-md-6 col-sm-6">
						<form:label for="name" path="name">Name * </form:label>
						<form:input type="text" class="form-control input-sm" id="name"
							placeholder="" path="name" />
					</div>
					<div class="form-group col-md-6 col-sm-6">
						<form:label for="email" path="email">Email *</form:label>
						<form:input type="email" class="form-control input-sm" id="email"
							placeholder="" path="email" />
					</div>

					<div class="form-group col-md-6 col-sm-6">
						<form:label for="mobile" path="mobile">Mobile *</form:label>
						<form:input type="text" class="form-control input-sm" id="mobile"
							placeholder="" path="mobile" />
					</div>

					<div class="form-group col-md-6 col-sm-6">
						<form:label for="address" path="experience">Relevant  Experience</form:label>
						<form:input type="text" class="form-control input-sm"
							id="experience" placeholder="" path="experience" />
					</div>

					<div class="form-group col-md-6 col-sm-6">
						<form:label for="city" path="city">City *</form:label>
						<form:input type="text" class="form-control input-sm" id="city" 
							placeholder="" path="city" />
					</div>

					<div class="form-group col-md-6 col-sm-6">
						<form:label for="currentCompany" path="currentCompany">Current  Company</form:label>
						<form:input type="text" class="form-control input-sm"
							id="currentCompany" placeholder="" path="currentCompany" />
					</div>
					<div class="form-group col-md-6 col-sm-6">
						<form:label for="noticePeriod" path="noticePeriod">Notice Period (in months)</form:label>
						<form:input type="text" class="form-control input-sm"
							id="noticePeriod" placeholder="" path="noticePeriod" />
					</div>
					<div class="form-group col-md-6 col-sm-6">
						<label for="resume">Resume *</label> 
						<input type="file" id="resume">
					</div>
				</div>
				<div class="form-group col-md-7 col-sm-7">
					<label for="resume">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Candidate Primary Skills *</label>
				</div>
				<div class="form-group col-md-6 col-sm-6">	
							<div class="col-xs-4">
								<form:select multiple="true" name="from[]" id="lstview" class="form-control" size="8" path="allSkills">
										<form:options items="${candidate.allSkills}" itemValue="id" itemLabel="name"/>
										</form:select>
							</div>
							<div class="col-xs-2">
										<button type="button" id="lstview_undo" class="btn btn-primary btn-block">undo</button>
										<button type="button" id="lstview_rightAll" class="btn btn-default btn-block"><i class="glyphicon glyphicon-forward"></i></button>
										<button type="button" id="lstview_rightSelected" class="btn btn-default btn-block"><i class="glyphicon glyphicon-chevron-right"></i></button>
										<button type="button" id="lstview_leftSelected" class="btn btn-default btn-block"><i class="glyphicon glyphicon-chevron-left"></i></button>
										<button type="button" id="lstview_leftAll" class="btn btn-default btn-block"><i class="glyphicon glyphicon-backward"></i></button>
										<button type="button" id="lstview_redo" class="btn btn-primary btn-block">redo</button>
							</div>
							<div class="col-xs-4">
										<form:select multiple="true" to="from[]" id="lstview_to" class="form-control" size="8" path="selectedSkills">
										<form:options items="${candidate.selectedSkills}" itemValue="id" itemLabel="name"/>
										</form:select>
							</div>
				</div>
				<div class="form-group col-md-6 col-sm-6">&nbsp;</div>
					<div class="form-group col-md-6 col-sm-6">
					<input type="submit" class="btn btn-primary" value="Submit" />
				</div>
					

				
			</form:form>
		</div>
	</div>
</body>
</html>