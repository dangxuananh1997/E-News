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
</head>
<body>
	<div class="e-navbar"></div>
	<div class="e-login"></div>

	<section class="container main">
        
        <s:iterator var="articleDTO" value="articleList" status="counter">
		<div class="article">
			<div class="feature-pic">
				<a href="article">
					<img src="data:image/jpeg;base64,<s:property value="%{#articleDTO.featureImage}"/>">
				</a>
			</div>
			<div class="article-info">
                <h3 class="article-title"><a href="article"><s:property value="%{#articleDTO.title}"/></a></h3>
                <s:url var="articleLink" value="viewArticle">
                    <s:param name="articleID" value="%{#articleDTO.articleID}" />
                </s:url>
                <s:a cssClass="article-preview" href="%{articleLink}">
                    <p>
                        <s:property value="%{#articleDTO.articleContent}" escapeHtml="false"/>
                    </p>
				</s:a>
				<span class="badge badge-primary author"><a href=""><s:property value="%{authorNameList[#counter.count - 1]}"/></a></span>
                <span class="publish-time"><s:date name="%{#articleDTO.publishTime}" format="dd/MM/yyyy" /></span>
				<i class="icon ion-eye views"><s:property value="%{#articleDTO.viewCount}"/></i>
			</div>
		</div>
        </s:iterator>

		<nav class="pagination">
			<ul class="pagination">
				<li class="page-item">
					<a class="page-link" href="#!" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span>
					</a>
				</li>
                
                
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
                
				<li class="page-item">
					<a class="page-link" href="#!" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
						<span class="sr-only">Next</span>
					</a>
				</li>
			</ul>
		</nav>

	</section>

	<div class="e-footer"></div>
</body>
</html>