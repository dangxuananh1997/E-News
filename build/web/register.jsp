<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>E-News - Register</title>
	<link rel="stylesheet" type="text/css" href="css/register.css">
	<script src="js/config.js"></script>
	<script src="jquery-validation/dist/jquery.validate.min.js"></script>
    <script src="js/formValidation.js"></script>
</head>
<body>
	<div class="e-navbar"></div>

	<section class="container">
		<h2>Register</h2>
        <form action="registerUser" class="register-form" id="register">
			<div class="form-group">
				<label for="email">Email:</label>
				<input class="form-control" type="email" name="email" required>
			</div>
			<div class="form-group">
				<label for="name">Full Name:</label>
				<input class="form-control" type="text" name="name" required minlength="3">
			</div>
			<div class="form-group">
				<label for="password">Password:</label>
				<input class="form-control" type="password" name="password" required minlength="3">
			</div>
			<div class="form-group">
				<label for="passwordConfirm">Confirm Password:</label>
				<input class="form-control" type="password" name="passwordConfirm" required minlength="3">
			</div>
			<div class="form-group">
				<label for="code">Security Code:</label>
				<input class="form-control" type="text" name="code" required>
			</div>
			<div class="security-code">
				50M3C0D3
			</div>
			<textarea rows="3" readonly>Term and and conditions.  Lorem ipsum dolor sit amet, consectetur ipisicing elit. Beatae sunt expedita perspiciatis asperiores, assumenda magni, tempora repellendus llam incidunt voluptatibus quod, quidem. Quam cupiditate, ea fugit quo esse deleniti quisquam.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod	tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo	consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum olore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
			</textarea>
			<div class="form-check">
				<label class="form-check-label">
					<input class="form-check-input" type="checkbox" value="" required>
					I have read understand and accept the terms and conditions.
				</label>
			</div>
			<button class="btn btn-success">Register</button>
			<button class="btn btn-info">Back to Home</button>
		</form>
	</section>

	<div class="e-footer"></div>
</body>
</html>