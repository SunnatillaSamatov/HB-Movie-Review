<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<html>
<head>
	<link type="text/css"
		 rel="stylesheet"
		 href="${pageContext.request.contextPath }/resources/css/style.css"/>
		 
    <link type="text/css"
		 rel="stylesheet"
		 href="${pageContext.request.contextPath }/resources/css/add-reviewer-style.css"/>
</head>
	<body>
	
		<div id="wrapper">
			<div id="header">
				<h2>Movie Rating and Review </h2>
			</div>
				<div id="container">
					<h3>Save Reviewer</h3>

						<form:form action="saveReviewer" modelAttribute="reviewer" method="POST">
		
		                    <!-- need to associate this data with customer id -->
			                
							<table>
								<tbody>
									<tr>
										<td><label>First name:</label></td>
										<td><form:input path="firstName" /></td>
									</tr>
									
									<tr>
										<td><label>Last name:</label></td>
										<td><form:input path="secondName" /></td>		
									</tr>
									
									
									
									
									<tr>
										<td><label></label></td>
										<td><input type="submit" value="Save" class="save"/></td>
									</tr>
									
									
								</tbody>
		
							</table>
						</form:form>

			    </div>
				
				<div style="clear; both;"> </div>
				
				<p>
					<a href="${pageContext.request.contextPath }/review/movielist">Back to list</a>
				</p>
				
			
				
			
		
		</div>
	
	</body>
</html>