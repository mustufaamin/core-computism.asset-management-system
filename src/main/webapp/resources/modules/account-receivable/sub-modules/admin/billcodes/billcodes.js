/**
 * Created by Muhammad Umer on 3/31/2016.
 */
(function(){
    angular.module('Asasa')
        .directive('billCodesPanel', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/sub-modules/admin/billcodes/templates/bill-codes-panel.jsp'
            }
        });

    angular.module('Asasa')
        .directive('billCodesSlidePanel', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/sub-modules/admin/billcodes/templates/bill-codes-slide-panel.jsp'
            }
        });

    angular.module('Asasa')
        .controller('BillCodesController', ['BillCodesGatewayService', '$http', function($http, billCodesSrv){
            var billCodesCtrl = this;

            billCodesCtrl.openBillCodesSlidePanel = function(type, billCode){
                if(billCode != null){
                    billCodesCtrl.id = billCode.id;
                    billCodesCtrl.billCodeType = billCode.billCodeType;
                    billCodesCtrl.addOnGroupId = billCode.addOnGroupId;
                    billCodesCtrl.name = billCode.name;
                    billCodesCtrl.description = billCode.description;
                    billCodesCtrl.activationDate = billCode.activationDate;
                    billCodesCtrl.deactivationDate = billCode.deactivationDate;
                    billCodesCtrl.status = billCode.status;
                }
                
                billCodesCtrl.showPanel = true;
                billCodesCtrl.isView = false;
                if(type == 1){
                    billCodesCtrl.slidePanelHeading = "Add Bill Code";
                }else if(type == 2){
                    billCodesCtrl.slidePanelHeading = "View Bill Code";
                    billCodesCtrl.isView = true;
                }else{
                    billCodesCtrl.slidePanelHeading = "Edit Bill Code";
                }
            };

            billCodesCtrl.getBillCodesList = function(){
                billCodesCtrl.listBillCodes = [];
                billCodesSrv.listBillCodes().$promise.then(function(response){
                    if(response != null){
                        for(var i = 0; i < response.data.length; i++){
                            var billCode = {};

                            billCode.id = response.data[i].id;
                            billCode.billCodeType = response.data[i].billCodeType;
                            billCode.addOnGroupId = response.data[i].addOnGroupId;
                            billCode.name = response.data[i].name;
                            billCode.description = response.data[i].description;
                            billCode.activationDate = response.data[i].activationDate;
                            billCode.deactivationDate = response.data[i].deactivationDate;
                            billCode.status = response.data[i].status;

                            billCodesCtrl.listBillCodes.push(billCode);
                        }
                    }
                });
            };

            billCodesCtrl.addBillCode = function (){
                var billCode = {};

                billCode.id = billCodesCtrl.id;
                billCode.billCodeType = billCodesCtrl.billCodeType;
                billCode.addOnGroupId = billCodesCtrl.addOnGroupId;
                billCode.name = billCodesCtrl.name;
                billCode.description = billCodesCtrl.description;
                billCode.activationDate = billCodesCtrl.activationDate;
                billCode.deactivationDate = billCodesCtrl.deactivationDate;
                billCode.status = billCodesCtrl.status;

                billCodesSrv.addArType(arType).$promise.then(function(response){
                    if(response){
                        billCodesCtrl.getBillCodesList();
                    }
                });
            };

        }]);


    angular.module('Asasa')
        .service('BillCodesGatewayService',['$resource' ,function ($resource) {
            var billCodesSrv = this;
            return $resource('',{},
                {
                    listBillCodes :{method: 'GET', isArray: false, url:"/billCodes/list"},

                    addBillCode :{method: 'POST', isArray: false, url:"/billCodes/add"}

                });
        }]);
})();