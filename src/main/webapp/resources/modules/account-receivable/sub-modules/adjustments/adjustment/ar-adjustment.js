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