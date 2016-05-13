/**
 * Created by VD on 4/25/2016.
 */
(function(){
    angular.module('Asasa')
        .directive('arAdjustmentPanel', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/sub-modules/adjustments/adjustment/templates/ar-adjustment-panel.jsp'
            }
        });

    angular.module('Asasa')
        .controller('ArAdjustmentController', ['ArAdjustmentGatewayService', '$http', function(adjustmentGatewayService, $http){
            var arAdjustmentCtrl = this;
            arAdjustmentCtrl.listBillCodes = [];
            arAdjustmentCtrl.customerName = "Customer's Name";

            arAdjustmentCtrl.getBillCodeList = function(){
                arAdjustmentCtrl.listBillCodes = [];
                adjustmentGatewayService.listOfBillCodes().$promise.then(function(response){
                    if(response != null){
                        console.log(response);
                        for(var i = 0; i < response.data.length; i++){
                            var billCode = {};
                            billCode.billCodeId = response.data[i].id;
                            billCode.name = response.data[i].name;
                            arAdjustmentCtrl.listBillCodes.push(billCode);
                        }
                    }
                });
            };
            arAdjustmentCtrl.getBillCodeList();

            arAdjustmentCtrl.getCustomer = function(val){
                var _url = "/customer/search/" + val;
                return $http.get(_url).then(function(response){
                    return response.data.data.map(function(item){
                        return {
                            label: item.firstName + " " +item.lastName,
                            value: item.id,
                            customerStatus: item.customerStatus,
                            customerTypeId: item.customerTypeId
                        }
                    });
                });
            };

            arAdjustmentCtrl.onSelectCustomer = function(customer){
                arAdjustmentCtrl.customerType = customer.customerTypeId;
                arAdjustmentCtrl.customerStatus = customer.customerStatus;
                arAdjustmentCtrl.customerName = arAdjustmentCtrl.customer.label;
            };

            //TODO: AR Adjustment list
            arAdjustmentCtrl.getArList = function(){
                arAdjustmentCtrl.listAr = [];
                adjustmentGatewayService.listOfArAdjustment().$promise.then(function(response){
                    if(response != null){
                        for(var i = 0; i < response.data.length; i++){
                            var customer = {};
                            customer.id = response.data[i].id;
                            customer.firstName = response.data[i].firstName;
                            customer.lastName = response.data[i].lastName;
                            customer.locationAddress = response.data[i].locationAddress;
                            customer.phoneNumber = response.data[i].phoneNumber;
                            customer.mobileNumber = response.data[i].mobileNumber;
                            customer.email = response.data[i].email;
                            customer.cityId = response.data[i].cityId;

                            arAdjustmentCtrl.listAr.push(customer);
                        }
                    }
                });
            };

            arAdjustmentCtrl.addArAdjustment = function (){
                var adjustment = {};
                adjustment.arAccountId = 1;//arAdjustmentCtrl.arAccountId;
                adjustment.billCodeId = arAdjustmentCtrl.billCodeId;
                adjustment.adjustmentDate = arAdjustmentCtrl.adjustmentDate;
                adjustment.amount = arAdjustmentCtrl.amount;
                adjustment.adjustmentType = 1;//arAdjustmentCtrl.adjustmentType;
                adjustment.status = 1;//arAdjustmentCtrl.status;
                adjustment.batchId = arAdjustmentCtrl.batchId;
                adjustment.description = arAdjustmentCtrl.description;
                adjustment.statementDescription2 = arAdjustmentCtrl.statementDescription2;
                adjustment.note = arAdjustmentCtrl.note;
                adjustment.suppressOnStatement = arAdjustmentCtrl.suppressOnStatement;
                adjustment.excludeValueAdded = arAdjustmentCtrl.excludeValueAdded;
                adjustment.createdBy = 1;//arAdjustmentCtrl.createdBy; TODO : Hardcoded value for UserId.

                adjustmentGatewayService.addArAdjustment(adjustment).$promise.then(function(response){
                    if(response){

                    }
                });
            };

        }]).config(function($mdThemingProvider) {

            // Configure a dark theme with primary foreground yellow

            $mdThemingProvider.theme('docs-dark', 'default')
                .primaryPalette('yellow')
                .dark();

        })
    ;


    angular.module('Asasa')
        .service('ArAdjustmentGatewayService',['$resource' ,function ($resource) {
            var arAdjustmentGatewayService = this;
            return $resource('',{},
                {
                    listOfArAdjustment :{method: 'GET', isArray: false, url:"/glAccount/glAccountTypes"},

                    listOfBillCodes : {method: 'GET', isArray: false, url: "/billCodes/list"},

                    addArAdjustment :{method: 'POST', isArray: false, url:"/adjustments/addAdjustment"}

                });
        }]);


})();