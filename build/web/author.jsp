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
				<a  class="nav-link <s:if test="%{tab == 4}">active</s:if>"
					id="rejected-tab"
					href="authorViewRejected"
					role="tab"
					aria-controls="rejected"
                    <s:if test="%{tab == 4}">aria-expanded="true"</s:if>
                    >
					Rejected Articles
				</a>
			</li>
		</ul>

		<div class="tab-content" id="myTabContent">
            
            <s:if test="%{tab == 1}">
			<!-- draft articles -->
			<div class="tab-pane fade show active" id="draft" role="tabpanel" aria-labelledby="draft-tab">
				<div class="article-list">
                    <s:iterator var="article" value="draftList" status="counter">
					<div class="article row">
						<div class="col-1 author-profile-picture">
                            <s:if test="%{#session.USERDETAILS.profilePicture != null && #session.USERDETAILS.profilePicture != ''}">
                                <img src="data:image/jpeg;base64,<s:property value="%{#session.USERDETAILS.profilePicture}"/>" height="80px" width="80px" class="img-thumbnail">
                            </s:if>
                            <s:if test="%{#session.USERDETAILS.profilePicture == null || #session.USERDETAILS.profilePicture == ''}">
                                <img src="assets/img/default-user.png" height="80px" width="80px" class="img-thumbnail">
                            </s:if>
						</div>
						<div class="col-11 article-title">
                            <h4><s:property value="%{#article.title}"/></h4>
                            <s:url value="authorViewArticleEditing" var="editingLink">
                                <s:param name="articleID" value="%{#article.articleID}"/>
                            </s:url>
                            <s:a cssClass="btn btn-outline-success" role="button" href="%{editingLink}">
								<i class="icon ion-edit"></i> Edit
                            </s:a>
                            <s:url value="adminDeleteArticle" var="deleteLink">
                                <s:param name="articleID" value="%{#article.articleID}"/>
                                <s:param name="pageNumber" value="%{pageNumber}"/>
                                <s:param name="actionName" value="'authorViewDraft'"/>
                            </s:url>
                            <s:a cssClass="btn btn-outline-danger" role="button" href="%{deleteLink}">
								<i class="icon ion-close"></i> Delete Article
                            </s:a>
						</div>
					</div>
                    </s:iterator>
				</div>
                <nav class="pagination">
                    <ul class="pagination">
                        <s:iterator begin="1" end="%{numberOfPages}" status="counter">
                        <li class="page-item <s:if test="%{pageNumber == #counter.count}">active</s:if>">
                            <s:url var="pageLink" value="authorViewDraft">
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
			<div class="tab-pane fade show active" id="pending" role="tabpanel" aria-labelledby="pending-tab">
				<div class="article-list">
					<s:iterator var="article" value="pendingList" status="counter">
					<div class="article row">
						<div class="col-1 author-profile-picture">
                            <s:if test="%{#session.USERDETAILS.profilePicture != null && #session.USERDETAILS.profilePicture != ''}">
                                <img src="data:image/jpeg;base64,<s:property value="%{#session.USERDETAILS.profilePicture}"/>" height="80px" width="80px" class="img-thumbnail">
                            </s:if>
                            <s:if test="%{#session.USERDETAILS.profilePicture == null || #session.USERDETAILS.profilePicture == ''}">
                                <img src="assets/img/default-user.png" height="80px" width="80px" class="img-thumbnail">
                            </s:if>
						</div>
						<div class="col-11 article-title">
                            <h4><s:property value="%{#article.title}"/></h4>
                            <s:url value="authorViewArticleEditing" var="editingLink">
                                <s:param name="articleID" value="%{#article.articleID}"/>
                            </s:url>
                            <s:a cssClass="btn btn-outline-success" role="button" href="%{editingLink}">
								<i class="icon ion-edit"></i> Edit
                            </s:a>
                            <s:url value="viewArticle" var="viewArticleLink">
                                <s:param name="articleID" value="%{#article.articleID}"/>
                                <s:param name="commentOff" value="true"/>
                            </s:url>
                            <s:a cssClass="btn btn-outline-info" role="button" href="%{viewArticleLink}">
								<i class="icon ion-eye"></i> View
                            </s:a>
                            <s:url value="adminDeleteArticle" var="deleteLink">
                                <s:param name="articleID" value="%{#article.articleID}"/>
                                <s:param name="pageNumber" value="%{pageNumber}"/>
                                <s:param name="actionName" value="'authorViewPending'"/>
                            </s:url>
                            <s:a cssClass="btn btn-outline-danger" role="button" href="%{deleteLink}">
								<i class="icon ion-close"></i> Delete Article
                            </s:a>
						</div>
					</div>
                    </s:iterator>
				</div>
                <nav class="pagination">
                    <ul class="pagination">
                        <s:iterator begin="1" end="%{numberOfPages}" status="counter">
                        <li class="page-item <s:if test="%{pageNumber == #counter.count}">active</s:if>">
                            <s:url var="pageLink" value="authorViewPending">
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
			<!-- approved articles -->
			<div class="tab-pane fade show active" id="approved" role="tabpanel" aria-labelledby="approved-tab">
				<div class="article-list">
					<s:iterator var="article" value="approvedList" status="counter">
					<div class="article row">
						<div class="col-1 author-profile-picture">
                            <s:if test="%{#session.USERDETAILS.profilePicture != null && #session.USERDETAILS.profilePicture != ''}">
                                <img src="data:image/jpeg;base64,<s:property value="%{#session.USERDETAILS.profilePicture}"/>" height="80px" width="80px" class="img-thumbnail">
                            </s:if>
                            <s:if test="%{#session.USERDETAILS.profilePicture == null || #session.USERDETAILS.profilePicture == ''}">
                                <img src="assets/img/default-user.png" height="80px" width="80px" class="img-thumbnail">
                            </s:if>
						</div>
						<div class="col-11 article-title">
                            <h4><s:property value="%{#article.title}"/></h4>
                            <s:url value="viewArticle" var="viewArticleLink">
                                <s:param name="articleID" value="%{#article.articleID}"/>
                            </s:url>
                            <s:a cssClass="btn btn-outline-info" role="button" href="%{viewArticleLink}">
								<i class="icon ion-eye"></i> View
                            </s:a>
                            <s:if test="%{#article.statusID == 3}">
                                <s:url value="authorRequestDelete" var="requestDeleteLink">
                                    <s:param name="articleID" value="%{#article.articleID}"/>
                                    <s:param name="pageNumber" value="%{pageNumber}"/>
                                </s:url>
                                <s:a cssClass="btn btn-outline-danger" role="button" href="%{requestDeleteLink}">
                                    <i class="icon ion-close"></i> Request Delete
                                </s:a>
                            </s:if>
                            <s:if test="%{#article.statusID == 4}">
                                <s:url value="authorCancelRequestDelete" var="cancelRequestDeleteLink">
                                    <s:param name="articleID" value="%{#article.articleID}"/>
                                    <s:param name="pageNumber" value="%{pageNumber}"/>
                                </s:url>
                                <s:a cssClass="btn btn-outline-secondary" role="button" href="%{cancelRequestDeleteLink}">
                                    <i class="icon ion-information-circled"></i> Cancel Delete Request
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
                            <s:url var="pageLink" value="authorViewApproved">
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
			<!-- approved articles -->
			<div class="tab-pane fade show active" id="rejected" role="tabpanel" aria-labelledby="rejected-tab">
				<div class="article-list">
                    <s:iterator var="article" value="rejectedList" status="counter">
					<div class="article row">
						<div class="col-1 author-profile-picture">
                            <s:if test="%{#session.USERDETAILS.profilePicture != null && #session.USERDETAILS.profilePicture != ''}">
                                <img src="data:image/jpeg;base64,<s:property value="%{#session.USERDETAILS.profilePicture}"/>" height="80px" width="80px" class="img-thumbnail">
                            </s:if>
                            <s:if test="%{#session.USERDETAILS.profilePicture == null || #session.USERDETAILS.profilePicture == ''}">
                                <img src="assets/img/default-user.png" height="80px" width="80px" class="img-thumbnail">
                            </s:if>
						</div>
						<div class="col-11 article-title">
                            <h4><s:property value="%{#article.title}"/></h4>
                            <h5>Reject Reason: <s:property value="%{#article.statusDescription}"/></h5>
							<s:url value="authorViewArticleEditing" var="editingLink">
                                <s:param name="articleID" value="%{#article.articleID}"/>
                            </s:url>
                            <s:a cssClass="btn btn-outline-success" role="button" href="%{editingLink}">
								<i class="icon ion-edit"></i> Edit
                            </s:a>
							<s:url value="adminDeleteArticle" var="deleteLink">
                                <s:param name="articleID" value="%{#article.articleID}"/>
                                <s:param name="pageNumber" value="%{pageNumber}"/>
                                <s:param name="actionName" value="'authorViewRejected'"/>
                            </s:url>
                            <s:a cssClass="btn btn-outline-danger" role="button" href="%{deleteLink}">
								<i class="icon ion-close"></i> Delete Article
                            </s:a>
						</div>
					</div>
                    </s:iterator>
				</div>
                <nav class="pagination">
                    <ul class="pagination">
                        <s:iterator begin="1" end="%{numberOfPages}" status="counter">
                        <li class="page-item <s:if test="%{pageNumber == #counter.count}">active</s:if>">
                            <s:url var="pageLink" value="authorViewRejected">
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