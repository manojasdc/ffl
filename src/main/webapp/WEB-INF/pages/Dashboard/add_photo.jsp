<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<script src="assets/dev_module_list/add_photo.js"></script>
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

        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                <div class="card">
                    <div class="card-header">
                        <div class="header-title">
                            <h4 class="card-title">Add Photo</h4>
                        </div>
                    </div>
                    <form name="addPhotoForm" id="addPhotoForm">
                        <div class="card-body custom-field-block">
                            <div class="row">
                                <div class="col-lg-4 col-md-6 col-sm-12 col-12">
                                    <div class="form-group">
                                        <label>Image URL<span class="mandatory">*</span></label>
                                        <input type="text" class="form-control" id="image_url" name="image_url" placeholder="Enter Image URL" required />
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

                            <div class="row">
                                <div class="col-12 col-md-12">
                                    <div class="form-group">
                                        <div class="inst_block">
                                            <h6 class="mb-1">Instruction</h6>
                                            <ul class="inst_list">
                                                <li>
                                                    <p class="inst_text">Ensure the image URL is correct.</p>
                                                </li>
                                                <li>
                                                    <p class="inst_text">Select a valid flag from the dropdown.</p>
                                                </li>
                                            </ul>
                                        </div>
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
    </div>
</div>



