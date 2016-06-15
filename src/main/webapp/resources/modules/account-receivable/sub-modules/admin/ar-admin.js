/**
 * Created by VD on 4/25/2016.
 */
(function(){
    angular.module('Asasa')
        .directive('arOverviewPanel', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/sub-modules/overview/template/ar-overview.jsp'
            }
        });

    angular.module('Asasa')
        .controller('ArOverviewController', ['ArOverviewsGatewayService', 'ngTableParams', '$http', function(overviewGatewayService, ngTableParams, $http) {
            var arOverviewCtrl = this;

        }]);


    angular.module('Asasa')
        .service('ArOverviewGatewayService',['$resource' ,function ($resource) {

        }]);


})();