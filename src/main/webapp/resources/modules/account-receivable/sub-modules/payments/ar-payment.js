/**
 * Created by VD on 4/25/2016.
 */
(function(){
    angular.module('Asasa')
        .directive('arPaymentPanel', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/sub-modules/payments/template/ar-payment.jsp'
            }
        });

    angular.module('Asasa')
        .controller('ArPaymentController', ['ArAdjustmentGatewayService', 'ngTableParams', '$http', function(adjustmentGatewayService, ngTableParams, $http) {
            var arPaymentCtrl = this;
            arPaymentCtrl.paymentOpen = false;
            arPaymentCtrl.importPaymentOpen = false;

            arPaymentCtrl.openImportPaymentsPanel = function () {
                arPaymentCtrl.importPaymentOpen = true;
                arPaymentCtrl.paymentOpen = false;

            };

            arPaymentCtrl.openPaymentsPanel = function () {
                arPaymentCtrl.importPaymentOpen = false;
                arPaymentCtrl.paymentOpen = true;
            };

            arPaymentCtrl.paymentCols = [
                {field: "command",title: "",sortable: "command",filter: {command: "command"},show: true,dataType: "command"},
                {field: "firstName",title: "First Name",sortable: "firstName",filter: {firstName: "text"},show: true,dataType: "text"},
                {field: "lastName",title: "Last Name",sortable: "lastName",filter: {lastName: "text"},show: true,dataType: "text"},
                {field: "phoneNumber",title: "Phone Number",sortable: "phoneNumber",filter: {phoneNumber: "number"},show: true,dataType: "number"},
                {field: "mobileNumber",title: "Mobile Number",sortable: "mobileNumber",filter: {mobileNumber: "number"},show: true,dataType: "number"},
                {field: "email",title: "Email",sortable: "email",filter: {email: "text"},show: true,dataType: "text"},
                {field: "locationAddress",title: "Address",sortable: "locationAddress",filter: {locationAddress: "text"},show: true,dataType: "text"},
                {field: "cityId",title: "City Id",sortable: "cityId",filter: {cityId: "number"},show: false,dataType: "number"},
                {field: "cityName",title: "City Name",sortable: "cityName",filter: {cityName: "text"},show: true,dataType: "text"},
                {field: "customerStatus",title: "Status",sortable: "customerStatus",filter: {customerStatus: "number"},show: true,dataType: "number"},
                {field: "customerTypeId",title: "CCT Id",sortable: "customerTypeId",filter: {customerTypeId: "number"},show: false,dataType: "number"},
                {field: "customerTypeName",title: "Customer Type Name",sortable: "customerTypeName",filter: {customerTypeName: "text"},show: true,dataType: "text"}
            ];

            arPaymentCtrl.paymentItemTable = new ngTableParams({
                page: 1,
                count: 10
            }, {
                total: 2,
                getData: function ($defer, params) {
                    arPaymentCtrl.data = arPaymentCtrl.listCustomer.slice((params.page() - 1) * params.count(), params.page() * params.count());
                    $defer.resolve(arPaymentCtrl.data);
                }
            });
        }]);


    angular.module('Asasa')
        .service('ArAdjustmentGatewayService',['$resource' ,function ($resource) {
            var arAdjustmentGatewayService = this;
            return $resource('',{},
                {
                    listOfArAdjustment :{method: 'GET', isArray: false, url:"/glAccount/glAccountTypes"},

                    listOfBillCodes : {method: 'GET', isArray: false, url: "/billCodes/list"},

                    addArAdjustment :{method: 'POST', isArray: false, url:"/adjustments/addAdjustment"}

                });
        }]);


})();