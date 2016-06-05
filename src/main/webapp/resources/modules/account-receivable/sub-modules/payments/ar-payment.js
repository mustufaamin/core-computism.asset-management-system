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
        .controller('ArPaymentController', ['ArPaymentGatewayService', '$http', function(paymentGatewayService, $http){
            var arPaymentCtrl = this;
            arPaymentCtrl.listPaymentTypes = [];
            arPaymentCtrl.customerName = "Customer's Name";

            arPaymentCtrl.getPaymentList = function(){
                arPaymentCtrl.listPaymentTypes = [];
                adjustmentGatewayService.listOfPaymentTypes().$promise.then(function(response){
                    if(response != null){
                        console.log(response);
                        for(var i = 0; i < response.data.length; i++){
                            var billCode = {};
                            billCode.billCodeId = response.data[i].id;
                            billCode.name = response.data[i].name;
                            arPaymentCtrl.listPaymentTypes.push(billCode);
                        }
                    }
                });
            };
            arPaymentCtrl.getPaymentList();

            arPaymentCtrl.getCustomer = function(val){
                var _url = "/customer/search/" + val;
                return $http.get(_url).then(function(response){
                    return response.data.data.map(function(item){
                        return {
                            label: item.firstName + " " +item.lastName,
                            value: item.id,
                            customerStatus: item.customerStatus,
                            customerTypeId: item.customerTypeId
                        }
                    });
                });
            };

            arPaymentCtrl.onSelectCustomer = function(customer){
                arPaymentCtrl.customerType = customer.customerTypeId;
                arPaymentCtrl.customerStatus = customer.customerStatus;
                arPaymentCtrl.customerName = arPaymentCtrl.customer.label;
            };

            //TODO: AR Adjustment list
            arPaymentCtrl.getArPaymentList = function(customerId){

                var params = {
                    customerId:customerId
                }
                arPaymentCtrl.listArPayments = [];
                paymentGatewayService.listOfArPayment().$promise.then(function(response){
                    if(response != null){
                        for(var i = 0; i < response.data.length; i++){
                            var payment = {};

                            payment.arAccountId = response.data[i].arAccountId;
                            payment.referenceArAccountId = response.data[i].referenceArAccountId;
                            payment.paymentTypeId = response.data[i].paymentTypeId;
                            payment.paymentAmount = response.data[i].paymentAmount;
                            payment.paymentDate = response.data[i].paymentDate;
                            payment.postedDate = response.data[i].postedDate;
                            payment.processedBy = response.data[i].processedBy;
                            payment.description = response.data[i].description;
                            payment.note = response.data[i].note;
                            payment.status = response.data[i].status;
                            payment.createdBy = response.data[i].createdBy;
                            payment.modifiedBy = response.data[i].modifiedBy;
                            payment.batchId = response.data[i].batchId;
                            payment.source = response.data[i].source;
                            payment.suppressOnStatement = response.data[i].suppressOnStatement;
                            payment.statementDescription2 = response.data[i].statementDescription2;
                            payment.referenceId = response.data[i].referenceId;

                            arPaymentCtrl.listArPayments.push(payment);
                        }
                    }
                });
            };

            arPaymentCtrl.addArPayment = function (){
                var payment = {};
                payment.arAccountId = arPaymentCtrl.arAccountId;
                //payment.referenceArAccountId = arPaymentCtrl.referenceArAccountId;
                payment.paymentTypeId = arPaymentCtrl.paymentTypeId;
                payment.paymentAmount = arPaymentCtrl.paymentAmount;
                payment.paymentDate = arPaymentCtrl.paymentDate;
                payment.postedDate = arPaymentCtrl.paymentDate;
                //payment.processedBy = arPaymentCtrl.processedBy;
                payment.description = arPaymentCtrl.description;
                payment.note = arPaymentCtrl.note;
                payment.status = arPaymentCtrl.status;
                payment.createdBy = arPaymentCtrl.createdBy;
                payment.modifiedBy = arPaymentCtrl.modifiedBy;
                payment.batchId = arPaymentCtrl.batchId;
                payment.source = arPaymentCtrl.source;
                payment.suppressOnStatement = arPaymentCtrl.suppressOnStatement;
                payment.statementDescription2 = arPaymentCtrl.statementDescription2;
                payment.referenceId = arPaymentCtrl.referenceId;

                adjustmentGatewayService.addArPayment(payment).$promise.then(function(response){
                    if(response){

                    }
                });
            };

        }]).config(function($mdThemingProvider) {

            // Configure a dark theme with primary foreground yellow

            $mdThemingProvider.theme('docs-dark', 'default')
                .primaryPalette('yellow')
                .dark();

        })
    ;


    angular.module('Asasa')
        .service('ArPaymentGatewayService',['$resource' ,function ($resource) {
            var arPaymentGatewayService = this;
            return $resource('',{},
                {
                    listOfArPayment :{method: 'GET', isArray: false, url:"/payments/list/:customerId"},

                    listOfPaymentTypes : {method: 'GET', isArray: false, url: "/billCodes/list"},

                    addArPayment :{method: 'POST', isArray: false, url:"/adjustments/addAdjustment"}

                });
        }]);


})();