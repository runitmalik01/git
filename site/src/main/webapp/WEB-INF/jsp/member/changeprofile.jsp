<%@include file="../includes/tags.jspf" %>
<script type="text/javascript" src="http://yui.yahooapis.com/2.9.0/build/datatable/datatable-min.js"></script>
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/2.9.0/build/datatable/assets/skins/sam/datatable.css" />
<ol id="breadcrumbs">
 <li><fmt:message key="member.location.label"/></li>
 <li>
     <hst:link var="home" siteMapItemRefId="home" />
     <a href="${home}"><fmt:message key="products.detail.location.home"/></a>&gt;
 </li>
 <li><span>Hello abhishek!</span>
<li class="rightfloat utilDelim"><a href="/site/memberLogin">My Account</a></li>
<li class="rightfloat"><a href="/site/memberLogin">Logout</a>
</li>
<li class="rightfloat"></li>
		<li class="rightfloat" style="padding-left: 20px"><a
						href="https://graph.facebook.com/oauth/authorize?client_id=102780276150&redirect_uri=http%3A%2F%2Flistings.mootly.com%2Foauth%2Fredirect&scope=publish_stream">Login
							to Facebook</a></li>
</ol>
<hst:actionURL var="actionUrl"/>
<%-- nav-container --%>
		<div id="container">
			<div id="home">
			<span id="notice" class="notice">Logged in
					successfully</span>
				   <ul style="padding: 0; margin: 0">
					<li style="list-style: none; display: inline"><a
						href="/account/myaccount">Change Profile</a>
					</li>
					<li style="list-style: none; display: inline"><a
						href="/account/mylistings">My Listings</a>
					</li>
					<li style="list-style: none; display: inline"><a
						href="/account/favorites">My Favorites</a>
					</li>
					<li style="list-style: none; display: inline"><a
						href="mymessages">My Messages</a>
					</li></ul>
           </div>
				
       <div align="center" class="signupform">
				<form action="${actionUrl} }" method="post">
					<table>
							
						<tr>
							<td colspan="2" style="font-weight: bold; font-size: bigger">Choosing
								your User Name</td>
						</tr>
						<tr>
							<td><label for="login" class="required">User Name</label>
							</td>
							<td><span id="error_user[login]" class="errormessage"></span>
								abhishek bhardwaj</span></td>
						</tr>
						<tr>
							<td><label for="email" class="required">Email</label>
							</td>
							<td>abhishek.hcst14@gmail.com <a href="/site/changeemail">Change
									Email</a><br/></td>
						</tr>
						<tr>

							<tr>
								<td><label for="password">Password</label>
								</td>
								<td>**********<small>Hidden for security</small> <a
									href="/site/changepass">Change Password</a><br/>
								</td>
							</tr>

							<tr>
								<td colspan="2" style="font-weight: bold; font-size: bigger">More
									information about you (optional)</td>
							</tr>
							<tr>
								
									<td><label for="sex">Sex</label>
									</td>
									<td><select id="user_sex" name="user[sex]"><option
												value="">Select</option>
											<option value="F">female</option>
											<option value="M" selected="selected">male</option>
									</select>
									</td>
							
							</tr>
							<tr>
								<td><label for="first_name">First Name</label>
								</td>
								<td><input id="user_first_name" name="user[first_name]"
									size="30" type="text" value="" />
								</td>
							</tr>
							<tr>
								<td><label for="last_name">Last Name</label>
								</td>
								<td><input id="user_last_name" name="user[last_name]"
									size="30" type="text" value="" />
								</td>
							</tr>

							<tr>
								<td><label for="city">City</label>
								</td>
								<td><input id="user_city" name="user[city]" size="30"
									type="text" value="" />
								</td>
							</tr>

							<tr>
								<td colspan="1" align="right"></td>
								<td align="left"><input name="commit" type="submit"
									value="Save changes" /></td>
							</tr>
					</table>
				</form>
			</div>
		</div>

</body>
</html>

<hst:headContribution keyHint="tablecss">
	<link type="text/css" rel="stylesheet"
		href='<hst:link path="/css/Newstyle.css"/>' />
</hst:headContribution>
<hst:headContribution keyHint="tablecss">
	<link type="text/css" rel="stylesheet"
		href='<hst:link path="/css/adornment.css"/>' />
</hst:headContribution>
<hst:headContribution keyHint="ExternalCSS">
	<link rel="stylesheet"
		href='<hst:link path="http://yui.yahooapis.com/3.8.0/build/cssbutton/cssbutton.css"/>'
		type="text/css" />
</hst:headContribution>
<hst:headContribution keyHint="formcss">
	<link rel="stylesheet"
		href='<hst:link path="/css/animation/animation.css"/>' type="text/css" />
</hst:headContribution>
<hst:headContribution keyHint="formcss">
	<link type="text/css" rel="stylesheet"
		href='<hst:link path="/css/adornment.css"/>' />
</hst:headContribution>
<hst:headContribution keyHint="ExternalCSS">
	<link rel="stylesheet"
		href='<hst:link path="http://yui.yahooapis.com/3.8.0/build/cssbutton/cssbutton.css"/>'
		type="text/css" />
</hst:headContribution>
