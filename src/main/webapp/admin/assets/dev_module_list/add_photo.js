$(document).ready(function() {
    // Attach event listener to the 'flag' dropdown
    $('#flag').on('change', function() {
        var flagValue = $(this).val();
        
        if (flagValue === 'institute') {
            $('#institute_name').prop('disabled', false); // Enable field
        } else {
            $('#institute_name').prop('disabled', true).val(null); // Disable and set value to null
        }
    });

	$('#submitPhoto').click(function(event) {
	    event.preventDefault();  // Prevent form submission to handle validation

	    // Get values from the form fields
	    var imageUrl = $('#image_url').val();
	    var flag = $('#flag').val();
	    var instituteName = $('#institute_name').val();  // Make sure this is correct

	    // Form Validation
	    if (!imageUrl) {
	        alert('Image URL is required');
	        return;
	    }

	    if (flag === '0') {
	        alert('Please select a valid flag');
	        return;
	    }

	    if (flag === 'institute' && !instituteName) {
	        alert('institute Information is required for Institute flag');
	        return;
	    }

	    const jsonData = {
	        imageurl: imageUrl,
	        flag: flag,
	        text: instituteName
	    };

	    // Log the data (You can replace this with an AJAX call or any other logic)
	    $.ajax({
	        url: '../admin/submitPhoto',  // Ensure this URL is correct
	        type: "POST",
	        dataType: 'json', // Expect JSON response
	        data: JSON.stringify(jsonData),
	        contentType: 'application/json',
	        success: function(response) {
	            console.log('Request succeeded');
	            console.log('Server Response:', response); // Log the success response
	            alert('Request was successful: ' + response.message);
	        },
	        error: function(xhr, status, error) {
	            console.log('Request failed');
	            console.log('Status:', status);  // Status code (e.g., 404, 500)
	            console.log('Error:', error);    // Error message (e.g., CORS issue, validation error)
	            console.log('Response:', xhr.responseText);  // Detailed response from server
	            alert('Error: ' + xhr.responseText);
	        }
	    });
	});

});
