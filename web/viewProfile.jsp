<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>E-News X's Profile</title>
	<link rel="stylesheet" type="text/css" href="css/viewProfile.css">
	<script src="js/config.js"></script>
</head>
<body>
	<div class="e-navbar"></div>
	<div class="e-login"></div>
	<section class="container">
		<h2>View Profile</h2>
		<div class="view-profile">
			<h3 class="breakline">Infomation</h3>
			<div class="row">
				<div class="col-md-3 profile-pic">
					<label>Profile Picture</label>
					<img src="assets/img/member.jpg" width="100%">
				</div>
				<div class="col-md-9 col-sm-8 info">
					<div class="form-group">
						<label for="email">Email:</label>
						<input class="form-control" disabled value="member@hotmail.com">
					</div>
					<div class="form-group">
						<label for="name">Full Name:</label>
						<input class="form-control" disabled value="Member Name">
					</div>
					<div class="form-check">
						<label for="gender">Gender: </label>
						<label class="form-check-label">
							<input class="form-check-input" type="radio" value="male" disabled>
							Male
						</label>
						<label class="form-check-label">
							<input class="form-check-input" type="radio" value="female" disabled checked>
							Female
						</label>
						<label class="form-check-label">
							<input class="form-check-input" type="radio" value="other" disabled>
							Other
						</label>
					</div>
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon">Date</span>
							<input type="number" class="form-control" disabled value="01">
							<span class="input-group-addon">Month</span>
							<input type="number" class="form-control" disabled value="01">
							<span class="input-group-addon">Year</span>
							<input type="number" class="form-control" disabled value="1997">
						</div>
					</div>
					<div class="form-group">
						<label for="address">Address:</label>
						<input class="form-control" disabled value=" Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.">
					</div>
					<div class="form-group">
						<label for="address">Phone Number:</label>
						<input class="form-control" type="number" disabled value="1234456789">
					</div>
				</div>
			</div>
		</div>
		
		<div class="member-comments">
			<h3 class="breakline">Comments</h3>

			<div class="comment row">
				<div class="col-md-2 col-4">
					<img src="assets/img/member.jpg" class="member-profile-picture img-thumbnail" width="70px" height="70px">
					<span class="badge badge-info">Member Name</span>
				</div>
				<i class="icon ion-ios-play col-md-1 col-sm-3"></i>
				<div class="col-md-9 col-sm-8">
					<h3 class="article-title"><a href="">Random article title</a></h3>
					<p class="comment-content">
						Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
						tempor incididunt ut labore et dolore magna aliqua.
					</p>
				</div>
			</div>
			
			<div class="comment row">
				<div class="col-md-2 col-4">
					<img src="assets/img/member.jpg" class="member-profile-picture img-thumbnail" width="70px" height="70px">
					<span class="badge badge-info">Member Name</span>
				</div>
				<i class="icon ion-ios-play col-md-1 col-sm-3"></i>
				<div class="col-md-9 col-sm-8">
					<h3 class="article-title"><a href="">Random article title</a></h3>
					<p class="comment-content">
						Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
						tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
						quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
						consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
						cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
						proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
					</p>
				</div>
			</div>

			<div class="comment row">
				<div class="col-md-2 col-4">
					<img src="assets/img/member.jpg" class="member-profile-picture img-thumbnail" width="70px" height="70px">
					<span class="badge badge-info">Member Name</span>
				</div>
				<i class="icon ion-ios-play col-md-1 col-sm-3"></i>
				<div class="col-md-9 col-sm-8">
					<h3 class="article-title"><a href="">Random article title</a></h3>
					<p class="comment-content">
						Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
					</p>
				</div>
			</div>
		</div>
	</section>

	<div class="e-footer"></div>
</body>
</html>