<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Edit Article</title>
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

		<div class="form-check">
			<label for="role">Category: </label>
			<label class="form-check-label">
				<input type="radio" class="form-check-input" name="categoryID" value="Science">Science
			</label>
			<label class="form-check-label">
				<input type="radio" class="form-check-input" name="categoryID" value="All">All
			</label>
			<label class="form-check-label">
				<input type="radio" class="form-check-input" name="categoryID" value="Economy">Economy
			</label>
			<label class="form-check-label">
				<input type="radio" class="form-check-input" name="categoryID" value="Entertainment">Entertainment
			</label>
			<label class="form-check-label">
				<input type="radio" class="form-check-input" name="categoryID" value="Politics">Politics
			</label>
			<label class="form-check-label">
				<input type="radio" class="form-check-input" name="categoryID" value="Sports">Sports
			</label>
			<label class="form-check-label">
				<input type="radio" class="form-check-input" name="categoryID" value="Education">Education
			</label>
			<label class="form-check-label">
				<input type="radio" class="form-check-input" name="categoryID" value="Health">Health
			</label>
			<label class="form-check-label">
				<input type="radio" class="form-check-input" name="categoryID" value="Family">Family
			</label>
			<label class="form-check-label">
				<input type="radio" class="form-check-input" name="categoryID" value="Travel">Travel
			</label>
		</div>
		

		<input type="file" name="featureImage" class="feature-picture-upload" accept=".jpg, .jpeg, .png">
		<label class="btn btn-outline-primary" for="featureImage">Upload New Feature Picture</label>

		<div id="summernote"></div>

		<input type="hidden" name="articleContent" id="content">
        
        <button name="btnAction" value="draft" class="btn btn-warning">Save Draft</button>
        <button name="btnAction" value="submit" class="btn btn-success">Submit</button>
		<button name="btnAction" value="back" class="btn btn-info">Back</button>
	</form>
	
	<div class="e-footer"></div>
</body>
</html>