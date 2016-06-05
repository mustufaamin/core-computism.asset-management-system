/**
 * Created by Muhammad Umer on 3/12/2016.
 */
var app = angular.module('Asasa', ['ngTable', 'ngResource', 'ui.router','ngAnimate', 'ui.bootstrap','ui.bootstrap.datetimepicker']);

app.controller('AsasaController', ['$rootScope', '$http', '$window', '$location', '$scope',  function ($rootScope, $http, $window, $location, $scope){
    var asasaCtrl = this;
    asasaCtrl.openCustomerModule = false;
    asasaCtrl.openHomePanel = true;
    asasaCtrl.openArModule = false;

    $scope.$on("OPEN_CUSTOMER_PANEL", function(events, args){
        asasaCtrl.openHomePanel = false;
        asasaCtrl.openCustomerModule = true;
        asasaCtrl.openArModule = false
    });

    $scope.$on("OPEN_AR_PANEL", function(events, args){
        asasaCtrl.openHomePanel = false;
        asasaCtrl.openCustomerModule = false;
        asasaCtrl.openArModule = true;
    });

}]);

app.config(['$stateProvider', '$urlRouterProvider', '$locationProvider',  function ($stateProvider, $urlRouterProvider, $locationProvider) {
    $urlRouterProvider.otherwise('/home');

    $stateProvider
        .state('modules', {
            url: '/home',
            templateUrl: 'resources/modules/home/templates/module-panel.jsp'
        })

        .state('customer', {
            url: '/customer',
            templateUrl: 'resources/modules/customer/templates/customer-panel.jsp'
        })

        .state('ar', {
            url: '/ar',
            templateUrl: 'resources/modules/account-receivable/templates/account-receivable-panel.jsp'
        })

        /*.state('arTypes', {
            url: '/arTypes',
            templateUrl: 'resources/modules/account-receivable/sub-modules/admin/ar-types/templates/ar-types-panel.jsp'
        })

        .state('billCodes', {
            url: '/billCodes',
            templateUrl: 'resources/modules/account-receivable/sub-modules/admin/billcodes/templates/bill-codes-panel.jsp'
        })

        .state('paymentTypes', {
            url: '/paymentTypes',
            templateUrl: 'resources/modules/account-receivable/sub-modules/admin/payment-type/template/payment-type-panel.jsp'
        })

        .state('GlAccountType', {
            url: '/GlAccountType',
            templateUrl: 'resources/modules/general-ledger/admin/account-type/templates/gl-account-type-panel.jsp'
        })

        .state('arAdjustment', {
            url: '/arAdjustment',
            templateUrl: 'resources/modules/account-receivable/sub-modules/adjustments/adjustment/templates/ar-adjustment-panel.jsp'
        })

        .state('inquiry/arAccount', {
            url: '/inquiry/arAccount',
            templateUrl: 'resources/modules/account-receivable/sub-modules/inquiry/ar-account/template/ar-account-panel.jsp'
        })
        .state('pos/order', {
            url: '/pos/order',
            templateUrl: '/resources/modules/pos/templates/order-management.jsp'
        })

        .state('inquiry/arTransaction', {
            url: '/inquiry/arTransaction',
            templateUrl: 'resources/modules/account-receivable/sub-modules/inquiry/ar-transaction/template/ar-transaction-panel.jsp'
        })

        .state('pos/admin/item', {
            url: '/pos/admin/item',
            templateUrl: 'resources/modules/pos/item/template/pos-item-panel.jsp'
        })*/
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

