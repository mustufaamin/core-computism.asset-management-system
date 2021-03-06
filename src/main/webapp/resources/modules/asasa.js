/**
 * Created by Muhammad Umer on 3/12/2016.
 */
var app = angular.module('Asasa', ['ngTable', 'ngRoute', 'ngResource', 'ui.router']);

app.controller('MainModulesController', ['$http', '$window', '$location',  function ($http, $window, $location){
    var mainMdlsCtrl = this;
    mainMdlsCtrl.showMainModules = true;

    mainMdlsCtrl.showCustomerPanel = false;
    mainMdlsCtrl.showArPanel = false;

    mainMdlsCtrl.openCustomerPanel =  function(){
        mainMdlsCtrl.showMainModules = false;
        mainMdlsCtrl.showArPanel = false;
        mainMdlsCtrl.showCustomerPanel = true;
    };

    mainMdlsCtrl.openArPanel = function(){
        mainMdlsCtrl.showMainModules = false;
        mainMdlsCtrl.showCustomerPanel = false;
        mainMdlsCtrl.showArPanel = true;
    };

}]);

app.config(['$stateProvider', '$urlRouterProvider', '$locationProvider',  function ($stateProvider, $urlRouterProvider, $locationProvider) {
    $urlRouterProvider.otherwise('/home');

    $stateProvider
        .state('home', {
            url: '/home',
            templateUrl: 'resources/modules/home/templates/home-panel.jsp'
        })

        .state('customer', {
            url: '/customer',
            templateUrl: 'resources/modules/customer/templates/customer-panel.jsp'
        })

        .state('ar', {
            url: '/ar',
            templateUrl: 'resources/modules/account-receivable/templates/account-receivable-panel.jsp'
        })

        .state('arTypes', {
            url: '/arTypes',
            templateUrl: 'resources/modules/account-receivable/sub-modules/admin/ar-types/templates/ar-types-panel.jsp'
        })

        .state('paymentTypes', {
            url: '/paymentTypes',
            templateUrl: 'resources/modules/account-receivable/sub-modules/payments/payment-type/template/payment-type-panel.jsp'
        })

    ;


    /*$locationProvider.html5Mode(true);*/

}]);

/*app.run(['$rootScope', '$state', '$stateParams',
    function ($rootScope, $state, $stateParams) {
        $rootScope.$state = $state;
        $rootScope.$stateParams = $stateParams;
    }]);

app.run(['$q', '$rootScope','$http', '$urlRouter','$stateProvider',
    function ($q, $rootScope, $http, $urlRouter, $stateProvider)
    {
        $http
            .get("resources/views.json")
            .success(function(data)
            {
                angular.forEach(data, function (value, key)
                {
                    var state = {
                        "url": value.url,
                        "parent" : value.parent,
                        "abstract": value.abstract,
                        "views": {}
                    };

                    angular.forEach(value.views, function (view)
                    {
                        state.views[view.name] = {
                            templateUrl : view.templateUrl
                        };
                    });

                    $stateProvider.state(value.name, state);
                });
                // Configures $urlRouter's listener *after* your custom listener

                $urlRouter.sync();
                $urlRouter.listen();
            });
    }]);*/

