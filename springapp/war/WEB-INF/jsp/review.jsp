<%@ include file="/WEB-INF/jsp/include.jsp" %>
<c:url var="theme1" value="/resources/theme1" scope="request" />
<c:url var="js" value="/resources/theme1/js" scope="request" />
<c:url var="font" value="/resources/theme1/font" scope="request" />
<html>
  <head><link href="${theme1}/css/core.css" rel="stylesheet">
<link rel="stylesheet" href="${theme1}/css/bootstrap.min.css">
<link rel="stylesheet" href="${theme1}/css/bootstrap-theme.min.css">
<script src="${js}/jquery.min.js" /></script>
<script src="${js}/bootstrap.min.js" /></script>
<style type="text/css">
.box4 .page-header {
   background-color:grey;
	color:black;
	margin-top:0%;
	padding-top:2%;
	padding-left:4%;
	font-weight:bold;
	font-size:30;
}
</style>
</head>
<body><div class="box4">
  		<div class="page-header">
  			<div class="row">
  				<div class="col-sm-2">
  					<img src="http://localhost:8081/images/Logo.jpg" id="logo" width="140" height="125">
  				</div>
  				
  				<div class="col-sm-6">
  					<h1 align="center">Instant Book Review</h1>
  				</div>
  			
  			
  				<div class="col-sm-4" align="right">
  					<span style="padding-left:60%"><button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myrev">About</button></span>
  					<h4>Inspired by <b>Rafael Nadal Biography</b></h4>
  				</div>
  			</div>
  		</div>
  	</div>
  
         <div class="modal fade" id="myrev" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">MORE INFO</h4>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
        </div>
        
      </div>
      
    </div>
  </div>

	<div>
	<c:forEach items="${revList}" var="rev">
        ${rev}
    </c:forEach>
	</div>
</body>
</html>