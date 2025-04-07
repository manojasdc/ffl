<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec"
    uri="http://www.springframework.org/security/tags"%>
    <link rel="stylesheet" href="admin/assets/css/outercss/outer_style.css">
    
    <section class="section gallery">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-12 text-center ">
                        <div class="section-heading gallery-heading">
                            
                            <h2>Photo Gallery</h2>
                        </div>
                    </div>
                </div>
                <%--             <ul class="event_filter" id="event_filter">${ulString}</ul> --%>
                <div class="row event_box" id="homepageEventPhotoes">
                    <%--             ${photoesString} --%>
                    <div class="row event_box __web-inspector-hide-shortcut__" id="homepageEventPhotoes">
                        <c:forEach var="map" items="${getPhotos}">
                                    <div class="col-lg-4 col-md-6 col-sm-12 col-12 align-self-center mb-30 event_outer IAF E &amp; C Society">
                                        <div class="events_item">
                                            <div class="thumb">
                                                <a href="#"><img class="card-image"
                                                    src="${map['imageurl']}" alt=""
                                                    title="This title is Static"></a>
                                            </div>
                                        </div>
                                    </div>
                            </c:forEach>
               
                </div>
            </div>
        </section>
