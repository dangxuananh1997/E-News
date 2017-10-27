<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>Author</title>
	<link rel="stylesheet" type="text/css" href="css/managePage.css">
	<script src="js/config.js"></script>
</head>
<body>
	<div class="e-navbar"></div>

	<section class="container manage-container">
		<div class="new">
			<a class="btn btn-outline-success" href="authorAddNewArticle" role="button"><i class="icon ion-plus"></i> New Article</a>
		</div>

		<ul class="nav nav-tabs">
			<li class="nav-item">
                <a  class="nav-link <s:if test="%{tab == 1}">active</s:if>"
					id="draft-tab"
					href="authorViewDraft"
					role="tab"
					aria-controls="draft"
                    <s:if test="%{tab == 1}">aria-expanded="true"</s:if>
                    >
					Draft Articles
				</a>
			</li>
			<li class="nav-item">
				<a  class="nav-link <s:if test="%{tab == 2}">active</s:if>"
					id="pending-tab"
					href="authorViewPending"
					role="tab"
					aria-controls="pending"
                    <s:if test="%{tab == 2}">aria-expanded="true"</s:if>
                    >
					Pending Articles
				</a>
			</li>
			<li class="nav-item">
				<a  class="nav-link <s:if test="%{tab == 3}">active</s:if>"
					id="approved-tab"
					href="authorViewApproved"
					role="tab"
					aria-controls="approved"
                    <s:if test="%{tab == 3}">aria-expanded="true"</s:if>
                    >
					Approved Articles
				</a>
			</li>
			<li class="nav-item">
				<a  class="nav-link <s:if test="%{tab == 3}">active</s:if>"
					id="approved-tab"
					href="authorViewApproved"
					role="tab"
					aria-controls="approved"
                    <s:if test="%{tab == 3}">aria-expanded="true"</s:if>
                    >
					Rejected Articles
				</a>
			</li>
		</ul>

		<div class="tab-content" id="myTabContent">
            
            <s:if test="%{tab == 1}">
			<!-- draft articles -->
			<div class="tab-pane fade show active" id="draft" role="tabpanel" aria-labelledby="draft-tab">
				<h3>Draft Articles</h3>
				<div class="article-list">
					<div class="article row">
						<div class="col-1 author-profile-picture">
							<img src="assets/img/author.jpg" height="80px" width="80px" class="img-thumbnail">
						</div>
						<div class="col-11 article-title">
							<h4>Draft Article</h4>
							<button class="btn btn-outline-success">
								<i class="icon ion-edit"></i> Edit
							</button>
							<button class="btn btn-outline-danger">
								<i class="icon ion-close"></i> Delete Article
							</button>
						</div>
					</div>
				</div>
			</div>
            </s:if>
            
            <s:if test="%{tab == 2}">
			<!-- pending articles -->
			<div class="tab-pane fade show active" id="pending" role="tabpanel" aria-labelledby="pending-tab">
				<h3>Pending Articles</h3>
				<div class="article-list">
					<div class="article row">
						<div class="col-1 author-profile-picture">
							<img src="assets/img/author.jpg" height="80px" width="80px" class="img-thumbnail">
						</div>
						<div class="col-11 article-title">
							<h4>Pending Article</h4>
							<button class="btn btn-outline-success">
								<i class="icon ion-edit"></i> View/Edit
							</button>
							<button class="btn btn-outline-danger">
								<i class="icon ion-close"></i> Delete Article
							</button>
						</div>
					</div>
				</div>
			</div>
            </s:if>
            
            <s:if test="%{tab == 3}">
			<!-- approved articles -->
			<div class="tab-pane fade show active" id="approved" role="tabpanel" aria-labelledby="approved-tab">
				<h3>Approved Articles</h3>
				<div class="article-list">
					<!-- approved article -->
					<div class="article row">
						<div class="col-1 author-profile-picture">
							<img src="assets/img/author.jpg" height="80px" width="80px" class="img-thumbnail">
						</div>
						<div class="col-11 article-title">
							<h4>Approved Article</h4>
							<button class="btn btn-outline-success">
								<i class="icon ion-edit"></i> View
							</button>
							<button class="btn btn-outline-danger">
								<i class="icon ion-close"></i> Request Delete
							</button>
						</div>
					</div>
					<!-- delete requested article -->
					<div class="article row">
						<div class="col-1 author-profile-picture">
							<img src="assets/img/author.jpg" height="80px" width="80px" class="img-thumbnail">
						</div>
						<div class="col-11 article-title">
							<h4>Delete Requested Article</h4>
							<button class="btn btn-outline-success">
								<i class="icon ion-edit"></i> View
							</button>
							<button class="btn btn-outline-info">
								<i class="icon ion-information-circled"></i> Cancel Delete Request
							</button>
						</div>
					</div>
				</div>
			</div>
            </s:if>
            
		</div>
	</section>

	<div class="e-footer"></div>
</body>
</html>