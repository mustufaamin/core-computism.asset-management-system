/**
 * Created by VD on 3/12/2016.
 */
(function(){
    angular.module('Asasa').directive('customerPanel', function(){
        return{
            restrict: "E",
            templateUrl: 'resources/modules/customer/templates/customer-panel.jsp'
        }
    });

    angular.module('Asasa').directive('addEditCustomerSlidePanel', function(){
        return{
            restrict: "E",
            templateUrl: 'resources/modules/customer/templates/add-edit-customer-slide-panel.jsp'
        }
    });

    angular.module('Asasa').controller('CustomerController', ['$http', function($http){

    }]);
})();
