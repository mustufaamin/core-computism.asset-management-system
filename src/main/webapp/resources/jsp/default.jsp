<html>
<head>
	<title>Assasa</title>
	<%--<base href="/">--%>

	<link id="bootstrap-style" href="resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="resources/css/font-awesome/font-awesome.min.css" rel="stylesheet">
	<link href="resources/fonts/alex_brushregular/stylesheet.css" rel="stylesheet">
	<link href="resources/css/ng-slim-scroll.css" rel="stylesheet">

	<%--Custom CSS--%>
	<link href="resources/css/asasa/asasa.css" rel="stylesheet">
	<link href="resources/modules/customer/css/customer.css" rel="stylesheet">

</head>
<body ng-app="Asasa" ng-controller="AsasaController as asasaCtrl">
<div class="container-fluid">
	<div class="headerMain row">
			<span class=" col-xs-3">
				<span class="heading">Assasa</span>
			</span>
			<span class="right-head pull-right">
				<span class=" col-xs-6 as-search">
					<input type="text" name="search" class="form-control as-inpt anime right" placeholder="Search..."></input>
					<img class="searchIcon anime" src="resources/images/search.svg" alt="Search">
				</span>
				<span class="anime pull-right as-options">
					<span class="profileImg"><img src="resources/images/umer.jpg" alt=""></span>
					<label class="profileName">Muhammad Umer</label>
					<span class="downCaret">&nbsp;<i class="fa fa-caret-down" aria-hidden="true"></i><!-- <img src="images/arrow-head-down.png" alt=""> --></span>
					<ul class="profileDD anime">
						<li><a>Yawer Ahmed</a></li>
						<li><a>Muhammad Umer</a></li>
						<li><a>Umair Ullah</a></li>
					</ul>
				</span>
				
			</span>
	</div>
	<div class="content row" ui-view>
		<div ui-sref="modules" ng-show="asasaCtrl.openHomePanel">
			<module-panel></module-panel>
		</div>
		<div ui-sref="customer" ng-show="asasaCtrl.openCustomerModule">
			<customer-panel></customer-panel>
		</div>
		<div ui-sref="ar" ng-show="asasaCtrl.openArModule">
			<customer-panel></customer-panel>
		</div>
	</div>
	<div class="footer row">
		<div class="copyright col-xs-6">
			<span class="cpyrightlbl">&copy; 2016 <a href="#" alt="" class="cpyrightlink">Core Computism</a></span>
		</div>
		<div class="socialmedia col-xs-6 pull-right">
				<span class="socialmediaWrapper">
					<img src="resources/images/facebook.svg" alt="Facebook" class="anime">
					<img src="resources/images/twitter.svg" alt="Twitter" class="anime">
					<img class="g-plus anime" src="resources/images/google-plus.svg" alt="Google+">
				</span>
		</div>
	</div>
	<script src="resources/libraries/bower-components/angular/angular.js"></script>
	<script src="resources/libraries/bower-components/ng-table/dist/ng-table.js"></script>
	<script src="resources/libraries/bower-components/angular-resource/angular-resource.min.js"></script>
	<script src="resources/libraries/bower-components/angular-ui-router/release/angular-ui-router.min.js"></script>
	<script src="resources/libraries/datetimepicker.js"></script>
	<script src="resources/libraries/bower-components/angular-bootstrap/ui-bootstrap-tpls.min.js"></script>
	<script src="resources/libraries/bower-components/angular-animate/angular-animate.min.js"></script>
	<script src="resources/libraries/bower-components/jquery/dist/jquery.min.js"></script>
	<script src="resources/libraries/scroll-script.js"></script>

	<%--Custom JS--%>
	<script src="resources/modules/asasa.js"></script>
	<script src="resources/modules/home/modules.js"></script>
	<script src="resources/modules/customer/customer.js"></script>
	<script src="resources/modules/account-receivable/account-receivable.js"></script>
	<script src="resources/modules/account-receivable/sub-modules/payments/ar-payment.js"></script>

</div>
</body>
</html>
