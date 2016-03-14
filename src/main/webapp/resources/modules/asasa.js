/**
 * Created by Muhammad Umer on 3/12/2016.
 */
var app = angular.module('Asasa', []);

app.controller('MainModulesController', ['$http', function ($http){
    var mainMdlsCtrl = this;
    mainMdlsCtrl.showMainModules = true;
    mainMdlsCtrl.showCustomerPanel = false;

    mainMdlsCtrl.openCustomerPanel =  function(){
        mainMdlsCtrl.showMainModules = false;
        mainMdlsCtrl.showCustomerPanel = true;
    };

}]);