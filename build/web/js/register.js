$(function() {
	$.validator.setDefaults({
		errorClass: 'help-block',
		highlight: function(element) {
		  	$(element).closest('.form-group').addClass('has-danger');
		},
		unhighlight: function(element) {
			$(element).closest('.form-group').removeClass('has-danger');
		},
	    errorPlacement: function (error, element) {
	      	if (element.prop('type') === 'checkbox') {
		        error.insertAfter(element.parent());
			} else {
	        	error.insertAfter(element);
			}
	    }
	});

	$.validator.addMethod("notEmptyString", function (value, element, regexp) {
            var re = new RegExp('^(?=.*[a-zA-Z0-9])');
            return this.optional(element) || re.test(value);
        },
        "Empty String!"
    );

    $.validator.addMethod("strongPassword", function (value, element, regexp) {
            var re = new RegExp('^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{6,})');
            return this.optional(element) || re.test(value);
        },
        "Password must contains at least 1 lowercase, 1 uppercase, 1 number and has at least 6 characters!"
    );

	$.validator.addMethod("validName", function (value, element, regexp) {
            var re = new RegExp('^[a-zA-Z\\s]*$');
            return this.optional(element) || re.test(value);
        },
        "Not a valid name!"
    );

	$('#registerForm').validate({
		rules: {
			email: {
				email: true,
				required: true
			},
			name: {
				required: true,
				validName: true,
				notEmptyString: true
			},
			password: {
				required: true,
				notEmptyString: true,
				strongPassword: true
			},
			passwordConfirm: {
				required: true,
				equalTo: '#password'
			},
			code: {
				required: true,
				equalTo: '#code'
			},
			acceptTerms: {
				required: true
			}
		},
		messages: {
			email: {
				required: 'Email is required!'
			},
			name: {
				required: 'Full Name is required!'
			},
			password: {
				required: 'Password is required!'
			},
			passwordConfirm: {
				required: 'Confirm Password is required!',
				equalTo: 'Password not match!'
			},
			code: {
				required: 'Security Code is required!',
				equalTo: 'Incorrect Code! '
			},
			acceptTerms: {
				required: 'Accept our terms and conditions to continue!'
			}
		}
	});
});


$(document).ready(function() {
	$('.btn-success').on('click', function() {
		$('#registerForm').valid();
	});
	var code = makeCode()
	$('#code').val(code);
	$('.security-code').html(code);
});

function makeCode() {
	var text = "";
	var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	for (var i = 0; i < 8; i++)
		text += possible.charAt(Math.floor(Math.random() * possible.length));

	return text;
}
