/**
 * Created by VD on 3/12/2016.
 */
(function(){
    angular.module('Asasa')
        .directive('customerPanel', function(){
        return{
            restrict: "E",
            templateUrl: 'resources/modules/customer/templates/customer-panel.jsp'
        }
    });

    angular.module('Asasa')
        .directive('addEditCustomerSlidePanel', function(){
        return{
            restrict: "E",
            templateUrl: 'resources/modules/customer/templates/add-edit-customer-slide-panel.jsp'
        }
    });

    angular.module('Asasa')
        .controller('CustomerController', ['CustomerGatewayService','$http', function(custGatewaySrv, $http){
            var custCtrl = this;
            custCtrl.showPanel = false;
            custCtrl.isView = false;
            custCtrl.slidePanelHeading = '';
            custCtrl.listCustomer = [];

            custCtrl.getCustomerList = function(){
                custCtrl.listCustomer = [];
                custGatewaySrv.listCustomer().$promise.then(function(response){
                    custCtrl.listCustomer = response;
                });
            };
            custCtrl.getCustomerList();

            custCtrl.openCustomerSlidePanel = function(type){
                custCtrl.showPanel = true;
                custCtrl.isView = false;
                if(type == 1){
                    custCtrl.slidePanelHeading = "Add Customer";
                }else if(type == 2){
                    custCtrl.slidePanelHeading = "View Customer";
                    custCtrl.isView = true;
                }else{
                    custCtrl.slidePanelHeading = "Edit Customer";
                }
            };
    }]);


    /*Customer Gateway*/
    angular.module('Asasa')
        .service('CustomerGatewayService',['$resource' ,function ($resource) {
            var custGatewaySrv = this;
            return $resource('',{},
            {
                listCustomer: {method: 'GET', isArray: false, url: '/customer/list'}
                /*addItem: {method: 'POST',isArray: false,url:'item/:add'},
                addItemType: {method: 'POST',isArray: false,url:'/item/addType/:typeName'},

                *//*Supplier Methods*//*
                addSupplier:{method: 'POST',isArray: false,url:'/supplier/add'},

                *//*Customer Methods*//*
                addCustomer:{method: 'POST',isArray: false,url:'/customer/add'}*/
            });
    }]);


})();
