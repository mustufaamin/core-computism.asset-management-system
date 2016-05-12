/**
 * Created by VD on 4/25/2016.
 */
(function(){
    angular.module('Asasa')
        .directive('glAccountTypePanel', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/general-ledger/admin/account-type/templates/gl-account-type-panel.jsp'
            }
        });

    angular.module('Asasa')
        .directive('glAccountTypeSlidePanel', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/general-ledger/admin/account-type/templates/gl-account-type-slide-panel.jsp'
            }
        });

    angular.module('Asasa')
        .controller('GLAccountTypeController', ['GlAccountTypeGatewayService', '$http', function(accountTypeGatewayService, $http){
            var glAccountTypeCtrl = this;
            glAccountTypeCtrl.showPanel = false;
            glAccountTypeCtrl.isView = false;
            glAccountTypeCtrl.slidePanelHeading = '';
            glAccountTypeCtrl.listGlAccountType = [];
            glAccountTypeCtrl.type = 0;

            glAccountTypeCtrl.openAccountTypeSlidePanel = function(type ,accountType){
                glAccountTypeCtrl.type = type;
                if(accountType != null){
                    glAccountTypeCtrl.glAccountId = accountType.glAccountId;
                    glAccountTypeCtrl.description = accountType.description;
                    glAccountTypeCtrl.name = accountType.name;
                    glAccountTypeCtrl.normalBalanceFlag = accountType.normalBalanceFlag == 0 ? false : true;
                }

                glAccountTypeCtrl.showPanel = true;
                glAccountTypeCtrl.isView = false;
                if(type == 1){
                    glAccountTypeCtrl.clearSlidePanel();
                    glAccountTypeCtrl.slidePanelHeading = "Add GL Account Type";
                }else if(type == 2){
                    glAccountTypeCtrl.slidePanelHeading = "View GL Account Type";
                    glAccountTypeCtrl.isView = true;
                }else{
                    glAccountTypeCtrl.slidePanelHeading = "Edit GL Account Type";
                }
            };

            glAccountTypeCtrl.getAccountTypeList = function(){
                glAccountTypeCtrl.listGlAccountType = [];
                accountTypeGatewayService.listOfGlAccountType().$promise.then(function(response){
                    if(response != null){
                        console.log(response);
                        for(var i = 0; i < response.data.length; i++){
                            var glAccountType = {};

                            glAccountType.glAccountId = response.data[i].glAccountId;
                            glAccountType.description = response.data[i].description;
                            glAccountType.name = response.data[i].name;
                            glAccountType.normalBalanceFlag = response.data[i].normalBalanceFlag;
                            glAccountTypeCtrl.listGlAccountType.push(glAccountType);
                        }
                    }
                });
            };

            glAccountTypeCtrl.getAccountTypeList();

            glAccountTypeCtrl.clearSlidePanel = function(){
                glAccountTypeCtrl.description = '';
                glAccountTypeCtrl.name = '';
                glAccountTypeCtrl.normalBalanceFlag = false;
            };

            glAccountTypeCtrl.addGlAccountType = function (){
                var glAccountType = {};

                glAccountType.glAccountId = glAccountTypeCtrl.glAccountId;
                glAccountType.description = glAccountTypeCtrl.description;
                glAccountType.name = glAccountTypeCtrl.name;
                glAccountType.normalBalanceFlag = glAccountTypeCtrl.normalBalanceFlag == true ? 1 : 0;

                if(glAccountTypeCtrl.type == 1){
                    accountTypeGatewayService.addGlAccountType(glAccountType).$promise.then(function(response){
                        if(response.success){
                            glAccountTypeCtrl.showPanel = false;
                            glAccountTypeCtrl.getAccountTypeList();
                        }
                    });
                }else{
                    accountTypeGatewayService.updateGlAccountType(glAccountType).$promise.then(function(response){
                        if(response.success){
                            glAccountTypeCtrl.showPanel = false;
                            glAccountTypeCtrl.getAccountTypeList();
                        }
                    });
                }
            };

        }]);


    angular.module('Asasa')
        .service('GlAccountTypeGatewayService',['$resource' ,function ($resource) {
            var glAccountTypeGatewayService = this;
            return $resource('',{},
                {
                    listOfGlAccountType :{method: 'GET', isArray: false, url:"/glAccount/glAccountTypes"},

                    addGlAccountType :{method: 'POST', isArray: false, url:"/glAccount/addAccountType"},

                    updateGlAccountType :{method: 'POST', isArray: false, url:"/glAccount/updateAccountType"}
                });
        }]);
})();