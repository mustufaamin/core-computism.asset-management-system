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
            arCtrl.adjustmentSubModule = false;
            arCtrl.processSubModule = false;
            arCtrl.paymentsSubModule = false;
            arCtrl.adminSubModule = false;
            arCtrl.inquirySubModule = false;


            arCtrl.openAdjustmentSubModule = function(){
                arCtrl.adjustmentSubModule = true;
                arCtrl.processSubModule = false;
                arCtrl.paymentsSubModule = false;
                arCtrl.adminSubModule = false;
                arCtrl.inquirySubModule = false;
            };

            arCtrl.openProcessSubModule = function(){
                arCtrl.adjustmentSubModule = false;
                arCtrl.processSubModule = true;
                arCtrl.paymentsSubModule = false;
                arCtrl.adminSubModule = false;
                arCtrl.inquirySubModule = false;
            };

            arCtrl.openPaymentsSubModule = function(){
                arCtrl.adjustmentSubModule = false;
                arCtrl.processSubModule = false;
                arCtrl.paymentsSubModule = true;
                arCtrl.adminSubModule = false;
                arCtrl.inquirySubModule = false;
            };

            arCtrl.openAdminSubModule = function(){
                arCtrl.adjustmentSubModule = false;
                arCtrl.processSubModule = false;
                arCtrl.paymentsSubModule = false;
                arCtrl.adminSubModule = true;
                arCtrl.inquirySubModule = false;
            };

            arCtrl.openInquirySubModule = function(){
                arCtrl.adjustmentSubModule = false;
                arCtrl.processSubModule = false;
                arCtrl.paymentsSubModule = false;
                arCtrl.adminSubModule = false;
                arCtrl.inquirySubModule = true;
            };


        }]);

})();