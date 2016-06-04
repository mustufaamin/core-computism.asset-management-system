/**
 * Created by Muhammad Umer on 3/24/2016.
 */
(function(){
    var app = angular.module('Asasa');
    app.directive('modulePanel', function(){
        return{
            restrict: "E",
            templateUrl: 'resources/modules/home/templates/module-panel.jsp'
        }
    });



    app.controller('ModuleController', ['$rootScope', function($rootScope){
        var moduleCtrl = this;

        moduleCtrl.openCustomerModule = function(){
            $rootScope.$broadcast("OPEN_CUSTOMER_PANEL", {});
        };

        moduleCtrl.openArModule = function(){
            $rootScope.$broadcast("OPEN_AR_PANEL", {});
        };

    }]);

})();