<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>E-News Edit Profile</title>
	<link rel="stylesheet" type="text/css" href="css/manageProfile.css">
	<script src="js/config.js"></script>
	<script src="js/manageProfile.js"></script>
</head>
<body>
	<div class="e-navbar"></div>

	<section class="container">
		<h2>Edit Profile</h2>
		<form class="edit-profile-form">
			<h3 class="breakline">Infomation</h3>
			<div class="row">
				<div class="col-md-3 profile-pic">
					<label>Profile Picture</label>
					<img src="assets/img/member.jpg" width="100%">
					<input type="file" name="profile-pic-upload" class="profile-pic-upload">
					<label class="btn btn-outline-primary" for="profile-pic-upload">Upload picture</label>
					<button class="btn btn-success">Update Profile</button>
					<button class="btn btn-info">Back to Home</button>
				</div>
				<div class="col-md-9 info">
					<div class="form-group">
						<label for="email">Email:</label>
						<input class="form-control" type="text" name="email" disabled value="member@hotmail.com">
					</div>
					<div class="form-group">
						<label for="name">Full Name:</label>
						<input class="form-control" type="text" name="name" value="Member Name">
					</div>
					<div class="form-check">
						<label for="gender">Gender: </label>
						<label class="form-check-label">
							<input class="form-check-input" type="radio" name="gender" value="male">
							Male
						</label>
						<label class="form-check-label">
							<input class="form-check-input" type="radio" name="gender" value="female" checked>
							Female
						</label>
						<label class="form-check-label">
							<input class="form-check-input" type="radio" name="gender" value="other">
							Other
						</label>
					</div>
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon">Date</span>
							<input type="number" class="form-control" name="day" value="01">
							<span class="input-group-addon">Month</span>
							<input type="number" class="form-control" name="month" value="01">
							<span class="input-group-addon">Year</span>
							<input type="number" class="form-control" name="yeah" value="1997">
						</div>
					</div>
					<div class="form-group">
						<label for="address">Address:</label>
						<input class="form-control" type="text" name="address" value="Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod">
					</div>
					<div class="form-group">
						<label for="address">Phone Number:</label>
						<input class="form-control" type="number" name="phone" value="1234456789">
					</div>

					<h3 class="breakline">Update Password</h3>
					<div class="form-group">
						<label for="password">Old Password:</label>
						<input class="form-control" type="password" name="oldPassword">
					</div>
					<div class="form-group">
						<label for="passwordConfirm">New Password:</label>
						<input class="form-control" type="password" name="newPassword">
					</div>
					<div class="form-group">
						<label for="passwordConfirm">Confirm New Password:</label>
						<input class="form-control" type="password" name="newPasswordConfirm">
					</div>
					<div class="form-group">
						<label for="code">Security Code:</label>
						<input class="form-control" type="text" name="code">
					</div>
					<div class="security-code">
						50M3C0D3
					</div>
				</div>
			</div>
		</form>
	</section>

	<div class="e-footer"></div>
</body>
</html>