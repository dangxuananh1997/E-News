<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>E-News</title>
	<link rel="stylesheet" type="text/css" href="css/article.css">
	<script src="js/config.js"></script>

</head>
<body>
	<div class="e-navbar"></div>
	<div class="e-login"></div>

	<section class="container">
		<div class="article-content">
			
			<h2 class="article-title">
				Article Title Lorem ipsum dolor sit amet, consectetur adipisicing elit
			</h2>

			<div class="author-info">
				<a href="home">
					<img src="assets/img/author.jpg" class="author-profile-pic img-thumbnail"
					width="60px" height="60px">
				</a>
				<span class="badge badge-primary author-name">
					<a href="home">Author Name</a>
				</span>
				<span class="article-publish-time">Today, 16:30</span>
			</div>

			<div class="content">
				<script type="text/javascript">
					// load from database
					document.write('<div class="content-image"><img src="assets/img/Author-NguyenVanAuthor/P0000002.jpg" width="100%"></div><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmodtempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodoconsequat. Duis aute irure dolor in reprehenderit in voluptate velit essecillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat nonproident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p><div class="content-image"><img src="assets/img/Author-NguyenVanAuthor/P0000003.jpg" width="100%"></div><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmodtempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodoconsequat. Duis aute irure dolor in reprehenderit in voluptate velit essecillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat nonproident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p><p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmodtempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodoconsequat. Duis aute irure dolor in reprehenderit in voluptate velit essecillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat nonproident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>');
				</script>
			</div>

			<span class="badge badge-success article-statistic">Comments: 1</span>
			<span class="badge badge-success article-statistic">Read: 1</span>
		</div>

		<div class="comment-section">
			
			<div class="comment"><!-- repeat -->
				<div class="member-info">
					<a href="viewProfile">
						<img src="assets/img/member.jpg" class="member-profile-pic img-thumbnail" width="60px" height="60px">
					</a>
					<span class="badge badge-default member-name">
						<a href="viewProfile">Member Name</a>
					</span>
					<span class="comment-time">Today, 16:31</span>
				</div>
				<p class="comment-content">
					Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
					tempor incididunt ut labore et dolore magna aliqua.
				</p>
			</div>

			<form class="comment new-comment" action="comment">
				<div class="member-info">
					<a href="manageProfile">
						<img src="assets/img/member.jpg" class="member-profile-pic img-thumbnail" width="60px" height="60px">
					</a>
					<span class="badge badge-info member-name">
						<a href="manageProfile">Member Name</a>
					</span>
				</div>
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Comment" name="commentContent">
					<span class="input-group-btn">
						<button class="btn btn-outline-primary" type="submit">
							Submit
						</button>
					</span>
				</div>
			</form>

		</div>
	</section>

	<div class="e-footer"></div>
</body>
</html>