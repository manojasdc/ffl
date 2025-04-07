<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script src="assets/dev_module_list/upload_image.js"></script>
<script src="assets/dev_module_list/jquery-confirm.min.js"></script>

<div class="content-page" id="photoDiv">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                <div class="custom-breadcrum">
                    <div class="iq-members">
                        <h1 class="page-title">Add Photo</h1>
                    </div>
                    <div class="page-breadcrumb">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="${dashboardurl}">Dashboard</a></li>
                                <li class="breadcrumb-item active" aria-current="photo_page">Add Photo</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
        </div>

        <!-- Image Upload Form -->
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                <div class="card">
                    <div class="card-header">
                        <div class="header-title">
                            <h4 class="card-title">Add Photo</h4>
                        </div>
                    </div>
                    <form name="addPhotoForm" id="addPhotoForm" enctype="multipart/form-data">
                        <div class="card-body custom-field-block">
                            <div class="row">
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="form-group">
                                        <label>Upload Image<span class="mandatory">*</span></label>
                                        <input type="file" class="form-control" id="image_file" name="image_file" accept="image/*" required />
                                    </div>
                                </div>

                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="form-group">
                                        <label>Flag<span class="mandatory">*</span></label>
                                        <select name="flag" id="flag" class="form-control">
                                            <option value="0">Select Flag</option>
                                            <option value="gallery">Gallery</option>
                                            <option value="institute">Institute</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="form-group">
                                        <label>Institute Name</label>
                                        <input type="text" class="form-control" id="institute_name" name="institute_name" placeholder="Enter Institute Name" />
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                <div class="btn-bottom">
                                    <button type="submit" class="btn btn-info btnsubmit" id="submitPhoto" name="submitPhoto">Submit</button>
                                    <button type="reset" class="btn btn-secondary btnsubmit" id="reset">Reset</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Table for displaying all images -->
		<div class="row mt-5">
		    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
		        <div class="card">
		            <div class="card-header">
		                <h4 class="card-title">Uploaded Images</h4>
		            </div>
		            <div class="card-body">
		                <table id="imageTable" class="table data-table table-striped table-hover custom-datatable datatable-responsive">
		                    <thead>
		                        <tr>
		                            <th data-orderable="false"><b>Sr No.</b></th>
		                            
		                            <th>Flag</th>
		                            <th>Institute Name</th>
									<th>Image</th>
		                            <th>Action</th>
		                        </tr>
		                    </thead>
		                    <tbody id="imageTableBody">
		                        <!-- Dynamically populated rows will appear here -->
		                    </tbody>
		                </table>
		            </div>
		        </div>
		    </div>
		</div>

        <!-- Modal to view the image -->
        <div class="modal fade" id="viewImageModal" tabindex="-1" role="dialog" aria-labelledby="viewImageModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="viewImageModalLabel">View Image</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <img id="modalImage" src="" alt="Image" class="img-fluid" />
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
