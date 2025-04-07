<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script src="js/amin_module/helpdesk/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="js/printWatermark/common.js"></script>
<link rel="stylesheet" href="js/autoComplate/autoComplate.css">
<link href="js/Calender/jquery-ui.css" rel="Stylesheet"></link>
<script src="js/Calender/jquery-ui.js" type="text/javascript"></script>
<link rel="stylesheet" href="js/printWatermark/cueWatermark.css">

<script type="text/javascript" src="js/amin_module/rbac/jquery-1.12.3.js"></script> 
<link rel="stylesheet" href="js/watermark/watermark.css">
<script src="js/watermark/watermark_onclick.js" type="text/javascript"></script>
<script src="js/watermark/printallpages.js" type="text/javascript"></script>

<script>
var newWin;
function editData(id,label3){
	document.getElementById('updateid').value=id;
	document.getElementById('label1').value=label3;
	document.getElementById('updateForm').submit();
}
</script>
<c:url value="viewticketDetails" var="updateUrl" />
<form:form action="${updateUrl}" method="post" id="updateForm" name="updateForm" modelAttribute="updateid" > <%--  target="result" --%>
	<input type="hidden" name="updateid" id="updateid" value="0"/>
	<input type="hidden" name="label3" id="label3" value="${label}"/>
</form:form> 
<form:form name="myticket" id="myticket" action="myticketAction" method='POST' modelAttribute="myticketCMD">
<div onFocus="parent_disable1();" onclick="parent_disable1();">

<div class="container-fluid">
        <div class="card">
                <div class="card-header"> <h5>${label}</h5></div> <!-- end of card-header -->
                <div class="card-body card-block">
                <div class="row mb-3">
     					<div class="col-md-2">
		               	<label for="text-input" class=" form-control-label"><strong style="color: red;">*</strong> Search by</label>
		               </div>
		                <div class="col-md-4">
                            <div class="form-check-inline form-check">
                              <label for="inline-radio1" class="form-check-label ">
                              	<input type="hidden" id="label1" name="label1"  class="form-control" value="${label}">
                                <input type="radio" id="inline-radio1" value="TicketId" name="type" class="form-check-input" onchange="clearTYPE();">Ticket Id
                              </label>&nbsp;&nbsp;&nbsp;
                              <label for="inline-radio2" class="form-check-label ">
                                <input type="radio" id="inline-radio2" value="Status" name="type" class="form-check-input" onchange="clearTYPE1();">Status
                              </label>&nbsp;&nbsp;&nbsp;
                            </div>
		                 </div>
                </div>
                       <div class="row mb-3">
                                <div class="col-md-2">                                     
                                        <label for="text-input" class=" form-control-label"><strong style="color: red;">*</strong> Ticket Id</label>
                                </div>
                                <div class="col-md-4">
                                	<input id="ticket" name="ticket" class="form-control" autocomplete="off" >  
                                	<input type="hidden" id="sus_no_id" name="sus_no_id"  class="form-control" >
                                	<input type="hidden" id="unit_name" name="unit_name" style="font-family: 'FontAwesome',Arial;" value='${unit_name}' class="form-control" readonly="readonly">
                                 </div>
                              <div class="col-md-2">
                                <label for="text-input" class=" form-control-label"><strong style="color: red;">*</strong> Status </label>
                              </div>
                              <div class="col-md-4">
                                  <select name="ticket_status" id="ticket_status" class="form-control">
                                     <option value="">--Select--</option>
                                     <option value="0">New</option>
                                     <option value="1">In Progress</option>
                    					<option value="2">Completed</option>
                                  </select>
                                </div>
                   </div>
                        <div class="row mb-3" id="hid_id">
                                <div class="col-md-2">
                                        <label for="text-input" class=" form-control-label">Date (from)</label>
                                </div>
                                     <div class="col-md-4">                                     
                                               <input type="date" id="from_date" name="from_date" class="form-control" autocomplete="off" >
                                     </div>
                                <div class="col-md-2">
                                   <label for="text-input" class=" form-control-label">Date (to) </label>
                                </div>
                                 <div class="col-md-4">                                     
                                    <input type="date" id="to_date" name="to_date" class="form-control" autocomplete="off" onchange="checkDate();">
                                 </div>
            </div>
            <div class="row mb-3">
	             		<div class="col-md-2">	             		
		                	<label for="text-input" class=" form-control-label">Help Topic </label>
		                </div>
		                <div class="col-md-4">
               				<select  id="help_topic" name="help_topic" class="form-control" > 
               				  <option value="">--Select--</option>
							  <option value="1">Feedback</option>
							  <option value="2">General Inquiry</option>
							  <option value="3">Report a problem</option>
							  <option value="4">Report a problem/Access Issues</option>
							  <option value="5">Feature Request</option>
						    </select>
						</div> 
	             		<div class="col-md-2">	             		
		                	<label for="text-input" class=" form-control-label"> Module</label>
		                </div>
		                <div class="col-md-4">
               				<select id="module" name="module" class="form-control" > 
               				<option value="0">--Select--</option>
       							<c:forEach var="item" items="${getModuleNameList}" varStatus="num" >
       								<option style="text-transform: uppercase;" value="${item.id}">${item.module_name}</option>
       							</c:forEach>
						    </select>
						</div>
           </div>
      </div> <!-- end of card-body -->
	       <div class="card-footer">
	                 <input type="reset" class="btn btn-success btn-sm" value="Clear">                                  
	                 <i class="fa fa-search"></i><input type="button" class="btn btn-info btn-sm" value="Search" onclick="Search();">
	       </div> <!-- end of card-footer -->
   </div> <!-- end of card -->
  </div> <!-- end of container -->

