


	<nav class="navbar navbar-home" id="common-navbar">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                      data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand brand" href="/">Team-Pool</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse navbar-left" id="navbar-main-search">
	      <form class="navbar-form navbar-left" role="search">
	        <div class="form-group">
	          <input type="text" class="form-control" placeholder="Search" id="main-search-box">
	        </div>
	        <button type="submit" class="btn btn-default">Submit</button>
	      </form>

              <!--
	      <div id="notifications-div">
	      		<a href="javascript:void(0)" id="notification-icon"
                           class="notification-icon dropdown-toggle"
                           data-toggle="dropdown" title="notifications">
				<span class="glyphicon glyphicon-bell"></span>
			</a>
			<span id="notification-counts"></span>
			<ul class="dropdown-menu" id="notification-dropdown"></ul>
	      </div>
              -->
	      
	    </div><!-- /.navbar-collapse -->
	    <div class="collapse navbar-collapse navbar-right">
	         <ul class="nav navbar-nav navbar-right help-navbar">
		        <li class="dropdown">
	      		<a href="javascript:void(0)" id="notification-icon"
                           class="header-user-icon dropdown-toggle" data-toggle="dropdown">
				<span class="glyphicon glyphicon-user"></span>
				<span class="caret"></span>
			</a>
		          <ul class="dropdown-menu">
		            <li><a href="/profile">Profile</a></li>
		            <li><a href="#">Settings</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="/service/auth/logout">Logout</a></li>
		          </ul>
		        </li>
		     </ul>
		     <ul class="nav navbar-nav create-navbar">
		        <li class="light_radial_gradient">
		          <a href="/products" role="button">Products</a>
		        </li>
		     </ul>
			 <ul class="nav navbar-nav create-navbar">
		        <li class="light_radial_gradient">
		          <a href="/teams" role="button">Teams</a>
		        </li>
		     </ul>

		     <ul class="nav navbar-nav create-navbar">
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
		          		aria-haspopup="true" aria-expanded="false">Add <span class="caret"></span></a>
		          <ul class="dropdown-menu">
				<!--
		            <li><a href="#" onclick="addProduct();return false;">Product</a></li>
				-->
		            <li><a href="#" data-toggle="modal" data-target="#addProductModal">Product</a></li>
		            <li><a href="#" onclick="addTeam();return false;">Team</a></li>
		            <li class="divider"></li>
		            <li><a href="#" onclick="addUser();return false;">User</a></li>
		          </ul>
		        </li>
		     </ul>
	    </div>
	  </div><!-- /.container-fluid -->
	</nav>
