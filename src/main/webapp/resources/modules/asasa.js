/**
 * Created by Muhammad Umer on 3/12/2016.
 */
var app = angular.module('Asasa', ["ngTable", "ngRoute"]);

app.controller('MainModulesController', ['$http', '$window', '$location',  function ($http, $window, $location){
    var mainMdlsCtrl = this;
    mainMdlsCtrl.showMainModules = true;
    mainMdlsCtrl.showCustomerPanel = false;

    mainMdlsCtrl.openCustomerPanel =  function(path){
        mainMdlsCtrl.showMainModules = false;
        mainMdlsCtrl.showCustomerPanel = true;
        $window.location.href = path;
    };

}]);

app.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
    $locationProvider.html5Mode(true);

    $routeProvider.when("/assasa", { templateUrl: "resources/modules/default.jsp" }).
        when("/customer", { templateUrl: "resources/modules/customer/templates/customer-panel.jsp" })
        otherwise({ redirectTo: '/assasa' });

}]);