</div>

<div class="container"  id="divPrint" style="display: none; "  >
			<div id="divShow" style="display: block;"></div>
			<div  class="watermarked" data-watermark="" id="divwatermark" style="display: block;">
				<span id="ip"></span>
		       <table id="TicketReport" class="table no-margin table-striped  table-hover  table-bordered report_print">
				<thead style="background-color: #9c27b0; color: white;">
					<tr>
						<th style="width: 5%;">Ser No</th>
						<th style="width: 10%;">Ticket Id</th>
						<th style="width: 10%;">Module</th>
						<th style="width: 10%;">Status</th>
						<th style="width: 10%;">Date</th>
						<th style="width: 20%;">Help Topic</th>
						<th style="width: 50%;">Issue Summary</th>
						<th class='lastCol' style="text-align: center; width: 7%;">Action</th>
					</tr>
		               </thead>
				<tbody>
		              
					<c:forEach var="item" items="${list}" varStatus="num">
						<tr>
							<th style="width: 5%;">${num.index+1}</th>
							<th style="width: 10%;">${item.ticket}</th>
							<th style="width: 10%;">${item.module_name}</th>
							<th style="width: 10%;">${item.ticket_status}</th>
							<th style="width: 10%;">${item.dt}</th>
							<th style="width: 20%;">${item.help_topic}</th>
							<th style="width: 50%;">${item.issue_summary}</th>
							<th id="thAction1" class='lastCol' style="text-align: center; width: 7%;">${item.id}</th>
						</tr>
					</c:forEach>
		                </tbody>
		        </table>
        	</div>	
		</div>	
</form:form>
	<c:url value="manageticketList" var="searchUrl" />
    		<form:form action="${searchUrl}" method="post" id="searchForm" name="searchForm" modelAttribute="ticket1">
    			<input type="hidden" name="ticket1" id="ticket1" value="0"/>
    			<input type="hidden" name="ticket_status1" id="ticket_status1" value="0"/>
    			<input type="hidden" name="from_date1" id="from_date1" value="0"/>
    			<input type="hidden" name="to_date1" id="to_date1" value="0"/>
    			<input type="hidden" name="help_topic1" id="help_topic1" value=""/>
    			<input type="hidden" name="type1" id="type1" value=""/>
    		    <input type="hidden" name="module1" id="module1" value=""/>
    			<input type="hidden" name="label" id="label" value="${label}"/>
    	</form:form> 
