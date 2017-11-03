$(function() {
    $.validator.setDefaults({
		errorClass: 'help-block',
		highlight: function(element) {
		  	$(element).closest('.form-group').addClass('has-danger');
		    $('.note-frame').addClass('note-frame-error');
		},
		unhighlight: function(element) {
			$(element).closest('.form-group').removeClass('has-danger');
		    $('.note-frame').removeClass('note-frame-error');
		}
	});

	$.validator.addMethod("notEmptyString", function (value, element, regexp) {
            var re = new RegExp('^(?=.*[a-zA-Z0-9])');
            return this.optional(element) || re.test(value);
        },
        "Empty String!"
    );
    
	$('#articleForm').validate({
		rules: {
			title: {
				required: true,
				notEmptyString: true
			},
			articleContent: {
				required: true	
			}
		},
		messages: {
			title: {
				required: 'Article title is required!'
			},
			articleContent: {
				required: 'Content is required!'	
			}
		}
	});
});

$(document).ready(function() {
	$('#summernote').summernote({
		tabsize: 2,
		minHeight: 470,
		maxHeight: 470,
		toolbar: [
			['style', ['bold', 'italic', 'underline', 'clear']],
			['fontsize', ['fontsize']],
			['color', ['color']],
            ['insert', ['picture', 'link', 'table']],
			['para', ['ul', 'ol', 'paragraph']],
			['height', ['height']],
			['misc', ['codeview']]
		]
	});

	$('#summernote').on('summernote.change', function(we, contents, $editable) {
  		var code = $('#summernote').summernote('code');
		filteredContent = $(code).text().replace(/\s+/g, '');

		if (!filteredContent.trim() == '') {		
			$('#content').val(code);
		}
	});

    $('input[type="file"].feature-picture-upload').change(function(e){
    	var fileName = e.target.files[0].name;
        $('label.btn').text(fileName);
    });

	$('.btn-success').on('click', function() {
		$("#articleForm").valid();
	});

	$('.btn-warning').on('click', function() {
		$("#articleForm").validate().destroy();
	});

});