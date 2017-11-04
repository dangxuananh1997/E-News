<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>Admin Page</title>
    <link rel="stylesheet" type="text/css" href="css/managePage.css">
    <script src="js/config.js"></script>
</head>
<body>
	<div class="e-navbar"></div>

	<section class="container manage-container">

		<ul class="nav nav-tabs">
			<li class="nav-item">
				<a  class="nav-link <s:if test="%{tab == 1}">active</s:if>" 
                    id="all-tab"
					href="adminViewAllArticle"
					role="tab"
                    aria-controls="all"
                    <s:if test="%{tab == 1}">aria-expanded="true"</s:if>
                    >
					All Articles
				</a>
			</li>
			<li class="nav-item">
				<a  class="nav-link <s:if test="%{tab == 2}">active</s:if>" 
                    id="pending-tab"
					href="adminViewPending"
                    role="tab"
                    aria-controls="pending"
                    <s:if test="%{tab == 2}">aria-expanded="true"</s:if>      
                    >
					Pending Articles
				</a>
			</li>
			<li class="nav-item">
				<a  class="nav-link <s:if test="%{tab == 3}">active</s:if>"
                    id="manage-comments-tab"
					href="adminViewDeleteRequest"
					role="tab"
                    aria-controls="delete-requests"
                    <s:if test="%{tab == 3}">aria-expanded="true"</s:if>
                    >
					Delete Requests
				</a>
			</li>
			<li class="nav-item">
				<a  class="nav-link <s:if test="%{tab == 4}">active</s:if>"
                    id="manage-comments-tab"
					href="adminViewComment"
					role="tab"
                    aria-controls="manage-comments"
                    <s:if test="%{tab == 4}">aria-expanded="true"</s:if>
                    >
					Manage Comments
				</a>
			</li>
			<li class="nav-item">
				<a  class="nav-link <s:if test="%{tab == 5}">active</s:if>"
                    id="manage-users-tab"
					href="adminViewManageUser"
                    role="tab"
                    aria-controls="manage-users"
                    <s:if test="%{tab == 5}">aria-expanded="true"</s:if>
                    >
					Manage Users
				</a>
			</li>
			<li class="nav-item">
				<a  class="nav-link <s:if test="%{tab == 6}">active</s:if>"
                    id="add-user-tab"
					href="adminViewAddUser"
                    role="tab"
                    aria-controls="add-user"
                    <s:if test="%{tab == 6}">aria-expanded="true"</s:if>
                    >
					Add User
				</a>
			</li>
		</ul>

		<div class="tab-content" id="myTabContent">

            <s:if test="%{tab == 1}">
			<!-- all articles -->
			<div class="tab-pane fade show active" id="all"
				role="tabpanel" aria-labelledby="all-tab">
				<h3>All Articles</h3>
				<div class="article-list">
					
                    <s:iterator var="article" value="articleList" status="counter">
					<div class="article row">
						<div class="col-1 author-profile-picture">
							<img src="data:img/jpeg;base64,<s:property value="%{authorList[#counter.count - 1].profilePicture}"/>" class="img-thumbnail"
								height="80px" width="80px">
						</div>
						<div class="col-11 article-title">
                            <h4><s:property value="%{#article.title}"/></h4>
							<span class="badge badge-primary">
								<s:property value="%{authorList[#counter.count - 1].fullName}"/>
							</span>
							<span class="badge badge-default">
								<s:property value="%{categoryList[#counter.count - 1]}"/>
							</span>
							<span class="badge badge-warning">
                                <s:date name="%{#article.publishTime}"/>
							</span>
							<span class="badge badge-info">
                                <s:if test="%{#article.statusID == 1}">
                                    Draft
                                </s:if>
                                <s:if test="%{#article.statusID == 2}">
                                    Pending
                                </s:if>
                                <s:if test="%{#article.statusID == 3}">
                                    Approved
                                </s:if>
                                <s:if test="%{#article.statusID == 4}">
                                    Requested To Delete
                                </s:if>
                                <s:if test="%{#article.statusID == 5}">
                                    Deleted
                                </s:if>
                                <s:if test="%{#article.statusID == 6}">
                                    Rejected
                                </s:if>
							</span>
							<div class="d-flex flex-row">
                                <s:url var="articleLink" value="viewArticle">
                                    <s:param name="articleID" value="%{#article.articleID}" />
                                    <s:param name="commentOff" value="true"/>
                                </s:url>
								<s:a cssClass="btn btn-outline-info" role="button" href="%{articleLink}">
									<i class="icon ion-eye"></i> View
								</s:a>
                                <s:if test="%{#article.statusID != 5}">
                                    <div class="input-group">
                                        <span class="input-group-btn">
                                            <s:url var="deleteArticleLink" value="adminDeleteArticle">
                                                <s:param name="articleID" value="%{#article.articleID}" />
                                                <s:param name="pageNumber" value="%{pageNumber}" />
                                                <s:param name="actionName" value="'adminViewAllArticle'" />
                                            </s:url>
                                            <s:a cssClass="btn btn-outline-danger" role="button" href="%{deleteArticleLink}">
                                                <i class="icon ion-close"></i> Delete
                                            </s:a>
                                        </span>
                                    </div>
                                </s:if>
							</div>
						</div>
					</div>
                    </s:iterator>
				</div>
                <nav class="pagination">
                    <ul class="pagination">
                        <s:iterator begin="1" end="%{numberOfPages}" status="counter">
                        <li class="page-item <s:if test="%{pageNumber == #counter.count}">active</s:if>">
                            <s:url var="pageLink" value="adminViewAllArticle">
                                <s:param name="pageNumber" value="%{#counter.count}" />
                            </s:url>
                            <s:a cssClass="page-link" href="%{pageLink}">
                                <s:property value="%{#counter.count}"/>
                            </s:a>
                        </li>
                        </s:iterator>
                    </ul>
                </nav>
			</div>
            </s:if>
            
            <s:if test="%{tab == 2}">
			<!-- pending articles -->
			<div class="tab-pane fade show active" id="pending"
				role="tabpanel" aria-labelledby="pending-tab">
				<h3>Pending Articles</h3>
				<div class="article-list">
					
                    <s:iterator var="article" value="pendingList" status="counter">
					<div class="article row">
						<div class="col-1 author-profile-picture">
							<img src="data:img/jpeg;base64,<s:property value="%{authorList[#counter.count - 1].profilePicture}"/>" class="img-thumbnail"
								height="80px" width="80px">
						</div>
						<div class="col-11 article-title">
							<h4><s:property value="%{#article.title}"/></h4>
							<span class="badge badge-primary">
								<s:property value="%{authorList[#counter.count - 1].fullName}"/>
							</span>
							<span class="badge badge-default">
								<s:property value="%{categoryList[#counter.count - 1]}"/>
							</span>
							<span class="badge badge-warning">
								<s:date name="%{#article.publishTime}"/>
							</span>
							<div class="d-flex flex-row">
                                <s:url var="articleLink" value="viewArticle">
                                    <s:param name="articleID" value="%{#article.articleID}" />
                                    <s:param name="commentOff" value="true"/>
                                </s:url>
								<s:a cssClass="btn btn-outline-info" role="button" href="%{articleLink}">
									<i class="icon ion-eye"></i> View
								</s:a>
                                    
                                <s:url var="approveLink" value="editorApproveArticle">
                                    <s:param name="articleID" value="%{#article.articleID}" />
                                    <s:param name="pageNumber" value="%{pageNumber}" />
                                    <s:param name="actionName" value="'adminViewPending'" />
                                </s:url>
                                <s:a cssClass="btn btn-outline-success" role="button" href="%{approveLink}">
                                    <i class="icon ion-checkmark"></i> Approved
                                </s:a>
							</div>
                            <form action="editorRejectArticle" method="POST">
                                <div class="form-group">
                                    <input type="hidden" name="articleID" value="<s:property value="%{#article.articleID}"/>">
                                    <input type="hidden" name="actionName" value="<s:property value="'adminViewPending'"/>">
                                    <textarea class="form-control" rows="2" name="reason" placeholder="Reason"></textarea>
                                    <button class="btn btn-outline-danger" type="submit">
                                        <i class="icon ion-close"></i> Reject
                                    </button>
                                </div>
                            </form>
						</div>
					</div>
                    </s:iterator>
                </div>
                <nav class="pagination">
                    <ul class="pagination">
                        <s:iterator begin="1" end="%{numberOfPages}" status="counter">
                        <li class="page-item <s:if test="%{pageNumber == #counter.count}">active</s:if>">
                            <s:url var="pageLink" value="adminViewPending">
                                <s:param name="pageNumber" value="%{#counter.count}" />
                            </s:url>
                            <s:a cssClass="page-link" href="%{pageLink}">
                                <s:property value="%{#counter.count}"/>
                            </s:a>
                        </li>
                        </s:iterator>
                    </ul>
                </nav>
			</div>
            </s:if>

            <s:if test="%{tab == 3}">
			<!-- delete requested articles -->
			<div class="tab-pane fade show active" id="all"
				role="tabpanel" aria-labelledby="delete-requests-tab">
				<h3>Delete Requests</h3>
				<div class="article-list">
					
                    <s:iterator var="article" value="articleList" status="counter">
					<div class="article row">
						<div class="col-1 author-profile-picture">
							<img src="data:img/jpeg;base64,<s:property value="%{authorList[#counter.count - 1].profilePicture}"/>" class="img-thumbnail"
								height="80px" width="80px">
						</div>
						<div class="col-11 article-title">
							<h4><s:property value="%{#article.title}"/></h4>
							<span class="badge badge-primary">
								<s:property value="%{authorList[#counter.count - 1].fullName}"/>
							</span>
							<span class="badge badge-default">
                                <s:property value="%{categoryList[#counter.count - 1]}"/>
							</span>
							<span class="badge badge-warning">
                                <s:date name="%{#article.publishTime}"/>
							</span>
							<div class="d-flex flex-row">
                                <s:url var="articleLink" value="viewArticle">
                                    <s:param name="articleID" value="%{#article.articleID}" />
                                    <s:param name="commentOff" value="true"/>
                                </s:url>
								<s:a cssClass="btn btn-outline-info" role="button" href="%{articleLink}">
									<i class="icon ion-eye"></i> View
								</s:a>
                                <div class="input-group">
                                    <span class="input-group-btn">
                                        <s:url var="deleteArticleLink" value="adminDeleteArticle">
                                            <s:param name="articleID" value="%{#article.articleID}" />
                                            <s:param name="pageNumber" value="%{pageNumber}" />
                                            <s:param name="actionName" value="'adminViewDeleteRequest'" />
                                        </s:url>
                                        <s:a cssClass="btn btn-outline-danger" role="button" href="%{deleteArticleLink}">
                                            <i class="icon ion-close"></i> Delete
                                        </s:a>
                                    </span>
                                </div>
							</div>
						</div>
					</div>
                    </s:iterator>
				</div>
                <nav class="pagination">
                    <ul class="pagination">
                        <s:iterator begin="1" end="%{numberOfPages}" status="counter">
                        <li class="page-item <s:if test="%{pageNumber == #counter.count}">active</s:if>">
                            <s:url var="pageLink" value="adminViewDeleteRequest">
                                <s:param name="pageNumber" value="%{#counter.count}" />
                            </s:url>
                            <s:a cssClass="page-link" href="%{pageLink}">
                                <s:property value="%{#counter.count}"/>
                            </s:a>
                        </li>
                        </s:iterator>
                    </ul>
                </nav>
			</div>
            </s:if>
            
            <s:if test="%{tab == 4}">
			<!-- manage comments -->
			<div class="tab-pane fade show active" id="manage-comments" 
				role="tabpanel" aria-labelledby="manage-comments-tab">
				<h3>Comments</h3>
				<div class="comment-list">
                    <s:iterator var="comment" value="commentList" status="counter">
					<div class="comment row">
						<div class="col-1">
                            <img src="data:img/jpeg;base64, <s:property value="%{commenterList[#counter.count - 1].profilePicture}"/>" 
								class="member-profile-picture img-thumbnail" 
								width="80px" height="80px">
						</div>
						<div class="col-11">
							<h4 class="article-title">
                                <s:property value="%{articleTitle[#counter.count - 1]}"/>
							</h4>
							<p class="comment-content">
								<span class="badge badge-info">
                                    <s:property value="%{commenterList[#counter.count - 1].fullName}"/>
								</span>
								<span class="badge badge-warning">
                                    <s:date name="%{#comment.publishTime}"/>
								</span>
								<i class="icon ion-ios-play"></i>
                                <s:property value="%{#comment.commentContent}"/>
							</p>
                            <s:url var="viewArticleLink" value="viewArticle">
                                <s:param name="articleID" value="%{#comment.articleID}" />
                                <s:param name="commentOff" value="true"/>
                            </s:url>
                            <s:a cssClass="btn btn-outline-info" role="button" href="%{viewArticleLink}">
                                <i class="icon ion-eye"></i> View Article
                            </s:a>
                                
                            <s:url var="deleteCommentLink" value="editorDeleteComment">
                                <s:param name="commentID" value="%{#comment.commentID}"/>
                                <s:param name="pageNumber" value="%{pageNumber}"/>
                                <s:param name="actionName" value="'adminViewComment'"/>
                            </s:url>
                            <s:a cssClass="btn btn-outline-danger" role="button" href="%{deleteCommentLink}">
                                <i class="icon ion-close"></i> Delete comment
                            </s:a>
						</div>
					</div>
                    </s:iterator>
				</div>
                <nav class="pagination">
                    <ul class="pagination">
                        <s:iterator begin="1" end="%{numberOfPages}" status="counter">
                        <li class="page-item <s:if test="%{pageNumber == #counter.count}">active</s:if>">
                            <s:url var="pageLink" value="adminViewComment">
                                <s:param name="pageNumber" value="%{#counter.count}" />
                            </s:url>
                            <s:a cssClass="page-link" href="%{pageLink}">
                                <s:property value="%{#counter.count}"/>
                            </s:a>
                        </li>
                        </s:iterator>
                    </ul>
                </nav>
			</div>
            </s:if>
            
            <s:if test="%{tab == 5}">
			<!-- manage user -->
			<div class="tab-pane fade show active" id="manage-users"
				role="tabpanel" aria-labelledby="manage-users-tab">
				<h3>Manage Users</h3>
				
                <form action="adminSearchUser" method="POST">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search User" name="searchValue" value="<s:property value="%{searchValue}"/>">
                        <span class="input-group-btn">
                            <button class="btn btn-primary" type="submit">
                                <i class="icon ion-search"></i>&nbsp;&nbsp;&nbsp;&nbsp;Search
                            </button>
                        </span>
                    </div>
                </form>

				<div class="user-list">
                    <s:iterator var="user" value="userList" status="counter">
					<div class="user row">
						<div class="col-2">
                            <img src="data:img/jpeg;base64,<s:property value="%{#user.profilePicture}"/>" class="img-thumbnail"
								width="80px" height="80px">
						</div>
						<div class="col-10">
							<p>
                                <span class="badge badge-info"><s:property value="%{#user.fullName}"/></span>
                                <span class="badge badge-default"><s:property value="%{roleList[#counter.count - 1]}"/></span>
                                <s:if test="%{!isActive[#counter.count - 1]}">
                                    <span class="badge badge-danger">Banned</span>
                                </s:if>
							</p>
                            
                            <s:url var="viewProfileLink" value="viewProfile">
                                <s:param name="userEmail" value="%{#user.email}"/>
                                <s:param name="pageNumber" value="%{pageNumber}"/>
                            </s:url>
                            <s:a cssClass="btn btn-outline-info" role="button" href="%{viewProfileLink}">
                                <i class="icon ion-eye"></i> View Profile
                            </s:a>
                            
                            <s:if test="%{isActive[#counter.count - 1] && roleList[#counter.count - 1] != 'Administrator'}">
                            <s:url var="banUserLink" value="adminBanUser">
                                <s:param name="searchValue" value="%{searchValue}"/>
                                <s:param name="actionName" value="%{actionName}"/>
                                <s:param name="userEmail" value="%{#user.email}"/>
                                <s:param name="pageNumber" value="%{pageNumber}"/>
                            </s:url>
                            <s:a cssClass="btn btn-outline-danger" role="button" href="%{banUserLink}">
                                <i class="icon ion-close"></i> Ban User
                            </s:a>
                            </s:if>
						</div>
					</div>
                    </s:iterator>
				</div>
                <nav class="pagination">
                    <ul class="pagination">
                        <s:iterator begin="1" end="%{numberOfPages}" status="counter">
                        <li class="page-item <s:if test="%{pageNumber == #counter.count}">active</s:if>">
                            <s:url var="pageLink" value="adminViewManageUser">
                                <s:param name="pageNumber" value="%{#counter.count}" />
                            </s:url>
                            <s:a cssClass="page-link" href="%{pageLink}">
                                <s:property value="%{#counter.count}"/>
                            </s:a>
                        </li>
                        </s:iterator>
                    </ul>
                </nav>
			</div>
            </s:if>
            
            <s:if test="%{tab == 6}">
			<!-- add user -->
			<div class="tab-pane fade show active" id="add-user"
				role="tabpanel" aria-labelledby="add-user-tab">
				<h3>Add Users</h3>
				<form class="register-form" action="adminAddUser" method="POST">
					<div class="form-group">
						<label for="email">Email:</label>
						<input class="form-control" type="text" name="email">
					</div>
					<div class="form-group">
						<label for="name">Full Name:</label>
						<input class="form-control" type="text" name="name">
					</div>
					<div class="form-group">
						<label for="password">Password:</label>
						<input class="form-control" type="password" name="password">
					</div>
					<div class="form-group">
						<label for="passwordConfirm">Confirm Password:</label>
						<input class="form-control" type="password" name="passwordConfirm">
					</div>
					<div class="form-group">
					<div class="form-check">
						<label for="role">Role: </label>
						<label class="form-check-label">
							<input class="form-check-input" type="radio" name="roleID" value="2" checked>
							Author
						</label>
						<label class="form-check-label">
							<input class="form-check-input" type="radio" name="roleID" value="3">
							Editor
						</label>
					</div>
						<label for="code">Security Code:</label>
						<input class="form-control" type="text" name="code">
					</div>
					<div class="security-code">
						50M3C0D3
					</div>
					<button class="btn btn-success">Register</button>
					<a href="home" class="btn btn-info">Back to Home</a>
				</form>
			</div>
            </s:if>
            
		</div>
	</section>

	<div class="e-footer"></div>
</body>
</html>