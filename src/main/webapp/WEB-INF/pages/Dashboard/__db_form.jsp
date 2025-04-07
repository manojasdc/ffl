<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

     <!-- Select Start -->
    <link rel="stylesheet" href="assets/vendor/dropDown/select2.min.css">
    <link rel="stylesheet" href="assets/vendor/dropDown/custom-select2.css">
    <script src="assets/vendor/dropDown/select2.min.js"></script>
    <script src="assets/vendor/dropDown/custom-select2.js"></script>
    <!-- Select End --> 
     <!-- Datepicker start -->
     <link rel="stylesheet" href="assets/vendor/datepicker/jquery-ui.css">
     <link rel="stylesheet" href="assets/vendor/datepicker/custom-jquery-ui.css">
     <script src="assets/vendor/datepicker/jquery-ui.js"></script>
     <script src="assets/vendor/datepicker/datePicketValidation.js"></script>
     <!-- Datepicker End -->
    <!-- Datatable start -->
    <link href="assets/vendor/datatable/datatables.min.css" rel="stylesheet" />
    <script src="assets/vendor/datatable/datatables.min.js"></script>
     <link href="assets/vendor/datatable/custom-datatable.css" rel="stylesheet" />
    <!-- Datatable end -->
    <!-- Datagrid start -->
    <link href="assets/vendor/datatable/responsive.dataTables.min.css" rel="stylesheet" />
    <script src="assets/vendor/datatable/dataTables.responsive.min.js"></script>
    <link href="assets/vendor/datatable/rowReorder.dataTables.min.css" rel="stylesheet" />
    <script src="assets/vendor/datatable/dataTables.rowReorder.min.js"></script>
    <!-- Datagrid End -->
    <!-- Treegrid Start -->
    <link rel="stylesheet" href="assets/vendor/treegrid/jquery.treegrid.css">
    <script src="assets/vendor/treegrid/jquery.treegrid.js"></script>
    <!-- Treegrid End -->
    <!-- Dashboard Style Start -->
<link rel="stylesheet" href="assets/css/style.css">
<!-- Dashboard Style end -->
    
<div class="content-page">
			<div class="container-fluid">
