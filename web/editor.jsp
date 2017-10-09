<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>Editor Page</title>
	<link rel="stylesheet" type="text/css" href="css/managePage.css">
	<script src="js/config.js"></script>
</head>
<body>
	<div class="e-navbar"></div>

	<section class="container manage-container">

		<ul class="nav nav-tabs">
			<li class="nav-item">
				<a  class="nav-link active"
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
					id="manage-comments-tab"
					data-toggle="tab"
					href="#manage-comments"
					role="tab"
					aria-controls="manage-comments">
					Manage Comments
				</a>
			</li>
		</ul>

		<div class="tab-content" id="myTabContent">

			<!-- pending article -->
			<div class="tab-pane fade show active" id="pending" role="tabpanel" aria-labelledby="pending-tab">
				<h3>Pending Articles</h3>
				<div class="article-list">
					
					<div class="article row">
						<div class="col-1 author-profile-picture">
							<img src="assets/img/author.jpg" height="80px" width="80px" class="img-thumbnail">
						</div>
						<div class="col-11 article-title">
							<h4>Pending Article</h4>
							<span class="badge badge-info">Author ajshdfkjshdfkjhd Name</span>
							<div class="d-flex flex-row">
								<button class="btn btn-outline-info">
									<i class="icon ion-eye"></i> View
								</button>
								<button class="btn btn-outline-success">
									<i class="icon ion-checkmark"></i> Approved
								</button>
								<div class="input-group">
									<span class="input-group-btn">
										<button class="btn btn-outline-danger" type="button">
											<i class="icon ion-close"></i> Reject
										</button>
									</span>
									<input type="text" class="form-control" placeholder="Reason">
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>

			<!-- manage-comments article -->
			<div class="tab-pane fade" id="manage-comments" role="tabpanel" aria-labelledby="manage-comments-tab">
				<h3>Comments</h3>
				<div class="comment-list">

					<div class="comment row">
						<div class="col-1">
							<img src="assets/img/member.jpg" class="member-profile-picture img-thumbnail" width="80px" height="80px">
						</div>
						<div class="col-11">
							<h4 class="article-title"><a href="">Random article title</a></h4>
							<p class="comment-content">
								<span class="badge badge-info">Member Nasdasdj asdasda asdasd Name</span>
								<i class="icon ion-ios-play"></i>
								Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
								tempor incididunt ut labore et dolore magna aliqua.
							</p>
							<button class="btn btn-outline-info">
								<i class="icon ion-eye"></i> View Article
							</button>
							<button class="btn btn-outline-danger">
								<i class="icon ion-close"></i> Delete comment
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