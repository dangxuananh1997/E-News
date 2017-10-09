<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>Reset Password</title>
	<link rel="stylesheet" type="text/css" href="css/resetPassword.css">
	<script src="js/config.js"></script>
</head>
<body>
	<div class="e-navbar"></div>

	<section class="container">
		<h2>Reset Password</h2>
		<form class="reset-password">
			<div class="form-group">
				<label for="email">Email:</label>
				<input class="form-control" type="text" name="email">
			</div>

			<div class="form-group">
				<label for="code">Security Code:</label>
				<input class="form-control" type="text" name="code">
			</div>

			<div class="security-code">
				50M3C0D3
			</div>
			
			<button class="btn btn-success">Reset Password</button>
			<button class="btn btn-info">Back to Home</button>
		</form>
	</section>

	<div class="e-footer"></div>
</body>
</html>