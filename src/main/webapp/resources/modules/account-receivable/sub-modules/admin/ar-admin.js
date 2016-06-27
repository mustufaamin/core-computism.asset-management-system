/**
 * Created by VD on 4/25/2016.
 */
(function(){
    angular.module('Asasa')
        .directive('arAdminPanel', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/sub-modules/admin/template/ar-admin.jsp'
            }
        });

    angular.module('Asasa')
        .directive('arBillcode', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/sub-modules/admin/template/ar-billCode.jsp'
            }
        });

    angular.module('Asasa')
        .directive('arPaymentType', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/sub-modules/admin/template/ar-payment-type.jsp'
            }
        });

    angular.module('Asasa')
        .controller('ArAdminController', ['ArAdminBillCodeService', 'ArAdminPaymentTypeService', 'ngTableParams', '$http', function(arAdminBillcodeGWSrv, arAdminPaymentTypeGWSrv,  ngTableParams, $http) {
            var arAdminCtrl = this;
            arAdminCtrl.openAddonChargePanel = function(){
                arAdminCtrl.addonChargeOpen = true;
                arAdminCtrl.addonGroupOpen = false;
                arAdminCtrl.receivableTypeOpen = false;
                arAdminCtrl.batchesOpen = false;
                arAdminCtrl.adminBillCodesOpen = false;
                arAdminCtrl.paymentTypesOpen = false;
                arAdminCtrl.propertiesOpen = false;
                arAdminCtrl.statementPropertiesOpen = false;
            };

            arAdminCtrl.openAddonGroupPanel = function(){
                arAdminCtrl.addonChargeOpen = false;
                arAdminCtrl.addonGroupOpen = true;
                arAdminCtrl.receivableTypeOpen = false;
                arAdminCtrl.batchesOpen = false;
                arAdminCtrl.adminBillCodesOpen = false;
                arAdminCtrl.paymentTypesOpen = false;
                arAdminCtrl.propertiesOpen = false;
                arAdminCtrl.statementPropertiesOpen = false;
            };

            arAdminCtrl.openRecievableTypesPanel = function(){
                arAdminCtrl.addonChargeOpen = false;
                arAdminCtrl.addonGroupOpen = false;
                arAdminCtrl.receivableTypeOpen = true;
                arAdminCtrl.batchesOpen = false;
                arAdminCtrl.adminBillCodesOpen = false;
                arAdminCtrl.paymentTypesOpen = false;
                arAdminCtrl.propertiesOpen = false;
                arAdminCtrl.statementPropertiesOpen = false;
            };

            arAdminCtrl.openBatchesPanel = function(){
                arAdminCtrl.addonChargeOpen = false;
                arAdminCtrl.addonGroupOpen = false;
                arAdminCtrl.receivableTypeOpen = false;
                arAdminCtrl.batchesOpen = true;
                arAdminCtrl.adminBillCodesOpen = false;
                arAdminCtrl.paymentTypesOpen = false;
                arAdminCtrl.propertiesOpen = false;
                arAdminCtrl.statementPropertiesOpen = false;
            };

            arAdminCtrl.openAdminBillCodesPanel = function(){
                arAdminCtrl.addonChargeOpen = false;
                arAdminCtrl.addonGroupOpen = false;
                arAdminCtrl.receivableTypeOpen = false;
                arAdminCtrl.batchesOpen = false;
                arAdminCtrl.adminBillCodesOpen = true;
                arAdminCtrl.paymentTypesOpen = false;
                arAdminCtrl.propertiesOpen = false;
                arAdminCtrl.statementPropertiesOpen = false;
                arAdminCtrl.getBillCodeList();
            };

            arAdminCtrl.openPaymentTypesPanel = function(){
                arAdminCtrl.addonChargeOpen = false;
                arAdminCtrl.addonGroupOpen = false;
                arAdminCtrl.receivableTypeOpen = false;
                arAdminCtrl.batchesOpen = false;
                arAdminCtrl.adminBillCodesOpen = false;
                arAdminCtrl.paymentTypesOpen = true;
                arAdminCtrl.propertiesOpen = false;
                arAdminCtrl.statementPropertiesOpen = false;
                arAdminCtrl.getPaymentTypeList();
            };

            arAdminCtrl.openPropertiesPanel = function(){
                arAdminCtrl.addonChargeOpen = false;
                arAdminCtrl.addonGroupOpen = false;
                arAdminCtrl.receivableTypeOpen = false;
                arAdminCtrl.batchesOpen = false;
                arAdminCtrl.adminBillCodesOpen = false;
                arAdminCtrl.paymentTypesOpen = false;
                arAdminCtrl.propertiesOpen = true;
                arAdminCtrl.statementPropertiesOpen = false;
            };

            arAdminCtrl.openStatementPropertiesPanel = function(){
                arAdminCtrl.addonChargeOpen = false;
                arAdminCtrl.addonGroupOpen = false;
                arAdminCtrl.receivableTypeOpen = false;
                arAdminCtrl.batchesOpen = false;
                arAdminCtrl.adminBillCodesOpen = false;
                arAdminCtrl.paymentTypesOpen = false;
                arAdminCtrl.propertiesOpen = false;
                arAdminCtrl.statementPropertiesOpen = true;
            };

            arAdminCtrl.paymentTypeCols = [
                {field: "command",title: "",sortable: "command",filter: {command: "command"},show: true,dataType: "command"},
                {field: "paymentTypeId",title: "Id",sortable: "paymentTypeId",filter: {paymentTypeId: "number"},show: false,dataType: "number"},
                {field: "paymentTypeName",title: "Payment Type Name",sortable: "paymentTypeName",filter: {paymentTypeName: "text"},show: true,dataType: "text"},
                {field: "paymentTypeDesc",title: "Description",sortable: "paymentTypeDesc",filter: {paymentTypeDesc: "text"},show: true,dataType: "text"},
                {field: "glAccountId",title: "GL Account Id",sortable: "glAccountId",filter: {glAccountId: "number"},show: true,dataType: "number"},
                {field: "glAccountNumber",title: "GL Account Name",sortable: "glAccountNumber",filter: {glAccountNumber: "text"},show: true,dataType: "text"},
                {field: "moduleId",title: "Module Id",sortable: "moduleId",filter: {moduleId: "number"},show: true,dataType: "number"},
                {field: "companyId",title: "Company Id",sortable: "companyId",filter: {companyId: "number"},show: false,dataType: "number"},
                {field: "addOnGroupId",title: "AddOn Group Id",sortable: "addOnGroupId",filter: {addOnGroupId: "number"},show: true,dataType: "number"},
                {field: "displayPriority",title: "Display Priority",sortable: "displayPriority",filter: {displayPriority: "number"},show: true,dataType: "number"},
                {field: "status",title: "Status",sortable: "status",filter: {status: "number"},show: true,dataType: "number"}
            ];

            arAdminCtrl.paymentTypeTable = new ngTableParams({
                page: 1,
                count: 10
            }, {
                total: 2,
                getData: function ($defer, params) {
                    arAdminCtrl.data = arAdminCtrl.listOfPaymentTypes.slice((params.page() - 1) * params.count(), params.page() * params.count());
                    $defer.resolve(arAdminCtrl.data);
                }
            });

            arAdminCtrl.getPaymentTypeList = function(){
                arAdminCtrl.listOfPaymentTypes = [];
                arAdminPaymentTypeGWSrv.listPaymentTypes().$promise.then(function(response){
                    if(response != null){
                        arAdminCtrl.listOfPaymentTypes = response.data;
                        arAdminCtrl.paymentTypeTable.total(arAdminCtrl.listOfPaymentTypes.length);
                        arAdminCtrl.paymentTypeTable.reload();
                    }
                });
            };

            arAdminCtrl.billCodeCols = [
                {field: "command",title: "",sortable: "command",filter: {command: "command"},show: true,dataType: "command"},
                {field: "id",title: "Id",sortable: "id",filter: {id: "number"},show: true,dataType: "number"},
                {field: "billCodeTypeId",title: "BillCode Type Id",sortable: "billCodeTypeId",filter: {billCodeTypeId: "number"},show: true,dataType: "number"},
                {field: "addOnGroupId",title: "AddOn Group Id",sortable: "addOnGroupId",filter: {addOnGroupId: "number"},show: true,dataType: "number"},
                {field: "glAccountId",title: "GL Account Id",sortable: "glAccountId",filter: {glAccountId: "number"},show: true,dataType: "number"},
                {field: "name",title: "Name",sortable: "name",filter: {name: "text"},show: true,dataType: "text"},
                {field: "description",title: "Description",sortable: "description",filter: {description: "text"},show: true,dataType: "text"},
                {field: "activationDate",title: "Activation Date",sortable: "activationDate",filter: {activationDate: "string"},show: false,dataType: "string"},
                {field: "deactivationDate",title: "Deactivation Date",sortable: "deactivationDate",filter: {deactivationDate: "text"},show: true,dataType: "text"},
                {field: "status",title: "Status",sortable: "status",filter: {status: "number"},show: true,dataType: "number"}
            ];

            arAdminCtrl.billCodeTable = new ngTableParams({
                page: 1,
                count: 10
            }, {
                total: 2,
                getData: function ($defer, params) {
                    arAdminCtrl.data = arAdminCtrl.listOfBillCodes.slice((params.page() - 1) * params.count(), params.page() * params.count());
                    $defer.resolve(arAdminCtrl.data);
                }
            });

            arAdminCtrl.getBillCodeList = function(){
                arAdminCtrl.listOfBillCodes = [];
                arAdminBillcodeGWSrv.listBillCodes().$promise.then(function(response){
                    if(response != null){
                        arAdminCtrl.listOfBillCodes = response.data;
                        arAdminCtrl.billCodeTable.total(arAdminCtrl.listOfBillCodes.length);
                        arAdminCtrl.billCodeTable.reload();
                    }
                });
            };

        }]);

    angular.module('Asasa')
        .service('ArAdminBillCodeService',['$resource' ,function ($resource) {
            var arAdminBillcodeGWSrv = this;
            return $resource('',{},
                {
                    updateBillCodes :{method: 'POST', isArray: false, url:"/billCodes/update"},

                    listBillCodes : {method: 'GET', isArray: false, url: "/billCodes/list"},

                    addBillCodes :{method: 'POST', isArray: false, url:"/billCodes/add"},

                    searchBillCodes :{method: 'GET', isArray: false, url:"/billCodes/search/{searchKey}"}

                });
        }]);

    angular.module('Asasa')
        .service('ArAdminPaymentTypeService',['$resource' ,function ($resource) {
            var arAdminPaymentTypeGWSrv = this;
            return $resource('',{},
                {
                    listPaymentTypes : {method: 'GET', isArray: false, url: "/payments/paymenttypes"}

                });
        }]);


})();