$(document).ready(function() {

	const togglePassword = document
		.getElementById('togglePassword');

	const password = document.getElementById('password');

	togglePassword.addEventListener('click', () => {

		// Toggle the type attribute using
		// getAttribure() method
		const type = password
			.getAttribute('type') === 'password' ?
			'text' : 'password';

		password.setAttribute('type', type);

		// Toggle the eye and bi-eye icon 
		togglePassword.classList.toggle('fa-eye');
		togglePassword.classList.toggle('fa-eye-slash');

	});
	document.addEventListener('keydown', function(event) {
		if (event.key === "Enter") {
			document.getElementById('loginbutton').click();
		}

	})

});