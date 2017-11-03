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
                                    <s:param name="actionName" value="'editorViewPending'" />
                                </s:url>
                                <s:a cssClass="btn btn-outline-success" role="button" href="%{approveLink}">
                                    <i class="icon ion-checkmark"></i> Approved
                                </s:a>
							</div>
                            <form action="editorRejectArticle" method="POST">
                                <div class="form-group">
                                    <input type="hidden" name="articleID" value="<s:property value="%{#article.articleID}"/>">
                                    <input type="hidden" name="actionName" value="<s:property value="'editorViewPending'"/>">
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
                            <s:url var="pageLink" value="editorViewPending">
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
			<!-- manage-comments article -->
			<div class="tab-pane fade show active" id="manage-comments" role="tabpanel" aria-labelledby="manage-comments-tab">
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
                                <s:param name="actionName" value="'editorViewComment'"/>
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
                            <s:url var="pageLink" value="editorViewComment">
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
            
		</div>
	</section>

	<div class="e-footer"></div>
</body>
</html>