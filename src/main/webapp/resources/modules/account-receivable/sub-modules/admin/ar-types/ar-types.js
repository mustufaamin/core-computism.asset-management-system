/**
 * Created by Muhammad Umer on 3/21/2016.
 */
(function(){
    angular.module('Asasa')
        .directive('arTypesPanel', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/sub-modules/admin/ar-types/templates/ar-types-panel.jsp'
            }
        });

    angular.module('Asasa')
        .directive('arTypesSlidePanel', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/sub-modules/admin/ar-types/templates/ar-types-slide-panel.jsp'
            }
        });

    angular.module('Asasa')
        .controller('AccountReceivableTypesController', ['$http', function($http){
            var arTypesCtrl = this;
            arTypesCtrl.showPanel = false;
            arTypesCtrl.isView = false;
            arTypesCtrl.slidePanelHeading = '';
            arTypesCtrl.listPaymentTypes = [];

            arTypesCtrl.openARTypeSlidePanel = function(type){
                arTypesCtrl.showPanel = true;
                arTypesCtrl.isView = false;
                if(type == 1){
                    arTypesCtrl.slidePanelHeading = "Add AR Types";
                }else if(type == 2){
                    arTypesCtrl.slidePanelHeading = "View AR Types";
                    arTypesCtrl.isView = true;
                }else{
                    arTypesCtrl.slidePanelHeading = "Edit AR Types";
                }
            };

        }]);


    angular.module('Asasa')
        .service('ArTypesGatewayService',['$resource' ,function ($resource) {
            var arTypesGWSrv = this;
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