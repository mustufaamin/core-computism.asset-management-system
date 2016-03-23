/**
 * Created by Muhammad Umer on 3/15/2016.
 */
(function(){
    angular.module('Asasa')
        .directive('accountReceivablePanel', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/templates/account-receivable-panel.jsp'
            }
        });

    angular.module('Asasa')
        .controller('AccountReceivableController', ['$http', function($http){
            var arCtrl = this;
            arCtrl.showPaymentsTypePanel = false;


        }]);

})();