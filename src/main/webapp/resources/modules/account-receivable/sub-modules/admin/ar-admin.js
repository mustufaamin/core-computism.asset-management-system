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
        .directive('arReceivableType', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/sub-modules/admin/template/ar-receivable-type.jsp'
            }
        });

    angular.module('Asasa')
        .directive('arAddOnCharge', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/sub-modules/admin/template/ar-add-on-charge.jsp'
            }
        });

    angular.module('Asasa')
        .directive('arBatches', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/sub-modules/admin/template/ar-batches.jsp'
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
        .controller('ArAdminController', ['ArAdminAddOnChargeService', 'ArAdminReceivableTypeService', 'ArAdminBatchesService', 'ArAdminBillCodeService', 'ArAdminPaymentTypeService', 'ngTableParams', '$http', function(arAdminAddOnChargeGWSrv, arAdminReceivableTypeGWSrv, arAdminBatchesGWSrv, arAdminBillcodeGWSrv, arAdminPaymentTypeGWSrv,  ngTableParams, $http) {
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
                arAdminCtrl.getAddOnChargeList();
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

            arAdminCtrl.openReceivableTypePanel = function(){
                arAdminCtrl.addonChargeOpen = false;
                arAdminCtrl.addonGroupOpen = false;
                arAdminCtrl.receivableTypeOpen = true;
                arAdminCtrl.batchesOpen = false;
                arAdminCtrl.adminBillCodesOpen = false;
                arAdminCtrl.paymentTypesOpen = false;
                arAdminCtrl.propertiesOpen = false;
                arAdminCtrl.statementPropertiesOpen = false;
                arAdminCtrl.getReceivableTypeList();
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
                arAdminCtrl.getBatchesList();
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

            arAdminCtrl.addOnChargeCols = [
                {field: "command",title: "",sortable: "command",filter: {command: "command"},show: true,dataType: "command"},
                {field: "arAccountTypeId",title: "Id",sortable: "arAccountTypeId",filter: {arAccountTypeId: "number"},show: true,dataType: "number"},
                {field: "accountTypeCode",title: "Code",sortable: "accountTypeCode",filter: {accountTypeCode: "text"},show: true,dataType: "text"},
                {field: "accountTypeName",title: "Name",sortable: "accountTypeName",filter: {accountTypeName: "text"},show: true,dataType: "text"},
                {field: "glAccountId",title: "Gl Account",sortable: "glAccountId",filter: {glAccountId: "number"},show: true,dataType: "number"},
                {field: "status",title: "Status",sortable: "status",filter: {status: "number"},show: true,dataType: "number"}
            ];

            arAdminCtrl.addOnChargeTable = new ngTableParams({
                page: 1,
                count: 10
            }, {
                total: 2,
                getData: function ($defer, params) {
                    arAdminCtrl.data = arAdminCtrl.listOfAddOnCharge.slice((params.page() - 1) * params.count(), params.page() * params.count());
                    $defer.resolve(arAdminCtrl.data);
                }
            });

            arAdminCtrl.getAddOnChargeList = function(){
                arAdminCtrl.listOfAddOnCharge = [];
                arAdminAddOnChargeGWSrv.listAddOnCharge().$promise.then(function(response){
                    if(response != null){
                        arAdminCtrl.listOfAddOnCharge = response.data;
                        arAdminCtrl.addOnChargeTable.total(arAdminCtrl.listOfAddOnCharge.length);
                        arAdminCtrl.addOnChargeTable.reload();
                    }
                });
            };

            arAdminCtrl.batchesCols = [
                {field: "command",title: "",sortable: "command",filter: {command: "command"},show: true,dataType: "command"},
                {field: "batchId",title: "Id",sortable: "batchId",filter: {batchId: "number"},show: true,dataType: "number"},
                {field: "batchName",title: "Name",sortable: "batchName",filter: {batchName: "text"},show: true,dataType: "text"},
                {field: "batchType",title: "Batch Type",sortable: "batchType",filter: {batchType: "number"},show: true,dataType: "number"},
                {field: "batchStatus",title: "Status",sortable: "batchStatus",filter: {batchStatus: "number"},show: true,dataType: "number"},
                {field: "batchCountMethod",title: "Count Method",sortable: "batchCountMethod",filter: {batchCountMethod: "number"},show: true,dataType: "number"},
                {field: "batchAmount",title: "Amount",sortable: "batchAmount",filter: {batchAmount: "number"},show: true,dataType: "number"}
            ];

            arAdminCtrl.batchesTable = new ngTableParams({
                page: 1,
                count: 10
            }, {
                total: 2,
                getData: function ($defer, params) {
                    arAdminCtrl.data = arAdminCtrl.listOfBatches.slice((params.page() - 1) * params.count(), params.page() * params.count());
                    $defer.resolve(arAdminCtrl.data);
                }
            });

            arAdminCtrl.getBatchesList = function(){
                arAdminCtrl.listOfBatches = [];
                arAdminBatchesGWSrv.listBatches().$promise.then(function(response){
                    if(response != null){
                        arAdminCtrl.listOfBatches = response.data;
                        arAdminCtrl.batchesTable.total(arAdminCtrl.listOfBatches.length);
                        arAdminCtrl.batchesTable.reload();
                    }
                });
            };

            arAdminCtrl.receivableTypeCols = [
                {field: "command",title: "",sortable: "command",filter: {command: "command"},show: true,dataType: "command"},
                {field: "arAccountTypeId",title: "Id",sortable: "arAccountTypeId",filter: {arAccountTypeId: "number"},show: true,dataType: "number"},
                {field: "accountTypeCode",title: "Code",sortable: "accountTypeCode",filter: {accountTypeCode: "text"},show: true,dataType: "text"},
                {field: "accountTypeName",title: "Name",sortable: "accountTypeName",filter: {accountTypeName: "text"},show: true,dataType: "text"},
                {field: "glAccountId",title: "Gl Account",sortable: "glAccountId",filter: {glAccountId: "number"},show: true,dataType: "number"},
                {field: "status",title: "Status",sortable: "status",filter: {status: "number"},show: true,dataType: "number"}
            ];

            arAdminCtrl.receivableTypeTable = new ngTableParams({
                page: 1,
                count: 10
            }, {
                total: 2,
                getData: function ($defer, params) {
                    arAdminCtrl.data = arAdminCtrl.listOfReceivableType.slice((params.page() - 1) * params.count(), params.page() * params.count());
                    $defer.resolve(arAdminCtrl.data);
                }
            });

            arAdminCtrl.getReceivableTypeList = function(){
                arAdminCtrl.listOfReceivableType = [];
                arAdminReceivableTypeGWSrv.listReceivableType().$promise.then(function(response){
                    if(response != null){
                        arAdminCtrl.listOfReceivableType = response.data;
                        arAdminCtrl.receivableTypeTable.total(arAdminCtrl.listOfReceivableType.length);
                        arAdminCtrl.receivableTypeTable.reload();
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
        .service('ArAdminAddOnChargeService',['$resource' ,function ($resource) {
            var arAdminAddOnChargeGWSrv = this;
            return $resource('',{},
                {
                    updateReceivableType :{method: 'POST', isArray: false, url:"/arAccountType/update"},

                    listAddOnCharge : {method: 'GET', isArray: false, url: "/arAccountType/arAccountTypes"},

                    addReceivableType :{method: 'POST', isArray: false, url:"/arAccountType/add"},

                    searchReceivableType :{method: 'GET', isArray: false, url:"/arAccountType/search/{searchKey}"}

                });
        }]);

    angular.module('Asasa')
        .service('ArAdminBatchesService',['$resource' ,function ($resource) {
            var arAdminBatchesGWSrv = this;
            return $resource('',{},
                {
                    updateBatches :{method: 'POST', isArray: false, url:"/batch/update"},

                    listBatches : {method: 'GET', isArray: false, url: "/batch/list"},

                    addBatches :{method: 'POST', isArray: false, url:"/batch/add"},

                    searchBatches :{method: 'GET', isArray: false, url:"/batch/search/{searchKey}"}

                });
        }]);

    angular.module('Asasa')
        .service('ArAdminReceivableTypeService',['$resource' ,function ($resource) {
            var arAdminReceivableTypeGWSrv = this;
            return $resource('',{},
                {
                    updateReceivableType :{method: 'POST', isArray: false, url:"/arAccountType/update"},

                    listReceivableType : {method: 'GET', isArray: false, url: "/arAccountType/arAccountTypes"},

                    addReceivableType :{method: 'POST', isArray: false, url:"/arAccountType/add"},

                    searchReceivableType :{method: 'GET', isArray: false, url:"/arAccountType/search/{searchKey}"}
                    //TODO : search api need to be written on backend.

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