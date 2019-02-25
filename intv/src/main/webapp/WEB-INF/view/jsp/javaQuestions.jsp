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
	
		<title>Java Questions</title>
		
		<style>
			.header-name div {
			display: inline-block;
			height: auto;
		  }
		</style>
		
		<script language="javascript">
			function showQuestionLink(id){
			var indexPOsition = id.indexOf('link');
			var idName = id.substr(0, indexPOsition);
				if('Show Answer' == document.getElementById(id).text){
					document.getElementById(id).text = 'Hide Answer';
					document.getElementById(idName).style.display = "inline";
				}
				else {
					document.getElementById(id).text = 'Show Answer';
					document.getElementById(idName).style.display = "none";
				}
			}
			
			/*function createQuestion(){
			 //var formDiv = document.getElementById('javaQuestionsForm').innerHTML ;
			 var formDiv = document.getElementById('javaQuestionsForm');
			 var divtest = document.createElement("div");
			 var buildDiv = '<br/><div class="form-group"> HI There <input class="form-check-input" type="checkbox" name="remember"></div>';
			 divtest.innerHTML = buildDiv;
			 //formDiv.appendChild(divtest);
			 formDiv.appendChild(divtest);
			} */
			
			function createJavaQuestion(){
				document.getElementById("newJavaQuestion").style.display = "inline";
				document.getElementById("newJavaAnswer").style.display = "inline";
				document.getElementById("newJavaAnswerSubmit").style.display = "inline";
				document.getElementById("newJavaAnswerDiscard").style.display = "inline";
				
			}
			
			function submitJavaQuestion(){
				
				document.getElementById("newJavaQuestion").value = "";
				document.getElementById("newJavaAnswer").value = "";
				
				document.getElementById("newJavaQuestion").style.display = "none";
				document.getElementById("newJavaAnswer").style.display = "none";
				document.getElementById("newJavaAnswerSubmit").style.display = "none";
				document.getElementById("newJavaAnswerDiscard").style.display = "none";
				
			}
			
			function discardJavaQuestion(){
				
				document.getElementById("newJavaQuestion").value = "";
				document.getElementById("newJavaAnswer").value = "";
				
				document.getElementById("newJavaQuestion").style.display = "none";
				document.getElementById("newJavaAnswer").style.display = "none";
				document.getElementById("newJavaAnswerSubmit").style.display = "none";
				document.getElementById("newJavaAnswerDiscard").style.display = "none";
			}
			
			function addSelectedQuestions(){
				var tab = document.getElementById ( "javaQuestionsForm" ); 
				var elems = tab.getElementsByTagName ( "input" );
				for ( var i = 0; i < elems.length; i++ )
				{
					if ( elems[i].type == "checkbox" )
					{
						if ( elems[i].checked ==true)
						alert(elems[i].id +" This is cheked");
						//collect in array
					}	
				}
			}		
		</script>
	</head>
	<body>
		
		<div class="container">
			<form id = 'javaQuestionsForm' name = 'javaQuestionsForm' action="/action_page.php">
				<div >
					<div><h3>Select Java Questions </h3> </div> 
				</div>
				<br/>
				<div class="form-group">
					<input class="form-check-input" type="checkbox" id = "quest1Check" name="remember">
					<label for="quest1">What is Java portability ?</label>
					<a href="#" id = "quest1link" onClick='showQuestionLink(this.id)'>Show Answer</a>
					<textarea class="form-control" rows="2" id="quest1"  placeholder="What is Java portability" style='resize:vertical; display:none' ></textarea>
				</div>
				<div class="form-group">
					<input class="form-check-input" type="checkbox" id = "quest2Check" name="remember">
					<label for="quest2">What are Java exceptions ?</label>
					<a href="#" id = "quest2link" onClick='showQuestionLink(this.id)'>Show Answer</a>
					<textarea class="form-control" rows="2" id="quest2"  placeholder="What are Java exceptions" style='resize:vertical; display:none' ></textarea>
				</div>
				<div class="form-group">
					<input class="form-check-input" type="checkbox" id = "quest3Check" name="remember">
					<label for="quest3">What is polymorphism ?</label>
					<a href="#" id = "quest3link" onClick='showQuestionLink(this.id)'>Show Answer</a>
					<textarea class="form-control" rows="2" id="quest3"  placeholder="What is polymorphism" style='resize:vertical; display:none' ></textarea>
				</div>
				
				<br/>
				<a href="#" id = "createQuestion" onClick='createJavaQuestion()'>Create New Question</a>
				<div class="form-group" id="newJavaQuestionDiv">
					<textarea class="form-control" rows="1" id="newJavaQuestion"  placeholder="Enter Question" style='resize:vertical; display:none' ></textarea>
					<br></br>
					<textarea class="form-control" rows="2" id="newJavaAnswer"  placeholder="Enter Answer" style='resize:vertical; display:none' ></textarea>
					<br></br>
					<button type="submit" class="btn btn-secondary" id="newJavaAnswerSubmit" style='resize:vertical; display:none' onClick='submitJavaQuestion()'>Submit Question</button>
					<button type="submit" class="btn btn-secondary" id="newJavaAnswerDiscard" style='resize:vertical; display:none' onClick='discardJavaQuestion()'>Discard Question</button>
				</div>
	
				<div class="form-group">
					<button type="submit" class="btn btn-primary" onClick='addSelectedQuestions()'>Add selected Questions</button>
				</div>
			</form>
		</div>
		
		<script src="<%=request.getContextPath()%>/resources/js/bootstrap/jquery-3.3.1.slim.min.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/bootstrap/popper.min.js"></script>
		<script src="<%=request.getContextPath()%>/resources/js/bootstrap/bootstrap.min.js"></script>
	</body>

</html>