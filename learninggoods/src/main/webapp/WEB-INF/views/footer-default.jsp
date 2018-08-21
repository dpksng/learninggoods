<div class="container-fluid footer">		
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<div class="footer-nav">
						<label class="category">Learninggoods</label>
						<ul>
							<li>
								<c:if test="${su!=null}">
									<a href="/learninggoods/default" class="nav-link menu-link">Home</a>
								</c:if>
								<c:if test="${su==null}">
									<a href="/learninggoods" class="nav-link menu-link">Home</a>
								</c:if>
							</li>
							<li><a href="/learninggoods/about">About</a></li>
							<li><a href="/learninggoods/feedback">Feedback</a></li>
							<li><a href="/learninggoods/contact">Contact</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="footer-nav">
					<label class="category">Languages</label>
						<ul>
							<li></li>
							<li><a href="/learninggoods/java">Java</a></li>
							<li><a href="/learninggoods/html">HTML</a></li>
							<li><a href="/learninggoods/css">CSS</a></li>
							<li><a href="/learninggoods/javascript">JavaScript</a></li>
							<li><a href="/learninggoods/python">Python</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="footer-nav">
						<label class="category">Important Links</label>
						<ul>
							<li></li>
							<li><a href="/learninggoods/disclaimer">Disclaimer</a></li>
							<li><a href="/learninggoods/privacy-policy">Privacy Policy</a></li>
							<li><a href="/learninggoods/terms">Terms</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-3">
						<label class="category">Social</label>
						<ul class="social_links">
							<li class="twitter animated bounceIn wow delay-02s"><a href="javascript:void(0)"><i class="fa fa-twitter"></i></a></li>
							<li class="facebook animated bounceIn wow delay-03s"><a href="javascript:void(0)"><i class="fa fa-facebook"></i></a></li>
							<li class="pinterest animated bounceIn wow delay-04s"><a href="javascript:void(0)"><i class="fa fa-pinterest"></i></a></li>
							<li class="gplus animated bounceIn wow delay-05s"><a href="javascript:void(0)"><i class="fa fa-google-plus"></i></a></li> 
						</ul>
				</div>
			</div>
		</div>
	</div>
	<footer>
		<span class="cpr">© 2018 <a href="/learninggoods">LEARNINGGOODS.COM</a> | ALL RIGHTS RESERVED</span>
	</footer>