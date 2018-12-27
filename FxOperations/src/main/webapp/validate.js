function ValidateForm() {
	var username = document.getElementById("email");

	var password = document.getElementById("password");

	removeMessage();
	var valid = true;
	if (username.value.length == 0) {
		username.className = "wrong-input";
		username.nextElementSibling.innerHTML = "Username can't be blank";
		valid = false;
	}

	if (password.value.length < 6) {
		password.className = "wrong-input";
		password.nextElementSibling.innerHTML = "Password cannot be less than 6";
		valid = false;
	}

	return valid;
}
function removeMessage() {
	var errorinput = document.querySelectorAll(".wrong-input");
	[].forEach.call(errorinput, function(el) {
		el.classList.remove("wrong-input");
	});

	var errorpara = document.querySelectorAll(".error");
	[].forEach.call(errorpara, function(el) {
		el.innerHTML = "";
	});
}