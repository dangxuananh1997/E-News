<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<nav class="navbar fixed-top navbar-toggleable-sm navbar-light bg-light">
	<button 
		class="navbar-toggler navbar-toggler-right" 
		type="button" 
		data-toggle="collapse" 
		data-target="#navbarToggler" 
		aria-controls="navbarToggler" 
		aria-expanded="false" 
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<a class="navbar-brand" href="viewHome">
		<img src="assets/img/logo.png" height="30px" width="50px">
	</a>
	<div class="collapse navbar-collapse" id="navbarToggler">
		<ul class="navbar-nav ml-auto mt-2 mt-md-0">
            
			<li class="nav-item">
				<a href="viewHome" class="nav-link">All</a>
			</li>
			<li class="nav-item">
                <s:url var="categoryLink" value="viewByCategory">
                    <s:param name="categoryID" value="1" />
                </s:url>
                <s:a cssClass="nav-link" href="%{categoryLink}">
                    Economy
                </s:a>
			</li>
			<li class="nav-item">
                <s:url var="categoryLink" value="viewByCategory">
                    <s:param name="categoryID" value="2" />
                </s:url>
                <s:a cssClass="nav-link" href="%{categoryLink}">
                    Entertainment
                </s:a>
			</li>
			<li class="nav-item">
                <s:url var="categoryLink" value="viewByCategory">
                    <s:param name="categoryID" value="3" />
                </s:url>
                <s:a cssClass="nav-link" href="%{categoryLink}">
                    Politics
                </s:a>
			</li>
			<li class="nav-item">
                <s:url var="categoryLink" value="viewByCategory">
                    <s:param name="categoryID" value="4" />
                </s:url>
                <s:a cssClass="nav-link" href="%{categoryLink}">
                    Sports
                </s:a>
			</li>
			<li class="nav-item">
                <s:url var="categoryLink" value="viewByCategory">
                    <s:param name="categoryID" value="5" />
                </s:url>
                <s:a cssClass="nav-link" href="%{categoryLink}">
                    Education
                </s:a>
			</li>
			<li class="nav-item">
                <s:url var="categoryLink" value="viewByCategory">
                    <s:param name="categoryID" value="6" />
                </s:url>
                <s:a cssClass="nav-link" href="%{categoryLink}">
                    Health
                </s:a>
			</li>
			<li class="nav-item">
                <s:url var="categoryLink" value="viewByCategory">
                    <s:param name="categoryID" value="7" />
                </s:url>
                <s:a cssClass="nav-link" href="%{categoryLink}">
                    Family
                </s:a>
			</li>
			<li class="nav-item">
                <s:url var="categoryLink" value="viewByCategory">
                    <s:param name="categoryID" value="8" />
                </s:url>
                <s:a cssClass="nav-link" href="%{categoryLink}">
                    Travel
                </s:a>
			</li>
			<li class="nav-item">
                <s:url var="categoryLink" value="viewByCategory">
                    <s:param name="categoryID" value="9" />
                </s:url>
                <s:a cssClass="nav-link" href="%{categoryLink}">
                    Science
                </s:a>
			</li>
			<li class="nav-item">
                <s:url var="categoryLink" value="viewByCategory">
                    <s:param name="categoryID" value="10" />
                </s:url>
                <s:a cssClass="nav-link" href="%{categoryLink}">
                    World
                </s:a>
			</li>
		</ul>
	</div>
    <form action="searchArticle" method="POST">
        <input type="" name="searchValue" placeholder="Search" class="search">
        <button type="submit" style="display: none"></button>
    </form>

    
    
    <s:if test="%{#session.USERDETAILS != null}">
        <a href="manageProfile" class="profile-picture">
            <s:if test="%{#session.USERDETAILS.profilePicture != null && #session.USERDETAILS.profilePicture != ''}">
                <img src="data:image/jpeg;base64,<s:property value="%{#session.USERDETAILS.profilePicture}"/>" height="30px" width="30px" class="profile-pic">
            </s:if>
            <s:if test="%{#session.USERDETAILS.profilePicture == null || #session.USERDETAILS.profilePicture == ''}">
                <img src="assets/img/default-user.png" height="30px" width="30px" class="profile-pic">
            </s:if>
        </a>
        <a href="manageProfile" class="manageProfile"><span class="badge badge-info"><s:property value="%{#session.USERDETAILS.fullName}"/></span></a>
        <a href="logout" class="btn btn-danger logout" role="button">Log Out</a>
    </s:if>
</nav>