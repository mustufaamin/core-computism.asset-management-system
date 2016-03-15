/**
 * Created by VD on 3/12/2016.
 */
(function(){
    angular.module('Asasa')
        .directive('customerPanel', function(){
        return{
            restrict: "E",
            templateUrl: 'resources/modules/customer/templates/customer-panel.jsp'
        }
    });

    angular.module('Asasa')
        .directive('addEditCustomerSlidePanel', function(){
        return{
            restrict: "E",
            templateUrl: 'resources/modules/customer/templates/add-edit-customer-slide-panel.jsp'
        }
    });

    angular.module('Asasa')
        .controller('CustomerController', ['$http', function($http){
            var custCtrl = this;
            custCtrl.showPanel = false;
            custCtrl.isView = false;
            custCtrl.slidePanelHeading = '';
            custCtrl.openCustomerSlidePanel = function(type){
                custCtrl.showPanel = true;
                custCtrl.isView = false;
                if(type == 1){
                    custCtrl.slidePanelHeading = "Add Customer";
                }else if(type == 2){
                    custCtrl.slidePanelHeading = "View Customer";
                    custCtrl.isView = true;
                }else{
                    custCtrl.slidePanelHeading = "Edit Customer";
                }
            };
    }]);
})();
