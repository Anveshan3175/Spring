<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>Home Page</title>

         <!-- Bootstrap CSS CDN -->
        <link type="text/css" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" rel="stylesheet"/>
         <link type="text/css" href="<%=request.getContextPath() %>/resources/css/style.css" rel="stylesheet"/>
        <!-- Our Custom CSS -->
    </head>
    <body>
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<c:url value="candidate/add" var="addNewCandidate" />
	<c:url value="skill/add" var="addNewSkill" />
	<c:url value="skill/add" var="addNewEvent" />
	<c:url value="skill/add" var="addNewSkill" />
	<c:url value="skill/add" var="addNewTechnology" />
	<c:url value="skill/add" var="analytics" />
	<c:url value="skill/add" var="toDoList" />
	<c:url value="candidate/edit" var="editCandidate" />

        <div class="wrapper" >
            <!-- Sidebar Holder background : #6d7fcc -->
            <nav id="sidebar">
                <div class="sidebar-header">
                    <h3>Hello User</h3>
                </div>

                <ul class="list-unstyled components">
                    <li class="active">
                        <a href="#homeSubmenu" aria-expanded="false">Home</a>             
                    </li>
                    <li>
                        <a href="<c:url value='${addNewCandidate}' />">Candidates</a>
                    </li>
                    <li>
                        <a href="<c:url value='${addNewSkill}' />">Technology & Skills</a>
                    </li>
                    <li>
                        <a href="<c:url value='${addNewEvent}' />">Events</a>
                    </li>
                    <li>
                        <a href="<c:url value='${addNewTechnology}' />">Companies</a>
                    </li>
                    <li>
                        <a href="<c:url value='${analytics}' />">Analytics</a>
                    </li>
                    <li>
                        <a href="<c:url value='${toDoList}' />">To Do List</a>
                    </li>
                    <li>
                        <a href="<c:url value='${editCandidate}' />">Edit Candidate</a>
                    </li>
                </ul>
            </nav>

            <!-- Page Content Holder -->
            <div id="content">

                <nav class="navbar navbar-default">
                    <div class="container-fluid">

                        <div class="navbar-header">

                        </div>

                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="#">Page</a></li>
                                <li><a href="#">Page</a></li>
                                <li><a href="<c:url value='${logoutUrl}' />">Logout</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>

                <h2>Collapsible Sidebar Using Bootstrap 3</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

                <div class="line"></div>

                <h2>Lorem Ipsum Dolor</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

                <div class="line"></div>

                <h2>Lorem Ipsum Dolor</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

                <div class="line"></div>

                <h3>Lorem Ipsum Dolor</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            </div>
        </div>
    </body>
</html>
