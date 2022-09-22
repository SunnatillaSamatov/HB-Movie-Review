<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>

    <div id="wrapper">
    
        <div id="header">
			<h2>Movie Rating and Review</h2>
		</div>
       
        <div id="container">
		
			<div id="content">
	
			
       
		<!-- add html table here -->
				
				<table>
					<tr>
						<th>First Name</th>
						<th>Second Namer</th>
					
						
					</tr>
					
					
					<!-- loop over and print reviewers('reviewers' is an attribute name spring mvc model -->
					<c:forEach var="reviewer" items="${reviewers }">
					
						<tr>
							<td>${reviewer.firstName}</td>
							<td>${reviewer.secondName}</td>
							
							
						</tr>
					</c:forEach>
				
				</table>
				
			</div>	
		</div>		
	</div>
</body>

</html>