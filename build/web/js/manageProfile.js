$(document).ready(function(){
    $('input[type="file"].profile-pic-upload').change(function(e){
    	var fileName = e.target.files[0].name;
        $('label.btn').text(fileName);
    });
});