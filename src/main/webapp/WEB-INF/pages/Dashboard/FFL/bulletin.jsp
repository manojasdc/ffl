<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script src="assets/dev_module_list/FFL/bulletin.js"></script>
<script src="assets/dev_module_list/jquery-confirm.min.js"></script>

<div class="content-page" id="photoDiv">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                <div class="custom-breadcrum">
                    <div class="iq-members">
                        <h1 class="page-title">Bulletin</h1>
                    </div>
                    <div class="page-breadcrumb">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="${dashboardurl}">Dashboard</a></li>
                                <li class="breadcrumb-item active" aria-current="photo_page">Bulletin</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
        </div>

		
		       <div class="row">
		           <div class="col-lg-12 col-md-12 col-sm-12 col-12">
		               <div class="card">
		                   <div class="card-header">
		                       <div class="header-title">
		                           <h4 class="card-title">Create Bulletin</h4>
		                       </div>
		                   </div>
		                   <form name="createbulletin" id="createbulletin" >
		                       <div class="card-body custom-field-block">
		                           <div class="row">
		                               <div class="col-lg-4 col-md-6 col-sm-12 col-12">
		                                   <div class="form-group">
		                                       <label>Title<span class="mandatory">*</span></label>
		                                       <input type="text" class="form-control" id="title" name="title" placeholder="Enter title" />
		                                   </div>
		                               </div>

		                               

		                               <div class="col-lg-4 col-md-6 col-sm-12 col-12">
		                                   <div class="form-group">
		                                       <label>Description<span class="mandatory">*</span></label>
		                                       <input type="text" class="form-control" id="description" name="description" placeholder="Enter Description" />
		                                   </div>
		                               </div>
									   <div class="col-lg-4 col-md-6 col-sm-12 col-12">
									   			<div class="form-group">
									   			<label>Date<span class="mandatory">*</span></label>
									   			<input type="date" class="form-control" id="bulletinDate" name="bulletinDate" readonly />
									   		</div>
									   	</div>
		                           </div>
								   
								   

		                           <div class="col-lg-12 col-md-12 col-sm-12 col-12">
		                               <div class="btn-bottom">
		                                   <button type="submit" class="btn btn-info btnsubmit" id="submitBulletin" name="submitBulletin">Submit</button>
		                                   <button type="reset" class="btn btn-secondary btnsubmit" id="reset">Reset</button>
		                               </div>
		                           </div>
		                       </div>
		                   </form>
		               </div>
		           </div>
		       </div>
      
		<div class="row mt-5">
		    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
		        <div class="card">
		            
		            <div class="card-body">
		                <table id="bulletintable" class="table data-table table-striped table-hover custom-datatable datatable-responsive">
		                    <thead>
		                        <tr>
		                            <th data-orderable="false"><b>Sr No.</b></th>
		                            
		                            <th>Title</th>
		                            <th>Description</th>
									<th>Date</th>
		                            <th>Action</th>
		                        </tr>
		                    </thead>
		                    <tbody id="bulletintableBody">
		                        <!-- Dynamically populated rows will appear here -->
		                    </tbody>
		                </table>
		            </div>
		        </div>
		    </div>
		</div>

		<!-- Comment Modal -->
		<div class="modal fade" id="commentModal" tabindex="-1" role="dialog" aria-labelledby="commentModalLabel" aria-hidden="true">
		    <div class="modal-dialog" role="document">
		        <div class="modal-content">
		            <div class="modal-header">
		                <h5 class="modal-title" id="commentModalLabel">Bulletin Comments</h5>
		                <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close">
		                    <span aria-hidden="true">&times;</span>
		                </button>
		            </div>
					<div class="modal-body">
					                <!-- Display bulletin title -->
					                <h5 id="bulletinTitle" class="text-center mb-3"></h5>

					                <!-- Add new comment field -->
					                <textarea id="newComment" class="form-control" placeholder="Add a comment..."></textarea>
					                <div class="d-flex justify-content-center mt-3">
					                    <button class="btn btn-success me-2" id="submitComment">Submit</button>
					                </div>
					            </div>

										
		            <div class="modal-body" id="commentModalBody">
		                <!-- Comments will be dynamically loaded here -->
		            </div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		            </div>
					            
		        </div>
		    </div>
		</div>
    </div>
</div>
