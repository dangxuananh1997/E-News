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

	$('#updatePasswordForm').validate({
		rules: {
			oldPassword: {
				required: true,
				notEmptyString: true
			},
			newPassword: {
				required: true,
				strongPassword: true
			},
			newPasswordConfirm: {
				required: true,
				equalTo: '#newPassword'
			},
			code: {
				required: true,
				equalTo: '#code'
			}
		},
		messages: {
			oldPassword: {
				required: 'Old Password is required!'
			},
			newPassword: {
				required: 'New Password is required!'
			},
			newPasswordConfirm: {
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
	$('#btn-password').on('click', function() {
		$('#updatePasswordForm').valid();
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
