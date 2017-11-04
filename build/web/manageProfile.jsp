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
    <script type="text/javascript" src="jquery-validation/dist/jquery.validate.min.js"></script>
    <script src="js/updateProfile.js"></script>
    <script src="js/updatePassword.js"></script>
</head>
<body>
	<div class="e-navbar"></div>

	<section class="container">
		<h2>Edit Profile</h2>
        <div class="edit-profile-form">
			<h3 class="breakline">Information</h3>
            <form action="updateProfile" method="POST" enctype="multipart/form-data" class="row" id="updateProfileForm">
                <div class="col-md-3 profile-pic">
                    <label>Profile Picture</label>
                    <s:if test="%{#session.USERDETAILS.profilePicture != null && #session.USERDETAILS.profilePicture != ''}">
                        <img src="data:image/jpeg;base64,<s:property value="%{#session.USERDETAILS.profilePicture}"/>" width="100%">
                    </s:if>
                    <s:if test="%{#session.USERDETAILS.profilePicture == null || #session.USERDETAILS.profilePicture == ''}">
                        <img src="assets/img/default-user.png" width="100%">
                    </s:if>
                    <input type="file" name="profilePicture" class="profile-pic-upload" accept=".jpg, .jpeg, .png">
                    <label class="btn btn-outline-primary" for="profilePicture">Upload picture</label>
                </div>
                <div class="col-md-9 info">
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input class="form-control" type="text" name="email" disabled value="<s:property value="%{#session.USERDETAILS.email}"/>">
                    </div>
                    <div class="form-group">
                        <label for="name">Full Name:</label>
                        <input class="form-control" type="text" name="fullName" value="<s:property value="%{#session.USERDETAILS.fullName}"/>">
                    </div>
                    <div class="form-check">
                        <label for="genderID">Gender: </label>
                        <label class="form-check-label">
                            <input class="form-check-input" type="radio" name="genderID" value="1" <s:if test="%{#session.USERDETAILS.genderID == 1}">checked</s:if>>
                            Male
                        </label>
                        <label class="form-check-label">
                            <input class="form-check-input" type="radio" name="genderID" value="2" <s:if test="%{#session.USERDETAILS.genderID == 2}">checked</s:if>>
                            Female
                        </label>
                        <label class="form-check-label">
                            <input class="form-check-input" type="radio" name="genderID" value="3" <s:if test="%{#session.USERDETAILS.genderID == 3}">checked</s:if>>
                            Other
                        </label>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <span class="input-group-addon">Date</span>
                            <input type="number" class="form-control" name="day" value="<s:date name="%{#session.USERDETAILS.birthDate}" format="dd"/>">
                            <span class="input-group-addon">Month</span>
                            <input type="number" class="form-control" name="month" value="<s:date name="%{#session.USERDETAILS.birthDate}" format="MM"/>">
                            <span class="input-group-addon">Year</span>
                            <input type="number" class="form-control" name="year" value="<s:date name="%{#session.USERDETAILS.birthDate}" format="yyyy"/>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="address">Address:</label>
                        <input class="form-control" type="text" name="address" value="<s:property value="%{#session.USERDETAILS.address}"/>">
                    </div>
                    <div class="form-group">
                        <label for="address">Phone Number:</label>
                        <input class="form-control" type="text" name="phone" value="<s:property value="%{#session.USERDETAILS.phone}"/>">
                    </div>
                    <button type="submit" class="btn btn-success" id="btn-profile">Update Profile</button>
                    <a class="btn btn-info" role="button" href="viewHome">Back to Home</a>
                </div>
            </form>
            <form action="updatePassword" method="POST" class="row" id="updatePasswordForm">
                <div class="col-md-3"></div>
                <div class="col-md-9 info">
                    <h3 class="breakline">Update Password</h3>
                    <div class="form-group <s:if test="%{error != null && error != ''}">has-danger</s:if>">
                        <label for="password">Old Password:</label>
                        <input class="form-control" type="password" name="oldPassword">
                        <s:if test="%{error != null && error != ''}">
                            <label id="oldPassword-error" class="help-block" for="oldPassword"><s:property value="%{error}"/></label>
                        </s:if>
                    </div>
                    <div class="form-group">
                        <label for="passwordConfirm">New Password:</label>
                        <input class="form-control" type="password" name="newPassword" id="newPassword">
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
                    <input type="hidden" id="code" value="123">
                    <button class="btn btn-success" id="btn-password">Update Password</button>
                    <a class="btn btn-info" role="button" href="viewHome">Back to Home</a>
                </div>
            </form>
        </div>
	</section>

	<div class="e-footer"></div>
</body>
</html>