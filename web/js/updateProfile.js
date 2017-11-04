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
	      	if (element.prop('type') === 'number') {
		        error.insertAfter(element.parent());
		        error.wrap('<div></div>')
			} else if (element.prop('type') === 'radio') {
				error.insertAfter(element.parent().parent().children().last());
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

	$.validator.addMethod("validName", function (value, element, regexp) {
            var re = new RegExp('^[a-zA-Z\\s]*$');
            return this.optional(element) || re.test(value);
        },
        "Not a valid name!"
    );

	$('#updateProfileForm').validate({
		rules: {
			fullName: {
				required: true,
				notEmptyString: true,
				validName: true
			},
			day: {
				required: true,
				min: 1,
				max: 31
			},
			month: {
				required: true,
				min: 1,
				max: 12
			},
			year: {
				required: true,
				min: 1900,
				max: 2017
			},
			genderID: {
				required: true
			},
			address: {
				required: true,
				notEmptyString: true
			},
			phone: {
				required: true,
				number: true,
				min: 1000000000,
				max: 99999999999
			}
		},
		messages: {
			fullName: {
				required: 'Full Name is required!'
			},
			day: {
				required: 'Date is required!',
				min: 'Invalid Date!',
				max: 'Invalid Date!'
			},
			month: {
				required: 'Month is required!',
				min: 'Invalid Month!',
				max: 'Invalid Month!'
			},
			year: {
				required: 'Year is required!',
				min: 'Year must be bigger than 1900!',
				max: 'Year must be smaller than 2017!'
			},
			genderID: {
				required: 'Gender is required!'
			},
			address: {
				required: 'Address is required!'
			},
			phone: {
				required: 'Phone is required!',
				number: 'Invalid Phone number!',
				min: 'Invalid Phone number!',
				max: 'Invalid Phone number!',
			}
		}
	})
});


$(document).ready(function() {
	$('#btn-profile').on('click', function() {
		$('#updateProfileForm').valid();
	});
});
