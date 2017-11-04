<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>Reset Password</title>
	<link rel="stylesheet" type="text/css" href="css/resetPassword.css">
	<script src="js/config.js"></script>
    <script type="text/javascript" src="jquery-validation/dist/jquery.validate.min.js"></script>
    <script src="js/resetPassword.js"></script>
</head>
<body>
	<div class="e-navbar"></div>

	<section class="container">
		<h2>Reset Password</h2>
		<form class="reset-password" action="newPassword" method="POST" id="newPassword">
            <input type="hidden" name="email" value="<s:property value="%{email}"/>">
            
			<div class="form-group <s:if test="%{error != null && error != ''}">has-danger</s:if>">
				<label for="newPassword">New Password:</label>
				<input class="form-control" type="password" name="newPassword" id="newPassword">
                <s:if test="%{error != null && error != ''}">
                    <label id="email-error" class="help-block" for="email"><s:property value="%{error}"/></label>
                </s:if>
			</div>

			<div class="form-group">
				<label for="confirmNewPassword">Confirm Password:</label>
				<input class="form-control" type="password" name="confirmNewPassword">
			</div>

			<div class="form-group">
				<label for="code">Security Code:</label>
				<input class="form-control" type="text" name="code">
			</div>

			<div class="security-code">
				50M3C0D3
			</div>
			<input type="hidden" id="code" value="123">
			
			<button class="btn btn-success" id="btn-new">Change Password</button>
			<a class="btn btn-info" role="button" href="viewHome">Back to Home</a>
		</form>
	</section>

	<div class="e-footer"></div>
</body>
</html>