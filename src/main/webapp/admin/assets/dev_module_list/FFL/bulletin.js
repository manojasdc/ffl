$(document).ready(function() {
	var today = new Date().toISOString().split('T')[0];
	$('#bulletinDate').val(today);
	$('#submitComment').on('click', function() {
		var bulletinId = $('#commentModal').data('bulletin-id');
		var commentText = $('#newComment').val().trim();

		if (commentText !== '') {
			var commentData = {
				bulletin: { id: bulletinId },   // Wrap ID inside an object
				comment: commentText
			};

			console.log("Submitting comment:", JSON.stringify(commentData));

			$.ajax({
				url: '../admin/submitComment',
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify(commentData),
				success: function(response) {
					console.log('Comment added:', response);
					alert('Comment added successfully!');
					$('#newComment').val('');
					fetchComments(bulletinId); // Refresh comments after successful submission
				},
				error: function(xhr, status, error) {
					console.log('Error adding comment:', error);
					alert('Failed to add comment: ' + xhr.responseText);
				}
			});
		} else {
			alert('Please enter a comment!');
		}
	});

	// Handle bulletin submission
	$('#createbulletin').on('submit', function(e) {
		e.preventDefault();

		// Collect form data
		var bulletinData = {
			title: $('#title').val().trim(),
			description: $('#description').val().trim(),
		};

		if (!bulletinData.title || !bulletinData.description) {
			alert("Please fill out all fields!");
			return;
		}

		console.log("Submitting bulletin:", bulletinData);

		$.ajax({
			url: '../admin/submitBulletin',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(bulletinData),
			success: function(response) {
				alert('Bulletin submitted successfully!');
				$('#reset').click();
				$('#bulletinDate').val(today);
				getAllBulletins();
			},
			error: function(xhr) {
				alert('Failed to submit bulletin: ' + xhr.responseText);
			}
		});
	});

	// Fetch all bulletins
	// Fetch all bulletins
	function getAllBulletins() {
	    $.ajax({
	        url: '../admin/getAllBulletin',
	        type: 'GET',
	        dataType: 'json',
	        success: function(response) {
	            console.log('Server Response:', response);

	            if ($.fn.DataTable.isDataTable('#bulletintable')) {
	                $('#bulletintable').DataTable().destroy();
	            }

	            var tableBody = $('#bulletintableBody');
	            tableBody.empty();

	            if (response && response.length > 0) {
	                // Sort bulletins by ID (or date)
	                response.sort((a, b) => a.bulletin_id - b.bulletin_id); // Ensure ascending order

	                response.forEach(function (bulletin, index) {
	                    var actionButton = '';

	                    if (bulletin.approval_status === "APPROVED" || bulletin.approval_status === "T") {
	                        actionButton = '<button class="btn btn-primary btn-sm comment-btn" ' +
	                            'data-id="' + bulletin.bulletin_id + '" data-title="' + bulletin.title + '">' +
	                            '<i class="fa fa-comment"></i> Comment</button>';
	                    } else if (bulletin.approval_status === "PENDING") {
	                        actionButton = '<button class="btn btn-secondary btn-sm request-btn" disabled>' +
	                            '<i class="fa fa-clock"></i> Requested</button>';
	                    } else {
	                        actionButton = '<button class="btn btn-primary btn-sm request-btn" ' +
	                            'data-id="' + bulletin.bulletin_id + '">' +
	                            '<i class="fa fa-envelope"></i> Request</button>';
	                    }

	                    var row = '<tr>' +
	                        '<td>' + (index + 1) + '</td>' +
	                        '<td>' + bulletin.title + '</td>' +
	                        '<td>' + bulletin.description + '</td>' +
	                        '<td>' + formatDate(bulletin.date) + '</td>' +
	                        '<td>' + actionButton + '</td>' +
	                        '</tr>';

	                    tableBody.append(row);
	                });
	            }

	            $('#bulletintable').DataTable({
	                paging: true,
	                searching: true,
	                ordering: true,
	                order: [[0, 'asc']], // Ensure consistent order based on ID
	                responsive: true,
	                language: {
	                    emptyTable: 'No bulletins available',
	                }
	            });
	        },
	        error: function(xhr, status, error) {
	            console.log('Error fetching bulletins:', error);
	            alert('Failed to fetch bulletins: ' + xhr.responseText);
	        }
	    });
	}


	$('#bulletintable').off('click', '.request-btn').on('click', '.request-btn', function() {
	    var button = $(this); // Store reference to the button
	    var bulletinId = button.data('id');

	    requestApproval(bulletinId);

	    // Disable the button after clicking
	    button.prop('disabled', true).text('Requested');
	});
	$('#bulletintable').off('click', '.comment-btn').on('click', '.comment-btn', function() {
		var bulletinId = $(this).data('id');
		var bulletinTitle = $(this).data('title');

		console.log('Bulletin ID:', bulletinId);

		$('#commentModal').data('bulletin-id', bulletinId);
		$('#bulletinTitle').text(bulletinTitle);

		fetchComments(bulletinId);
	});

	function requestApproval(bulletinId) {
		$.ajax({
			url: '../admin/requestApproval/' + bulletinId,
			type: 'POST',
			dataType: 'json',
			success: function(data) {
				console.log(data);
			},
			error: function(xhr, status, error) {

				alert(xhr.responseText);
			}
		})
	}
	function formatDate(dateArray) {
	    if (!dateArray || dateArray.length < 3) return 'N/A';

	    var year = ('0' + dateArray[0]).slice(-2); // Ensure two digits
	    var month = ('0' + dateArray[1]).slice(-2); // Ensure two digits
	    var day = dateArray[2];

	    return `${day}/${month}/${year}`; // Format: DD/MM/YYYY
	}

	// Fetch and display comments
	function fetchComments(bulletinId) {
		$.ajax({
			url: '../admin/getComments/' + bulletinId,
			type: 'GET',
			dataType: 'json',
			success: function(comments) {
				var modalBody = $('#commentModalBody');
				modalBody.empty();

				if (comments && comments.length > 0) {
					comments.forEach(function(comment) {
						modalBody.append('<p>' + comment.comment + '</p><hr>');
					});
				} else {
					modalBody.append('<p>No comments found for this bulletin.</p>');
				}
				$('#commentModal').data('bulletin-id', bulletinId);
				$('#commentModal').modal('show');
			},
			error: function(xhr, status, error) {
				console.log('Error fetching comments:', error);
				alert('Failed to fetch comments: ' + xhr.responseText);
			}
		});
	}

	getAllBulletins();
});

/*'<button class="btn btn-primary btn-sm comment-btn" ' +
							'data-id="' + bulletin.id + '" data-title="' + bulletin.title + '">' +*/
							

							/*'<i class="fa fa-comment"></i> Comment</button>' +*/