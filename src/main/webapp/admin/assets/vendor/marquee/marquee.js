
document.addEventListener('DOMContentLoaded', function() {

	document.getElementById('marq_id').onmouseover = function() {
		this.stop();
	};
	document.getElementById('marq_id').onmouseout = function() {
		this.start();		
	};
	
	
});
