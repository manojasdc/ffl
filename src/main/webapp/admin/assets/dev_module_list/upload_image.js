$(document).ready(function() {
	// Attach event listener to the 'flag' dropdown
	$('#flag').on('change', function() {
		var flagValue = $(this).val();

		if (flagValue === 'institute') {
			$('#institute_name').prop('disabled', false); // Enable field
		} else {
			$('#institute_name').prop('disabled', true).val(null); // Disable and clear value
		}
	});

	// Submit image upload
	$('#submitPhoto').click(function(event) {
		event.preventDefault();  // Prevent default form submission

		var imageFile = $('#image_file')[0].files[0]; // Get the uploaded file
		var flag = $('#flag').val();
		var instituteName = $('#institute_name').val();

		// Form Validation
		if (!imageFile) {
			alert('Please upload an image file.');
			return;
		}

		// Validate image file type (Allow only jpg, jpeg, png)
		var allowedExtensions = /(\.jpg|\.jpeg|\.png)$/i;
		if (!allowedExtensions.exec(imageFile.name)) {
			alert('Invalid file type. Only JPG, JPEG, and PNG files are allowed.');
			return;
		}

		if (flag === '0') {
			alert('Please select a valid flag');
			return;
		}

		if (flag === 'institute' && !instituteName) {
			alert('Institute Information is required for Institute flag');
			return;
		}

		// Create FormData to send image and other data
		var formData = new FormData();
		formData.append("image", imageFile); // Use the correct key "image"
		formData.append("flag", flag); // Add flag
		formData.append("text", instituteName); // Add institute name if applicable

		// AJAX request to send FormData
		$.ajax({
			url: '../admin/uploadImage',  // Ensure this URL matches your backend endpoint
			type: "POST",
			data: formData,
			contentType: false, // Let jQuery handle the content type
			processData: false, // Let jQuery handle the data
			success: function(response) {
				console.log('Request succeeded');
				console.log('Server Response:', response); // Log the success response
				alert('Photo uploaded successfully: ' + response.message);

				// Optionally, call getAllImages() to refresh the table
				getAllImages();
			},
			error: function(xhr, status, error) {
				console.log('Request failed');
				console.log('Status:', status);  // Status code (e.g., 404, 500)
				console.log('Error:', error);    // Error message
				console.log('Response:', xhr.responseText);  // Detailed response from server
				alert('Error: ' + xhr.responseText);
			}
		});
		$('#flag').val('0');  // Reset flag dropdown
		$('#institute_name').val('').prop('disabled', true);  // Clear and disable institute name
		$('#image_file').val('');  // Clear file input
	});

	// Fetch all images when the page loads or after successful upload
	function getAllImages() {
	    $.ajax({
	        url: '../admin/getAllImages',  // Ensure this URL matches your backend endpoint
	        type: "GET",
	        success: function(response) {
	            console.log('Request succeeded');
	            console.log('Server Response:', response); // Log the success response

	            // Populate the table with image data
	            var images = response.images;

	            // Initialize or destroy DataTable if already initialized
	            if ($.fn.DataTable.isDataTable('#imageTable')) {
	                $('#imageTable').DataTable().destroy();
	            }

	            var tableBody = $('#imageTableBody');
	            tableBody.empty(); // Clear existing rows

	            // Add rows to the table
	            images.forEach(function(image, index) {
	                var row = $('<tr>');
	                row.append('<td>' + (index + 1) + '</td>');  // Set row ID to incremental value (1 to n)
	                row.append('<td>' + image.flag + '</td>');
	                row.append('<td>' + image.text + '</td>');

	                // Use the image path returned from the backend
	                var imageData = image.imagePath;
	                row.append('<td><button class="btn btn-primary btn-sm eye-btn" data-image="' + imageData + '"><i class="fa fa-eye"></i> View</button></td>');
	                row.append('<td><button class="btn btn-danger btn-sm delete-btn" data-id="' + image.id + '"><i class="fa fa-trash"></i> Delete</button></td>');

	                tableBody.append(row);
	            });

	            // Initialize DataTable with pagination, search, and entity count
	            $('#imageTable').DataTable({
	                "paging": true,
	                "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]],
	                "searching": true,
	                "ordering": true,
	                "info": true,
	                "responsive": true,
	                "language": {
	                    "emptyTable": "No images found",
	                    "info": "Showing _START_ to _END_ of _TOTAL_ entries",
	                    "infoEmpty": "Showing 0 to 0 of 0 entries",
	                    "lengthMenu": "Show _MENU_ entries",
	                    "search": "Search:",
	                }
	            });

	            
				$('#imageTable').off('click', '.eye-btn').on('click', '.eye-btn', function() {
				    var imageUrl = $(this).data('image');
				    var baseUrl = window.location.origin;
				    var fullImageUrl = baseUrl + '/FriendsForLife/' + imageUrl.replace('/admin/', '/');

				    var win = window.open();
				    win.document.write('<img src="' + fullImageUrl + '" height="700px" width="900px" />');
				});

				
				$('#imageTable').off('click', '.delete-btn').on('click', '.delete-btn', function() {
				    var imageId = $(this).data('id');
				    if (confirm("Are you sure you want to delete this image?")) {
				        deleteImage(imageId);
				    }
				});

	        },
	        error: function(xhr, status, error) {
	            console.log('Request failed');
	            console.log('Status:', status);  
	            console.log('Error:', error);    
	            console.log('Response:', xhr.responseText);  
	            alert('Error: ' + xhr.responseText);
	        }
	    });
	}

	// Call getAllImages on page load to populate the table initially
	getAllImages();
});

// Function to handle deleting an image
function deleteImage(id) {
    console.log("Delete Image with ID: " + id);
    $.ajax({
        url: '../admin/deleteById/' + id,  // Ensure this URL matches your backend endpoint
        type: 'POST',
        success: function(response) {
            alert('Image deleted successfully!');

            // Remove the row using DataTables API
            var table = $('#imageTable').DataTable();
            table.rows().every(function() {
                var rowId = $(this.node()).find('.delete-btn').data('id');
                if (rowId == id) {
                    this.remove();  // Remove the row from the DataTable
                }
            });

            table.draw(false); // Redraw the table without resetting pagination
        },
        error: function(xhr, status, error) {
            console.log('Request failed');
            console.log('Status:', status);  // Status code (e.g., 404, 500)
            console.log('Error:', error);    // Error message
            console.log('Response:', xhr.responseText);  // Detailed response from server
            alert('Error: ' + xhr.responseText);
        }
    });
}
