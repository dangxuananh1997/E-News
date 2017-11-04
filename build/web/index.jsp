<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<title>E-News</title>
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<script src="js/config.js"></script>
    <script src="js/index.js"></script>
</head>
<body>
	<div class="e-navbar"></div>
	<div class="e-login"></div>

    <s:if test="%{error != null && error != ''}">
        <label class="help-block float-right"><s:property value="%{error}"/></label>
    </s:if>
    
	<section class="container main">
        
        <s:iterator var="articleDTO" value="articleList" status="counter">
        <s:url var="articleLink" value="viewArticle">
            <s:param name="articleID" value="%{#articleDTO.articleID}" />
        </s:url>
		<div class="article">
			<div class="feature-pic">
                <s:a href="%{articleLink}" value="">
					<img src="data:image/jpeg;base64,<s:property value="%{#articleDTO.featureImage}"/>">
                </s:a>
			</div>
			<div class="article-info">
                <h3 class="article-title">
                    <s:a href="%{articleLink}" value="">
                        <s:property value="%{#articleDTO.title}"/>
                    </s:a>
                </h3>
                <%--<s:a cssClass="article-preview" href="%{articleLink}">--%>
					<%--<s:property value="%{#articleDTO.articleContent}" escapeHtml="false"/>--%>
				<%--</s:a>--%>
				<span class="badge badge-primary author">
                    <s:url var="articlesByAuthorLink" value="viewByAuthor">
                        <s:param name="authorEmail" value="%{#articleDTO.authorEmail}" />
                    </s:url>
                    <s:a href="%{articlesByAuthorLink}">
                        <s:if test="%{authorNameList == null}">
                            <s:property value="%{authorName}"/>
                        </s:if>
                        <s:if test="%{authorNameList != null}">
                            <s:property value="%{authorNameList[#counter.count - 1]}"/>
                        </s:if>
                    </s:a>
                </span>
                <span class="publish-time"><s:date name="%{#articleDTO.publishTime}" format="dd/MM/yyyy" /></span>
				<i class="icon ion-eye views"><s:property value="%{#articleDTO.viewCount}"/></i>
			</div>
		</div>
        </s:iterator>

        <s:if test="%{authorNameList != null && categoryID == null && searchValue == null}"> <!-- home pagination -->
		<nav class="pagination">
			<ul class="pagination">
                <s:iterator begin="1" end="%{numberOfPages}" status="counter">
                <li class="page-item <s:if test="%{pageNumber == #counter.count}">active</s:if>">
                    <s:url var="pageLink" value="viewHome">
                        <s:param name="pageNumber" value="%{#counter.count}" />
                    </s:url>
                    <s:a cssClass="page-link" href="%{pageLink}">
                        <s:property value="%{#counter.count}"/>
                    </s:a>
                </li>
                </s:iterator>
			</ul>
		</nav>
        </s:if>

        <s:if test="%{categoryID != null && searchValue == null}"> <!-- viewByCategory pagination -->
		<nav class="pagination">
			<ul class="pagination">
                <s:iterator begin="1" end="%{numberOfPages}" status="counter">
                <li class="page-item <s:if test="%{pageNumber == #counter.count}">active</s:if>">
                    <s:url var="pageLink" value="viewByCategory">
                        <s:param name="pageNumber" value="%{#counter.count}"/>
                        <s:param name="categoryID" value="%{categoryID}"/>
                    </s:url>
                    <s:a cssClass="page-link" href="%{pageLink}">
                        <s:property value="%{#counter.count}"/>
                    </s:a>
                </li>
                </s:iterator>
			</ul>
		</nav>
        </s:if>
        
        <s:if test="%{authorNameList == null && categoryID == null && searchValue == null}"> <!-- viewByAuthor pagination -->
		<nav class="pagination">
			<ul class="pagination">
                <s:iterator begin="1" end="%{numberOfPages}" status="counter">
                <li class="page-item <s:if test="%{pageNumber == #counter.count}">active</s:if>">
                    <s:url var="pageLink" value="viewByAuthor">
                        <s:param name="pageNumber" value="%{#counter.count}" />
                        <s:param name="authorEmail" value="%{authorEmail}" />
                    </s:url>
                    <s:a cssClass="page-link" href="%{pageLink}">
                        <s:property value="%{#counter.count}"/>
                    </s:a>
                </li>
                </s:iterator>
			</ul>
		</nav>
        </s:if>
        
        <s:if test="%{searchValue != null && searchValue != ''}"> <!-- search pagination -->
        <nav class="pagination">
			<ul class="pagination">
                <s:iterator begin="1" end="%{numberOfPages}" status="counter">
                <li class="page-item <s:if test="%{pageNumber == #counter.count}">active</s:if>">
                    <s:url var="pageLink" value="searchArticle">
                        <s:param name="pageNumber" value="%{#counter.count}" />
                        <s:param name="searchValue" value="%{searchValue}" />
                    </s:url>
                    <s:a cssClass="page-link" href="%{pageLink}">
                        <s:property value="%{#counter.count}"/>
                    </s:a>
                </li>
                </s:iterator>
			</ul>
		</nav>
        </s:if>
        
	</section>

	<div class="e-footer"></div>
</body>
</html>