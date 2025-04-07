

function toggleLight(){	
	  var body = document.getElementById("body");
  	  var currentClass = body.className;  	  	  
  if(currentClass.includes("dark-mode")){		  	
		  currentClass =  currentClass.replace("dark-mode",'light-mode');	  	  
		  body.className = currentClass;
		  $("#light").removeClass("active");
		  $("#dark").addClass("active");
//		  $(this).currentTarget.className += " active";	
		  localStorage.setItem('thememode', 'lightmode');	  	 
  }
}

function toggleDark(){	
  var body = document.getElementById("body");
	  var currentClass = body.className;
	  if(currentClass.includes("light-mode")){
	  currentClass =  currentClass.replace("light-mode",'dark-mode');	  
	  body.className = currentClass;
	  $("#dark").removeClass("active");
	  $("#light").addClass("active");
//	  $(this).currentTarget.className += " active";	  
	  localStorage.setItem('thememode', 'darkmode');
  }	  	 
}

jQuery(document).ready(function() {
 		
 		/* theme mode (front) start*/ 		
 			if(localStorage.getItem('thememode') == 'lightmode'){ 				
 				toggleLight();
 			}
 			else if(localStorage.getItem('thememode') == 'darkmode'){ 				
 				toggleDark();	
 			}
});


document.addEventListener('DOMContentLoaded', function() {
	
//	document.getElementById('dark').onclick = function() {
//		toggleDark();
//	};
//	
//	document.getElementById('light').onclick = function() {
//		toggleLight();
//	};
});

