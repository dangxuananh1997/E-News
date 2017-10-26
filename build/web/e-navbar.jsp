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
            
			<li class="nav-item"><a href="home" class="nav-link">All</a></li>
			<li class="nav-item"><a href="home" class="nav-link">Economy</a></li>
			<li class="nav-item"><a href="home" class="nav-link">Entertainment</a></li>
			<li class="nav-item"><a href="home" class="nav-link">Politics</a></li>
			<li class="nav-item"><a href="home" class="nav-link">Sports</a></li>
			<li class="nav-item"><a href="home" class="nav-link">Education</a></li>
			<li class="nav-item"><a href="home" class="nav-link">Health</a></li>
			<li class="nav-item"><a href="home" class="nav-link">Family</a></li>
			<li class="nav-item"><a href="home" class="nav-link">Travel</a></li>
			<li class="nav-item"><a href="home" class="nav-link">Science</a></li>
			<li class="nav-item"><a href="home" class="nav-link">World</a></li>
		</ul>
	</div>
	<input type="" name="" placeholder="Search" class="search">

    
    
    <s:if test="%{#session.USERDETAILS != null}">
        <a href="manageProfile" class="profile-picture">
            <s:if test="%{#session.USERDETAILS.profilePicture != null && #session.USERDETAILS.profilePicture != ''}">
                <img src="data:image/jpeg;base64,<s:property value="%{#session.USERDETAILS.profilePicture}"/>" height="30px" width="30px" class="profile-pic">
            </s:if>
            <s:if test="%{#session.USERDETAILS.profilePicture == null || #session.USERDETAILS.profilePicture == ''}">
                <img src="assets/img/default-user.png" height="30px" width="30px" class="profile-pic">
            </s:if>
        </a>
        <a href="manageProfile"><span class="badge badge-info"><s:property value="%{#session.USERDETAILS.fullName}"/></span></a>
        <a href="logout">Logout</a>
    </s:if>
</nav>