<div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="d-flex flex-wrap align-items-top justify-content-between">
                            <div class="iq-members">
                                <h2 class="page-title">Form Control</h2>
                            </div>
                            <div class="page-breadcrumb">
                                <nav aria-label="breadcrumb">
                                    <ol class="breadcrumb">
                                        <li class="breadcrumb-item"><a href="#">Dashboard</a></li>
                                        <li class="breadcrumb-item"><a href="#">Form</a></li>
                                        <li class="breadcrumb-item active" aria-current="page">DB Form</li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Project Dependency</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle">Bootstrap</h6>
                                        <ul>
                                            <li>Current Version : <code>V5.2.3</code></li>
                                        </ul>
                                    </div>

                                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle">jQuery</h6>
                                        <ul>
                                            <li> Current Version :
                                                <code>V3.6.4.min.js</code>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Inputs</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group">
                                            <label>Normal Input<span class="mandatory">*</span></label>
                                            <input class="form-control" type="text"
                                                placeholder="Enter Input">
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group form-group-lg">
                                            <label>Large Input<span class="mandatory">*</span></label>
                                            <input class="form-control form-control-lg" type="text"
                                                placeholder="Enter Input">
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group form-group-sm">
                                            <label>Small Input<span class="mandatory">*</span></label>
                                            <input class="form-control form-control-sm" type="text"
                                                placeholder="Enter Input">
                                        </div>
                                    </div>

                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group">
                                            <label>Input with Button<span class="mandatory">*</span></label>
                                            <div class="input-group">
                                                <input type="text" class="form-control"
                                                    placeholder="Recipient's username">
                                                <button type="button" class="btn btn-primary icon-btn"><i
                                                        class="ri-settings-4-fill"></i></button>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group">
                                            <label>Input Range<span class="mandatory">*</span></label>
                                            <input class="form-control" type="number"
                                                placeholder="Enter Input">
                                        </div>
                                    </div>

                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group">
                                            <label>File Upload<span class="mandatory">*</span></label>
                                            <input class="form-control" type="file">
                                        </div>
                                    </div>

                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group">
                                            <label>Textarea<span class="mandatory">*</span></label>
                                            <textarea placeholder="Enter Textarea"
                                                class="form-control"></textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Select Inputs</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group">
                                            <label>Single Select<span class="mandatory">*</span></label>
                                            <select name="type" class="singleselect form-control custom-select">
                                                <option></option>
                                                <option value="1">New List</option>
                                                <option value="2">Demo List</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group">
                                            <label>Select2 Select<span class="mandatory">*</span></label>
                                            <select name="type" class="select2 form-control custom-select">
                                                <option></option>
                                                <option value="1">New List</option>
                                                <option value="2">Demo List</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group">
                                            <label>Multi Select<span class="mandatory">*</span></label>
                                            <select name="type" class="multiselect2 form-control custom-select"
                                                multiple="multiple">
                                                <option></option>
                                                <option value="1">New List</option>
                                                <option value="2">Demo List</option>
                                                <option value="3">New List</option>
                                                <option value="4">Demo List</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group">
                                            <label>Select with Button<span class="mandatory">*</span></label>
                                            <div class="input-group select2-group">
                                                <select class="singleselect form-control">
                                                    <option></option>
                                                    <option value="1">One</option>
                                                    <option value="2">Two</option>
                                                    <option value="3">Three</option>
                                                </select>
                                                <button class="btn btn-primary icon-btn" type="button"><i
                                                        class="ri-settings-4-fill"></i></button>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group">
                                            <label>Select with Input<span class="mandatory">*</span></label>
                                            <div class="input-group select2-group select2-input-group">
                                                <select class="singleselect form-select" id="inputGroupSelect04"
                                                    aria-label="Example select with button addon">
                                                    <option></option>
                                                    <option value="1">One</option>
                                                    <option value="2">Two</option>
                                                    <option value="3">Three</option>
                                                </select>
                                                <input class="form-control" type="text"
                                                    placeholder="Enter Input">
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Date & Time Inputs</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group">
                                            <label>Date<span class="mandatory">*</span></label>
                                            <input class="form-control" type="date">
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group form-group-icon">
                                            <label>Date Picker<span class="mandatory">*</span>
                                            </label> <input type="text" name="dob" id="dob" maxlength="10"
                                                onclick="clickclear(this, 'DD/MM/YYYY')"
                                                class="form-control effect-9"
                                                onfocus="this.style.color='#000000'"
                                                onblur="clickrecall(this,'DD/MM/YYYY');validateDate_BackDate(this.value,this);"
                                                onkeyup="clickclear(this, 'DD/MM/YYYY')"
                                                onchange="clickrecall(this,'DD/MM/YYYY');validateDate_FutureDate(this.value,this); calculate_age('dob');  "
                                                aria-required="true" autocomplete="off" value="DD/MM/YYYY">
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group">
                                            <label>Time<span class="mandatory">*</span></label>
                                            <input class="form-control" type="time">
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group">
                                            <label>Date & Time<span class="mandatory">*</span></label>
                                            <input class="form-control" type="datetime-local">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Inputs Validation</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group">
                                            <label>Input With Note<span class="mandatory">*</span></label>
                                            <input class="form-control" type="text"
                                                placeholder="Enter Input">
                                            <div class="note-text">
                                                <span class="mandatory">Mention the note sentence</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group">
                                            <label>Input With Note<span class="mandatory">*</span></label>
                                            <input class="form-control" type="text"
                                                placeholder="Enter Input">
                                            <div class="note-text note-text-success">
                                                <span class="mandatory">Mention the successful note sentence</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group">
                                            <label>Valid Input<span class="mandatory">*</span></label>
                                            <input class="form-control valid-input" type="text"
                                                placeholder="Enter Input">
                                            <div class="note-text valid-text">
                                                <span class="tikClass">Kindly add custom-d-none class when you use
                                                    this input.</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="form-group">
                                            <label>Invalid Input<span class="mandatory">*</span></label>
                                            <input class="form-control invalid-input" type="text"
                                                placeholder="Enter Input">
                                            <div class="note-text invalid-text">
                                                <span class="errorClass">Kindly add custom-d-none class when you use
                                                    this input.</span>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Checkbox & Radio</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle">Checkbox</h6>
                                        <div class="form-check custom-formcheck">
                                            <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
                                            <label class="form-check-label" for="defaultCheck1">
                                                Default checkbox
                                            </label>
                                        </div>
                                        <div class="form-check custom-formcheck">
                                            <input class="form-check-input" type="checkbox" value="" id="defaultCheck2"
                                                disabled>
                                            <label class="form-check-label" for="defaultCheck2">
                                                Disabled checkbox
                                            </label>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle">Inline Checkbox</h6>
                                        <div class="form-check custom-formcheck form-check-inline">
                                            <input class="form-check-input" type="checkbox" id="inlineCheckbox1"
                                                value="option1">
                                            <label class="form-check-label" for="inlineCheckbox1">1</label>
                                        </div>
                                        <div class="form-check custom-formcheck form-check-inline">
                                            <input class="form-check-input" type="checkbox" id="inlineCheckbox2"
                                                value="option2">
                                            <label class="form-check-label" for="inlineCheckbox2">2</label>
                                        </div>
                                        <div class="form-check custom-formcheck form-check-inline">
                                            <input class="form-check-input" type="checkbox" id="inlineCheckbox3"
                                                value="option3" disabled>
                                            <label class="form-check-label" for="inlineCheckbox3">3 (disabled)</label>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle">Radio</h6>
                                        <div class="form-check custom-formcheck">
                                            <input class="form-check-input" type="radio" name="exampleRadios"
                                                id="exampleRadios1" value="option1" checked>
                                            <label class="form-check-label" for="exampleRadios1">
                                                Default radio
                                            </label>
                                        </div>
                                        <div class="form-check custom-formcheck">
                                            <input class="form-check-input" type="radio" name="exampleRadios"
                                                id="exampleRadios2" value="option2">
                                            <label class="form-check-label" for="exampleRadios2">
                                                Second default radio
                                            </label>
                                        </div>
                                        <div class="form-check custom-formcheck">
                                            <input class="form-check-input" type="radio" name="exampleRadios"
                                                id="exampleRadios3" value="option3" disabled>
                                            <label class="form-check-label" for="exampleRadios3">
                                                Disabled radio
                                            </label>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle">Inline Radio</h6>
                                        <div class="form-check custom-formcheck form-check-inline">
                                            <input class="form-check-input" type="radio" name="inlineRadioOptions"
                                                id="inlineRadio1" value="option1">
                                            <label class="form-check-label" for="inlineRadio1">1</label>
                                        </div>
                                        <div class="form-check custom-formcheck form-check-inline">
                                            <input class="form-check-input" type="radio" name="inlineRadioOptions"
                                                id="inlineRadio2" value="option2">
                                            <label class="form-check-label" for="inlineRadio2">2</label>
                                        </div>
                                        <div class="form-check custom-formcheck form-check-inline">
                                            <input class="form-check-input" type="radio" name="inlineRadioOptions"
                                                id="inlineRadio3" value="option3" disabled>
                                            <label class="form-check-label" for="inlineRadio3">3 (disabled)</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Badges</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <span class="badge badge-primary">Primary</span>
                                        <span class="badge badge-secondary">Secondary</span>
                                        <span class="badge badge-success">Success</span>
                                        <span class="badge badge-danger">Danger</span>
                                        <span class="badge badge-warning">Warning</span>
                                        <span class="badge badge-info">Info</span>
                                        <span class="badge badge-light">Light</span>
                                        <span class="badge badge-dark">Dark</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Buttons With Badge</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <button type="button" class="btn btn-primary">
                                            Notifications <span class="badge badge-light">4</span>
                                        </button>
                                        <button type="button" class="btn btn-outline-primary">
                                            Notifications <span class="badge badge-primary">4</span>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Modal</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <p class="mb-1">Add <code
                                                class="highlighter-rouge">.modal-xl, .modal-lg & .modal-sm</code> to
                                            <code class="highlighter-rouge">.modal-dialog</code> for modal size.
                                        </p>
                                        <!-- Button trigger modal -->
                                        <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                            data-bs-target="#staticBackdrop">
                                            Modal
                                        </button>
                                    </div>
                                </div>
                                <!-- Modal -->
                                <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
                                    data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
                                    aria-hidden="true">
                                    <div class="modal-dialog modal-dialog-scrollable modal-dialog-centered">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h1 class="modal-title fs-5" id="staticBackdropLabel">Modal title</h1>
                                                <button type="button" class="close" data-bs-dismiss="modal"
                                                    aria-label="Close">
                                                    <span aria-hidden="true">×</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <p>Cras mattis consectetur purus sit amet fermentum. Cras justo odio,
                                                    dapibus ac facilisis in, egestas eget quam. Morbi leo risus, porta
                                                    ac consectetur ac, vestibulum at eros.</p>
                                                <p>Cras mattis consectetur purus sit amet fermentum. Cras justo odio,
                                                    dapibus ac facilisis in, egestas eget quam. Morbi leo risus, porta
                                                    ac consectetur ac, vestibulum at eros.</p>
                                                <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur et.
                                                    Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor
                                                    auctor.</p>
                                                <p>Aenean lacinia bibendum nulla sed consectetur. Praesent commodo
                                                    cursus magna, vel scelerisque nisl consectetur et. Donec sed odio
                                                    dui. Donec ullamcorper nulla non metus auctor fringilla.</p>
                                                <p>Cras mattis consectetur purus sit amet fermentum. Cras justo odio,
                                                    dapibus ac facilisis in, egestas eget quam. Morbi leo risus, porta
                                                    ac consectetur ac, vestibulum at eros.</p>
                                                <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur et.
                                                    Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor
                                                    auctor.</p>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary"
                                                    data-bs-dismiss="modal">Close</button>
                                                <button type="button" class="btn btn-primary">Understood</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Buttons</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle mt-3">Default Buttons</h6>
                                        <button type="button" class="btn btn-primary">Primary</button>
                                        <button type="button" class="btn btn-secondary">Secondary</button>
                                        <button type="button" class="btn btn-success">Success</button>
                                        <button type="button" class="btn btn-danger">Danger</button>
                                        <button type="button" class="btn btn-warning">Warning</button>
                                        <button type="button" class="btn btn-info">Info</button>
                                        <button type="button" class="btn btn-light">Light</button>
                                        <button type="button" class="btn btn-dark">Dark</button>
                                        <button type="button" class="btn btn-link">Link</button>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle mt-3">Rounded Buttons</h6>
                                        <button type="button" class="btn btn-primary rounded-pill">Primary</button>
                                        <button type="button" class="btn btn-secondary rounded-pill">Secondary</button>
                                        <button type="button" class="btn btn-success rounded-pill">Success</button>
                                        <button type="button" class="btn btn-danger rounded-pill">Danger</button>
                                        <button type="button" class="btn btn-warning rounded-pill">Warning</button>
                                        <button type="button" class="btn btn-info rounded-pill">Info</button>
                                        <button type="button" class="btn btn-light rounded-pill">Light</button>
                                        <button type="button" class="btn btn-dark rounded-pill">Dark</button>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle mt-3">Outline Buttons</h6>
                                        <button type="button" class="btn btn-outline-primary">Primary</button>
                                        <button type="button" class="btn btn-outline-secondary">Secondary</button>
                                        <button type="button" class="btn btn-outline-success">Success</button>
                                        <button type="button" class="btn btn-outline-danger">Danger</button>
                                        <button type="button" class="btn btn-outline-warning">Warning</button>
                                        <button type="button" class="btn btn-outline-info">Info</button>
                                        <button type="button" class="btn btn-outline-dark">Dark</button>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle mt-3">Rounded Outline Buttons</h6>
                                        <button type="button"
                                            class="btn btn-outline-primary rounded-pill">Primary</button>
                                        <button type="button"
                                            class="btn btn-outline-secondary rounded-pill">Secondary</button>
                                        <button type="button"
                                            class="btn btn-outline-success rounded-pill">Success</button>
                                        <button type="button"
                                            class="btn btn-outline-danger rounded-pill">Danger</button>
                                        <button type="button"
                                            class="btn btn-outline-warning rounded-pill">Warning</button>
                                        <button type="button" class="btn btn-outline-info rounded-pill">Info</button>
                                        <button type="button" class="btn btn-outline-dark rounded-pill">Dark</button>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle mt-3">Icon Buttons</h6>
                                        <button type="button" class="btn btn-primary"><i class="ri-bill-fill"></i><span
                                                class="btn-text">Primary</span></button>
                                        <button type="button" class="btn btn-secondary"><i
                                                class="ri-heart-fill"></i>Secondary</button>
                                        <button type="button" class="btn btn-success"><i
                                                class="ri-bill-fill"></i>Success</button>
                                        <button type="button" class="btn btn-danger"><i
                                                class="ri-heart-fill"></i>Danger</button>
                                        <button type="button" class="btn btn-warning"><i
                                                class="ri-bill-fill"></i>Warning</button>
                                        <button type="button" class="btn btn-info"><i
                                                class="ri-heart-fill"></i>Info</button>
                                        <button type="button" class="btn btn-light"><i
                                                class="ri-bill-fill"></i>Light</button>
                                        <button type="button" class="btn btn-dark"><i
                                                class="ri-heart-fill"></i>Dark</button>
                                        <button type="button" class="btn btn-primary icon-btn"><i
                                                class="ri-heart-fill"></i></button>
                                        <button type="button" class="btn btn-secondary icon-btn"><i
                                                class="ri-star-fill"></i></button>
                                        <button type="button" class="btn btn-success icon-btn"><i
                                                class="ri-settings-4-fill"></i></button>
                                        <button type="button" class="btn btn-danger icon-btn"><i
                                                class="ri-radio-button-fill"></i></button>
                                        <button type="button" class="btn btn-warning icon-btn"><i
                                                class="ri-delete-bin-2-fill"></i></button>
                                        <button type="button" class="btn btn-info icon-btn"><i
                                                class="ri-lock-fill"></i></button>
                                        <button type="button" class="btn btn-light icon-btn"><i
                                                class="ri-time-fill"></i></button>
                                        <button type="button" class="btn btn-dark icon-btn"><i
                                                class="ri-sun-fill"></i></button>
                                        <button type="button" class="btn btn-link icon-btn"><i class="ri-moon-fill
                                                     "></i></button>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle mt-3">Rounded Icon Buttons</h6>
                                        <button type="button" class="btn btn-primary rounded-pill"><i
                                                class="ri-bill-fill"></i>Primary</button>
                                        <button type="button" class="btn btn-secondary rounded-pill"><i
                                                class="ri-heart-fill"></i>Secondary</button>
                                        <button type="button" class="btn btn-success rounded-pill"><i
                                                class="ri-bill-fill"></i>Success</button>
                                        <button type="button" class="btn btn-danger rounded-pill"><i
                                                class="ri-heart-fill"></i>Danger</button>
                                        <button type="button" class="btn btn-warning rounded-pill"><i
                                                class="ri-bill-fill"></i>Warning</button>
                                        <button type="button" class="btn btn-info rounded-pill"><i
                                                class="ri-heart-fill"></i>Info</button>
                                        <button type="button" class="btn btn-light rounded-pill"><i
                                                class="ri-bill-fill"></i>Light</button>
                                        <button type="button" class="btn btn-dark rounded-pill"><i
                                                class="ri-heart-fill"></i>Dark</button>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle mt-3">Outline Icon Buttons</h6>
                                        <button type="button" class="btn btn-outline-primary"><i
                                                class="ri-heart-line"></i>Primary</button>
                                        <button type="button" class="btn btn-outline-secondary"><i
                                                class="ri-alert-line"></i>Secondary</button>
                                        <button type="button" class="btn btn-outline-success"><i
                                                class="ri-heart-line"></i>Success</button>
                                        <button type="button" class="btn btn-outline-danger"><i
                                                class="ri-alert-line"></i>Danger</button>
                                        <button type="button" class="btn btn-outline-warning"><i
                                                class="ri-heart-line"></i>Warning</button>
                                        <button type="button" class="btn btn-outline-info"><i
                                                class="ri-alert-line"></i>Info</button>
                                        <button type="button" class="btn btn-outline-dark"><i
                                                class="ri-alert-line"></i>Dark</button>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle mt-3">Rounded Icon Buttons</h6>
                                        <button type="button" class="btn btn-outline-primary"><i
                                                class="ri-heart-line"></i>Primary</button>
                                        <button type="button" class="btn btn-outline-primary rounded-pill
                                       "><i class="ri-heart-line"></i>Primary</button>
                                        <button type="button" class="btn btn-outline-secondary
                                        rounded-pill"><i class="ri-alert-line"></i>Secondary</button>
                                        <button type="button" class="btn btn-outline-success rounded-pill
                                       "><i class="ri-heart-line"></i>Success</button>
                                        <button type="button" class="btn btn-outline-danger rounded-pill
                                       "><i class="ri-alert-line"></i>Danger</button>
                                        <button type="button" class="btn btn-outline-warning rounded-pill
                                       "><i class="ri-heart-line"></i>Warning</button>
                                        <button type="button" class="btn btn-outline-info rounded-pill
                                       "><i class="ri-alert-line"></i>Info</button>
                                        <button type="button" class="btn btn-outline-dark rounded-pill
                                       "><i class="ri-alert-line"></i>Dark</button>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle mt-3">Button Size</h6>
                                        <button type="button" class="btn btn-primary btn-sm mr-2">Small
                                            Button</button>
                                        <button type="button" class="btn btn-success mr-2">Button</button>
                                        <button type="button" class="btn btn-info btn-lg border-0">Large
                                            Button</button>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle mt-3">Disabled Button</h6>
                                        <button type="button" class="btn btn-primary disabled"
                                            disabled="">Disabled</button>
                                        <button type="button" class="btn btn-accent disabled"
                                            disabled="">Disabled</button>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle mt-3">Block Button</h6>
                                        <button type="button" class="btn btn-primary btn-block">Block
                                            level button</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Alerts Dismissing</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="alert text-white bg-primary" role="alert">
                                            <div class="iq-alert-text">A simple <b>primary</b> alert—check it out!</div>
                                            <button type="button" class="close" data-bs-dismiss="alert"
                                                aria-label="Close">
                                                <i class="ri-close-line"></i>
                                            </button>
                                        </div>
                                        <div class="alert text-white bg-secondary" role="alert">
                                            <div class="iq-alert-text">A simple <b>secondary</b> alert—check it out!
                                            </div>
                                            <button type="button" class="close" data-bs-dismiss="alert"
                                                aria-label="Close">
                                                <i class="ri-close-line"></i>
                                            </button>
                                        </div>
                                        <div class="alert text-white bg-success" role="alert">
                                            <div class="iq-alert-text">A simple <b>success</b> alert—check it out!</div>
                                            <button type="button" class="close" data-bs-dismiss="alert"
                                                aria-label="Close">
                                                <i class="ri-close-line"></i>
                                            </button>
                                        </div>
                                        <div class="alert text-white bg-danger" role="alert">
                                            <div class="iq-alert-text">A simple <b>danger</b> alert—check it out!</div>
                                            <button type="button" class="close" data-bs-dismiss="alert"
                                                aria-label="Close">
                                                <i class="ri-close-line"></i>
                                            </button>
                                        </div>
                                        <div class="alert text-white bg-warning" role="alert">
                                            <div class="iq-alert-text">A simple <b>warning</b> alert—check it out!</div>
                                            <button type="button" class="close" data-bs-dismiss="alert"
                                                aria-label="Close">
                                                <i class="ri-close-line"></i>
                                            </button>
                                        </div>
                                        <div class="alert text-white bg-info" role="alert">
                                            <div class="iq-alert-text">A simple <b>info</b> alert—check it out!</div>
                                            <button type="button" class="close" data-bs-dismiss="alert"
                                                aria-label="Close">
                                                <i class="ri-close-line"></i>
                                            </button>
                                        </div>
                                        <div class="alert bg-light" role="alert">
                                            <div class="iq-alert-text">A simple <b>light</b> alert—check it out!</div>
                                            <button type="button" class="close text-muted" data-bs-dismiss="alert"
                                                aria-label="Close">
                                                <i class="ri-close-line"></i>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Alerts Dismissing With Icons</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="alert text-white bg-primary" role="alert">
                                            <div class="iq-alert-icon">
                                                <i class="ri-alert-line"></i>
                                            </div>
                                            <div class="iq-alert-text">A simple <b>primary</b> alert—check it out!</div>
                                            <button type="button" class="close" data-bs-dismiss="alert"
                                                aria-label="Close">
                                                <i class="ri-close-line"></i>
                                            </button>
                                        </div>
                                        <div class="alert text-white bg-secondary" role="alert">
                                            <div class="iq-alert-icon">
                                                <i class="ri-information-line"></i>
                                            </div>
                                            <div class="iq-alert-text">A simple <b>secondary</b> alert—check it out!
                                            </div>
                                            <button type="button" class="close" data-bs-dismiss="alert"
                                                aria-label="Close">
                                                <i class="ri-close-line"></i>
                                            </button>
                                        </div>
                                        <div class="alert text-white bg-success" role="alert">
                                            <div class="iq-alert-icon">
                                                <i class="ri-alert-line"></i>
                                            </div>
                                            <div class="iq-alert-text">A simple <b>success</b> alert—check it out!</div>
                                            <button type="button" class="close" data-bs-dismiss="alert"
                                                aria-label="Close">
                                                <i class="ri-close-line"></i>
                                            </button>
                                        </div>
                                        <div class="alert text-white bg-danger" role="alert">
                                            <div class="iq-alert-icon">
                                                <i class="ri-information-line"></i>
                                            </div>
                                            <div class="iq-alert-text">A simple <b>danger</b> alert—check it out!</div>
                                            <button type="button" class="close" data-bs-dismiss="alert"
                                                aria-label="Close">
                                                <i class="ri-close-line"></i>
                                            </button>
                                        </div>
                                        <div class="alert text-white bg-warning" role="alert">
                                            <div class="iq-alert-icon">
                                                <i class="ri-alert-line"></i>
                                            </div>
                                            <div class="iq-alert-text">A simple <b>warning</b> alert—check it out!</div>
                                            <button type="button" class="close" data-bs-dismiss="alert"
                                                aria-label="Close">
                                                <i class="ri-close-line"></i>
                                            </button>
                                        </div>
                                        <div class="alert text-white bg-info" role="alert">
                                            <div class="iq-alert-icon">
                                                <i class="ri-information-line"></i>
                                            </div>
                                            <div class="iq-alert-text">A simple <b>info</b> alert—check it out!</div>
                                            <button type="button" class="close" data-bs-dismiss="alert"
                                                aria-label="Close">
                                                <i class="ri-close-line"></i>
                                            </button>
                                        </div>
                                        <div class="alert bg-light" role="alert">
                                            <div class="iq-alert-icon">
                                                <i class="ri-alert-line"></i>
                                            </div>
                                            <div class="iq-alert-text">A simple <b>light</b> alert—check it out!</div>
                                            <button type="button" class="close text-muted" data-bs-dismiss="alert"
                                                aria-label="Close">
                                                <i class="ri-close-line"></i>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Alerts With Background</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="alert alert-primary" role="alert">
                                            <div class="iq-alert-text">A simple primary alert with <a href="#"
                                                    class="alert-link">an
                                                    example link</a>. Give it a click if you like.
                                            </div>
                                        </div>
                                        <div class="alert alert-secondary" role="alert">
                                            <div class="iq-alert-text">A simple secondary alert with <a href="#"
                                                    class="alert-link">an
                                                    example link</a>. Give it a click if you like.
                                            </div>
                                        </div>
                                        <div class="alert alert-success" role="alert">
                                            <div class="iq-alert-text">A simple success alert with <a href="#"
                                                    class="alert-link">an
                                                    example link</a>. Give it a click if you like.
                                            </div>
                                        </div>
                                        <div class="alert alert-danger" role="alert">
                                            <div class="iq-alert-text">A simple danger alert with <a href="#"
                                                    class="alert-link">an
                                                    example link</a>. Give it a click if you like.
                                            </div>
                                        </div>
                                        <div class="alert alert-warning" role="alert">
                                            <div class="iq-alert-text">A simple warning alert with <a href="#"
                                                    class="alert-link">an
                                                    example link</a>. Give it a click if you like.
                                            </div>
                                        </div>
                                        <div class="alert alert-info" role="alert">
                                            <div class="iq-alert-text">A simple info alert with <a href="#"
                                                    class="alert-link">an
                                                    example link</a>. Give it a click if you like.
                                            </div>
                                        </div>
                                        <div class="alert alert-light" role="alert">
                                            <div class="iq-alert-text">A simple light alert with <a href="#"
                                                    class="alert-link">an
                                                    example link</a>. Give it a click if you like.
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Additional Content</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="alert alert-primary" role="alert">
                                            <div class="iq-alert-text">
                                                <h5 class="alert-heading">Well done!</h5>
                                                <p>Aww yeah, you successfully read this important alert message. This
                                                    example text is going to run a bit longer so that you can see how
                                                    spacing within an alert works with this kind of content.
                                                </p>
                                                <hr>
                                                <p class="mb-0">Whenever you need to, be sure to use margin utilities to
                                                    keep things nice and tidy.
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="alert alert-success" role="alert">
                                            <div class="iq-alert-text">
                                                <h5 class="alert-heading">Well done!</h5>
                                                <p>Aww yeah, you successfully read this important alert message. This
                                                    example text is going to run a bit longer so that you can see how
                                                    spacing within an alert works with this kind of content.
                                                </p>
                                                <hr>
                                                <p class="mb-0">Whenever you need to, be sure to use margin utilities to
                                                    keep things nice and tidy.
                                                </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card">
                            <div class="card-header d-flex justify-content-between">
                                <div class="header-title">
                                    <h4 class="card-title">Slides With Controls</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <p>Here’s a carousel with slides only. Note the presence of the <code>.d-block</code>
                                    and <code>.img-fluid</code> on carousel images to prevent browser default image
                                    alignment.</p>
                                <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                                    <div class="carousel-inner">
                                        <div class="carousel-item active">
                                            <img src="assets/images/img-1.jpg" class="d-block w-100" alt="#">
                                        </div>
                                        <div class="carousel-item">
                                            <img src="assets/images/img-1.jpg" class="d-block w-100" alt="#">
                                        </div>
                                        <div class="carousel-item">
                                            <img src="assets/images/img-1.jpg" class="d-block w-100" alt="#">
                                        </div>
                                    </div>
                                    <a class="carousel-control-prev" href="#carouselExampleControls" role="button"
                                        data-bs-slide="prev">
                                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                        <span class="sr-only">Previous</span>
                                    </a>
                                    <a class="carousel-control-next" href="#carouselExampleControls" role="button"
                                        data-bs-slide="next">
                                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                        <span class="sr-only">Next</span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card">
                            <div class="card-header d-flex justify-content-between">
                                <div class="header-title">
                                    <h4 class="card-title">Slides With Indicators</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <p>Here’s a carousel with slides only. Note the presence of the <code>.d-block</code>
                                    and <code>.img-fluid</code> on carousel images to prevent browser default image
                                    alignment.</p>
                                <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
                                    <ol class="carousel-indicators">
                                        <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0"
                                            class="active"></li>
                                        <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"></li>
                                        <li data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"></li>
                                    </ol>
                                    <div class="carousel-inner">
                                        <div class="carousel-item active">
                                            <img src="assets/images/img-1.jpg" class="d-block w-100" alt="#">
                                        </div>
                                        <div class="carousel-item">
                                            <img src="assets/images/img-1.jpg" class="d-block w-100" alt="#">
                                        </div>
                                        <div class="carousel-item">
                                            <img src="assets/images/img-1.jpg" class="d-block w-100" alt="#">
                                        </div>
                                    </div>
                                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button"
                                        data-bs-slide="prev">
                                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                        <span class="sr-only">Previous</span>
                                    </a>
                                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button"
                                        data-bs-slide="next">
                                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                        <span class="sr-only">Next</span>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card">
                            <div class="card-header d-flex justify-content-between">
                                <div class="header-title">
                                    <h4 class="card-title">Slides With Captions</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <p>Here’s a carousel with slides only. Note the presence of the <code>.d-block</code>
                                    and <code>.img-fluid</code> on carousel images to prevent browser default image
                                    alignment.</p>
                                <div class="bd-example">
                                    <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
                                        <ol class="carousel-indicators">
                                            <li data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0"
                                                class="active"></li>
                                            <li data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"></li>
                                            <li data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"></li>
                                        </ol>
                                        <div class="carousel-inner">
                                            <div class="carousel-item active">
                                                <img src="assets/images/img-1.jpg" class="d-block w-100" alt="#">
                                                <div class="carousel-caption d-none d-md-block">
                                                    <h4 class="text-white">First slide label</h4>
                                                    <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                                                </div>
                                            </div>
                                            <div class="carousel-item">
                                                <img src="assets/images/img-1.jpg" class="d-block w-100" alt="#">
                                                <div class="carousel-caption d-none d-md-block">
                                                    <h4 class="text-white">Second slide label</h4>
                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                                                </div>
                                            </div>
                                            <div class="carousel-item">
                                                <img src="assets/images/img-1.jpg" class="d-block w-100" alt="#">
                                                <div class="carousel-caption d-none d-md-block">
                                                    <h4 class="text-white">Third slide label</h4>
                                                    <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                        <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button"
                                            data-bs-slide="prev">
                                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                            <span class="sr-only">Previous</span>
                                        </a>
                                        <a class="carousel-control-next" href="#carouselExampleCaptions" role="button"
                                            data-bs-slide="next">
                                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                            <span class="sr-only">Next</span>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Instructions</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle">Step Instruction</h6>
                                        <div class="inst_block">
                                            <h6 class="mb-1">Instruction</h6>
                                            <ul class="inst_list">
                                                <li>
                                                    <p class="inst_text">If any of the value is not
                                                        available or not applicable then please put it as 0</p>
                                                </li>
                                                <li>
                                                    <p class="inst_text">Please click on 'Download
                                                        templates' to download the templates being uploaded in
                                                        applicable sections of the form.</p>
                                                </li>
                                                <li>
                                                    <p class="inst_text">For uploading the required
                                                        files, take a print on the letterhead of the Institution, and
                                                        after getting it stamped and signed, upload the scanned copy
                                                        by clicking at the appropriate option.</p>
                                                </li>
                                                <li>
                                                    <p class="inst_text">Please click on <b class="concat-string">Module
                                                            &gt; <a class="text-heighlight" href="">'Link'</a></b></p>
                                                </li>
                                            </ul>
                                        </div>
                                        <h6 class="custom-card-subtitle">Mandatory &amp;
                                            Important Instruction</h6>
                                        <div class="inst_block simple-instruction">
                                            <strong>Instruction :</strong> Upload file size upto 50kb and
                                            support file extension .png, .jpeg, .jpg <span class="concat-string"> &amp;
                                                <b>Upload court order</b> file
                                                size upto 200kb and support file extension .pdf
                                            </span>
                                        </div>
                                        <h6 class="custom-card-subtitle">Declaration / Undertaking</h6>
                                        <div class="custom-choose-one">
                                            <div class="input-style-form-check_block check-multi-list">
                                                <div class="form-check checkbox-style">
                                                    <input type="checkbox" id="Declaration" name="Declaration"
                                                        autocomplete="off" maxlength="25" class="form-check-input">
                                                    <input type="hidden" id="hiddenUpdate" name="hiddenUpdate"
                                                        class="form-control autocomplete" value="0"> <label
                                                        class="check-list">I have carefully read the concept
                                                        and rules regarding my admission, I fully understand that my
                                                        admission is provisional and is subject to final approval and
                                                        enrollment by the University. I also understand that my
                                                        provisional admission is without prejudice to the
                                                        directives/rules and regulations/orders/confirmation from the
                                                        designated and competent authorities of the state/central
                                                        government or the hon'ble court. </label> <label
                                                        class="check-list">
                                                        I hereby agree to abide by the terms and conditions or the
                                                        rules pertaining to admission as prescribed by the competent
                                                        authorities and admit that they are binding upon me legally
                                                        and legitimately.</label> <label class="check-list"> I
                                                        undertake to pay the fees fixed by the Competent Authority,
                                                        University.</label> <label class="check-list">I undertake to
                                                        see daily notices exhibited on the noticed board of the
                                                        college, observe and maintain a strict discipline as the
                                                        student and otherwise, in the college premises including
                                                        hostel and campus.</label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Progress bar</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <ul>
                                            <li>We use the <code>.progress</code> as a wrapper to indicate the max value
                                                of the
                                                progress bar.</li>
                                            <li>We use the inner <code>.progress-bar</code> to indicate the progress so
                                                far.
                                            </li>
                                            <li>The <code>.progress-bar</code> requires an inline style, utility class,
                                                or
                                                custom CSS to set their width.</li>
                                            <li>The <code>.progress-bar</code> also requires some <code>role</code> and
                                                <code>aria</code> attributes to make it accessible.
                                            </li>
                                        </ul>
                                        <p>Put that all together, and you have the following examples.</p>
                                        <div class="progress">
                                            <div class="progress-bar" role="progressbar" aria-valuenow="0"
                                                aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                        <div class="progress">
                                            <div class="progress-bar" role="progressbar" style="width: 25%"
                                                aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                        <div class="progress">
                                            <div class="progress-bar" role="progressbar" style="width: 25%;"
                                                aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">25%</div>
                                        </div>
                                        <h6 class="custom-card-subtitle mt-3">Animated stripes</h6>
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-striped progress-bar-animated"
                                                role="progressbar" aria-valuenow="75" aria-valuemin="0"
                                                aria-valuemax="100" style="width: 75%"></div>
                                        </div>
                                        <h6 class="custom-card-subtitle mt-3">Multipal Bars</h6>
                                        <div class="progress">
                                            <div class="progress-bar" role="progressbar" style="width: 15%"
                                                aria-valuenow="15" aria-valuemin="0" aria-valuemax="100"></div>
                                            <div class="progress-bar bg-success" role="progressbar" style="width: 30%"
                                                aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                                            <div class="progress-bar bg-info" role="progressbar" style="width: 20%"
                                                aria-valuenow="20" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header d-flex justify-content-between">
                                <div class="header-title">
                                    <h4 class="card-title">Typography</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <p>All HTML headings, <code>&lt;h1&gt;</code> through <code>&lt;h6&gt;</code>,
                                    are available.</p>
                                <h1>h1. Bootstrap heading</h1>
                                <h2>h2. Bootstrap heading</h2>
                                <h3>h3. Bootstrap heading</h3>
                                <h4>h4. Bootstrap heading</h4>
                                <h5>h5. Bootstrap heading</h5>
                                <h6 class="mb-0">h6. Bootstrap heading</h6>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header d-flex justify-content-between">
                                <div class="header-title">
                                    <h4 class="card-title">Inline text elements</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <p>You can use the mark tag to <mark>highlight</mark> text.</p>
                                <p><del>This line of text is meant to be treated as deleted text.</del></p>
                                <p><u>This line of text will render as underlined</u></p>
                                <p><small>This line of text is meant to be treated as fine print.</small></p>
                                <p><strong>This line rendered as bold text.</strong></p>
                                <p><em>This line rendered as italicized text.</em></p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header d-flex justify-content-between">
                                <div class="header-title">
                                    <h4 class="card-title">Lists</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle">Bullet List</h6>
                                        <ul>
                                            <li>Phasellus iaculis neque</li>
                                            <li>Purus sodales ultricies</li>
                                            <li>Vestibulum laoreet porttitor sem</li>
                                            <li>Ac tristique libero volutpat at</li>
                                        </ul>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle">Unstyled List</h6>
                                        <ul class="list-unstyled">
                                            <li>Lorem ipsum dolor sit amet</li>
                                            <li>Consectetur adipiscing elit</li>
                                            <li>Integer molestie lorem at massa</li>
                                            <li>Facilisis in pretium nisl aliquet</li>
                                        </ul>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-12"></div>
                                    <h6 class="custom-card-subtitle">Inline List</h6>
                                    <p>Remove a list’s bullets and apply some light <code>margin</code>
                                        with a combination of two classes, <code>.list-inline</code>
                                        and <code>.list-inline-item</code>.</p>
                                    <ul class="list-inline">
                                        <li class="list-inline-item">Lorem ipsum</li>
                                        <li class="list-inline-item">Phasellus iaculis</li>
                                        <li class="list-inline-item">Nulla volutpat</li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header d-flex justify-content-between">
                                <div class="header-title">
                                    <h4 class="card-title">Blockquotes</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <p>For quoting blocks of content from another source within your
                                    document. Wrap <code>&lt;blockquote class="blockquote"&gt;</code>
                                    around any <abbr title="HyperText Markup Language">HTML</abbr>
                                    as the quote.</p>
                                <blockquote class="blockquote">
                                    <p class="mb-0">Lorem ipsum dolor sit amet, consectetur
                                        adipiscing elit. Integer posuere erat a ante.</p>
                                    <footer class="blockquote-footer">Someone famous in <cite
                                            title="Source Title">Source Title</cite></footer>
                                </blockquote>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Sweet Alert</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <a href="#" class="btn btn-outline-primary btn-lg success" onclick="fireSweetAlert()">Success</a>
                                        <a href="#" class="btn btn-outline-primary btn-lg" id="danger" onclick="fireSweetAlert()">Danger</a>
                                        <a href="#" class="btn btn-outline-primary btn-lg" id="warning" onclick="fireSweetAlert()">Warning</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Tables</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle">Simple Table</h6>

                                        <div class="table-responsive">
                                            <table class="table basic-table table-striped table-hover">
                                                <thead>
                                                    <tr>
                                                        <th class="table-block-sm">Sr No.</th>
                                                        <th>First</th>
                                                        <th>Last</th>
                                                        <th>Handle</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td class="table-block-sm">1</td>
                                                        <td>Mark</td>
                                                        <td>Otto</td>
                                                        <td>@mdo</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="table-block-sm">2</td>
                                                        <td>Jacob</td>
                                                        <td>Thornton</td>
                                                        <td>@fat</td>
                                                    </tr>
                                                    <tr>
                                                        <td class="table-block-sm">3</td>
                                                        <td>Larry</td>
                                                        <td>the Bird</td>
                                                        <td>@twitter</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>

                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle">Table with Input</h6>
                                        <div class="table-responsive">
                                            <table class="table basic-table table-striped table-hover">
                                                <thead>
                                                    <tr>
                                                        <th class="table-block-sm">Sr No.</th>
                                                        <th>First</th>
                                                        <th>Last</th>
                                                        <th>Handle</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td class="table-block-sm">1</td>
                                                        <td>
                                                            <div class="form-group">
                                                                <input class="form-control" type="text"
                                                                    placeholder="Enter Input">
                                                            </div>
                                                        </td>
                                                        <td>
                                                            <div class="form-group">
                                                                <input class="form-control" type="text"
                                                                    placeholder="Enter Input">
                                                            </div>
                                                        </td>
                                                        <td>
                                                            <div class="form-group">
                                                                <input class="form-control" type="text"
                                                                    placeholder="Enter Input">
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="table-block-sm">2</td>
                                                        <td>
                                                            <div class="form-group">
                                                                <select name="type"
                                                                    class="singleselect form-control custom-select">
                                                                    <option></option>
                                                                    <option value="1">New List</option>
                                                                    <option value="2">Demo List</option>
                                                                </select>
                                                            </div>
                                                        </td>
                                                        <td>
                                                            <div class="form-group">
                                                                <select name="type"
                                                                    class="singleselect form-control custom-select">
                                                                    <option></option>
                                                                    <option value="1">New List</option>
                                                                    <option value="2">Demo List</option>
                                                                </select>
                                                            </div>
                                                        </td>
                                                        <td>
                                                            <div class="form-group">
                                                                <select name="type"
                                                                    class="singleselect form-control custom-select">
                                                                    <option></option>
                                                                    <option value="1">New List</option>
                                                                    <option value="2">Demo List</option>
                                                                </select>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="table-block-sm">3</td>
                                                        <td>
                                                            <div class="form-group">
                                                                <select name="type"
                                                                    class="select2 form-control custom-select">
                                                                    <option></option>
                                                                    <option value="1">New List</option>
                                                                    <option value="2">Demo List</option>
                                                                </select>
                                                            </div>
                                                        </td>
                                                        <td>
                                                            <div class="form-group">
                                                                <select name="type"
                                                                    class="select2 form-control custom-select">
                                                                    <option></option>
                                                                    <option value="1">New List</option>
                                                                    <option value="2">Demo List</option>
                                                                </select>
                                                            </div>
                                                        </td>
                                                        <td>
                                                            <div class="form-group">
                                                                <select name="type"
                                                                    class="select2 form-control custom-select">
                                                                    <option></option>
                                                                    <option value="1">New List</option>
                                                                    <option value="2">Demo List</option>
                                                                </select>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="table-block-sm">4</td>
                                                        <td>
                                                            <div class="form-check custom-formcheck form-check-inline">
                                                                <input class="form-check-input" type="checkbox"
                                                                    id="inlineCheckbox1" value="option1">
                                                                <label class="form-check-label"
                                                                    for="inlineCheckbox1">1</label>
                                                            </div>
                                                            <div class="form-check custom-formcheck form-check-inline">
                                                                <input class="form-check-input" type="checkbox"
                                                                    id="inlineCheckbox2" value="option2">
                                                                <label class="form-check-label"
                                                                    for="inlineCheckbox2">2</label>
                                                            </div>
                                                            <div class="form-check custom-formcheck form-check-inline">
                                                                <input class="form-check-input" type="checkbox"
                                                                    id="inlineCheckbox3" value="option3" disabled>
                                                                <label class="form-check-label" for="inlineCheckbox3">3
                                                                    (disabled)</label>
                                                            </div>
                                                        </td>
                                                        <td>
                                                            <div class="form-check custom-formcheck form-check-inline">
                                                                <input class="form-check-input" type="checkbox"
                                                                    id="inlineCheckbox1" value="option1">
                                                                <label class="form-check-label"
                                                                    for="inlineCheckbox1">1</label>
                                                            </div>
                                                            <div class="form-check custom-formcheck form-check-inline">
                                                                <input class="form-check-input" type="checkbox"
                                                                    id="inlineCheckbox2" value="option2">
                                                                <label class="form-check-label"
                                                                    for="inlineCheckbox2">2</label>
                                                            </div>
                                                            <div class="form-check custom-formcheck form-check-inline">
                                                                <input class="form-check-input" type="checkbox"
                                                                    id="inlineCheckbox3" value="option3" disabled>
                                                                <label class="form-check-label" for="inlineCheckbox3">3
                                                                    (disabled)</label>
                                                            </div>
                                                        </td>
                                                        <td>
                                                            <div class="form-check custom-formcheck form-check-inline">
                                                                <input class="form-check-input" type="checkbox"
                                                                    id="inlineCheckbox1" value="option1">
                                                                <label class="form-check-label"
                                                                    for="inlineCheckbox1">1</label>
                                                            </div>
                                                            <div class="form-check custom-formcheck form-check-inline">
                                                                <input class="form-check-input" type="checkbox"
                                                                    id="inlineCheckbox2" value="option2">
                                                                <label class="form-check-label"
                                                                    for="inlineCheckbox2">2</label>
                                                            </div>
                                                            <div class="form-check custom-formcheck form-check-inline">
                                                                <input class="form-check-input" type="checkbox"
                                                                    id="inlineCheckbox3" value="option3" disabled>
                                                                <label class="form-check-label" for="inlineCheckbox3">3
                                                                    (disabled)</label>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="table-block-sm">5</td>
                                                        <td>
                                                            <div class="form-check custom-formcheck">
                                                                <input class="form-check-input" type="checkbox" value=""
                                                                    id="defaultCheck1">
                                                                <label class="form-check-label" for="defaultCheck1">
                                                                    Default checkbox
                                                                </label>
                                                            </div>
                                                            <div class="form-check custom-formcheck">
                                                                <input class="form-check-input" type="checkbox" value=""
                                                                    id="defaultCheck2" disabled>
                                                                <label class="form-check-label" for="defaultCheck2">
                                                                    Disabled checkbox
                                                                </label>
                                                            </div>
                                                        </td>
                                                        <td>
                                                            <div class="form-check custom-formcheck">
                                                                <input class="form-check-input" type="checkbox" value=""
                                                                    id="defaultCheck1">
                                                                <label class="form-check-label" for="defaultCheck1">
                                                                    Default checkbox
                                                                </label>
                                                            </div>
                                                            <div class="form-check custom-formcheck">
                                                                <input class="form-check-input" type="checkbox" value=""
                                                                    id="defaultCheck2" disabled>
                                                                <label class="form-check-label" for="defaultCheck2">
                                                                    Disabled checkbox
                                                                </label>
                                                            </div>
                                                        </td>
                                                        <td>
                                                            <div class="form-check custom-formcheck">
                                                                <input class="form-check-input" type="checkbox" value=""
                                                                    id="defaultCheck1">
                                                                <label class="form-check-label" for="defaultCheck1">
                                                                    Default checkbox
                                                                </label>
                                                            </div>
                                                            <div class="form-check custom-formcheck">
                                                                <input class="form-check-input" type="checkbox" value=""
                                                                    id="defaultCheck2" disabled>
                                                                <label class="form-check-label" for="defaultCheck2">
                                                                    Disabled checkbox
                                                                </label>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <h6 class="custom-card-subtitle">Table with Action</h6>
                                        <div class="table-responsive">
                                            <table class="table table-hover table-striped basic-table">
                                                <thead>
                                                    <tr>
                                                        <th class="table-block-sm">Sr No.</th>
                                                        <th>
                                                            Image
                                                        </th>
                                                        <th>
                                                            Name
                                                        </th>
                                                        <th>
                                                            Date
                                                        </th>
                                                        <th>
                                                            Status
                                                        </th>
                                                        <th>
                                                            Action
                                                        </th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td class="table-block-sm">1</td>
                                                        <td>
                                                            <img src="assets/images/options/01.png"
                                                                class="bg-success-light rounded p-3 img-fluid avatar-70"
                                                                alt="image">
                                                        </td>
                                                        <td>
                                                            <h6 class="mb-2">Campaigns Name</h6>
                                                            <span>Audience : All Contact</span>
                                                        </td>
                                                        <td>03 Dec , 2020</td>
                                                        <td><a href="#" class="bg-warning-light badge">Completed</a>
                                                        </td>
                                                        <td>
                                                            <button type="button" class="btn btn-success icon-btn"><i
                                                                    class="ri-settings-4-fill"></i></button>
                                                            <button type="button" class="btn btn-secondary icon-btn"><i
                                                                    class="ri-star-fill"></i></button>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td class="table-block-sm">2</td>
                                                        <td>
                                                            <img src="assets/images/options/04.png"
                                                                class="bg-info-light rounded p-3 img-fluid avatar-70"
                                                                alt="image">
                                                        </td>
                                                        <td>
                                                            <h6 class="mb-2">Campaigns Name</h6>
                                                            <span>Audience : All Contact</span>
                                                        </td>
                                                        <td>29 Nov , 2020</td>
                                                        <td><a href="#" class="bg-success-light badge">Active</a>
                                                        </td>
                                                        <td>
                                                            <div class="dropdown">
                                                                <span class="dropdown-toggle1"
                                                                    id="dropdownMenuButtontwenty"
                                                                    data-bs-toggle="dropdown" aria-expanded="false"
                                                                    role="button">
                                                                    <i class="fas fa-cog"></i>
                                                                </span>
                                                                <div class="dropdown-menu dropdown-menu-right"
                                                                    aria-labelledby="dropdownMenuButtontwenty">
                                                                    <a class="dropdown-item" href="#">Show
                                                                        activity</a>
                                                                    <a class="dropdown-item" href="#">View
                                                                        details</a>
                                                                    <a class="dropdown-item" href="#">Copy
                                                                        campaign</a>
                                                                    <a class="dropdown-item" href="#">Create
                                                                        list</a>
                                                                    <a class="dropdown-item" data-extra-toggle="delete"
                                                                        data-closest-elem=".item" href="#">Delete</a>
                                                                </div>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Datatable</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <table id="datatabledemo"
                                            class="table data-table table-striped table-hover custom-datatable datatable-responsive"
                                            width="100%">
                                            <thead>
                                                <tr>
                                                    <th class="table-block-sm">Sr No.</th>
                                                    <th>Name</th>
                                                    <th>Position</th>
                                                    <th>Office</th>

                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td class="table-block-sm">1</td>
                                                    <td>Tiger Nixon</td>
                                                    <td>System Architect</td>
                                                    <td>Edinburgh</td>

                                                </tr>
                                                <tr>
                                                    <td class="table-block-sm">2</td>
                                                    <td>Garrett Winters</td>
                                                    <td>Accountant</td>
                                                    <td>Tokyo</td>

                                                </tr>
                                                <tr>
                                                    <td class="table-block-sm">3</td>
                                                    <td>Ashton Cox</td>
                                                    <td>Junior Technical Author</td>
                                                    <td>San Francisco</td>

                                                </tr>
                                                <tr>
                                                    <td class="table-block-sm">4</td>
                                                    <td>Cedric Kelly</td>
                                                    <td>Senior Javascript Developer</td>
                                                    <td>Edinburgh</td>

                                                </tr>
                                                <tr>
                                                    <td class="table-block-sm">5</td>
                                                    <td>Airi Satou</td>
                                                    <td>Accountant</td>
                                                    <td>Tokyo</td>

                                                </tr>
                                                <tr>
                                                    <td class="table-block-sm">6</td>
                                                    <td>Brielle Williamson</td>
                                                    <td>Integration Specialist</td>
                                                    <td>New York</td>

                                                </tr>
                                                <tr>
                                                    <td class="table-block-sm">7</td>
                                                    <td>Herrod Chandler</td>
                                                    <td>Sales Assistant</td>
                                                    <td>San Francisco</td>

                                                </tr>
                                                <tr>
                                                    <td class="table-block-sm">8</td>
                                                    <td>Rhona Davidson</td>
                                                    <td>Integration Specialist</td>
                                                    <td>Tokyo</td>

                                                </tr>
                                                <tr>
                                                    <td class="table-block-sm">9</td>
                                                    <td>Colleen Hurst</td>
                                                    <td>Javascript Developer</td>
                                                    <td>San Francisco</td>

                                                </tr>
                                                <tr>
                                                    <td class="table-block-sm">10</td>
                                                    <td>Sonya Frost</td>
                                                    <td>Software Engineer</td>
                                                    <td>Edinburgh</td>

                                                </tr>
                                                <tr>
                                                    <td class="table-block-sm">11</td>
                                                    <td>Jena Gaines</td>
                                                    <td>Office Manager</td>
                                                    <td>London</td>

                                                </tr>
                                                <tr>
                                                    <td class="table-block-sm">12</td>
                                                    <td>Quinn Flynn</td>
                                                    <td>Support Lead</td>
                                                    <td>Edinburgh</td>

                                                </tr>
                                                <tr>
                                                    <td class="table-block-sm">13</td>
                                                    <td>Charde Marshall</td>
                                                    <td>Regional Director</td>
                                                    <td>San Francisco</td>

                                                </tr>
                                                <tr>
                                                    <td class="table-block-sm">14</td>
                                                    <td>Haley Kennedy</td>
                                                    <td>Senior Marketing Designer</td>
                                                    <td>London</td>

                                                </tr>
                                                <tr>
                                                    <td class="table-block-sm">15</td>
                                                    <td>Tatyana Fitzpatrick</td>
                                                    <td>Regional Director</td>
                                                    <td>London</td>

                                                </tr>
                                                <tr>
                                                    <td class="table-block-sm">16</td>
                                                    <td>Michael Silva</td>
                                                    <td>Marketing Designer</td>
                                                    <td>London</td>

                                                </tr>
                                                <tr>
                                                    <td class="table-block-sm">17</td>
                                                    <td>Paul Byrd</td>
                                                    <td>Chief Financial Officer (CFO)</td>
                                                    <td>New York</td>

                                                </tr>
                                                <tr>
                                                    <td class="table-block-sm">18</td>
                                                    <td>Gloria Little</td>
                                                    <td>Systems Administrator</td>
                                                    <td>New York</td>

                                                </tr>

                                            </tbody>
                                            <tfoot>
                                                <tr>
                                                    <th class="table-block-sm">Sr No.</th>
                                                    <th>Name</th>
                                                    <th>Position</th>
                                                    <th>Office</th>
                                                </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Datatable Grid</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <table id="datagrid"
                                            class="table data-table table-striped table-hover custom-datatable custom-datatablegrid"
                                            width="100%">
                                            <thead>
                                                <tr>
                                                    <th>Name</th>
                                                    <th>Position</th>
                                                    <th>Office</th>
                                                    <th>Age</th>
                                                    <th>Start date</th>
                                                    <th>Salary</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>Tiger Nixon</td>
                                                    <td>System Architect</td>
                                                    <td>Edinburgh</td>
                                                    <td>61</td>
                                                    <td>2011/04/25</td>
                                                    <td>$320,800</td>
                                                </tr>
                                                <tr>
                                                    <td>Garrett Winters</td>
                                                    <td>Accountant</td>
                                                    <td>Tokyo</td>
                                                    <td>63</td>
                                                    <td>2011/07/25</td>
                                                    <td>$170,750</td>
                                                </tr>
                                                <tr>
                                                    <td>Ashton Cox</td>
                                                    <td>Junior Technical Author</td>
                                                    <td>San Francisco</td>
                                                    <td>66</td>
                                                    <td>2009/01/12</td>
                                                    <td>$86,000</td>
                                                </tr>
                                                <tr>
                                                    <td>Cedric Kelly</td>
                                                    <td>Senior Javascript Developer</td>
                                                    <td>Edinburgh</td>
                                                    <td>22</td>
                                                    <td>2012/03/29</td>
                                                    <td>$433,060</td>
                                                </tr>
                                                <tr>
                                                    <td>Airi Satou</td>
                                                    <td>Accountant</td>
                                                    <td>Tokyo</td>
                                                    <td>33</td>
                                                    <td>2008/11/28</td>
                                                    <td>$162,700</td>
                                                </tr>
                                                <tr>
                                                    <td>Brielle Williamson</td>
                                                    <td>Integration Specialist</td>
                                                    <td>New York</td>
                                                    <td>61</td>
                                                    <td>2012/12/02</td>
                                                    <td>$372,000</td>
                                                </tr>
                                                <tr>
                                                    <td>Herrod Chandler</td>
                                                    <td>Sales Assistant</td>
                                                    <td>San Francisco</td>
                                                    <td>59</td>
                                                    <td>2012/08/06</td>
                                                    <td>$137,500</td>
                                                </tr>
                                                <tr>
                                                    <td>Rhona Davidson</td>
                                                    <td>Integration Specialist</td>
                                                    <td>Tokyo</td>
                                                    <td>55</td>
                                                    <td>2010/10/14</td>
                                                    <td>$327,900</td>
                                                </tr>
                                                <tr>
                                                    <td>Colleen Hurst</td>
                                                    <td>Javascript Developer</td>
                                                    <td>San Francisco</td>
                                                    <td>39</td>
                                                    <td>2009/09/15</td>
                                                    <td>$205,500</td>
                                                </tr>
                                                <tr>
                                                    <td>Sonya Frost</td>
                                                    <td>Software Engineer</td>
                                                    <td>Edinburgh</td>
                                                    <td>23</td>
                                                    <td>2008/12/13</td>
                                                    <td>$103,600</td>
                                                </tr>
                                                <tr>
                                                    <td>Jena Gaines</td>
                                                    <td>Office Manager</td>
                                                    <td>London</td>
                                                    <td>30</td>
                                                    <td>2008/12/19</td>
                                                    <td>$90,560</td>
                                                </tr>
                                                <tr>
                                                    <td>Quinn Flynn</td>
                                                    <td>Support Lead</td>
                                                    <td>Edinburgh</td>
                                                    <td>22</td>
                                                    <td>2013/03/03</td>
                                                    <td>$342,000</td>
                                                </tr>
                                                <tr>
                                                    <td>Charde Marshall</td>
                                                    <td>Regional Director</td>
                                                    <td>San Francisco</td>
                                                    <td>36</td>
                                                    <td>2008/10/16</td>
                                                    <td>$470,600</td>
                                                </tr>
                                                <tr>
                                                    <td>Haley Kennedy</td>
                                                    <td>Senior Marketing Designer</td>
                                                    <td>London</td>
                                                    <td>43</td>
                                                    <td>2012/12/18</td>
                                                    <td>$313,500</td>
                                                </tr>
                                                <tr>
                                                    <td>Tatyana Fitzpatrick</td>
                                                    <td>Regional Director</td>
                                                    <td>London</td>
                                                    <td>19</td>
                                                    <td>2010/03/17</td>
                                                    <td>$385,750</td>
                                                </tr>
                                                <tr>
                                                    <td>Michael Silva</td>
                                                    <td>Marketing Designer</td>
                                                    <td>London</td>
                                                    <td>66</td>
                                                    <td>2012/11/27</td>
                                                    <td>$198,500</td>
                                                </tr>
                                                <tr>
                                                    <td>Paul Byrd</td>
                                                    <td>Chief Financial Officer (CFO)</td>
                                                    <td>New York</td>
                                                    <td>64</td>
                                                    <td>2010/06/09</td>
                                                    <td>$725,000</td>
                                                </tr>
                                                <tr>
                                                    <td>Gloria Little</td>
                                                    <td>Systems Administrator</td>
                                                    <td>New York</td>
                                                    <td>59</td>
                                                    <td>2009/04/10</td>
                                                    <td>$237,500</td>
                                                </tr>
                                                <tr>
                                                    <td>Bradley Greer</td>
                                                    <td>Software Engineer</td>
                                                    <td>London</td>
                                                    <td>41</td>
                                                    <td>2012/10/13</td>
                                                    <td>$132,000</td>
                                                </tr>
                                                <tr>
                                                    <td>Dai Rios</td>
                                                    <td>Personnel Lead</td>
                                                    <td>Edinburgh</td>
                                                    <td>35</td>
                                                    <td>2012/09/26</td>
                                                    <td>$217,500</td>
                                                </tr>
                                                <tr>
                                                    <td>Jenette Caldwell</td>
                                                    <td>Development Lead</td>
                                                    <td>New York</td>
                                                    <td>30</td>
                                                    <td>2011/09/03</td>
                                                    <td>$345,000</td>
                                                </tr>
                                                <tr>
                                                    <td>Yuri Berry</td>
                                                    <td>Chief Marketing Officer (CMO)</td>
                                                    <td>New York</td>
                                                    <td>40</td>
                                                    <td>2009/06/25</td>
                                                    <td>$675,000</td>
                                                </tr>
                                                <tr>
                                                    <td>Caesar Vance</td>
                                                    <td>Pre-Sales Support</td>
                                                    <td>New York</td>
                                                    <td>21</td>
                                                    <td>2011/12/12</td>
                                                    <td>$106,450</td>
                                                </tr>
                                                <tr>
                                                    <td>Doris Wilder</td>
                                                    <td>Sales Assistant</td>
                                                    <td>Sydney</td>
                                                    <td>23</td>
                                                    <td>2010/09/20</td>
                                                    <td>$85,600</td>
                                                </tr>
                                                <tr>
                                                    <td>Angelica Ramos</td>
                                                    <td>Chief Executive Officer (CEO)</td>
                                                    <td>London</td>
                                                    <td>47</td>
                                                    <td>2009/10/09</td>
                                                    <td>$1,200,000</td>
                                                </tr>
                                                <tr>
                                                    <td>Gavin Joyce</td>
                                                    <td>Developer</td>
                                                    <td>Edinburgh</td>
                                                    <td>42</td>
                                                    <td>2010/12/22</td>
                                                    <td>$92,575</td>
                                                </tr>
                                                <tr>
                                                    <td>Jennifer Chang</td>
                                                    <td>Regional Director</td>
                                                    <td>Singapore</td>
                                                    <td>28</td>
                                                    <td>2010/11/14</td>
                                                    <td>$357,650</td>
                                                </tr>
                                                <tr>
                                                    <td>Brenden Wagner</td>
                                                    <td>Software Engineer</td>
                                                    <td>San Francisco</td>
                                                    <td>28</td>
                                                    <td>2011/06/07</td>
                                                    <td>$206,850</td>
                                                </tr>
                                                <tr>
                                                    <td>Fiona Green</td>
                                                    <td>Chief Operating Officer (COO)</td>
                                                    <td>San Francisco</td>
                                                    <td>48</td>
                                                    <td>2010/03/11</td>
                                                    <td>$850,000</td>
                                                </tr>
                                                <tr>
                                                    <td>Shou Itou</td>
                                                    <td>Regional Marketing</td>
                                                    <td>Tokyo</td>
                                                    <td>20</td>
                                                    <td>2011/08/14</td>
                                                    <td>$163,000</td>
                                                </tr>
                                                <tr>
                                                    <td>Michelle House</td>
                                                    <td>Integration Specialist</td>
                                                    <td>Sydney</td>
                                                    <td>37</td>
                                                    <td>2011/06/02</td>
                                                    <td>$95,400</td>
                                                </tr>
                                                <tr>
                                                    <td>Suki Burks</td>
                                                    <td>Developer</td>
                                                    <td>London</td>
                                                    <td>53</td>
                                                    <td>2009/10/22</td>
                                                    <td>$114,500</td>
                                                </tr>
                                                <tr>
                                                    <td>Prescott Bartlett</td>
                                                    <td>Technical Author</td>
                                                    <td>London</td>
                                                    <td>27</td>
                                                    <td>2011/05/07</td>
                                                    <td>$145,000</td>
                                                </tr>
                                                <tr>
                                                    <td>Gavin Cortez</td>
                                                    <td>Team Leader</td>
                                                    <td>San Francisco</td>
                                                    <td>22</td>
                                                    <td>2008/10/26</td>
                                                    <td>$235,500</td>
                                                </tr>
                                                <tr>
                                                    <td>Martena Mccray</td>
                                                    <td>Post-Sales support</td>
                                                    <td>Edinburgh</td>
                                                    <td>46</td>
                                                    <td>2011/03/09</td>
                                                    <td>$324,050</td>
                                                </tr>
                                                <tr>
                                                    <td>Unity Butler</td>
                                                    <td>Marketing Designer</td>
                                                    <td>San Francisco</td>
                                                    <td>47</td>
                                                    <td>2009/12/09</td>
                                                    <td>$85,675</td>
                                                </tr>
                                                <tr>
                                                    <td>Howard Hatfield</td>
                                                    <td>Office Manager</td>
                                                    <td>San Francisco</td>
                                                    <td>51</td>
                                                    <td>2008/12/16</td>
                                                    <td>$164,500</td>
                                                </tr>
                                                <tr>
                                                    <td>Hope Fuentes</td>
                                                    <td>Secretary</td>
                                                    <td>San Francisco</td>
                                                    <td>41</td>
                                                    <td>2010/02/12</td>
                                                    <td>$109,850</td>
                                                </tr>
                                                <tr>
                                                    <td>Vivian Harrell</td>
                                                    <td>Financial Controller</td>
                                                    <td>San Francisco</td>
                                                    <td>62</td>
                                                    <td>2009/02/14</td>
                                                    <td>$452,500</td>
                                                </tr>
                                                <tr>
                                                    <td>Timothy Mooney</td>
                                                    <td>Office Manager</td>
                                                    <td>London</td>
                                                    <td>37</td>
                                                    <td>2008/12/11</td>
                                                    <td>$136,200</td>
                                                </tr>
                                                <tr>
                                                    <td>Jackson Bradshaw</td>
                                                    <td>Director</td>
                                                    <td>New York</td>
                                                    <td>65</td>
                                                    <td>2008/09/26</td>
                                                    <td>$645,750</td>
                                                </tr>
                                                <tr>
                                                    <td>Olivia Liang</td>
                                                    <td>Support Engineer</td>
                                                    <td>Singapore</td>
                                                    <td>64</td>
                                                    <td>2011/02/03</td>
                                                    <td>$234,500</td>
                                                </tr>
                                                <tr>
                                                    <td>Bruno Nash</td>
                                                    <td>Software Engineer</td>
                                                    <td>London</td>
                                                    <td>38</td>
                                                    <td>2011/05/03</td>
                                                    <td>$163,500</td>
                                                </tr>
                                                <tr>
                                                    <td>Sakura Yamamoto</td>
                                                    <td>Support Engineer</td>
                                                    <td>Tokyo</td>
                                                    <td>37</td>
                                                    <td>2009/08/19</td>
                                                    <td>$139,575</td>
                                                </tr>
                                                <tr>
                                                    <td>Thor Walton</td>
                                                    <td>Developer</td>
                                                    <td>New York</td>
                                                    <td>61</td>
                                                    <td>2013/08/11</td>
                                                    <td>$98,540</td>
                                                </tr>
                                                <tr>
                                                    <td>Finn Camacho</td>
                                                    <td>Support Engineer</td>
                                                    <td>San Francisco</td>
                                                    <td>47</td>
                                                    <td>2009/07/07</td>
                                                    <td>$87,500</td>
                                                </tr>
                                                <tr>
                                                    <td>Serge Baldwin</td>
                                                    <td>Data Coordinator</td>
                                                    <td>Singapore</td>
                                                    <td>64</td>
                                                    <td>2012/04/09</td>
                                                    <td>$138,575</td>
                                                </tr>
                                                <tr>
                                                    <td>Zenaida Frank</td>
                                                    <td>Software Engineer</td>
                                                    <td>New York</td>
                                                    <td>63</td>
                                                    <td>2010/01/04</td>
                                                    <td>$125,250</td>
                                                </tr>
                                                <tr>
                                                    <td>Zorita Serrano</td>
                                                    <td>Software Engineer</td>
                                                    <td>San Francisco</td>
                                                    <td>56</td>
                                                    <td>2012/06/01</td>
                                                    <td>$115,000</td>
                                                </tr>
                                                <tr>
                                                    <td>Jennifer Acosta</td>
                                                    <td>Junior Javascript Developer</td>
                                                    <td>Edinburgh</td>
                                                    <td>43</td>
                                                    <td>2013/02/01</td>
                                                    <td>$75,650</td>
                                                </tr>
                                                <tr>
                                                    <td>Cara Stevens</td>
                                                    <td>Sales Assistant</td>
                                                    <td>New York</td>
                                                    <td>46</td>
                                                    <td>2011/12/06</td>
                                                    <td>$145,600</td>
                                                </tr>
                                                <tr>
                                                    <td>Hermione Butler</td>
                                                    <td>Regional Director</td>
                                                    <td>London</td>
                                                    <td>47</td>
                                                    <td>2011/03/21</td>
                                                    <td>$356,250</td>
                                                </tr>
                                                <tr>
                                                    <td>Lael Greer</td>
                                                    <td>Systems Administrator</td>
                                                    <td>London</td>
                                                    <td>21</td>
                                                    <td>2009/02/27</td>
                                                    <td>$103,500</td>
                                                </tr>
                                                <tr>
                                                    <td>Jonas Alexander</td>
                                                    <td>Developer</td>
                                                    <td>San Francisco</td>
                                                    <td>30</td>
                                                    <td>2010/07/14</td>
                                                    <td>$86,500</td>
                                                </tr>
                                                <tr>
                                                    <td>Shad Decker</td>
                                                    <td>Regional Director</td>
                                                    <td>Edinburgh</td>
                                                    <td>51</td>
                                                    <td>2008/11/13</td>
                                                    <td>$183,000</td>
                                                </tr>
                                                <tr>
                                                    <td>Michael Bruce</td>
                                                    <td>Javascript Developer</td>
                                                    <td>Singapore</td>
                                                    <td>29</td>
                                                    <td>2011/06/27</td>
                                                    <td>$183,000</td>
                                                </tr>
                                                <tr>
                                                    <td>Donna Snider</td>
                                                    <td>Customer Support</td>
                                                    <td>New York</td>
                                                    <td>27</td>
                                                    <td>2011/01/25</td>
                                                    <td>$112,000</td>
                                                </tr>
                                            </tbody>
                                            <tfoot>
                                                <tr>
                                                    <th>Name</th>
                                                    <th>Position</th>
                                                    <th>Office</th>
                                                    <th>Age</th>
                                                    <th>Start date</th>
                                                    <th>Salary</th>
                                                </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Simple Table Tree View</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="table-responsive">
                                            <table class="table table-hover table-striped basic-table tree">
                                                <thead>
                                                    <tr>
                                                        <th>Title 1</th>
                                                        <th>Title 2</th>
                                                        <th>Title 3</th>
                                                        <th>Title 4</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr class="treegrid-1">
                                                        <td>Root node</td>
                                                        <td>Additional info</td>
                                                        <td>Root node</td>
                                                        <td>Additional info</td>
                                                    </tr>
                                                    <tr class="treegrid-2 treegrid-parent-1">
                                                        <td>Node 1-1</td>
                                                        <td>Additional info</td>
                                                        <td>Node 1-1</td>
                                                        <td>Additional info</td>
                                                    </tr>
                                                    <tr class="treegrid-3 treegrid-parent-1">
                                                        <td>Node 1-2</td>
                                                        <td>Additional info</td>
                                                        <td>Node 1-2</td>
                                                        <td>Additional info</td>
                                                    </tr>
                                                    <tr class="treegrid-4 treegrid-parent-3">
                                                        <td>Node 1-2-1</td>
                                                        <td>Additional info</td>
                                                        <td>Node 1-2-1</td>
                                                        <td>Additional info</td>
                                                    </tr>
                                                    <tr class="treegrid-5 treegrid-parent-4">
                                                        <td>Node 1-2-2</td>
                                                        <td>Additional info</td>
                                                        <td>Node 1-2-2</td>
                                                        <td>Additional info</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>



                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Datatable Tree View</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <table id="datatable"
                                            class="table data-table table-striped table-hover custom-datatable datatable-tree tree"
                                            width="100%">
                                            <thead>
                                                <tr>
                                                    <th>Name</th>
                                                    <th>Position</th>
                                                    <th>Office</th>
                                                    <th>Age</th>
                                                    <th>Start date</th>
                                                    <th>Salary</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr class="treegrid-1">
                                                    <td>Tiger Nixon</td>
                                                    <td>System Architect</td>
                                                    <td>Edinburgh</td>
                                                    <td>61</td>
                                                    <td>2011/04/25</td>
                                                    <td>$320,800</td>
                                                </tr>
                                                <tr class="treegrid-2 treegrid-parent-1">
                                                    <td class="no-sort">Garrett Winters</td>
                                                    <td>Accountant</td>
                                                    <td>Tokyo</td>
                                                    <td>63</td>
                                                    <td>2011/07/25</td>
                                                    <td>$170,750</td>
                                                </tr>
                                                <tr class="treegrid-3 treegrid-parent-1">
                                                    <td class="no-sort">Ashton Cox</td>
                                                    <td>Junior Technical Author</td>
                                                    <td>San Francisco</td>
                                                    <td>66</td>
                                                    <td>2009/01/12</td>
                                                    <td>$86,000</td>
                                                </tr>
                                                <tr class="treegrid-4">
                                                    <td>Cedric Kelly</td>
                                                    <td>Senior Javascript Developer</td>
                                                    <td>Edinburgh</td>
                                                    <td>22</td>
                                                    <td>2012/03/29</td>
                                                    <td>$433,060</td>
                                                </tr>
                                                <tr class="treegrid-5 treegrid-parent-4">
                                                    <td class="no-sort">Airi Satou</td>
                                                    <td>Accountant</td>
                                                    <td>Tokyo</td>
                                                    <td>33</td>
                                                    <td>2008/11/28</td>
                                                    <td>$162,700</td>
                                                </tr>
                                                <tr>
                                                    <td>Jennifer Acosta</td>
                                                    <td>Junior Javascript Developer</td>
                                                    <td>Edinburgh</td>
                                                    <td>43</td>
                                                    <td>2013/02/01</td>
                                                    <td>$75,650</td>
                                                </tr>
                                                <tr>
                                                    <td>Cara Stevens</td>
                                                    <td>Sales Assistant</td>
                                                    <td>New York</td>
                                                    <td>46</td>
                                                    <td>2011/12/06</td>
                                                    <td>$145,600</td>
                                                </tr>
                                                <tr>
                                                    <td>Hermione Butler</td>
                                                    <td>Regional Director</td>
                                                    <td>London</td>
                                                    <td>47</td>
                                                    <td>2011/03/21</td>
                                                    <td>$356,250</td>
                                                </tr>
                                                <tr>
                                                    <td>Lael Greer</td>
                                                    <td>Systems Administrator</td>
                                                    <td>London</td>
                                                    <td>21</td>
                                                    <td>2009/02/27</td>
                                                    <td>$103,500</td>
                                                </tr>
                                                <tr>
                                                    <td>Jonas Alexander</td>
                                                    <td>Developer</td>
                                                    <td>San Francisco</td>
                                                    <td>30</td>
                                                    <td>2010/07/14</td>
                                                    <td>$86,500</td>
                                                </tr>
                                                <tr>
                                                    <td>Shad Decker</td>
                                                    <td>Regional Director</td>
                                                    <td>Edinburgh</td>
                                                    <td>51</td>
                                                    <td>2008/11/13</td>
                                                    <td>$183,000</td>
                                                </tr>
                                                <tr>
                                                    <td>Michael Bruce</td>
                                                    <td>Javascript Developer</td>
                                                    <td>Singapore</td>
                                                    <td>29</td>
                                                    <td>2011/06/27</td>
                                                    <td>$183,000</td>
                                                </tr>
                                                <tr>
                                                    <td>Donna Snider</td>
                                                    <td>Customer Support</td>
                                                    <td>New York</td>
                                                    <td>27</td>
                                                    <td>2011/01/25</td>
                                                    <td>$112,000</td>
                                                </tr>

                                            </tbody>
                                            <tfoot>
                                                <tr>
                                                    <th>Name</th>
                                                    <th>Position</th>
                                                    <th>Office</th>
                                                    <th>Age</th>
                                                    <th>Start date</th>
                                                    <th>Salary</th>
                                                </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Cards</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-3 col-md-6 col-sm-12 col-12">
                                        <div class="card">
                                            <img src="assets/images/07.jpg" class="card-img-top" alt="#">
                                            <div class="card-body">
                                                <h4 class="card-title">Card title</h4>
                                                <p class="card-text">It is a long established fact that a reader will be
                                                    distracted by the readable content of a page when looking at its
                                                    layout. </p>
                                                <a href="#" class="btn btn-primary">Button</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-md-6 col-sm-12 col-12">
                                        <div class="card">
                                            <img src="assets/images/07.jpg" class="card-img-top" alt="#">
                                            <div class="card-body">
                                                <h4 class="card-title">Card title</h4>
                                                <p class="card-text">It is a long established fact that a reader will be
                                                    distracted by the readable content of a page when looking at its
                                                    layout. </p>
                                                <a href="#" class="card-link">Card link</a>
                                                <a href="#" class="card-link">Another link</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-md-6 col-sm-12 col-12">
                                        <div class="card">
                                            <img src="assets/images/07.jpg" class="card-img-top" alt="#">
                                            <div class="card-body">
                                                <h4 class="card-title">Card title</h4>
                                                <p class="card-text">It is a long established fact that a reader will be
                                                    distracted by the readable content of a page when looking at its
                                                    layout. </p>
                                                <a href="#" class="btn btn-primary btn-block">Go somewhere</a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-md-6 col-sm-12 col-12">
                                        <div class="card">
                                            <img src="assets/images/07.jpg" class="card-img-top" alt="#">
                                            <div class="card-body">
                                                <h4 class="card-title">Card title</h4>
                                                <p class="card-text">This is a wider card with supporting text below as
                                                    a natural lead-in to additional content. This content is a little
                                                    bit longer.</p>
                                                <p class="card-text"><small class="text-muted">Last updated 3 mins
                                                        ago</small></p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-md-6 col-sm-12 col-12">
                                        <div class="card text-white bg-primary">
                                            <div class="card-body">
                                                <h4 class="card-title text-white">Primary card title</h4>
                                                <blockquote class="blockquote mb-0">
                                                    <p class="font-size-14">Lorem ipsum dolor sit amet, consectetur
                                                        adipiscing elit. Integer posuere erat a ante.</p>
                                                    <footer class="blockquote-footer text-white font-size-12">Someone
                                                        famous in <cite title="Source Title" class="text-white">Source
                                                            Title</cite></footer>
                                                </blockquote>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-3 col-md-6 col-sm-12 col-12">
                                        <div class="card text-center">
                                            <div class="card-body">
                                                <i class="ri-window-line ri-4x line-height text-primary"></i>
                                                <h5 class="card-title mt-1">Why is the Site Down?</h5>
                                                <p class="mb-0">It is a long established fact that a reader will be
                                                    distracted by the readable content of a page when looking at its
                                                    layout.</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                                        <div class="card">
                                            <div class="row no-gutters">
                                                <div class="col-md-6 col-lg-4">
                                                    <img src="assets/images/09.jpg" class="card-img" alt="#">
                                                </div>
                                                <div class="col-md-6 col-lg-8">
                                                    <div class="card-body">
                                                        <h4 class="card-title">Card title</h4>
                                                        <p class="card-text">This is a wider card with supporting text
                                                            below as a natural lead-in. a little bit longer.</p>
                                                        <p class="card-text"><small class="text-muted">Last updated 3
                                                                mins ago</small></p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Tab 1</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="custom-basic-tab">
                                            <ul class="nav nav-tabs basic-tabs" id="myTab-1" role="tablist">
                                                <li class="nav-item">
                                                    <a class="nav-link btn btn-lg btn-outline-primary active"
                                                        id="home-tab" data-bs-toggle="tab" href="#home" role="tab"
                                                        aria-controls="home" aria-selected="true">Home</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link btn btn-lg btn-outline-primary" id="profile-tab"
                                                        data-bs-toggle="tab" href="#profile" role="tab"
                                                        aria-controls="profile" aria-selected="false">Profile</a>
                                                </li>
                                                <li class="nav-item">
                                                    <a class="nav-link btn btn-lg btn-outline-primary" id="contact-tab"
                                                        data-bs-toggle="tab" href="#contact" role="tab"
                                                        aria-controls="contact" aria-selected="false">Contact</a>
                                                </li>
                                            </ul>
                                            <div class="tab-content" id="myTabContent-2">
                                                <div class="tab-pane fade show active" id="home" role="tabpanel"
                                                    aria-labelledby="home-tab">
                                                    <p>Lorem Ipsum is simply dummy text of the printing and
                                                        typesetting industry. Lorem Ipsum has been the
                                                        industry's standard dummy text ever since the 1500s,
                                                        when an unknown printer took a galley of type and
                                                        scrambled it to make a type specimen book.</p>
                                                </div>
                                                <div class="tab-pane fade" id="profile" role="tabpanel"
                                                    aria-labelledby="profile-tab">
                                                    <p>Lorem Ipsum is simply dummy text of the printing and
                                                        typesetting industry. Lorem Ipsum has been the
                                                        industry's standard dummy text ever since the 1500s,
                                                        when an unknown printer took a galley of type and
                                                        scrambled it to make a type specimen book.</p>
                                                </div>
                                                <div class="tab-pane fade" id="contact" role="tabpanel"
                                                    aria-labelledby="contact-tab">
                                                    <p>Lorem Ipsum is simply dummy text of the printing and
                                                        typesetting industry. Lorem Ipsum has been the
                                                        industry's standard dummy text ever since the 1500s,
                                                        when an unknown printer took a galley of type and
                                                        scrambled it to make a type specimen book.</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Tab 2</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                                            <li class="nav-item">
                                                <a class="nav-link active" id="pills-home-tab" data-bs-toggle="pill"
                                                    href="#pills-home" role="tab" aria-controls="pills-home"
                                                    aria-selected="true">Home</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" id="pills-profile-tab" data-bs-toggle="pill"
                                                    href="#pills-profile" role="tab" aria-controls="pills-profile"
                                                    aria-selected="false">Profile</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" id="pills-contact-tab" data-bs-toggle="pill"
                                                    href="#pills-contact" role="tab" aria-controls="pills-contact"
                                                    aria-selected="false">Contact</a>
                                            </li>
                                        </ul>
                                        <div class="tab-content" id="pills-tabContent-2">
                                            <div class="tab-pane fade show active" id="pills-home" role="tabpanel"
                                                aria-labelledby="pills-home-tab">
                                                <p>Lorem Ipsum is simply dummy text of the printing and
                                                    typesetting industry. Lorem Ipsum has been the
                                                    industry's standard dummy text ever since the 1500s,
                                                    when an unknown printer took a galley of type and
                                                    scrambled it to make a type specimen book.</p>
                                            </div>
                                            <div class="tab-pane fade" id="pills-profile" role="tabpanel"
                                                aria-labelledby="pills-profile-tab">
                                                <p>Lorem Ipsum is simply dummy text of the printing and
                                                    typesetting industry. Lorem Ipsum has been the
                                                    industry's standard dummy text ever since the 1500s,
                                                    when an unknown printer took a galley of type and
                                                    scrambled it to make a type specimen book.</p>
                                            </div>
                                            <div class="tab-pane fade" id="pills-contact" role="tabpanel"
                                                aria-labelledby="pills-contact-tab">
                                                <p>Lorem Ipsum is simply dummy text of the printing and
                                                    typesetting industry. Lorem Ipsum has been the
                                                    industry's standard dummy text ever since the 1500s,
                                                    when an unknown printer took a galley of type and
                                                    scrambled it to make a type specimen book.</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Tab 3</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <ul class="nav nav-tabs" id="myTab-two" role="tablist">
                                            <li class="nav-item">
                                                <a class="nav-link active" id="home-tab-two" data-bs-toggle="tab"
                                                    href="#home-two" role="tab" aria-controls="home"
                                                    aria-selected="true">Home</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" id="profile-tab-two" data-bs-toggle="tab"
                                                    href="#profile-two" role="tab" aria-controls="profile"
                                                    aria-selected="false">Profile</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" id="contact-tab-two" data-bs-toggle="tab"
                                                    href="#contact-two" role="tab" aria-controls="contact"
                                                    aria-selected="false">Contact</a>
                                            </li>
                                        </ul>
                                        <div class="tab-content" id="myTabContent-1">
                                            <div class="tab-pane fade show active" id="home-two" role="tabpanel"
                                                aria-labelledby="home-tab-two">
                                                <p>Lorem Ipsum is simply dummy text of the printing and
                                                    typesetting industry. Lorem Ipsum has been the
                                                    industry's standard dummy text ever since the 1500s,
                                                    when an unknown printer took a galley of type and
                                                    scrambled it to make a type specimen book.</p>
                                            </div>
                                            <div class="tab-pane fade" id="profile-two" role="tabpanel"
                                                aria-labelledby="profile-tab-two">
                                                <p>Lorem Ipsum is simply dummy text of the printing and
                                                    typesetting industry. Lorem Ipsum has been the
                                                    industry's standard dummy text ever since the 1500s,
                                                    when an unknown printer took a galley of type and
                                                    scrambled it to make a type specimen book.</p>
                                            </div>
                                            <div class="tab-pane fade" id="contact-two" role="tabpanel"
                                                aria-labelledby="contact-tab-two">
                                                <p>Lorem Ipsum is simply dummy text of the printing and
                                                    typesetting industry. Lorem Ipsum has been the
                                                    industry's standard dummy text ever since the 1500s,
                                                    when an unknown printer took a galley of type and
                                                    scrambled it to make a type specimen book.</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Tab 4</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="custom-v-pills-tab">
                                            <div class="row">
                                                <div class="col-sm-3">
                                                    <div class="nav flex-column nav-pills text-center" id="v-pills-tab"
                                                        role="tablist" aria-orientation="vertical">
                                                        <a class="nav-link active" id="v-pills-home-tab"
                                                            data-bs-toggle="pill" href="#v-pills-home" role="tab"
                                                            aria-controls="v-pills-home" aria-selected="true">Home</a>
                                                        <a class="nav-link" id="v-pills-profile-tab"
                                                            data-bs-toggle="pill" href="#v-pills-profile" role="tab"
                                                            aria-controls="v-pills-profile"
                                                            aria-selected="false">Profile</a>
                                                        <a class="nav-link" id="v-pills-messages-tab"
                                                            data-bs-toggle="pill" href="#v-pills-messages" role="tab"
                                                            aria-controls="v-pills-messages"
                                                            aria-selected="false">Messages</a>
                                                        <a class="nav-link" id="v-pills-settings-tab"
                                                            data-bs-toggle="pill" href="#v-pills-settings" role="tab"
                                                            aria-controls="v-pills-settings"
                                                            aria-selected="false">Settings</a>
                                                    </div>
                                                </div>
                                                <div class="col-sm-9">
                                                    <div class="tab-content mt-0" id="v-pills-tabContent">
                                                        <div class="tab-pane fade show active" id="v-pills-home"
                                                            role="tabpanel" aria-labelledby="v-pills-home-tab">
                                                            <p>Lorem Ipsum is simply dummy text of the printing
                                                                and typesetting industry. Lorem Ipsum has been the
                                                                industry's standard dummy text ever since the
                                                                1500s, when an unknown printer took a galley of
                                                                type and scrambled it to make a type specimen
                                                                book. It has survived not only five centuries, but
                                                                also the leap into electronic typesetting,
                                                                remaining essentially unchanged.</p>
                                                        </div>
                                                        <div class="tab-pane fade" id="v-pills-profile" role="tabpanel"
                                                            aria-labelledby="v-pills-profile-tab">
                                                            <p>Lorem Ipsum is simply dummy text of the printing
                                                                and typesetting industry. Lorem Ipsum has been the
                                                                industry's standard dummy text ever since the
                                                                1500s, when an unknown printer took a galley of
                                                                type and scrambled it to make a type specimen
                                                                book. It has survived not only five centuries, but
                                                                also the leap into electronic typesetting,
                                                                remaining essentially unchanged.</p>
                                                        </div>
                                                        <div class="tab-pane fade" id="v-pills-messages" role="tabpanel"
                                                            aria-labelledby="v-pills-messages-tab">
                                                            <p>Lorem Ipsum is simply dummy text of the printing
                                                                and typesetting industry. Lorem Ipsum has been the
                                                                industry's standard dummy text ever since the
                                                                1500s, when an unknown printer took a galley of
                                                                type and scrambled it to make a type specimen
                                                                book. It has survived not only five centuries, but
                                                                also the leap into electronic typesetting,
                                                                remaining essentially unchanged.</p>
                                                        </div>
                                                        <div class="tab-pane fade" id="v-pills-settings" role="tabpanel"
                                                            aria-labelledby="v-pills-settings-tab">
                                                            <p>Lorem Ipsum is simply dummy text of the printing
                                                                and typesetting industry. Lorem Ipsum has been the
                                                                industry's standard dummy text ever since the
                                                                1500s, when an unknown printer took a galley of
                                                                type and scrambled it to make a type specimen
                                                                book. It has survived not only five centuries, but
                                                                also the leap into electronic typesetting,
                                                                remaining essentially unchanged.</p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Tab 5</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <ul class="nav nav-pills mb-3 nav-fill" id="pills-tab-1" role="tablist">
                                            <li class="nav-item">
                                                <a class="nav-link active" id="pills-home-tab-fill"
                                                    data-bs-toggle="pill" href="#pills-home-fill" role="tab"
                                                    aria-controls="pills-home" aria-selected="true">Home</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" id="pills-profile-tab-fill" data-bs-toggle="pill"
                                                    href="#pills-profile-fill" role="tab" aria-controls="pills-profile"
                                                    aria-selected="false">Profile</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" id="pills-contact-tab-fill" data-bs-toggle="pill"
                                                    href="#pills-contact-fill" role="tab" aria-controls="pills-contact"
                                                    aria-selected="false">Contact</a>
                                            </li>
                                        </ul>
                                        <div class="tab-content" id="pills-tabContent-1">
                                            <div class="tab-pane fade show active" id="pills-home-fill" role="tabpanel"
                                                aria-labelledby="pills-home-tab-fill">
                                                <p>Lorem Ipsum is simply dummy text of the printing and
                                                    typesetting industry. Lorem Ipsum has been the
                                                    industry's standard dummy text ever since the 1500s,
                                                    when an unknown printer took a galley of type and
                                                    scrambled it to make a type specimen book.</p>
                                            </div>
                                            <div class="tab-pane fade" id="pills-profile-fill" role="tabpanel"
                                                aria-labelledby="pills-profile-tab-fill">
                                                <p>Lorem Ipsum is simply dummy text of the printing and
                                                    typesetting industry. Lorem Ipsum has been the
                                                    industry's standard dummy text ever since the 1500s,
                                                    when an unknown printer took a galley of type and
                                                    scrambled it to make a type specimen book.</p>
                                            </div>
                                            <div class="tab-pane fade" id="pills-contact-fill" role="tabpanel"
                                                aria-labelledby="pills-contact-tab-fill">
                                                <p>Lorem Ipsum is simply dummy text of the printing and
                                                    typesetting industry. Lorem Ipsum has been the
                                                    industry's standard dummy text ever since the 1500s,
                                                    when an unknown printer took a galley of type and
                                                    scrambled it to make a type specimen book.</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card">
                            <div class="card-header d-flex justify-content-between">
                                <div class="header-title">
                                    <h4 class="card-title">Tooltips</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <p>Hover over the buttons below to see the four tooltips directions: top, right, bottom,
                                    and left. The data-placement attribute specifies the tooltip position.</p>

                                <button type="button" class="btn btn-secondary" data-bs-toggle="tooltip"
                                    data-bs-placement="top" data-bs-title="Tooltip on top">
                                    Tooltip on top
                                </button>
                                <button type="button" class="btn btn-secondary" data-bs-toggle="tooltip"
                                    data-bs-placement="right" data-bs-title="Tooltip on right">
                                    Tooltip on right
                                </button>
                                <button type="button" class="btn btn-secondary" data-bs-toggle="tooltip"
                                    data-bs-placement="bottom" data-bs-title="Tooltip on bottom">
                                    Tooltip on bottom
                                </button>
                                <button type="button" class="btn btn-secondary" data-bs-toggle="tooltip"
                                    data-bs-placement="left" data-bs-title="Tooltip on left">
                                    Tooltip on left
                                </button>

                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Always Open Accordion</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="accordion" id="accordionPanelsStayOpenExample">
                                            <div class="accordion-item accordion-itemstyle">
                                                <h2 class="accordion-header" id="panelsStayOpen-headingOne">
                                                    <button
                                                        class="accordion-button accordion-itemstylena accordion-primary-button "
                                                        type="button" data-bs-toggle="collapse"
                                                        data-bs-target="#panelsStayOpen-collapseOne"
                                                        aria-expanded="true"
                                                        aria-controls="panelsStayOpen-collapseOne">Accordion
                                                        Item #1</button>
                                                </h2>
                                                <div id="panelsStayOpen-collapseOne"
                                                    class="accordion-collapse collapse show"
                                                    aria-labelledby="panelsStayOpen-headingOne">
                                                    <div class="accordion-body">
                                                        <strong>This is the first item's accordion body.</strong> It
                                                        is shown by default, until the collapse plugin adds the
                                                        appropriate classes that we use to style each element. These
                                                        classes control the overall appearance, as well as the
                                                        showing and hiding via CSS transitions. You can modify any
                                                        of this with custom CSS or overriding our default variables.
                                                        It's also worth noting that just about any HTML can go
                                                        within the
                                                        <code>.accordion-body</code>
                                                        , though the transition does limit overflow.
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="accordion-item accordion-itemstyle">
                                                <h2 class="accordion-header" id="panelsStayOpen-headingTwo">
                                                    <button
                                                        class="accordion-button accordion-itemstylena accordion-primary-button collapsed"
                                                        type="button" data-bs-toggle="collapse"
                                                        data-bs-target="#panelsStayOpen-collapseTwo"
                                                        aria-expanded="false"
                                                        aria-controls="panelsStayOpen-collapseTwo">Accordion
                                                        Item #2</button>
                                                </h2>
                                                <div id="panelsStayOpen-collapseTwo" class="accordion-collapse collapse"
                                                    aria-labelledby="panelsStayOpen-headingTwo">
                                                    <div class="accordion-body">
                                                        <strong>This is the second item's accordion body.</strong>
                                                        It is hidden by default, until the collapse plugin adds the
                                                        appropriate classes that we use to style each element. These
                                                        classes control the overall appearance, as well as the
                                                        showing and hiding via CSS transitions. You can modify any
                                                        of this with custom CSS or overriding our default variables.
                                                        It's also worth noting that just about any HTML can go
                                                        within the
                                                        <code>.accordion-body</code>
                                                        , though the transition does limit overflow.
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="accordion-item accordion-itemstyle">
                                                <h2 class="accordion-header" id="panelsStayOpen-headingThree">
                                                    <button
                                                        class="accordion-button accordion-itemstylena accordion-primary-button collapsed"
                                                        type="button" data-bs-toggle="collapse"
                                                        data-bs-target="#panelsStayOpen-collapseThree"
                                                        aria-expanded="false"
                                                        aria-controls="panelsStayOpen-collapseThree">
                                                        Accordion Item #3</button>
                                                </h2>
                                                <div id="panelsStayOpen-collapseThree"
                                                    class="accordion-collapse collapse"
                                                    aria-labelledby="panelsStayOpen-headingThree">
                                                    <div class="accordion-body">
                                                        <strong>This is the third item's accordion body.</strong> It
                                                        is hidden by default, until the collapse plugin adds the
                                                        appropriate classes that we use to style each element. These
                                                        classes control the overall appearance, as well as the
                                                        showing and hiding via CSS transitions. You can modify any
                                                        of this with custom CSS or overriding our default variables.
                                                        It's also worth noting that just about any HTML can go
                                                        within the
                                                        <code>.accordion-body</code>
                                                        , though the transition does limit overflow.
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-12 col-12">
                        <div class="card card-block card-stretch card-height">
                            <div class="card-header">
                                <div class="header-title">
                                    <h4 class="card-title">Flush Accordion</h4>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                                        <div class="accordion accordion-flush" id="accordionFlushExample">
                                            <div class="accordion-item">
                                                <h2 class="accordion-header" id="flush-headingOne">
                                                    <button
                                                        class="accordion-button accordion-itemstylena accordion-primary-button collapsed"
                                                        type="button" data-bs-toggle="collapse"
                                                        data-bs-target="#flush-collapseOne" aria-expanded="false"
                                                        aria-controls="flush-collapseOne">
                                                        Accordion Item #1
                                                    </button>
                                                </h2>
                                                <div id="flush-collapseOne" class="accordion-collapse collapse"
                                                    aria-labelledby="flush-headingOne"
                                                    data-bs-parent="#accordionFlushExample">
                                                    <div class="accordion-body">Placeholder content for this accordion,
                                                        which is intended to demonstrate the
                                                        <code>.accordion-flush</code> class. This is the first item's
                                                        accordion body.</div>
                                                </div>
                                            </div>
                                            <div class="accordion-item">
                                                <h2 class="accordion-header" id="flush-headingTwo">
                                                    <button
                                                        class="accordion-button accordion-itemstylena accordion-primary-button collapsed"
                                                        type="button" data-bs-toggle="collapse"
                                                        data-bs-target="#flush-collapseTwo" aria-expanded="false"
                                                        aria-controls="flush-collapseTwo">
                                                        Accordion Item #2
                                                    </button>
                                                </h2>
                                                <div id="flush-collapseTwo" class="accordion-collapse collapse"
                                                    aria-labelledby="flush-headingTwo"
                                                    data-bs-parent="#accordionFlushExample">
                                                    <div class="accordion-body">Placeholder content for this accordion,
                                                        which is intended to demonstrate the
                                                        <code>.accordion-flush</code> class. This is the second item's
                                                        accordion body. Let's imagine this being filled with some actual
                                                        content.</div>
                                                </div>
                                            </div>
                                            <div class="accordion-item">
                                                <h2 class="accordion-header" id="flush-headingThree">
                                                    <button
                                                        class="accordion-button accordion-itemstylena accordion-primary-button collapsed"
                                                        type="button" data-bs-toggle="collapse"
                                                        data-bs-target="#flush-collapseThree" aria-expanded="false"
                                                        aria-controls="flush-collapseThree">
                                                        Accordion Item #3
                                                    </button>
                                                </h2>
                                                <div id="flush-collapseThree" class="accordion-collapse collapse"
                                                    aria-labelledby="flush-headingThree"
                                                    data-bs-parent="#accordionFlushExample">
                                                    <div class="accordion-body">Placeholder content for this accordion,
                                                        which is intended to demonstrate the
                                                        <code>.accordion-flush</code> class. This is the third item's
                                                        accordion body. Nothing more exciting happening here in terms of
                                                        content, but just filling up the space to make it look, at least
                                                        at first glance, a bit more representative of how this would
                                                        look in a real-world application.</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </div>
            
     <!-- Datagrid start -->
    <script src="assets/vendor/treegrid/custom-treegrid.js"></script>
    <!-- Datagrid end -->
    <!-- Datepicker Start-->
    <script nonce="${cspNonce}">
        $(document).ready(function () {
            var valid_dt = '${valid_dt}';
            var y = valid_dt.substring(0, 4);
            var m = valid_dt.substring(5, 7);
            var d = valid_dt.substring(8, 10);
            var valid_dt1 = d + "/" + m + "/" + y;
            var today = new Date();
            var yyyy = today.getFullYear();
            var mm = today.getMonth() + 1; // Months start at 0!
            var dd = today.getDate();
            if (dd < 10)
                dd = '0' + dd;
            if (mm < 10)
                mm = '0' + mm;
            today = dd + '/' + mm + '/' + yyyy;
            var valid_dt2 = valid_dt.split('/').reverse().join('-');
            var today2 = today.split('/').reverse().join('-');
            if ("${hid}" != "3" && valid_dt2 <= today2) {
                datepicketDate('dob');
            }
        });
    </script>
    <!-- Datepicker End-->
    