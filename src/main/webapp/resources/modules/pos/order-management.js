(function () {
    "use strict";
    angular.module('Asasa')
        .directive('orderManagementPanel', function () {
            return {
                restrict: "E",
                templateUrl: 'resources/modules/pos/templates/order-management.jsp'
            }
        });

    angular.module('Asasa')
        .controller('OrderManagementController', ['ngTableParams', 'PosOrderGatewayService', 'PosPaymentGatewayService', 'PosItemGetewayService',
            function (ngTableParams, posOrderGatewayService, posPaymentGatewayService, posItemGetewayService) {
                var orderCtrl = this;


                orderCtrl.order = {}
                orderCtrl.payment = {}
                orderCtrl.item = {};
                orderCtrl.items = [];
                orderCtrl.totalAmount = 0;


                orderCtrl.cols = [
                    {field: "itemCode",title: "Item Code",sortable: "itemCode",filter: {itemCode: "number"},show: true,dataType: "text"},
                    {field: "itemDescription",title: "Description ",sortable: "itemDescription",filter: {itemDescription: "text"},show: true,dataType: "text"},
                    {field: "costPrice",title: "Price ",sortable: "costPrice",filter: {costPrice: "number"},show: true,dataType: "text"},
                    {field: "action",title: "Actions",sortable: "action",filter: {action: "number"},show: true,dataType: "command"}
                ];


                orderCtrl.itemTable = new ngTableParams({
                    page: 1,
                    count: 10
                }, {
                    total: orderCtrl.items.length,
                    getData: function ($defer, params) {
                        console.log(orderCtrl.items);
                        orderCtrl.data = orderCtrl.items.slice((params.page() - 1) * params.count(), params.page() * params.count());
                        $defer.resolve(orderCtrl.data);
                    }
                });


                orderCtrl.scannedItem = function (itemCode) {
                    var params = {
                        itemCode: itemCode
                    };
                    posItemGetewayService.getPosItem(params).$promise.then(function (response) {
                        if (response) {
                            orderCtrl.addGridElement(response.data);
                            orderCtrl.calculateTotalAmount();
                        }
                    });
                }

                /**
                 * This function check all the items in the grid and calculate the Amount
                 */
                orderCtrl.calculateTotalAmount = function () {
                    orderCtrl.totalAmount = 0;
                    for (var idx in orderCtrl.items) {
                        var element = orderCtrl.items[idx];
                        orderCtrl.totalAmount = parseFloat(orderCtrl.totalAmount) + parseFloat(element.costPrice);
                    }
                }

                /**
                 * This Function used to add the Item in the front end grid
                 * @param itemElement
                 */
                orderCtrl.addGridElement = function (itemElement) {
                    if(itemElement.quantity == null){
                        itemElement.quantity = 1;
                    }
                    orderCtrl.items.push(angular.copy(itemElement));
                    orderCtrl.itemTable.reload();
                }

                /**
                 * Remove the Item from the Grid
                 * @param row
                 */
                orderCtrl.deleteItem = function (row) {
                    _.remove(orderCtrl.items, function (item) {
                        return row === item;
                    });
                    orderCtrl.itemTable.reload().then(function (data) {
                        if (data.length === 0 && orderCtrl.itemTable.total() > 0) {
                            orderCtrl.items.page(orderCtrl.itemTable.page() - 1);
                            orderCtrl.itemTable.reload();
                        }
                        orderCtrl.calculateTotalAmount();
                    });
                };


                /**
                 * Builder use to Create the Order Object which use to save the order
                 */
                var buildOrderObject = function () {
                    orderCtrl.order.totalAmount = orderCtrl.totalAmount;
                    orderCtrl.order.numberOfItems = orderCtrl.items.length;

                    //TODO: need to set the customer ID and Currency Id
                    orderCtrl.order.customerId = 1;
                    orderCtrl.order.currencyId = 1;

                    orderCtrl.order.items = [];

                    for (var idx in orderCtrl.items) {
                        var item = {
                            itemId: orderCtrl.items[idx].id,
                            quantity: orderCtrl.items[idx].quantity
                        };
                        orderCtrl.order.items.push(item);
                    }
                };

                /**
                 *  Used to build the payment object
                 */
                var buildPosPaymentObject = function () {
                    orderCtrl.payment = {
                        amount : orderCtrl.totalAmount,
                        posOrderId : orderCtrl.order.id,
                        paymentDate : new Date(),
                        posPaymentTypeId : 1,       //TODO: Need to make payment type Dynamic
                        posPaymentTypeName : 'CASH_PAYMENT', //TODO: Need to make payment type Dynamic
                        transactionId : 1 // TODO: Need to talk to @faizan about it
                    }
                };
                /**
                 * Use to save the order with the items attached
                 */
                orderCtrl.saveOrder = function () {
                    buildOrderObject();
                    posOrderGatewayService.saveOrder(orderCtrl.order).$promise.then(function(response){
                        orderCtrl.order = response.data;
                    });
                };

                /**
                 *  Perform the payment of the ORder
                 */
                orderCtrl.doPayment = function () {
                    buildPosPaymentObject();
                    posPaymentGatewayService.doPayment(orderCtrl.payment);
                };
            }]);
})();
