<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script src="assets/dev_module_list/FFL/bulletinApproval.js"></script>
<script src="assets/dev_module_list/jquery-confirm.min.js"></script>

<div class="content-page" id="approvalBulletinDiv">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                <div class="custom-breadcrum">
                    <div class="iq-members">
                        <h1 class="page-title">Approval Bulletin</h1>
                    </div>
                    <div class="page-breadcrumb">
                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="${dashboardurl}">Dashboard</a></li>
                                <li class="breadcrumb-item active" aria-current="approvalBulletinPage">Approval Bulletin</li>
                            </ol>
                        </nav>
                    </div>
                </div>
            </div>
        </div>

        <div class="row mt-5">
            <div class="col-lg-12 col-md-12 col-sm-12 col-12">
                <div class="card">
                    <div class="card-body">
                        <table id="approvalBulletinTable" class="table data-table table-striped table-hover custom-datatable datatable-responsive">
                            <thead>
                                <tr>
                                    <th>Sr No.</th>
                                    <th>Bulletin ID</th>
									<th>Title</th>
                                    <th>Requested By</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody id="approvalBulletinTableBody">
                                <!-- Dynamically populated rows will appear here -->
                                <!--<c:forEach var="approvalBulletin" items="${approvalBulletins}">
                                    <tr>
                                        <td>${approvalBulletin.id}</td>
                                        <td>${approvalBulletin.bulletin_id}</td>
                                        <td>${approvalBulletin.username}</td>
                                        <td>
                                            <button class="btn btn-primary btn-sm request-btn"
                                                data-bulletin-id="${approvalBulletin.bulletin_id}"
                                                data-username="${approvalBulletin.username}"
                                                ${approvalBulletin.approvalStatus eq 't' ? 'disabled' : ''}>
                                                ${approvalBulletin.approvalStatus eq 't' ? 'Requested' : 'Request'}
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>-->
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
