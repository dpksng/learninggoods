<nav class="navbar navbar-light header navbar-toggleable-md">
				<div class="container">
					<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<c:set var="su" value="${su}"/>
					<c:if test="${su!=null}">
						<a class="navbar-brand" href="/learninggoods/default"><img src="<%=request.getContextPath()%>/resources/img/logo.png" width="220" height="26"></a>
					</c:if>
					<c:if test="${su==null}">
						<a class="navbar-brand" href="/learninggoods"><img src="<%=request.getContextPath()%>/resources/img/logo.png" width="220" height="26"></a>
					</c:if>
					<div class="collapse navbar-collapse menu" id="navbarSupportedContent">
						<ul class="navbar-nav ml-auto menu-nav">
							<li>
								<c:if test="${su!=null}">
									<a href="/learninggoods/default" class="nav-link menu-link">Home</a>
								</c:if>
								<c:if test="${su==null}">
									<a href="/learninggoods" class="nav-link menu-link">Home</a>
								</c:if>
							</li>
							<li>
								<a href="/learninggoods/about" class="nav-link menu-link">About</a>
							</li>
							<li>
								<a href="/learninggoods/contact" class="nav-link menu-link">Contact</a>
							</li>
							<c:set var="su" value="${su}"/>
							<c:if test="${su!=null}">
								 <li class="nav-item menu-link dropdown">
									<a class="nav-link menu-link dropdown-toggle" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
										${su.name}
									</a>
									<div class="dropdown-menu drop-color">
										<a class="dropdown-item" href="/learninggoods/edit-profile/${su.email}">Edit Profile</a>
										<a class="dropdown-item" href="/learninggoods/userLogout">Logout</a>
									</div>
								</li>																			
							</c:if>
						</ul>
					</div>
				</div>
			</nav>