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
        .controller('PaymentTypeController', ['$http', function($http){
            var paymentTypeCtrl = this;
            paymentTypeCtrl.showPanel = false;
            paymentTypeCtrl.isView = false;
            paymentTypeCtrl.slidePanelHeading = '';
            paymentTypeCtrl.listPaymentTypes = [];

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
                    listCustomer: {method: 'GET', isArray: false, url: '/customer/list'},

                    addCustomer: {method: 'POST', isArray: false, url: '/customer/add'}
                    /*addItem: {method: 'POST',isArray: false,url:'item/:add'},
                     addItemType: {method: 'POST',isArray: false,url:'/item/addType/:typeName'},

                     *//*Supplier Methods*//*
                 addSupplier:{method: 'POST',isArray: false,url:'/supplier/add'},

                 *//*Customer Methods*//*
                 addCustomer:{method: 'POST',isArray: false,url:'/customer/add'}*/
                });
        }]);
})();