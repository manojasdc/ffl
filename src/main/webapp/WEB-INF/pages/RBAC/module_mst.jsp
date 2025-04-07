<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<script type="text/javascript" src="js/amin_module/rbac/jquery-1.12.3.js"></script> 
<link rel="stylesheet" href="js/watermark/watermark.css">
<script src="js/watermark/watermark_onclick.js" type="text/javascript"></script>


	<script type="text/javascript">
		window.history.forward();
		function noBack() {
			window.history.forward();
		}
		
		$(document).ready(function (){
			
			 $('html').bind('cut copy paste', function (e) {
		        e.preventDefault();
		    });
		   
		    $("html").on("contextmenu",function(e){
		        return false;
		    }); 
		    
		    $('#module_name').keyup(function() {
		        this.value = this.value.toUpperCase();
		    }); 
		
		    watermarkreport();
		  
		    try{
	    		   if(window.location.href.includes("msg="))
	    			{
	    			 
	    				var url = window.location.href.split("?msg")[0];
	    				window.location = url;
	    			} 	
	    		}
	    		catch (e) {
	    			
	    		} 
			});
		
		
	</script>

  <form:form name="module_mst" id="module_mst" action="module_mstAction" method='POST' modelAttribute="module_mstCMD">
	<div class="container">
       	<div class="card">
       		<div class="card-header"> <h5>Module Master</h5><!-- <strong>Schedule Details </strong> --></div>
      			<div class="card-body card-block">
      				<div class="row mb-3"> 
             					<div class="col-md-2">
               					<label for="text-input"  >Module Name <strong style="color: red;">*</strong></label> 
             					</div>
             					<div class="col-md-4">
               				     <input  id="module_name" name="module_name" style="font-family: 'FontAwesome',Arial;"  class="form-control" autocomplete="off" maxlength="20">
					        	<input  id="module_old_name" name="module_old_name" type="hidden" class="form-control" autocomplete="off" >
						</div>
				</div>
			</div><!-- end of card-body -->
       		<div class="card-footer">
     	        <input type="reset" class="btn btn-success btn-sm" value="Clear">    	
           		<input type="submit"  id="save_btn" class="btn btn-primary btn-sm" value="Save" onclick="return isValid();">
           		<input type="submit" id="update_btn" class="btn btn-secondary btn-sm" value="Update" onclick="return isValid();" style="display: none">
           	</div><!-- end of card-footer -->
        </div> <!-- end of card -->
</div> <!-- end of container -->
</form:form>

<div class="container"  id="divPrint"  >
 		<div id="divShow"></div>
		 <div  class="watermarked" data-watermark="" id="divwatermark" style="display: block;">
			<span id="ip"></span>
			<table id="ModuleReport" class="table no-margin table-striped  table-hover  table-bordered report_print" >
				<thead>
					<tr style="font-size: 15px;">
						<th style=" width:10%;">Ser No</th>	
						<th style=" width:80%;">Module Name</th>			
						<th style="text-align: center;  width:10%;" class='lastCol'>Action</th>
					</tr>
				</thead> 
				<tbody >
					<c:forEach var="item" items="${list}" varStatus="num" >
						<tr style="font-size: 13px;">
							<td style=" width:10%;">${num.index+1}</td>
							<td style=" width:80%;">${item.module_name}</td>	
							<td style="text-align: center;  width:10%;">${item.id}</td>														
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>	
</div>

<script>
function isValid()
{
	if($("#module_name").val() == ""){
		alert("Please Enter Module Name");
		$("#module_name").focus();
		return false;
   	}
	return true;
}
</script>

<script>	
	function Update(id,name){	
		document.getElementById('module_name').value=name;
		document.getElementById('module_old_name').value=id;
		document.getElementById('update_btn').style.display='inline-block'; 
		document.getElementById('save_btn').style.display='none'; 
	}
</script>