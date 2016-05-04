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
        .controller('ArAccountController', ['ArAccountGatewayService', '$http', function(accountGatewayService, $http){
            var arAccountCtrl = this;
            arAccountCtrl.listArAccountCtrl = [];

            arAccountCtrl.getArAccountList = function(){
                arAccountCtrl.listArAccountCtrl = [];
                accountGatewayService.listOfArAccount().$promise.then(function(response){
                    if(response != null){
                        console.log(response);
                        for(var i = 0; i < response.data.length; i++){
                            var arAccount = {};
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
                            arAccountCtrl.listArAccountCtrl.push(arAccount);
                        }
                    }
                });
            };
            arAccountCtrl.getArAccountList();

        }])
    ;


    angular.module('Asasa')
        .service('ArAccountGatewayService',['$resource' ,function ($resource) {
            var arAccountGatewayService = this;
            return $resource('',{},
                {
                    listOfArAccount :{method: 'GET', isArray: false, url:"/arAccount/arAccountList"}
                });
        }]);


})();