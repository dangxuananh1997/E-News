<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>Editor Page</title>
	<link rel="stylesheet" type="text/css" href="css/managePage.css">
	<script src="js/config.js"></script>
</head>
<body>
	<div class="e-navbar"></div>

	<section class="container manage-container">

		<ul class="nav nav-tabs">
			<li class="nav-item">
				<a  class="nav-link <s:if test="%{tab == 1}">active</s:if>"
					id="pending-tab"
					href="editorViewPending"
					role="tab"
					aria-controls="pending"
                    <s:if test="%{tab == 1}">aria-expanded="true"</s:if>
                    >
					Pending Articles
				</a>
			</li>
			<li class="nav-item">
				<a  class="nav-link <s:if test="%{tab == 2}">active</s:if>"
					id="manage-comments-tab"
					href="editorViewComment"
					role="tab"
					aria-controls="manage-comments"
                    <s:if test="%{tab == 2}">aria-expanded="true"</s:if>
                    >
					Manage Comments
				</a>
			</li>
		</ul>

		<div class="tab-content" id="myTabContent">

            <s:if test="%{tab == 1}">
			<!-- pending article -->
			<div class="tab-pane fade show active" id="pending" role="tabpanel" aria-labelledby="pending-tab">
				<h3>Pending Articles</h3>
				<div class="article-list">
					
					<div class="article row">
						<div class="col-1 author-profile-picture">
							<img src="assets/img/author.jpg" height="80px" width="80px" class="img-thumbnail">
						</div>
						<div class="col-11 article-title">
							<h4>Pending Article</h4>
							<span class="badge badge-primary">
								Author Name
							</span>
							<span class="badge badge-default">
								Science
							</span>
							<span class="badge badge-warning">
								Today, 16:10
							</span>
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
            </s:if>
            
            <s:if test="%{tab == 2}">
			<!-- manage-comments article -->
			<div class="tab-pane fade show active" id="manage-comments" role="tabpanel" aria-labelledby="manage-comments-tab">
				<h3>Comments</h3>
				<div class="comment-list">

					<div class="comment row">
						<div class="col-1">
							<img src="assets/img/member.jpg" class="member-profile-picture img-thumbnail" width="80px" height="80px">
						</div>
						<div class="col-11">
							<h4 class="article-title"><a href="">Random article title</a></h4>
							<p class="comment-content">
								<span class="badge badge-info">
                                    Member Name
                                </span>
                                <span class="badge badge-warning">
                                    Today, 16:10
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
            </s:if>
            
		</div>
	</section>

	<div class="e-footer"></div>
</body>
</html>