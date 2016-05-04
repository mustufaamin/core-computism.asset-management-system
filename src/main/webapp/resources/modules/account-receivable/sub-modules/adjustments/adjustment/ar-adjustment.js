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

                    addArAdjustment :{method: 'POST', isArray: false, url:"/glAccount/addAccountType"}

                });
        }]);


})();