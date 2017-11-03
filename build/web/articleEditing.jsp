<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

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
    <script type="text/javascript" src="jquery-validation/dist/jquery.validate.min.js"></script>
</head>
<body>
	<div class="e-navbar"></div>

	<form class="container" method="POST" action="authorEditArticle" enctype="multipart/form-data" id="articleForm">

		<div class="form-group">
			<label for="title"><h3>Title</h3></label>
            <input type="text" class="form-control" name="title" placeholder="Article title" value="<s:property value="%{article.title}"/>">
		</div>

		<div class="form-check">
            <s:if test="%{article.articleID != null && article.articleID != ''}">
            <input type="hidden" name="articleID" value="<s:property value="%{article.articleID}"/>">
            </s:if>
			<label for="role">Category: </label>
			<label class="form-check-label">
				<input type="radio" class="form-check-input" name="categoryID" value="1" 
                    <s:if test="%{article.categoryID == 1}">checked</s:if>
                    <s:if test="%{article == null || article == ''}">checked</s:if>
                    <s:if test="%{article.categoryID == null || article.categoryID == ''}">checked</s:if>
                    >Economy
			</label>
			<label class="form-check-label">
				<input type="radio" class="form-check-input" name="categoryID" value="2" <s:if test="%{article.categoryID == 2}">checked</s:if> >Entertainment
			</label>
			<label class="form-check-label">
				<input type="radio" class="form-check-input" name="categoryID" value="3" <s:if test="%{article.categoryID == 3}">checked</s:if> >Politics
			</label>
			<label class="form-check-label">
				<input type="radio" class="form-check-input" name="categoryID" value="4" <s:if test="%{article.categoryID == 4}">checked</s:if> >Sports
			</label>
			<label class="form-check-label">
				<input type="radio" class="form-check-input" name="categoryID" value="5" <s:if test="%{article.categoryID == 5}">checked</s:if> >Education
			</label>
			<label class="form-check-label">
				<input type="radio" class="form-check-input" name="categoryID" value="6" <s:if test="%{article.categoryID == 6}">checked</s:if> >Health
			</label>
			<label class="form-check-label">
				<input type="radio" class="form-check-input" name="categoryID" value="7" <s:if test="%{article.categoryID == 7}">checked</s:if> >Family
			</label>
			<label class="form-check-label">
				<input type="radio" class="form-check-input" name="categoryID" value="8" <s:if test="%{article.categoryID == 8}">checked</s:if> >Travel
			</label>
			<label class="form-check-label">
                <input type="radio" class="form-check-input" name="categoryID" value="9" <s:if test="%{article.categoryID == 9}">checked</s:if> >Science
			</label>
			<label class="form-check-label">
                <input type="radio" class="form-check-input" name="categoryID" value="10" <s:if test="%{article.categoryID == 10}">checked</s:if> >World
			</label>
		</div>
		

		<input type="file" name="featureImage" class="feature-picture-upload" accept=".jpg, .jpeg, .png">
		<label class="btn btn-outline-primary" for="featureImage">Upload New Feature Picture</label>

        <div id="summernote"></div>
        <s:if test="%{article.articleContent != '' && article.articleContent != null}">
        <script>
            $('#summernote').summernote('code', '<s:property value="%{article.articleContent}" escapeHtml="false"/>');
        </script>
        </s:if>
                
		<input name="articleContent" id="content">
        
        <button name="btnAction" value="draft" class="btn btn-warning">Save Draft</button>
        <button name="btnAction" value="submit" class="btn btn-success">Submit</button>
		<a class="btn btn-info" role="button" href="authorViewPending">Back</a>
	</form>
	
	<div class="e-footer"></div>
</body>
</html>