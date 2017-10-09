<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>'Action'(New/Edit) Aritcle</title>
	<script type="text/javascript" src="js/config.js"></script>

	<!-- summernote -->
	<link rel="stylesheet" type="text/css" href="summernote/dist/summernote-bs4.css">
	<script type="text/javascript" src="summernote/dist/summernote-bs4.min.js"></script>
    
	<link rel="stylesheet" type="text/css" href="css/articleEditing.css">
	<script type="text/javascript" src="js/articleEditing.js"></script>
</head>
<body>
	<div class="e-navbar"></div>

	<form class="container">

		<div class="form-group">
			<label for="title"><h3>Title</h3></label>
			<input type="text" class="form-control" name="title" placeholder="Article title">
		</div>

		<input type="file" name="feature-picture-upload" class="feature-picture-upload" accept=".jpg, .jpeg, .png">
		<label class="btn btn-outline-primary" for="feature-picture-upload">Upload New Feature Picture</label>

		<a class="btn btn-outline-primary" data-toggle="modal" data-target="#choosePicture">Choose Existed Feature Picture</a>
		<input type="hidden" name="existed-feature-picture">

		<div id="summernote"></div>

		<input type="hidden" name="content" id="content">

		<button class="btn btn-success">Submit</button>
		<button class="btn btn-info">Back</button>
	</form>

	<!-- Modal -->
	<div class="modal fade" id="choosePicture" tabindex="-1" role="dialog" aria-labelledby="choosePictureLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="choosePictureLabel">Choose Feature Picture</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					Pictures
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Accept</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="e-footer"></div>
</body>
</html>