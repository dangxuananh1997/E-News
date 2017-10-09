<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>Author</title>
	<link rel="stylesheet" type="text/css" href="css/managePage.css">
	<script src="js/config.js"></script>
</head>
<body>
	<div class="e-navbar"></div>

	<section class="container manage-container">
		<div class="new">
			<button class="btn btn-outline-success"><i class="icon ion-plus"></i> New Article</button>
		</div>

		<ul class="nav nav-tabs">
			<li class="nav-item">
				<a  class="nav-link active"
					id="draft-tab"
					data-toggle="tab"
					href="#draft"
					role="tab"
					aria-controls="draft"
					aria-expanded="true">
					Draft Articles
				</a>
			</li>
			<li class="nav-item">
				<a  class="nav-link"
					id="pending-tab"
					data-toggle="tab"
					href="#pending"
					role="tab"
					aria-controls="pending">
					Pending Articles
				</a>
			</li>
			<li class="nav-item">
				<a  class="nav-link"
					id="approved-tab"
					data-toggle="tab"
					href="#approved"
					role="tab"
					aria-controls="approved">
					Approved Articles
				</a>
			</li>
		</ul>

		<div class="tab-content" id="myTabContent">
			<!-- draft article -->
			<div class="tab-pane fade show active" id="draft" role="tabpanel" aria-labelledby="draft-tab">
				<h3>Draft Articles</h3>
				<div class="article-list">
					<div class="article row">
						<div class="col-1 author-profile-picture">
							<img src="assets/img/author.jpg" height="80px" width="80px" class="img-thumbnail">
						</div>
						<div class="col-11 article-title">
							<h4>Draft Article</h4>
							<button class="btn btn-outline-success">
								<i class="icon ion-edit"></i> Edit
							</button>
							<button class="btn btn-outline-danger">
								<i class="icon ion-close"></i> Delete Article
							</button>
						</div>
					</div>
				</div>
			</div>

			<!-- pending article -->
			<div class="tab-pane fade" id="pending" role="tabpanel" aria-labelledby="pending-tab">
				<h3>Pending Articles</h3>
				<div class="article-list">
					<div class="article row">
						<div class="col-1 author-profile-picture">
							<img src="assets/img/author.jpg" height="80px" width="80px" class="img-thumbnail">
						</div>
						<div class="col-11 article-title">
							<h4>Pending Article</h4>
							<button class="btn btn-outline-success">
								<i class="icon ion-edit"></i> View/Edit
							</button>
							<button class="btn btn-outline-danger">
								<i class="icon ion-close"></i> Delete Article
							</button>
						</div>
					</div>
				</div>
			</div>

			<!-- approved articles -->
			<div class="tab-pane fade" id="approved" role="tabpanel" aria-labelledby="approved-tab">
				<h3>Approved Articles</h3>
				<div class="article-list">
					<!-- approved article -->
					<div class="article row">
						<div class="col-1 author-profile-picture">
							<img src="assets/img/author.jpg" height="80px" width="80px" class="img-thumbnail">
						</div>
						<div class="col-11 article-title">
							<h4>Approved Article</h4>
							<button class="btn btn-outline-success">
								<i class="icon ion-edit"></i> View
							</button>
							<button class="btn btn-outline-danger">
								<i class="icon ion-close"></i> Request Delete
							</button>
						</div>
					</div>
					<!-- delete requested article -->
					<div class="article row">
						<div class="col-1 author-profile-picture">
							<img src="assets/img/author.jpg" height="80px" width="80px" class="img-thumbnail">
						</div>
						<div class="col-11 article-title">
							<h4>Delete Requested Article</h4>
							<button class="btn btn-outline-success">
								<i class="icon ion-edit"></i> View
							</button>
							<button class="btn btn-outline-info">
								<i class="icon ion-information-circled"></i> Cancel Delete Request
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<div class="e-footer"></div>
</body>
</html>