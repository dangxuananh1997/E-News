<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title><s:property value="%{userDetails.fullName}"/>'s Profile</title>
	<link rel="stylesheet" type="text/css" href="css/viewProfile.css">
	<script src="js/config.js"></script>
</head>
<body>
	<div class="e-navbar"></div>
	<div class="e-login"></div>
	<section class="container">
		<h2>View Profile</h2>
		<div class="view-profile">
			<h3 class="breakline">Information</h3>
			<div class="row">
				<div class="col-md-3 profile-pic">
					<label>Profile Picture</label>
                    <s:if test="%{userDetails.profilePicture != null && userDetails.profilePicture != ''}">
                        <img src="data:image/jpeg;base64,<s:property value="%{userDetails.profilePicture}"/>" width="100%">
                    </s:if>
                    <s:if test="%{userDetails.profilePicture == null || userDetails.profilePicture == ''}">
                        <img src="assets/img/default-user.png" width="100%">
                    </s:if>
				</div>
				<div class="col-md-9 col-sm-8 info">
					<div class="form-group">
						<label for="email">Email:</label>
                        <input class="form-control" disabled value="<s:property value="%{userDetails.email}"/>">
					</div>
					<div class="form-group">
						<label for="name">Full Name:</label>
						<input class="form-control" disabled value="<s:property value="%{userDetails.fullName}"/>">
					</div>
					<div class="form-check">
						<label for="gender">Gender: </label>
						<label class="form-check-label">
                            <input class="form-check-input" type="radio" value="male" disabled <s:if test="%{userDetails.genderID == 1}">checked</s:if> >
							Male
						</label>
						<label class="form-check-label">
							<input class="form-check-input" type="radio" value="female" disabled <s:if test="%{userDetails.genderID == 2}">checked</s:if> >
							Female
						</label>
						<label class="form-check-label">
							<input class="form-check-input" type="radio" value="other" disabled <s:if test="%{userDetails.genderID == 3}">checked</s:if> >
							Other
						</label>
					</div>
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon">Date</span>
							<input type="number" class="form-control" disabled value="<s:property value="%{userDetails.birthDate.date}"/>">
							<span class="input-group-addon">Month</span>
							<input type="number" class="form-control" disabled value="<s:property value="%{userDetails.birthDate.month + 1}"/>">
							<span class="input-group-addon">Year</span>
							<input type="number" class="form-control" disabled value="<s:property value="%{userDetails.birthDate.year + 1900}"/>">
						</div>
					</div>
					<div class="form-group">
						<label for="address">Address:</label>
						<input class="form-control" disabled value="<s:property value="%{userDetails.address}"/>">
					</div>
					<div class="form-group">
						<label for="address">Phone Number:</label>
						<input class="form-control" type="number" disabled value="<s:property value="%{userDetails.phone}"/>">
					</div>
				</div>
			</div>
		</div>
		
		<div class="member-comments">
			<h3 class="breakline">Comments</h3>
            
            <s:iterator var="comment" value="commentList" status="counter">
			<div class="comment row">
				<div class="col-md-2 col-4">
                    <s:if test="%{userDetails.profilePicture != null && userDetails.profilePicture != ''}">
                        <img src="data:image/jpeg;base64,<s:property value="%{userDetails.profilePicture}"/>" class="member-profile-picture img-thumbnail" width="70px" height="70px">
                    </s:if>
                    <s:if test="%{userDetails.profilePicture == null || userDetails.profilePicture == ''}">
                        <img src="assets/img/default-user.png" class="member-profile-picture img-thumbnail" width="70px" height="70px">
                    </s:if>
					<span class="badge badge-info"><s:property value="%{userDetails.fullName}"/></span>
				</div>
				<i class="icon ion-ios-play col-md-1 col-sm-3"></i>
				<div class="col-md-9 col-sm-8">
                    <h3 class="article-title">
                        <s:url var="articleLink" value="viewArticle">
                            <s:param name="articleID" value="%{#comment.articleID}" />
                        </s:url>
                        <s:a href="%{articleLink}">
                            <s:property value="%{articleTitleList[#counter.count - 1]}"/>
                        </s:a>
                    </h3>
					<p class="comment-content">
						<s:property value="%{#comment.commentContent}"/>
					</p>
				</div>
			</div>
            </s:iterator>
		</div>
                    
        <nav class="pagination">
            <ul class="pagination">
                <s:iterator begin="1" end="%{numberOfPages}" status="counter">
                <li class="page-item <s:if test="%{pageNumber == #counter.count}">active</s:if>">
                    <s:url var="pageLink" value="viewProfile">
                        <s:param name="userEmail" value="%{userDetails.email}"/>
                        <s:param name="pageNumber" value="%{#counter.count}"/>
                    </s:url>
                    <s:a cssClass="page-link" href="%{pageLink}">
                        <s:property value="%{#counter.count}"/>
                    </s:a>
                </li>
                </s:iterator>
            </ul>
        </nav>

	</section>

	<div class="e-footer"></div>
</body>
</html>