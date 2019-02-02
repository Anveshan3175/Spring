<!doctype html>
<html lang="en">

	<head>
		 <!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
		<!-- Bootstrap core CSS -->
		<link type="text/css"
			href="<%=request.getContextPath()%>/resources/css/bootstrap/bootstrap.min.css"
			rel="stylesheet" />
	
		<title>Take Interview</title>
		
		<style>
			.header-name div {
			display: inline-block;
			height: auto;
		  }
		</style>
	</head>
	<body>
		
		<div class="container">
			<div class="header-name">
				<div><h3>Hello Anveshan</h3> </div> <div style="float: right;"><h6>Date : 01-Jan-2019</h6></div>
			</div>
			<form action="/action_page.php">
				<div class="form-group">
					<label for="yourself">Tell me about yourself</label>
					<textarea class="form-control" rows="2" id="selfDesc" id="selfDesc" placeholder="Tell me about yourself" ></textarea>
				</div>
				<div class="form-group" >
					<h4 align="center" >Questions Asked</h4>
				</div>
				<div class="form-group">
					<label for="yourself">What is OOPs </label>
					<textarea class="form-control" rows="2" id="selfDesc" id="selfDesc" placeholder="What is OOPs" >
					Sorry I don't know</textarea>
				</div>
				<div class="form-group">
					<label for="yourself">What are access class modifiers in Java </label>
					<textarea class="form-control" rows="2" id="selfDesc" id="selfDesc" placeholder="What are access modifiers in Java" >
					Public and default
					</textarea>
				</div>
				
					<label for="MoreQuestions">Ask More Questions</label>
				<div class="form-group">
					<a href="<%=request.getContextPath()%>/spr/javaQuestions">Get Java Questions</a>
				</div>
				<div class="form-group">
					<a href="J2eeQuestions.html">Get J2EE Questions</a>
				</div>
				<div class="form-group">
					<a href="SpringQuestions.html">Get Spring Questions</a>
				</div>
				<div class="form-group">
					<a href="HibernateQuestions.html">Get Hibernate Questions</a>
				</div>
				<div class="form-group">
					<a href="AlgorithamicQuestions.html">Get Algorithmic Questions</a>
				</div>
				<div class="form-group">
					<label for="email">Review of interviewer</label>
					<textarea class="form-control" rows="2" id="selfDesc" id="selfDesc" placeholder="Review of interviewer" ></textarea>
				</div>				
				<div class="form-group dropdown">
					<label for="result">Result</label>
					<input type="text" class="form-control" id="result" aria-describedby="emailHelp" placeholder="Result">
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</form>
		</div>
			
		<script src="<%=request.getContextPath()%>/resources/js/bootstrap/jquery-3.3.1.slim.min.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/bootstrap/popper.min.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap.min.js"></script>
	</body>

</html>