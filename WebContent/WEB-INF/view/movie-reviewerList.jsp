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
			<h2> Reviewers' Score and Comments</h2>
		</div>
       
        <div id="container">
		
			<div id="content">
			
			
       
		<!-- add html table here -->
				
				<table>
					<tr>
						<th>First Name</th>
						<th>Second Name</th>
						<th>Score</th>
						<th>Comments</th>
						
					</tr>
					
					
					<!-- loop over and print movies(movies is an attribute name spring mvc model -->
					<c:forEach var="tempreviewer" items="${reviewerScoreComment }">
					 
					
					 
						<tr>
							<td>${tempreviewer.firstName} </td>
							<td>${tempreviewer.secondName}</td>
							<td>Awesome</td>
							<td>Rating is good</td>
						</tr>
					</c:forEach>
				
				</table>
				
			</div>	
		</div>		
	</div>

	<div style="clear; both;"> </div>
				
				<p>
					<a href="${pageContext.request.contextPath }/review/movielist">Back to list</a>
				</p>

</body>


</html>
