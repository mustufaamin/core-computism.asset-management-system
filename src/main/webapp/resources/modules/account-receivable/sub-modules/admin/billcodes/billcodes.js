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
        .controller('BillCodesController', ['ngTableParams','BillCodesGatewayService', '$http', function(ngTableParams,billCodesSrv, $http){
            var billCodesCtrl = this;


            billCodesCtrl.billCodes= [];


            billCodesCtrl.cols = [
                {field: "id",title: "Bill Code ID:",sortable: "id",filter: {id: "number"},show: true,dataType: "number"},
                {field: "glAccountId",title: "GlAccount ",sortable: "glAccountId",filter: {glAccountId: "number"},show: true,dataType: "number"},
                {field: "name",title: "Name ",sortable: "costPrice",filter: {name: "text"},show: true,dataType: "text"},
                {field: "description",title: "Description",sortable: "description",filter: {action: "number"},show: true,dataType: "text"},
                {field: "status",title: "Status",sortable: "status",filter: {status: "number"},show: true,dataType: "text"}

            ];

            billCodesCtrl.billCodeListTable = new ngTableParams({
                page: 1,
                count: 10
            }, {
                total: billCodesCtrl.billCodes.length,
                getData: function ($defer, params) {
                    console.log(billCodesCtrl.billCodes);
                    billCodesCtrl.data = billCodesCtrl.billCodes.slice((params.page() - 1) * params.count(), params.page() * params.count());
                    $defer.resolve(billCodesCtrl.data);
                }
            });


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
                billCodesCtrl.listArAccountCtrl = [];
                billCodesSrv.listOfBillCodes().$promise.then(function(response){
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

                            billCodesCtrl.billCodes.push(billCode);
                        }
                    }
                    billCodesCtrl.billCodeListTable.reload();

                });
            };

            billCodesCtrl.getBillCodesList();


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
                billCode.glAccountId = 1;

                billCodesSrv.addBillCode(billCode).$promise.then(function(response){
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
                    listOfBillCodes :{method: 'GET', isArray: false, url:"/billCodes/list"},

                    addBillCode :{method: 'POST', isArray: false, url:"/billCodes/add"}

                });
        }]);
})();