<script>
function parent_disable1() {
	if(newWin && !newWin.closed)
		newWin.focus();
}
function getRefreshReport(page,msg){
	if(msg.includes("Updated+Successfully"))
	{
		if(page == "myticket1")
		{
			Search();
		}
	}
}
function clearTYPE(){
	 document.getElementById("ticket").disabled = false;
	document.getElementById("ticket_status").disabled = true;
	$("#ticket_status").val("");
	$("#divPrint").hide();
}
function clearTYPE1(){
	 document.getElementById("ticket").disabled = true;
	 document.getElementById("ticket_status").disabled = false;	
	 $("#ticket").val("");
	 $("#divPrint").hide();
}
function Search(){
	watermarkreport();
	var r =  $('input:radio[name=type]:checked').val();	
	if(r == undefined)
	 {		 
		 alert("Please Select type");
		 $("#type").focus();
		return false;
	 }
	if(r == 'TicketId')
	 {		 
		if($("#ticket").val() == "")
		 {		 
			 alert("Please Enter ticket");
			 $("#ticket").focus();
			return false;
		 }
	 }
	if(r == 'Status')
	 {		 
		if($("#ticket_status").val() == "")
		 {		 
			 alert("Please Select Ticket Status");
			 $("#ticket_status").focus();
			return false;
		 }
	 }
		$("#ticket1").val($("#ticket").val());
	    $("#ticket_status1").val($("#ticket_status").val());
		$("#to_date1").val($("#to_date").val());
		$("#from_date1").val($("#from_date").val());
		$("#help_topic1").val($("#help_topic").val());
		$("#type1").val(r);
		$("#module1").val($("#module").val());
		$("#label").val($("#label1").val());
	    document.getElementById('searchForm').submit();
	
}
$(document).ready(function (){
	watermarkreport();
	document.getElementById("ticket_status").disabled = true;
	 document.getElementById("ticket").disabled = true;
	 $("#sus_no_id").val('${list[0][0]}');
	$("#unit_name").val('${list[0][1]}');
	if('${list.size()}' == 0 ){
	     $("table#TicketReport").append("<tr><td colspan='6' style='align:center;'>Data Not Available</td></tr>");
	 }
	if('${ticket1}'!= ""){
 		document.getElementById("ticket_status").disabled = true;
		 document.getElementById("ticket").disabled = false;
 	}
 	if('${ticket_status1}'!= ""){
 		document.getElementById("ticket_status").disabled = false;
		 document.getElementById("ticket").disabled = true;
 	}
	if('${ticket1}'!= "" || '${ticket_status1}'!= ""){
		$("#label1").val('${label}');
		$("#ticket").val('${ticket1}');
	 	$("#ticket_status").val('${ticket_status1}');
	 	$("#from_date").val('${from_date1}');
	 	$("#to_date").val('${to_date1}');
	 	$("#help_topic").val('${help_topic1}');
	  	$("input[name=type][value="+'${type1}'+"]").prop('checked', true);
	 	$("#module").val('${module1}');
	 	$("#divPrint").show();	
	}
	 try{
	     if(window.location.href.includes("msg="))
		{
			var url = window.location.href.split("?msg=")[0];
			var m=  window.location.href.split("?msg=")[1];
			window.location = url;
			
			if(m.includes("Updated+Successfully")){
				window.opener.getRefreshReport('myticket1',m);
				window.close('','_parent','');
			}
		} if( document.getElementById("msg").value != "")
		{
			$("div#divwatermark").val('').removeClass('watermarked'); 
			$("div#divSerachInput").hide();
			$("div#divPrint").hide();
		}
	}
catch (e) {
}  	 
});

function checkDate(){
	  var startDate = document.getElementById("from_date").value;
	  var endDate = document.getElementById("to_date").value;
	
	  if ((Date.parse(endDate) <= Date.parse(startDate))) {
	        alert("Effective To date should be greater than Effective From date");
	        document.getElementById("to_date").value = "";
	    }
}
$("#searchInput").on("keyup", function() {
	var value = $(this).val().toLowerCase();
	$("#TicketReport tbody tr").filter(function() { 
	$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	});
}); 
function printDiv() 
{
 	var printLbl = ["Status:","Ticket Id:","From Date:","To Date:"];
 	var status = document.getElementById('ticket_status').value;
 	var help_tp = document.getElementById('help_topic').value;
 	if(status == "0"){
 		status = "New";
 	}else if(status == "1"){
 		status = "In Progress";
 	}else if(status == "2"){
 		status = "Completed";
 	}else if(status == "3"){
 		status = "Feedback";
 	}else if(status == "4"){
 		status = "Feature Request";
 	}
 	if(help_tp == "1"){
 		help_tp = "Feedback";
 	}else if(help_tp == "2"){
 		help_tp = "General Inquiry";
 	}else if(help_tp == "3"){
 		help_tp = "Report a problem";
 	}else if(help_tp == "4"){
 		help_tp = "Report a problem/Access Issues";
 	}else if(help_tp == "5"){
 		help_tp = "Feature Request";
 	}
 	var printVal = [status,document.getElementById('ticket').value,help_tp];
 	printDivOptimize('divPrint','My Ticket',printLbl,printVal,"");
} 
</script>				