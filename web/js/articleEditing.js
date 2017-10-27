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

	$('button.btn').click(function() {
		var markupStr = $('#summernote').summernote('code');
		$('#content').val(markupStr);
	});

    $('input[type="file"].feature-picture-upload').change(function(e){
    	var fileName = e.target.files[0].name;
        $('label.btn').text(fileName);
    });
	
});