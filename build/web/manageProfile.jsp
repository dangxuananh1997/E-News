<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
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
			<h3 class="breakline">Information</h3>
			<div class="row">
				<div class="col-md-3 profile-pic">
					<label>Profile Picture</label>
                    
                    <s:if test="%{#session.USERDETAILS.profilePicture != null && #session.USERDETAILS.profilePicture != ''}">
                        <img src="<s:property value="%{#session.USERDETAILS.profilePicture"/>" width="100%">
                    </s:if>
                    <s:if test="%{#session.USERDETAILS.profilePicture == null || #session.USERDETAILS.profilePicture == ''}">
                        <img src="assets/img/default-user.png" width="100%">
                    </s:if>
                    
					<input type="file" name="profile-pic-upload" class="profile-pic-upload">
					<label class="btn btn-outline-primary" for="profile-pic-upload">Upload picture</label>
				</div>
				<div class="col-md-9 info">
                    <form action="updateProfile">
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input class="form-control" type="text" name="email" disabled value="<s:property value="%{#session.USERDETAILS.email}"/>">
                        </div>
                        <div class="form-group">
                            <label for="name">Full Name:</label>
                            <input class="form-control" type="text" name="name" value="<s:property value="%{#session.USERDETAILS.fullName}"/>">
                        </div>
                        <div class="form-check">
                            <label for="gender">Gender: </label>
                            <label class="form-check-label">
                                <input class="form-check-input" type="radio" name="gender" value="1">
                                Male
                            </label>
                            <label class="form-check-label">
                                <input class="form-check-input" type="radio" name="gender" value="2">
                                Female
                            </label>
                            <label class="form-check-label">
                                <input class="form-check-input" type="radio" name="gender" value="3">
                                Other
                            </label>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <span class="input-group-addon">Date</span>
                                <input type="number" class="form-control" name="day" value="">
                                <span class="input-group-addon">Month</span>
                                <input type="number" class="form-control" name="month" value="">
                                <span class="input-group-addon">Year</span>
                                <input type="number" class="form-control" name="yeah" value="">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="address">Address:</label>
                            <input class="form-control" type="text" name="address" value="">
                        </div>
                        <div class="form-group">
                            <label for="address">Phone Number:</label>
                            <input class="form-control" type="number" name="phone" value="">
                        </div>
                        <button class="btn btn-success">Update Profile</button>
                        <button class="btn btn-info">Back to Home</button>
                    </form>

                    <form action="updatePassword">
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
                        <button class="btn btn-success">Update Password</button>
                        <button class="btn btn-info">Back to Home</button>
                    </form>
				</div>
			</div>
		</form>
	</section>

	<div class="e-footer"></div>
</body>
</html>