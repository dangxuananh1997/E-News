$(function() {
	$.validator.setDefaults({
		errorClass: 'help-block',
		highlight: function(element) {
		  	$(element).closest('.form-group').addClass('has-danger');
		},
		unhighlight: function(element) {
			$(element).closest('.form-group').removeClass('has-danger');
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

	$('#resetPassword').validate({
		rules: {
			email: {
				email: true,
				required: true
			},
			code: {
				required: true,
				equalTo: '#code'
			},
			phone: {
				required: true,
				number: true,
				min: 1000000000,
				max: 99999999999
			}
		},
		messages: {
			email: {
				required: 'Email is required!'
			},
			code: {
				required: 'Security Code is required!',
				equalTo: 'Incorrect Code! '
			},
			phone: {
				required: 'Phone is required!',
				number: 'Invalid Phone number!',
				min: 'Invalid Phone number!',
				max: 'Invalid Phone number!',
			}
		}
	});

	$('#newPassword').validate({
		rules: {
			newPassword: {
				strongPassword: true,
				required: true
			},
			confirmNewPassword: {
				required: true,
				equalTo: 'input#newPassword'
			},
			code: {
				required: true,
				equalTo: '#code'
			}
		},
		messages: {
			newPassword: {
				required: 'New Password is required!'
			},
			confirmNewPassword: {
				required: 'Confirm Password is required!',
				equalTo: 'Password not match!'
			},
			code: {
				required: 'Security Code is required!',
				equalTo: 'Incorrect Code! '
			}
		}
	});
});


$(document).ready(function() {
	$('#btn-reset').on('click', function() {
		$('#resetPassword').valid();
	});
	$('#btn-new').on('click', function() {
		$('#newPassword').valid();
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
