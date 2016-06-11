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
        .controller('ArPaymentController', ['ArPaymentGatewayService', 'ngTableParams', '$http', function(arPaymentGatewayService, ngTableParams, $http) {
            var arPaymentCtrl = this;
            arPaymentCtrl.paymentOpen = false;
            arPaymentCtrl.importPaymentOpen = false;
            arPaymentCtrl.paymentList = [];

            arPaymentCtrl.openImportPaymentsPanel = function () {
                arPaymentCtrl.importPaymentOpen = true;
                arPaymentCtrl.paymentOpen = false;

            };

            arPaymentCtrl.openPaymentsPanel = function () {
                arPaymentCtrl.importPaymentOpen = false;
                arPaymentCtrl.paymentOpen = true;
            };

            arPaymentCtrl.paymentCols = [
                {field: "command", title: "", sortable: "command", filter: {command: "command"}, show: true, dataType: "command"},
                {field: "paymentDate", title: "Payment Date", sortable: "paymentDate", filter: {paymentDate: "text"}, show: true,dataType: "text"},
                {field: "description", title: "Description",sortable: "description", filter: {description: "text"},show: true,dataType: "text"},
                {field: "paymentSource", title: "Payment Source",sortable: "paymentSource", filter: {paymentSource: "text"},show: true,dataType: "text"},
                {field: "paymentTypeName", title: "Type",sortable: "paymentTypeName", filter: {paymentTypeName: "text"},show: true,dataType: "text"},
                {field: "paymentAmount", title: "Amount",sortable: "paymentAmount", filter: {paymentAmount: "number"},show: true,dataType: "number"},
                {field: "paymentStatus", title: "Status",sortable: "paymentStatus", filter: {paymentStatus: "text"},show: true,dataType: "text"}
            ];

            arPaymentCtrl.paymentItemTable = new ngTableParams({
                page: 1,
                count: 10
            }, {
                total: 2,
                getData: function ($defer, params) {
                    arPaymentCtrl.data = arPaymentCtrl.paymentList.slice((params.page() - 1) * params.count(), params.page() * params.count());
                    $defer.resolve(arPaymentCtrl.data);
                }
            });

            arPaymentCtrl.listOfArPayment = function(fromDate, toDate) {
                var param = {
                    fromDate:0,
                    toDate:1465633213438
                };
                arPaymentGatewayService.listOfArPayment(param).$promise.then( function(response){
                    if(response!=null) {
                        arPaymentCtrl.paymentList = [];
                        for(var i = 0; i < response.data.length; i++){
                            var arPayment = {};
                            arPayment.arAccountId = response.data[i].arAccountId;
                            arPayment.referenceArAccountId = response.data[i].referenceArAccountId;
                            arPayment.paymentTypeId = response.data[i].paymentTypeId;
                            arPayment.paymentTypeName = response.data[i].paymentTypeName;
                            arPayment.paymentAmount = response.data[i].paymentAmount;
                            arPayment.paymentDate = response.data[i].paymentDate;
                            arPayment.description = response.data[i].description;
                            arPayment.status = response.data[i].status;
                            arPayment.paymentStatus = response.data[i].paymentStatus;
                            arPayment.source = response.data[i].source;
                            arPayment.paymentSource = response.data[i].paymentSource;
                            arPaymentCtrl.paymentList.push(arPayment);
                        }
                        arPaymentCtrl.paymentItemTable.reload();
                    }
                });
            }
            arPaymentCtrl.listOfArPayment();
        }]);


    angular.module('Asasa')
        .service('ArPaymentGatewayService',['$resource' ,function ($resource) {
            var arPaymentGatewayService = this;
            return $resource('',{},
                {
                    listOfArPayment :{method: 'GET', isArray: false, url:"payments/list/:fromDate/:toDate"},

                    listOfBillCodes : {method: 'GET', isArray: false, url: "/billCodes/list"},

                    addArAdjustment :{method: 'POST', isArray: false, url:"/adjustments/addAdjustment"}

                });
        }]);


})();