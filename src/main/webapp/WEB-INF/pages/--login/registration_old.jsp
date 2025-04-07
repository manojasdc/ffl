<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Bisag-N</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="admin/login_file/images/favicon.png" rel="icon">

  <!-- Vendor CSS Files -->
  <link href="admin/login_file/assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link href="admin/login_file/assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="admin/login_file/assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="admin/login_file/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="admin/login_file/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="admin/login_file/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="admin/login_file/assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="admin/login_file/assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="admin/login_file/assets/css/style.css" rel="stylesheet">
  
</head>
<body style="padding-top: 140px;    background-color: #f7fcfc;">
 <!-- ======= Header ======= -->
  <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">
<!--       <a href="index.html" class="logo me-auto"><img src="admin/login_file/assets/img/amclogo.png" alt=""></a> -->
      <h1 class="logo me-auto"><a href="#">AFMS</a></h1>

      <nav id="navbar" class="navbar order-last order-lg-0">
        <ul>
          <li><a class="nav-link scrollto " href="login">Home</a></li>         
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->
      
    </div>
  </header><!-- End Header -->
  
<div class="container mt-3">
<div class="col-4 mt-3 w3-border w3-padding ws-lightgreen" style="border-radius: 4px 4px 0px 0px;">
<h5 class="m-0">Registration Form</h5>
</div>
  <div class="container-fluid w3-border w3-padding  ws-grey mb-3" style="border-radius: 0px 4px 4px 4px;">
    <div class="mb-3 mt-3">
      <label for="name">Adharcard Number OR NEET Registration Number </label>
      <input type="number" class="form-control" id="reg" placeholder="adhar number or neet reg number" name="email">
    </div>
     <div class="mb-3 mt-3">
      <label for="email">Email </label>
      <input type="email" class="form-control" id=email placeholder="enter your email" name="email">
    </div>
      <div class="mb-3 mt-3">
      <label for="name">Name</label>
      <input type="text" class="form-control"  placeholder="your name" name="name">
    </div>
      <div class="mb-3 mt-3">
      <label for="dob">Date Of Birth</label>
      <input type="text" class="form-control"  placeholder="your mobile number" name="dob">
    </div>  <div class="mb-3 mt-3">
      <label for="gender">Gender</label>
      <div class="d-flex">
      <div class="form-check">
      <input type="radio" class="form-check-input" id="radio1" name="optradio" value="option1" checked>
      <label class="form-check-label" for="radio1">Male &nbsp;&nbsp;&nbsp;&nbsp;</label>
    </div>
    <div class="form-check">
      <input type="radio" class="form-check-input" id="radio2" name="optradio" value="option2">
      <label class="form-check-label" for="radio2">Female</label>
    </div>   
    </div> 
    </div>
      <div class="mb-3 mt-3">
      <label for="address">Address</label>
      <input type="number" class="form-control"  placeholder="your address" name="address">
    </div>
     <div class="mb-3 mt-3">
      <label for="attmpnub">Attemp Number</label>
      <input type="number" class="form-control"  placeholder="attemp number" name="attmpnub">
    </div>
      <div class="mb-3 mt-3">
      <label for="regnum">Previous your Registation Number</label>
      <input type="number" class="form-control"  placeholder="Previous registation number" name="regnum">
    </div> 
    
    <div class="mb-3 mt-3">
    <label for="sel1" class="form-label">Select Document</label>
    <select class="form-select" id="sel1" name="sellist1">
      <option>degree certificate</option>
      <option>marksheet certificate</option>
      <option>dob certificate</option>
      <option>sponsorship certificate</option>
      <option>attemp certificate</option>
      <option>medical certificate</option>
    </select>
    </div>
    
    <div class="mb-3 mt-3">
    <label for="sel1" class="form-label">Upload Document</label>
     <input type="file" class="form-control"  placeholder="upload your document" name="">
    </div>
        
    <button type="button" class="btn btn btn-success mb-3">Submit</button>
</div>
</div>

</body>
</html>
