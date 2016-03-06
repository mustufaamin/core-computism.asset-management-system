<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="assasaApp">
<head>
    <title>Harmony Brain</title>
    <script src = ../resources/js/libraries/bower_components/angular/angular.min.js></script>
    <script src = ../resources/js/libraries/bower_components/angular-resource/angular-resource.min.js></script>
    <script src = ../resources/js/assasa/app.js></script>
    <script src = ../resources/js/assasa/service.js></script>
    <script src = ../resources/js/assasa/controller.js></script>
    <link href = "../resources/js/libraries/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">


</head>
<body>
    <div id="wrapper">
        <%-- side bar--%>
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li><a href="#">Account</a></li>
                <li><a href="#">Settings</a></li>
                <li><a href="#">Logout</a></li>
            </ul>
        </div>
        <%--Page Content--%>
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="col-lg-12">
                    <a href="#" class="btn btn-success" id="menu-toggle">Toggle Menu</a>
                    <h1>Side Barr</h1>
                    <p>
                        THis is the side bar demo THis is the side bar demo THis is the side bar demo THis is the side bar demo
                    </p>
                </div>
            </div>
        </div>

    </div>

    <input ng-model = customers>
    {{customers}}
    <button ng-click="getList()" ng-init="count=0">Get</button>
    <button ng-click="addType()" ng-init="count=0">AddItemType</button>
    <button ng-click="addSupplier()" ng-init="count=0">addSupplier</button>

    {{postBody}}
</div>

</div>
<h3>Harmony - Brain started successfully!</h3>
${message}
</body>
</html>
