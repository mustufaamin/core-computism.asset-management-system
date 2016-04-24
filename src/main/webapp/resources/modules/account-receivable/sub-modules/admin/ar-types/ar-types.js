/**
 * Created by Muhammad Umer on 3/21/2016.
 */
(function(){
    angular.module('Asasa')
        .directive('arTypesPanel', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/sub-modules/admin/ar-types/templates/ar-types-panel.jsp'
            }
        });

    angular.module('Asasa')
        .directive('arTypesSlidePanel', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/sub-modules/admin/ar-types/templates/ar-types-slide-panel.jsp'
            }
        });

    angular.module('Asasa')
        .controller('AccountReceivableTypesController', ['ArTypesGatewayService', '$http', function(arTypesGWSrv, $http){
            var arTypesCtrl = this;
            arTypesCtrl.showPanel = false;
            arTypesCtrl.isView = false;
            arTypesCtrl.slidePanelHeading = '';
            arTypesCtrl.listPaymentTypes = [];

            arTypesCtrl.openARTypeSlidePanel = function(type ,arType){
                if(arType != null){
                    arTypesCtrl.arAccountTypeId = arTypearAccountTypeId;
                    arTypesCtrl.accountTypeName = arType.accountTypeName;
                    arTypesCtrl.accountTypeDesc = arType.accountTypeDesc;
                    arTypesCtrl.glAccountId = arType.glAccountId;
                    arTypesCtrl.companyId = arType.companyId;
                    arTypesCtrl.accountTypeCode = arType.accountTypeCode;
                    arTypesCtrl.leftOverAmount = arType.leftOverAmount;
                    arTypesCtrl.status = arType.status;
                    arTypesCtrl.priority = arType.priority;
                    arTypesCtrl.requiredStatus = arType.requiredStatus;
                    arTypesCtrl.over30Message = arType.over30Message;
                    arTypesCtrl.over60Message = arType.over60Message;
                    arTypesCtrl.over90Message = arType.over90Message;
                    arTypesCtrl.over120Message = arType.over120Message;
                    arTypesCtrl.showAgingMessage = arType.showAgingMessage;

                }

                arTypesCtrl.showPanel = true;
                arTypesCtrl.isView = false;
                if(type == 1){
                    arTypesCtrl.slidePanelHeading = "Add AR Types";
                }else if(type == 2){
                    arTypesCtrl.slidePanelHeading = "View AR Types";
                    arTypesCtrl.isView = true;
                }else{
                    arTypesCtrl.slidePanelHeading = "Edit AR Types";
                }
            };

            arTypesCtrl.getArTypesList = function(){
                arTypesCtrl.listArTypes = [];
                arTypesGWSrv.listArTypes().$promise.then(function(response){
                    if(response != null){
                        for(var i = 0; i < response.data.length; i++){
                            var arType = {};

                            arType.arAccountTypeId = response.data[i].arAccountTypeId;
                            arType.accountTypeName = response.data[i].accountTypeName;
                            arType.accountTypeDesc = response.data[i].accountTypeDesc;
                            arType.glAccountId = response.data[i].glAccountId;
                            arType.companyId = response.data[i].companyId;
                            arType.accountTypeCode = response.data[i].accountTypeCode;
                            arType.leftOverAmount = response.data[i].leftOverAmount;
                            arType.requiredStatus = response.data[i].requiredStatus;
                            arType.status = response.data[i].status;
                            arType.priority = response.data[i].priority;
                            arType.over30Message = response.data[i].over30Message;
                            arType.over60Message = response.data[i].over60Message;
                            arType.over90Message = response.data[i].over90Message;
                            arType.over120Message = response.data[i].over120Message;
                            arType.showAgingMessage = response.data[i].showAgingMessage;

                            arTypesCtrl.listArTypes.push(arType);
                        }
                    }
                });
            };

            arTypesCtrl.getArTypesList();

            arTypesCtrl.addArTypes = function (){
                var arType = {};

                arType.arAccountTypeId = arTypesCtrl.arAccountTypeId;
                arType.accountTypeName = arTypesCtrl.accountTypeName;
                arType.accountTypeDesc = arTypesCtrl.accountTypeDesc;
                arType.glAccountId = arTypesCtrl.glAccountId;
                arType.companyId = arTypesCtrl.companyId;
                arType.accountTypeCode = arTypesCtrl.accountTypeCode;
                arType.leftOverAmount = arTypesCtrl.leftOverAmount;
                arType.requiredStatus = arTypesCtrl.requiredStatus;
                arType.status = arTypesCtrl.status;
                arType.priority = arTypesCtrl.priority;
                arType.over30Message = arTypesCtrl.over30Message;
                arType.over60Message = arTypesCtrl.over60Message;
                arType.over90Message = arTypesCtrl.over90Message;
                arType.over120Message = arTypesCtrl.over120Message;
                arType.showAgingMessage = arTypesCtrl.showAgingMessage;

                arTypesGWSrv.addArType(arType).$promise.then(function(response){
                    if(response){
                        arTypesCtrl.getArTypesList();
                    }
                });
            };

        }]);


    angular.module('Asasa')
        .service('ArTypesGatewayService',['$resource' ,function ($resource) {
            var arTypesGWSrv = this;
            return $resource('',{},
                {
                    listArTypes :{method: 'GET', isArray: false, url:"/arAccount/arAccountTypes"},

                    addArType :{method: 'POST', isArray: false, url:"/arAccount/addAccountType"}
                });
        }]);
})();