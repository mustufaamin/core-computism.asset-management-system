/**
 * Created by VD on 4/25/2016.
 */
(function(){
    angular.module('Asasa')
        .directive('arAccountPanel', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/sub-modules/inquiry/ar-account/template/ar-account-panel.jsp'
            }
        });

    angular.module('Asasa')
        .controller('ArAccountController', ['ngTableParams','ArAccountGatewayService', '$http', function(ngTableParams,accountGatewayService, $http){
            var arAccountCtrl = this;


            arAccountCtrl.arAccount = {};
            arAccountCtrl.arAccounts = [];


            arAccountCtrl.cols = [
                {field: "arAccountId",title: "Account ID:",sortable: "arAccountId",filter: {arAccountId: "number"},show: true,dataType: "number"},
                {field: "customerName",title: "Customer Name ",sortable: "customerName",filter: {customerName: "text"},show: true,dataType: "text"},
                {field: "accountTypeName",title: "Account Type ",sortable: "accountTypeName",filter: {accountTypeName: "text"},show: true,dataType: "text"},
                {field: "currentBalance",title: "Balance",sortable: "currentBalance",filter: {currentBalance: "number"},show: true,dataType: "text"},
                {field: "activationDate",title: "Activation Date",sortable: "activationDate",filter: {activationDate: "text"},show: true,dataType: "text"}

            ];

            arAccountCtrl.arAccountTable = new ngTableParams({
                page: 1,
                count: 10
            }, {
                total: arAccountCtrl.arAccounts.length,
                getData: function ($defer, params) {
                    console.log(arAccountCtrl.arAccounts);
                    arAccountCtrl.data = arAccountCtrl.arAccounts.slice((params.page() - 1) * params.count(), params.page() * params.count());
                    $defer.resolve(arAccountCtrl.data);
                }
            });


            arAccountCtrl.getArAccountList = function(){
                arAccountCtrl.arAccounts = [];
                accountGatewayService.listOfArAccount().$promise.then(function(response){
                    if(response != null){
                        console.log(response);
                        for(var i = 0; i < response.data.length; i++){
                            var arAccount = {};
                            arAccount.arAccountId = response.data[i].arAccountId;
                            arAccount.customerId = response.data[i].customerId;
                            arAccount.customerName = response.data[i].customerName;
                            arAccount.accountTypeId = response.data[i].accountTypeId;
                            arAccount.accountTypeName = response.data[i].accountTypeName;
                            arAccount.currentBalance = response.data[i].currentBalance;
                            arAccount.accountStatus = response.data[i].accountStatus;
                            arAccount.companyId = response.data[i].companyId;
                            arAccount.createdBy = response.data[i].createdBy;
                            arAccount.modifiedDate = response.data[i].modifiedDate;
                            arAccount.modifiedBy = response.data[i].modifiedBy;
                            arAccount.activationDate = response.data[i].activationDate;
                            arAccount.deactivationDate = response.data[i].deactivationDate;
                            arAccountCtrl.arAccounts.push(arAccount);
                        }
                        arAccountCtrl.arAccountTable.reload();
                    }
                });
            };
            arAccountCtrl.getArAccountList();

            arAccountCtrl.searchArAccounts = function (typeSearchKey) {
                if(typeSearchKey == null || typeSearchKey == ''){
                    arAccountCtrl.getArAccountList();
                } else {
                    var params = {
                        searchKey: typeSearchKey
                    };
                    accountGatewayService.searchArAccounts(params).$promise.then(function (response) {
                        if(response != null){
                            arAccountCtrl.arAccounts = [];
                            for(var i = 0; i < response.data.length; i++){
                                var arAccount = {};
                                arAccount.arAccountId = response.data[i].arAccountId;
                                arAccount.customerId = response.data[i].customerId;
                                arAccount.customerName = response.data[i].customerName;
                                arAccount.accountTypeId = response.data[i].accountTypeId;
                                arAccount.accountTypeName = response.data[i].accountTypeName;
                                arAccount.currentBalance = response.data[i].currentBalance;
                                arAccount.accountStatus = response.data[i].accountStatus;
                                arAccount.companyId = response.data[i].companyId;
                                arAccount.createdBy = response.data[i].createdBy;
                                arAccount.modifiedDate = response.data[i].modifiedDate;
                                arAccount.modifiedBy = response.data[i].modifiedBy;
                                arAccount.activationDate = response.data[i].activationDate;
                                arAccount.deactivationDate = response.data[i].deactivationDate;
                                arAccountCtrl.arAccounts.push(arAccount);
                            }
                        }
                        arAccountCtrl.arAccountTable.reload();
                    });
                }
            };

        }])
    ;


    angular.module('Asasa')
        .service('ArAccountGatewayService',['$resource' ,function ($resource) {
            var arAccountGatewayService = this;
            return $resource('',{},
                {
                    listOfArAccount :{method: 'GET', isArray: false, url:"/arAccount/list"},
                    searchArAccounts:{method: 'GET', isArray: false, url:"/arAccount/search/:searchKey"}
                });
        }]);


})();