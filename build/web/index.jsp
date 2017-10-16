<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>E-News</title>
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<script src="js/config.js"></script>
</head>
<body>
	<div class="e-navbar"></div>
	<div class="e-login"></div>

	<section class="container main">
		<div class="article"><!-- repeat -->
			<div class="feature-pic">
				<a href="article">
					<img src="assets/img/Author-NguyenVanAuthor/P0000001.jpg">
				</a>
			</div>
			<div class="article-info">
				<h3 class="article-title"><a href="article">Random Title</a></h3>
				<a href="article" class="article-preview">
					<p>
						Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
						tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
						quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
						consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
						cillum dolore eu fugiat nulla pariatur.
					</p>
				</a>
				<span class="badge badge-primary author"><a href="">Author Name</a></span>
				<span class="publish-time">Today, 16:30</span>
				<i class="icon ion-eye views">&nbsp;1000</i>
			</div>
		</div>

		<nav class="pagination">
			<ul class="pagination">
				<li class="page-item">
					<a class="page-link" href="#!" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span>
					</a>
				</li>
				<li class="page-item active"><a class="page-link" href="#!">1</a></li>
				<li class="page-item"><a class="page-link" href="#!">2</a></li>
				<li class="page-item"><a class="page-link" href="#!">3</a></li>
				<li class="page-item">
					<a class="page-link" href="#!" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
						<span class="sr-only">Next</span>
					</a>
				</li>
			</ul>
		</nav>

	</section>

	<div class="e-footer"></div>
</body>
</html>