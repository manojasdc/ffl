<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
 <div class="card">
   <div class="card-header">
     <h5>form title here</h5>
   </div> <!-- end of card-header -->
   
   <div class="card-body card-block">
      <div class="row mb-3">
         <div class="col-md-2">       
		    <label for="" class="form-label">Example</label>  
		</div>
		<div class="col-md-4">
		    <input type="text" class="form-control" id="" name="" placeholder="">
		</div>
		<div class="col-md-2">       
		    <label for="exampleDataList" class="form-label">Datalist example</label> 
		</div>
		<div class="col-md-4">
		   <input class="form-control" list="datalistOptions" id="exampleDataList" placeholder="Type to search...">
				<datalist id="datalistOptions">
				  <option value="San Francisco">
				  <option value="New York">
				  <option value="Seattle">
				  <option value="Los Angeles">
				  <option value="Chicago">
				</datalist>
		</div>
		</div> <!-- end of first-row -->
		
		<div class="row mb-3">
         <div class="col-md-2">
            <label for="" class="form-label">Example textarea</label>
         </div>
         <div class="col-md-10">
            <textarea class="form-control" id="" rows="3"></textarea>
         </div>
      </div> <!-- end of second-row -->
      
      <div class="row mb-3">
        <div class="col-md-2">
           <label for="" class="form-label">Example Select</label>
        </div>
        <div class="col-md-4">
          <select class="form-select">
			  <option selected>Open this select menu</option>
			  <option value="1">One</option>
			  <option value="2">Two</option>
			  <option value="3">Three</option>
		 </select>
        </div>
        <div class="col-md-2">
          <label for="formFile" class="form-label">file input example</label>
        </div>
        <div class="col-md-4">
          <input class="form-control" type="file" id="formFile">
        </div>
        
      </div> <!-- end of third-row -->
      
      <div class="row mb-3">
        <div class="col-md-2">
           <label for="" class="form-label">Example Checkbox</label>
        </div>
        <div class="col-md-4">
          <div class="form-check form-check-inline">
			  <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
			  <label class="form-check-label" for="inlineCheckbox1">1</label>
		</div>
		<div class="form-check form-check-inline">
			  <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
			  <label class="form-check-label" for="inlineCheckbox2">2</label>
		</div>
        </div>
        <div class="col-md-2">Example Radiobutton</div>
        <div class="col-md-4">
         <div class="form-check form-check-inline">
		  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
		  <label class="form-check-label" for="inlineRadio1">1</label>
		</div>
		<div class="form-check form-check-inline">
		  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
		  <label class="form-check-label" for="inlineRadio2">2</label>
		</div>
        </div>
     </div> <!-- end of fourth-row -->
         
   </div><!-- end of card-body -->
   
   <div class="card-footer">    	
	     <input type="submit" class="btn btn-primary btn-sm" value="Save"> <!-- use btn-primary class for save button -->
	     <input type="reset" class="btn btn-success btn-sm" value="Clear"> <!-- use btn-success class for clear button -->
	     <input type="submit" class="btn btn-secondary btn-sm" value="Update"> <!-- use btn-secondary class for update button -->
	     <input type=button class="btn btn-danger btn-sm" value="Cancel"> <!-- use btn-danger class for cancel button -->
	     <i class="fa fa-search"></i><input type="button" class="btn btn-info btn-sm" value="Search"> <!-- use btn-info class for search button -->
	     <i class="fa fa-print"></i><input type="button" class="btn btn-dark btn-sm" value="Print"> <!-- use btn-dark class for print button -->
   </div> <!-- end of card-footer -->
     
 </div><!-- end of card -->
</div> <!-- end of container -->
</body>
</html>