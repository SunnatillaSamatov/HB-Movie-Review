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
			<!-- put the new button -->
			<input type="button" value="Add Reviewer"
			       onclick="window.location.href='showFormForAdd'; return false;"
			       class="add-button"/>
			
       
		<!-- add html table here -->
				
				<table>
					<tr>
						<th>Title</th>
						<th>Year</th>
						<th>Director</th>
						<th>Rating</th>
						
					</tr>
					
					
					<!-- loop over and print movies(movies is an attribute name spring mvc model -->
					<c:forEach var="tempmovie" items="${movies }">
					 
					 <c:url var="templink" value="listReviewrScoreComment">
	       				<!--<c:param name="command" value="Load"/> -->
	       				<c:param name="movieId" value="${tempmovie.movieId }"/>
	       			</c:url>
					 
						<tr>
							<td><a href="${templink }">${tempmovie.title} </a> </td>
							<td>${tempmovie.year}</td>
							<td>${tempmovie.director}</td>
							<td>Rating is good</td>
						</tr>
					</c:forEach>
				
				</table>
				
			</div>	
		</div>		
	</div>
</body>

</html>