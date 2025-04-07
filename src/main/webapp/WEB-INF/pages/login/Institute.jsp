<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
    uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet" href="admin/assets/css/outercss/outer_style.css">

<section class="section gallery">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-12 text-center">
                <div class="section-heading gallery-heading">
                    <h2>CAT 'A' & 'B' EST</h2>
                </div>
            </div>
        </div>
        <div class="team-boxed">
            <div class="row g-4">
                <c:forEach var="map" items="${institute}">
                <div class="col-xl-2 col-lg-3 col-md-4 col-sm-6 col-12">
                    <div class="box box1">
                        <div class="diffimagecss">
                            <img class="img-fluid" src="${map.imageurl}" alt="Institute Image">
                        </div>
                        <div class="diffh3div">
                            <h3 class="name">${map.text}</h3>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
    </div>
</section>