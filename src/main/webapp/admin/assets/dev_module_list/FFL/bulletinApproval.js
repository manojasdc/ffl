$(document).ready(function() {
	function getAllApprovalBulletins() {
		$.ajax({
			url: '../admin/getAllApprovalBulletins',
			type: 'GET',
			dataType: 'json',
			success: function(response) {
				console.log(response);

				// Destroy existing DataTable instance if it exists
				if ($.fn.DataTable.isDataTable('#approvalBulletinTable')) {
					$('#approvalBulletinTable').DataTable().destroy();
				}

				// Initialize DataTable with explicit column definitions
				$('#approvalBulletinTable').DataTable({
					data: response, // Pass response directly to DataTable
					columns: [
						{ title: "#", data: null, render: (data, type, row, meta) => meta.row + 1 },
						{ title: "Bulletin ID", data: "bulletin_id" },
						{ title: "Title", data: "title" },
						{ title: "Username", data: "username" },
						{
							title: "Actions",
							data: null,
							render: function(data, type, row) {
								return `
                                    <button class="btn btn-primary btn-sm approve-btn" data-bulletin-id="${row.bulletin_id}" data-username="${row.username}">Approve</button>
                                    <button class="btn btn-danger btn-sm reject-btn" data-bulletin-id="${row.bulletin_id}" data-username="${row.username}">Reject</button>
                                `;
							}
						}
					],
					paging: true,
					searching: true,
					ordering: true,
					responsive: true,
					language: {
						emptyTable: 'No approval bulletins available',
					}
				});
			},
			error: function(xhr, status, error) {
				console.log('Error fetching approval bulletins:', error);
				alert('Failed to fetch approval bulletins: ' + xhr.responseText);
			}
		});
	}

	// Click event for Approve button
	$('#approvalBulletinTable').off('click', '.approve-btn').on('click', '.approve-btn', function() {
		var button = $(this);
		var bulletinId = button.data('bulletin-id');
		var username = button.data('username');

		updateApprovalStatus(bulletinId, username, "APPROVED");
	});

	// Click event for Reject button
	$('#approvalBulletinTable').off('click', '.reject-btn').on('click', '.reject-btn', function() {
		var button = $(this);
		var bulletinId = button.data('bulletin-id');
		var username = button.data('username');

		updateApprovalStatus(bulletinId, username, "REJECTED");
	});

	// Function to update approval status via AJAX
	function updateApprovalStatus(bulletinId, username, status) {
		var requestData = {
			bulletin_id: bulletinId,
			username: username,
			status: status
		};

		$.ajax({
			url: '../admin/updateApprovalStatus',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(requestData),
			success: function(data) {
				alert(data); // Show success message
				getAllApprovalBulletins(); // **Refresh the table after success**
			},
			error: function(xhr, status, error) {
				alert(xhr.responseText);
			}
		});
	}

	getAllApprovalBulletins(); // Load table on page load
});
