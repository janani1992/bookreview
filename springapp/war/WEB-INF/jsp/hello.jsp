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
      .carousel{
      background: #2f4357;
      margin-top: 20px;
      }
      .carousel .item img{
      margin: 0 auto;/* Align slide image horizontally center */
      margin-left:100px;
      height:200px;
      width:150px;
      }
      
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
<script type="text/javascript">
function getImg(img)
{
	alert(img.id);
	document.getElementById("imgId").value = img.id;
	var form = document.getElementById('bookForm');
	form.submit();
}
</script>
</head>
  <body>
  <form id="bookForm" method="post" action="/springapp/review.htm"> 
  	<input type="hidden" id="imgId" name="imgId" />
  	<div class="box4">
  		<div class="page-header">
  			<div class="row">
  				<div class="col-sm-2">
  					<img src="http://localhost:8081/Logo.jpg" id="logo" width="140" height="125">
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
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#Fiction">Fiction</a></li>
    <li><a data-toggle="tab" href="#Comedy">Comedy</a></li>
    <li><a data-toggle="tab" href="#Romantic">Romantic</a></li>
    <li><a data-toggle="tab" href="#Education">Education</a></li>
  </ul>

  <div class="tab-content">
    <div id="Fiction" class="tab-pane fade in active">
      <c:forEach items="${imageList}" var="image">
<img src="http://localhost:8081/fiction/${image.bookPath}.png" onClick="getImg(this)" id="${image.bookId}" class="img-thumbnail" alt="Cinque Terre" width="100" height="150">
</c:forEach>
    </div>
    <div id="Comedy" class="tab-pane fade">
      <img src="http://localhost:8081/images/image1.png" onClick="alert(this.id)" id="image1" class="img-thumbnail" alt="Cinque Terre" width="100" height="150">
	        <img src="http://localhost:8081/images/image2.png" onClick="alert(this.id)" id="image2" class="img-thumbnail" alt="Cinque Terre" width="100" height="150">
	        <img src="http://localhost:8081/images/image3.png" onClick="alert(this.id)" id="image3" class="img-thumbnail" alt="Cinque Terre" width="100" height="150">
	        <img src="http://localhost:8081/images/image4.png" onClick="alert(this.id)" id="image4" class="img-thumbnail" alt="Cinque Terre" width="100" height="150">
  			<img src="http://localhost:8081/images/image5.png" onClick="alert(this.id)" id="image5" class="img-thumbnail" alt="Cinque Terre" width="100" height="150"> 
    </div>
    <div id="Romantic" class="tab-pane fade">
      <img src="http://localhost:8081/images/image1.png" onClick="alert(this.id)" id="image1" class="img-thumbnail" alt="Cinque Terre" width="100" height="150">
	        <img src="http://localhost:8081/images/image2.png" onClick="alert(this.id)" id="image2" class="img-thumbnail" alt="Cinque Terre" width="100" height="150">
	        <img src="http://localhost:8081/images/image3.png" onClick="alert(this.id)" id="image3" class="img-thumbnail" alt="Cinque Terre" width="100" height="150">
	        <img src="http://localhost:8081/images/image4.png" onClick="alert(this.id)" id="image4" class="img-thumbnail" alt="Cinque Terre" width="100" height="150">
  			<img src="http://localhost:8081/images/image5.png" onClick="alert(this.id)" id="image5" class="img-thumbnail" alt="Cinque Terre" width="100" height="150"> 
    </div>
    <div id="Education" class="tab-pane fade">
   <img src="http://localhost:8081/images/image1.png" onClick="alert(this.id)" id="image1" class="img-thumbnail" alt="Cinque Terre" width="100" height="150">
	        <img src="http://localhost:8081/images/image2.png" onClick="alert(this.id)" id="image2" class="img-thumbnail" alt="Cinque Terre" width="100" height="150">
	        <img src="http://localhost:8081/images/image3.png" onClick="alert(this.id)" id="image3" class="img-thumbnail" alt="Cinque Terre" width="100" height="150">
	        <img src="http://localhost:8081/images/image4.png" onClick="alert(this.id)" id="image4" class="img-thumbnail" alt="Cinque Terre" width="100" height="150">
  			<img src="http://localhost:8081/images/image5.png" onClick="alert(this.id)" id="image5" class="img-thumbnail" alt="Cinque Terre" width="100" height="150">
  </div>
	</div>	
	</form>
  </body>
</html>