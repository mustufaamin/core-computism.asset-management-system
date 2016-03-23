/**
 * Created by Muhammad Umer on 3/21/2016.
 */
(function(){
    angular.module('Asasa')
        .directive('paymentTypePanel', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/sub-modules/payments/payment-type/template/payment-type-panel.jsp'
            }
        });

    angular.module('Asasa')
        .controller('PaymentTypeController', ['$http', function($http){
            var paymentTypeCtrl = this;

        }]);
})();