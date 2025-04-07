$(document).ready(function() {

	if (window.location.href.includes("?")) {
		var urlWithQueryString = window.location.href;
		var urlWithoutQueryString = urlWithQueryString.split("?")[0];
		window.history.pushState({}, document.title, urlWithoutQueryString);
		sessionStorage.setItem("urlWithQueryString", urlWithQueryString);
		sessionStorage.setItem("urlWithoutQueryString", urlWithoutQueryString);
	} else {
		var storedUrlWithQueryString = sessionStorage.getItem("urlWithQueryString");
		var storedUrlWithoutQueryString = sessionStorage.getItem("urlWithoutQueryString");
		if (storedUrlWithQueryString && storedUrlWithoutQueryString) {
			if (storedUrlWithoutQueryString == window.location.href) {
				window.location.href = storedUrlWithQueryString;
			}
		}
	}

});