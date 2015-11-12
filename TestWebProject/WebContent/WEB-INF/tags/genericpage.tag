<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<html>
<head>
	<link type="text/css" rel="stylesheet" href="../resources/css/template.css" />
    <link  rel="stylesheet" type="text/css" href="../resources/css/account-tabs.css"/>
    <link rel="stylesheet" href="../resources/css/UserMenu.css" type="text/css" />
	<link href="../resources/css/styles.css" rel="stylesheet" type="text/css" />
</head>
  <body>
  <div id="header">
	    <div id="logo" class="logo"><img src="../resources/images/logo.png" alt="Stream Health" /></div>
	    <div id="topMenu">
		    <a href="default_logged.aspx" id="homeifloggedLink">Home</a>
            <a href="Members/default.aspx" id="homeifnotloggedLink">Home</a>
		    <a href="../aboutPage.aspx">About</a>
            <a href="../ProductChoice.aspx">Pricing</a>
		    <a href="../benefitsPage.aspx">Benefits</a>
		    <a href="../contactPage.aspx">Contact Us</a>
        </div>
	    <div id="userArea">
            <div>
		        <a href="Members/Login.aspx" id="loginLink">Login</a>
		        <a href="Members/Register.aspx" id="registerLink">Register</a>
            <nav class="dropDownUserMenu" id="menu_user">
				<ul>
					<li>
						<a href="#" class="UserAccountMenu"></a>
						<ul class="fallback">
							<li><a href="PersonalDetailsPage.aspx" class="myAccountMItem">My Account</a></li>
							<li><a href="PurchasePage.aspx" class="myStreamsMItem">My Streams</a></li>
                            <li><a href="myPackets.aspx" class="myStreamsMItem">My Packets</a></li>
							<li><a href="settings.aspx" class="settingsMItem">Settings</a></li>
							<li><a href="#" class="logoutMItem">Log Out</a></li>
						</ul>
					</li>
				</ul>
			</nav>
			    <div class="newMessages" id="new_messages">
				  <a href="AlertPage.aspx">Messages</a>
			    </div>
            </div>
	    </div>
	    <div class="clear"></div>
    </div>
      <jsp:invoke fragment="header"/>
    <div id="body">
    <div id="pageHeader" class="dashboard">
    <h1 id="title1">Dashboard</h1>
    <nav id="menu_options">
		<a href="UserDashboard2.aspx">Dashboard</a>
        <a href="SelectStreamforStateDiagram.aspx">Diagrams</a>
		<a href="AlertPage.aspx">Messages</a>
		<a href="logsPage.aspx">Logs</a>
		<a href="../AddStream.aspx">Add Stream</a>
	</nav>
	</div>
	<div class="clear"></div>
    
    
    
    
    <font color="red">
      <jsp:doBody/>
      </font>
    </div>
    <div id="pagefooter">
      <jsp:invoke fragment="footer"/>
      <div id="footer">
	<div class="social">facebook twitter</div>
	<div id="bottom-menu">
		<div>
			<img src="../resources/images/logo-small.png" alt="streamhealth" />
			<div class="items">
				<div><a href="../aboutPage.aspx">About StreaHealth</a> <a href="../ProductChoice.aspx">Pricing</a> <a href="../benefitsPage.aspx">Benefits</a>  </div>
				<div><a href="#">My Account</a>  <a href="../contactPage.aspx">Contact Us</a> <a href="#">Register</a></div>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div id="disclaimer">
	<a href="../legalAgreementsPage.aspx">Legal agreements</a>
	<a href="../TermsOfUsePage.aspx">Terms of use</a>
	<a href="../privacyPolicyPage.aspx">Privacy policy</a>
	<p>©2015 StreamHealth. The StreamHealth is a trademark of Gloman S.A.</p>
	</div>
</div>
    </div>
  </body>
</html>
