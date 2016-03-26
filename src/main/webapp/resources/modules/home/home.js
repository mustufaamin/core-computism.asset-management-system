/**
 * Created by Muhammad Umer on 3/24/2016.
 */
(function(){
    angular.module('Asasa')
        .directive('homePanel', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/home/templates/home-panel.jsp'
            }
        });


    angular.module('Asasa')
        .controller('HomeController', [function(){
            var homeCtrl = this;
        }]);



})();