<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>Admin Page</title>
    <link rel="stylesheet" type="text/css" href="css/managePage.css">
    <script src="js/config.js"></script>
</head>
<body>
	<div class="e-navbar"></div>

	<section class="container manage-container">

		<ul class="nav nav-tabs">
			<li class="nav-item">
				<a  class="nav-link active" id="pending-tab"
					href="#pending" aria-controls="pending"
					data-toggle="tab" role="tab">
					Pending Articles
				</a>
			</li>
			<li class="nav-item">
				<a  class="nav-link" id="manage-comments-tab"
					href="#manage-comments" aria-controls="manage-comments"
					data-toggle="tab" role="tab">
					Manage Comments
				</a>
			</li>
			<li class="nav-item">
				<a  class="nav-link" id="manage-users-tab"
					href="#manage-users" aria-controls="manage-users"
					data-toggle="tab" role="tab">
					Manage Users
				</a>
			</li>
			<li class="nav-item">
				<a  class="nav-link" id="add-user-tab"
					href="#add-user" aria-controls="add-user"
					data-toggle="tab" role="tab">
					Add User
				</a>
			</li>
		</ul>

		<div class="tab-content" id="myTabContent">

			<!-- pending article -->
			<div class="tab-pane fade show active" id="pending" 
				role="tabpanel" aria-labelledby="pending-tab">
				<h3>Pending Articles</h3>
				<div class="article-list">
					
					<div class="article row">
						<div class="col-1 author-profile-picture">
							<img src="assets/img/author.jpg" class="img-thumbnail"
								height="80px" width="80px">
						</div>
						<div class="col-11 article-title">
							<h4>Pending Article</h4>
							<span class="badge badge-info">Author Name</span>
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

			<!-- manage comments -->
			<div class="tab-pane fade" id="manage-comments" 
				role="tabpanel" aria-labelledby="manage-comments-tab">
				<h3>Comments</h3>
				<div class="comment-list">

					<div class="comment row">
						<div class="col-1">
							<img src="assets/img/member.jpg" 
								class="member-profile-picture img-thumbnail" 
								width="80px" height="80px">
						</div>
						<div class="col-11">
							<h4 class="article-title">
								<a href="">Random article title</a>
							</h4>
							<p class="comment-content">
								<span class="badge badge-info">
									Member Name
								</span>
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

			<!-- manage user -->
			<div class="tab-pane fade" id="manage-users"
				role="tabpanel" aria-labelledby="manage-users-tab">
				<h3>Manage Users</h3>
				
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search User">
					<span class="input-group-btn">
						<button class="btn btn-primary" type="button">
							<i class="icon ion-search"></i>&nbsp;&nbsp;&nbsp;&nbsp;Search
						</button>
					</span>
				</div>

				<div class="user-list">

					<div class="user row">
						<div class="col-2">
							<img src="assets/img/member.jpg" class="img-thumbnail"
								width="80px" height="80px">
						</div>
						<div class="col-10">
							<p>
								<a href="">
									<span class="badge badge-info">Member Name</span>
								</a>
							</p>
							<button class="btn btn-outline-info">
								<i class="icon ion-eye"></i> View Profile
							</button>
							<button class="btn btn-outline-danger">
								<i class="icon ion-close"></i> Ban User
							</button>
						</div>
					</div>

				</div>
			</div>

			<!-- add user -->
			<div class="tab-pane fade" id="add-user"
				role="tabpanel" aria-labelledby="add-user-tab">
				<h3>Add Users</h3>
				<form class="register-form">
					<div class="form-group">
						<label for="email">Email:</label>
						<input class="form-control" type="text" name="email">
					</div>
					<div class="form-group">
						<label for="name">Full Name:</label>
						<input class="form-control" type="text" name="name">
					</div>
					<div class="form-group">
						<label for="password">Password:</label>
						<input class="form-control" type="password" name="password">
					</div>
					<div class="form-group">
						<label for="passwordConfirm">Confirm Password:</label>
						<input class="form-control" type="password" name="passwordConfirm">
					</div>
					<div class="form-group">
					<div class="form-check">
						<label for="role">Role: </label>
						<label class="form-check-label">
							<input class="form-check-input" type="radio" name="role" value="author">
							Author
						</label>
						<label class="form-check-label">
							<input class="form-check-input" type="radio" name="role" value="editor">
							Editor
						</label>
					</div>
						<label for="code">Security Code:</label>
						<input class="form-control" type="text" name="code">
					</div>
					<div class="security-code">
						50M3C0D3
					</div>
					<button class="btn btn-success">Register</button>
					<a href="home" class="btn btn-info">Back to Home</a>
				</form>
			</div>

		</div>
	</section>

	<div class="e-footer"></div>
</body>
</html>