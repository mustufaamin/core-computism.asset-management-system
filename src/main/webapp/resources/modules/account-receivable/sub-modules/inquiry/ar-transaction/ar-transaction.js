(function () {
    "use strict";
    angular.module('Asasa')
        .directive('arTransactionPanel', function () {
            return {
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/sub-modules/inquiry/ar-transaction/template/ar-transaction-panel.jsp'
            }
        });

    angular.module('Asasa')
        .controller('ArTransactionListController', ['ngTableParams', 'ArTransactionGatewayService', '$http',
            function (ngTableParams, transactionGatewayService, $http) {
                var transactionCtrl = this;
                transactionCtrl.items = [];
                transactionCtrl.totalAmount = 0;

                transactionCtrl.cols = [
                    {
                        field: "customerId",
                        title: "Customer Id",
                        sortable: "customerId",
                        filter: {customerId: "number"},
                        show: true,
                        dataType: "number"
                    },
                    {
                        field: "customerName",
                        title: "Customer Name",
                        sortable: "customerName",
                        filter: {customerName: "text"},
                        show: true,
                        dataType: "text"
                    },
                    {
                        field: "date",
                        title: "Date",
                        sortable: "date",
                        filter: {date: "text"},
                        show: true,
                        dataType: "text"
                    },
                    {
                        field: "description",
                        title: "Description",
                        sortable: "description",
                        filter: {description: "text"},
                        show: true,
                        dataType: "text"
                    },
                    {
                        field: "charge",
                        title: "Charge",
                        sortable: "charge",
                        filter: {description: "number"},
                        show: true,
                        dataType: "number"
                    },
                    {
                        field: "totalAmount",
                        title: "Total Amount",
                        sortable: "totalAmount",
                        filter: {description: "number"},
                        show: true,
                        dataType: "number"
                    }
                ];


                transactionCtrl.itemTable = new ngTableParams({
                    page: 1,
                    count: 10
                }, {
                    total: transactionCtrl.items.length,
                    getData: function ($defer, params) {
                        console.log(transactionCtrl.items);
                        transactionCtrl.data = transactionCtrl.items.slice((params.page() - 1) * params.count(), params.page() * params.count());
                        $defer.resolve(transactionCtrl.data);
                    }
                });

                transactionCtrl.getTransactionList = function () {
                    transactionGatewayService.listOfArTransactions().$promise.then(function (response) {
                        if (response != null) {
                            console.log(response);
                            for (var i = 0; i < response.data.length; i++) {
                                var arTransaction = {};
                                arTransaction.arAccountId = response.data[i].arAccountId;
                                arTransaction.statementId = response.data[i].statementId;
                                arTransaction.referenceId = response.data[i].referenceId;
                                arTransaction.sourceId = response.data[i].sourceId;
                                arTransaction.date = response.data[i].transactionDate;
                                arTransaction.transactionType = response.data[i].transactionType;
                                arTransaction.charge = response.data[i].amount;
                                arTransaction.status = response.data[i].status;
                                arTransaction.description = response.data[i].statementDescription1;
                                arTransaction.statementDescription2 = response.data[i].statementDescription2;
                                arTransaction.description = response.data[i].description;
                                arTransaction.postingDate = response.data[i].postingDate;
                                arTransaction.chargeCustomerId = response.data[i].chargeCustomerId;
                                arTransaction.createdBy = response.data[i].createdBy;
                                arTransaction.glAccountId = response.data[i].glAccountId;
                                arTransaction.transactionSubType = response.data[i].transactionSubType;
                                arTransaction.totalAmount = response.data[i].totalAmount;
                                arTransaction.suppressOnStatement = response.data[i].suppressOnStatement;
                                arTransaction.customerId = response.data[i].customerId;
                                arTransaction.customerName = response.data[i].customerFullName;
                                transactionCtrl.items.push(arTransaction);
                                transactionCtrl.itemTable.reload();
                            }
                        }
                    });
                };

                transactionCtrl.getTransactionList();


                /**
                 * This function check all the items in the grid and calculate the Amount
                 */
                transactionCtrl.calculateTotalAmount = function () {
                    transactionCtrl.totalAmount = 0;
                    for (var idx in transactionCtrl.items) {
                        var element = transactionCtrl.items[idx];
                        transactionCtrl.totalAmount = parseFloat(transactionCtrl.totalAmount) + parseFloat(element.costPrice);
                    }
                }
            }]);

    angular.module('Asasa')
        .service('ArTransactionGatewayService', ['$resource', function ($resource) {
            var arTransactionGatewayService = this;
            return $resource('', {},
                {
                    listOfArTransactions: {method: 'GET', isArray: false, url: "/ar/transactions/listAllTransactions"},
                });
        }]);
})();
