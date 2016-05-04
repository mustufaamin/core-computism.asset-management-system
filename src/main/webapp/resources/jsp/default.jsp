<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assasa</title>
    <%--<base href="/home">--%>




    <link  href="resources/libraries/bower-components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link id="base-style" href="resources/css/style.css" rel="stylesheet">
    <link id="base-style-responsive" href="resources/css/style-responsive.css" rel="stylesheet">
    <link href="resources/css/font-awesome/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="resources/libraries/bower-components/ng-table/dist/ng-table.css">

    <link href="resources/modules/customer/css/customer.css" rel="stylesheet">
    <link href="resources/modules/account-receivable/css/account-receivable.css" rel="stylesheet">
    <link href="resources/modules/account-receivable/sub-modules/payments/payment-type/css/payment-type.css" rel="stylesheet">
    <link href="resources/modules/account-receivable/sub-modules/admin/ar-types/css/ar-types.css" rel="stylesheet">
    <link href="resources/modules/account-receivable/sub-modules/admin/billcodes/css/billcodes.css" rel="stylesheet">
    <link href="resources/css/asasa/asasa.css" rel="stylesheet">

    <link rel="stylesheet" href="resources/libraries/bower-components/angular-material/angular-material.min.css">
</head>
<body ng-app="Asasa">
<div class="container-fluid-full"   layout="column" ng-cloak="" class="md-inline-form inputdemoBasicUsage" ng-controller="MainModulesController as mainMdlsCtrl">
    <div>
        <order-management-panel></order-management-panel>
    </div>


    <%--<div class="row-fluid">--%>

        <!-- start: Main Menu -->
        <%--<div id="sidebar-left" class="span2">--%>
            <%--<div class="nav-collapse sidebar-nav">--%>
                <%--<ul class="nav nav-tabs nav-stacked main-menu">--%>
                    <%--<li><a href="index.html"><i class="icon-bar-chart"></i><span class="hidden-tablet"> Dashboard</span></a></li>--%>
                    <%--<li><a href="messages.html"><i class="icon-envelope"></i><span class="hidden-tablet"> Messages</span></a></li>--%>
                    <%--<li><a href="tasks.html"><i class="icon-tasks"></i><span class="hidden-tablet"> Tasks</span></a></li>--%>
                    <%--<li><a href="ui.html"><i class="icon-eye-open"></i><span class="hidden-tablet"> UI Features</span></a></li>--%>
                    <%--<li><a href="widgets.html"><i class="icon-dashboard"></i><span class="hidden-tablet"> Widgets</span></a></li>--%>
                    <%--<li>--%>
                        <%--<a class="dropmenu" href="#"><i class="icon-folder-close-alt"></i><span class="hidden-tablet"> Dropdown</span><span class="label label-important"> 3 </span></a>--%>
                        <%--<ul>--%>
                            <%--<li><a class="submenu" href="submenu.html"><i class="icon-file-alt"></i><span class="hidden-tablet"> Sub Menu 1</span></a></li>--%>
                            <%--<li><a class="submenu" href="submenu2.html"><i class="icon-file-alt"></i><span class="hidden-tablet"> Sub Menu 2</span></a></li>--%>
                            <%--<li><a class="submenu" href="submenu3.html"><i class="icon-file-alt"></i><span class="hidden-tablet"> Sub Menu 3</span></a></li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
                    <%--<li><a href="form.html"><i class="icon-edit"></i><span class="hidden-tablet"> Forms</span></a></li>--%>
                    <%--<li><a href="chart.html"><i class="icon-list-alt"></i><span class="hidden-tablet"> Charts</span></a></li>--%>
                    <%--<li><a href="typography.html"><i class="icon-font"></i><span class="hidden-tablet"> Typography</span></a></li>--%>
                    <%--<li><a href="gallery.html"><i class="icon-picture"></i><span class="hidden-tablet"> Gallery</span></a></li>--%>
                    <%--<li><a href="table.html"><i class="icon-align-justify"></i><span class="hidden-tablet"> Tables</span></a></li>--%>
                    <%--<li><a href="calendar.html"><i class="icon-calendar"></i><span class="hidden-tablet"> Calendar</span></a></li>--%>
                    <%--<li><a href="file-manager.html"><i class="icon-folder-open"></i><span class="hidden-tablet"> File Manager</span></a></li>--%>
                    <%--<li><a href="icon.html"><i class="icon-star"></i><span class="hidden-tablet"> Icons</span></a></li>--%>
                    <%--<li><a href="login.html"><i class="icon-lock"></i><span class="hidden-tablet"> Login Page</span></a></li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        <%--</div>--%>
        <!-- end: Main Menu -->

        <!-- start: Content -->
        <%--<div class="slideoverlay">

        </div>
        <div class="slidepanel">

        </div>--%>
        <%--<div id="content-m" class="span10">--%>


            <%--<ul class="breadcrumb">--%>
                <%--<li>--%>
                    <%--<i class="icon-home"></i>--%>
                    <%--<a ui-sref="home">Home</a>--%>
                    <%--<i class="icon-angle-right"></i>--%>
                <%--</li>--%>
                <%--<li><a href="#">Dashboard</a></li>--%>
            <%--</ul>--%>


            <%--<div ui-view ng-show="mainMdlsCtrl.showCustomerPanel">--%>
                <%--<customer-panel></customer-panel>--%>
            <%--</div>--%>
            <%--<div ui-view ng-show="mainMdlsCtrl.showArPanel">--%>
                <%--<account-receivable-panel></account-receivable-panel>--%>
            <%--</div>--%>
            <%--<div ui-view ng-show="mainMdlsCtrl.showMainModules">--%>
                <%--<home-panel></home-panel>--%>
            <%--</div>--%>

        <!--/.fluid-container-->

        <!-- end: Content -->
        <%--</div><!--/#content.span10-->--%>
    <%--</div><!--/fluid-row-->--%>


    <%--<div class="modal hide fade" id="myModal">--%>
        <%--<div class="modal-header">--%>
            <%--<button type="button" class="close" data-dismiss="modal">×</button>--%>
            <%--<h3>Settings</h3>--%>
        <%--</div>--%>
        <%--<div class="modal-body">--%>
            <%--<p>Here settings can be configured...</p>--%>
        <%--</div>--%>
        <%--<div class="modal-footer">--%>
            <%--<a href="#" class="btn" data-dismiss="modal">Close</a>--%>
            <%--<a href="#" class="btn btn-primary">Save changes</a>--%>
        <%--</div>--%>
    <%--</div>--%>

