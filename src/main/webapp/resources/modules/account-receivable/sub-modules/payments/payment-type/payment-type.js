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
        .directive('paymentTypeSlidePanel', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/sub-modules/payments/payment-type/template/payment-type-slide-panel.jsp'
            }
        });

    angular.module('Asasa')
        .controller('PaymentTypeController', ['$http', 'PaymentTypeGatewayService', function($http, paymentTypeGWSrv){
            var paymentTypeCtrl = this;
            paymentTypeCtrl.showPanel = false;
            paymentTypeCtrl.isView = false;
            paymentTypeCtrl.slidePanelHeading = '';
            paymentTypeCtrl.listPaymentTypes = [];

            paymentTypeCtrl.getPaymentTypeList = function(){
                paymentTypeCtrl.listPaymentTypes = [];
                paymentTypeGWSrv.listPaymentTypes().$promise.then(function(response){
                    if(response != null){
                        for(var i = 0; i < response.data.length; i++){
                            var paymentType = {};
                            /*customer.id = response.data[i].id;
                            customer.firstName = response.data[i].firstName;
                            customer.lastName = response.data[i].lastName;
                            customer.locationAddress = response.data[i].locationAddress;
                            customer.phoneNumber = response.data[i].phoneNumber;
                            customer.mobileNumber = response.data[i].mobileNumber;
                            customer.email = response.data[i].email;
                            customer.cityId = response.data[i].cityId;*/

                            paymentTypeCtrl.listPaymentTypes.push(paymentType);
                        }
                    }
                });
            };
            paymentTypeCtrl.getPaymentTypeList();

            paymentTypeCtrl.addPaymentType = function(){
                var paymentType = {};
                paymentType.paymentTypeName = paymentTypeCtrl.paymentTypeName;
                paymentType.paymentTypeDesc = paymentTypeCtrl.paymentTypeDesc;
                paymentType.glAccountId = paymentTypeCtrl.glAccountId;
                paymentType.status = paymentTypeCtrl.status;
                paymentType.moduleId = paymentTypeCtrl.moduleId;
                paymentType.companyId = paymentTypeCtrl.companyId;
                paymentType.addOnGroupId = paymentTypeCtrl.addOnGroupId;
                paymentType.displayPriority = paymentTypeCtrl.displayPriority;
                paymentType.description = paymentTypeCtrl.description;

                paymentTypeGWSrv.addPaymentType(paymentType).$promise.then(function(response){
                    if(response){

                    }
                });
            };

            paymentTypeCtrl.openPaymentTypeSlidePanel = function(type){
                paymentTypeCtrl.showPanel = true;
                paymentTypeCtrl.isView = false;
                if(type == 1){
                    paymentTypeCtrl.slidePanelHeading = "Add Payment Type";
                }else if(type == 2){
                    paymentTypeCtrl.slidePanelHeading = "View Payment Type";
                    paymentTypeCtrl.isView = true;
                }else{
                    paymentTypeCtrl.slidePanelHeading = "Edit Payment Type";
                }
            };

        }]);


    angular.module('Asasa')
        .service('PaymentTypeGatewayService',['$resource' ,function ($resource) {
            var paymentTypeGWSrv = this;
            return $resource('',{},
                {
                    listPaymentTypes: {method: 'GET', isArray: false, url: '/payments/paymenttypes'},

                    addPaymentType: {method: 'POST', isArray: false, url: '/payments/addPaymentType'}

                });
        }]);
})();