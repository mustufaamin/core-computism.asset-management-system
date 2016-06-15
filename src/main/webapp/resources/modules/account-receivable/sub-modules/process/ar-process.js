/**
 * Created by Muhammad Umer on 4/25/2016.
 */
(function(){
    angular.module('Asasa')
        .directive('arPaymentPanel', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/sub-modules/process/template/ar-process.jsp'
            }
        });

    angular.module('Asasa')
        .controller('ArProcessController', ['ArProcessGatewayService', 'ngTableParams', '$http', function(processGatewayService, ngTableParams, $http) {
            var arProcessCtrl = this;

        }]);


    angular.module('Asasa')
        .service('ArProcessGatewayService',['$resource' ,function ($resource) {

        }]);


})();