<%--<div class="clearfix"></div>--%>

<%--<footer>--%>

    <%--<p>--%>
        <%--<span style="text-align:left;float:left">&copy; 2016 <a href="#" alt="">Core Computism</a></span>--%>
    <%--</p>--%>

<%--</footer>--%>

    <%--Custom JS files--%>

    <script src="resources/libraries/bower-components/angular/angular.js"></script>


    <script src="resources/libraries/angular-route.min.js"></script>
    <script src="resources/libraries/jquery-1.9.1.min.js"></script>
    <script src="resources/libraries/jquery-migrate-1.0.0.min.js"></script>
    <script src="resources/libraries/jquery-ui-1.10.0.custom.min.js"></script>
    <script src="resources/libraries/jquery.ui.touch-punch.js"></script>
    <script src="resources/libraries/modernizr.js"></script>
    <script src="resources/libraries/bower-components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="resources/libraries/jquery.cookie.js"></script>
    <script src="resources/libraries/fullcalendar.min.js"></script>
    <script src="resources/libraries/jquery.dataTables.min.js"></script>
    <script src="resources/libraries/excanvas.js"></script>
    <script src="resources/libraries/jquery.flot.js"></script>
    <script src="resources/libraries/jquery.flot.pie.js"></script>
    <script src="resources/libraries/jquery.flot.stack.js"></script>
    <script src="resources/libraries/jquery.flot.resize.min.js"></script>
    <script src="resources/libraries/jquery.chosen.min.js"></script>
    <script src="resources/libraries/jquery.uniform.min.js"></script>
    <script src="resources/libraries/jquery.cleditor.min.js"></script>
    <script src="resources/libraries/jquery.noty.js"></script>
    <script src="resources/libraries/jquery.elfinder.min.js"></script>
    <script src="resources/libraries/jquery.raty.min.js"></script>
    <script src="resources/libraries/jquery.iphone.toggle.js"></script>
    <script src="resources/libraries/jquery.uploadify-3.1.min.js"></script>
    <script src="resources/libraries/jquery.gritter.min.js"></script>
    <script src="resources/libraries/jquery.imagesloaded.js"></script>
    <script src="resources/libraries/jquery.masonry.min.js"></script>
    <script src="resources/libraries/jquery.knob.modified.js"></script>
    <script src="resources/libraries/jquery.sparkline.min.js"></script>
    <script src="resources/libraries/counter.js"></script>
    <script src="resources/libraries/retina.js"></script>
    <script src="resources/libraries/custom.js"></script>
    <script src="resources/libraries/ui-bootstrap-tpls-0.14.3.js"></script>


    <script src="resources/modules/asasa.js"></script>
    <script src="resources/modules/home/home.js"></script>
    <script src="resources/modules/customer/customer.js"></script>
    <script src="resources/modules/pos/order-management.js"></script>
    <script src="resources/modules/account-receivable/account-receivable.js"></script>
    <script src="resources/modules/account-receivable/sub-modules/payments/payment-type/payment-type.js"></script>
    <script src="resources/modules/account-receivable/sub-modules/admin/ar-types/ar-types.js"></script>
    <script src="resources/modules/account-receivable/sub-modules/admin/billcodes/billcodes.js"></script>
    <script src="resources/modules/general-ledger/admin/account-type/account_type.js"></script>
    <script src="resources/libraries/bower-components/ng-table/dist/ng-table.js"></script>
    <script src="resources/libraries/bower-components/angular-resource/angular-resource.min.js"></script>
    <script src="resources/libraries/bower-components/angular-ui-router/release/angular-ui-router.min.js"></script>

    <script src="resources/libraries/bower-components/angular-animate/angular-animate.min.js"></script>
    <script src="resources/libraries/bower-components/angular-aria/angular-aria.min.js"></script>
    <script src="resources/libraries/bower-components/angular-messages/angular-messages.min.js"></script>
    <script src="resources/libraries/bower-components/angular-material/angular-material.min.js"></script>
    <script src="resources/libraries/bower-components/lodash/dist/lodash.min.js"></script>




</div>

</body>
</html>
