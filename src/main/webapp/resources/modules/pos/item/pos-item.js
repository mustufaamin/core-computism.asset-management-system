/**
 * Created by Muhammad Umer on 3/31/2016.
 */
(function () {
    angular.module('Asasa')
        .directive('posItemPanel', function () {
            return {
                restrict: "E",
                templateUrl: 'resources/modules/pos/item/template/pos-item-panel.jsp'
            }
        });

    angular.module('Asasa')
        .directive('posItemSlidePanel', function () {
            return {
                restrict: "E",
                templateUrl: 'resources/modules/pos/item/template/pos-item-slide-panel.jsp'
            }
        });

    angular.module('Asasa')
        .controller('PosItemController', ['ngTableParams', 'PosItemGatewayService', '$http', function (ngTableParams, posItemSrv, $http) {
            var posItemCtrl = this;


            posItemCtrl.posItem={};
            posItemCtrl.items = [];

            posItemCtrl.cols = [
                {field: "id", title: "Item ID", sortable: "id", filter: {id: "number"}, show: true, dataType: "number"},
                {
                    field: "itemCode",
                    title: "item Code ",
                    sortable: "itemCode",
                    filter: {itemCode: "text"},
                    show: true,
                    dataType: "text"
                },
                {
                    field: "name",
                    title: "Name ",
                    sortable: "costPrice",
                    filter: {name: "text"},
                    show: true,
                    dataType: "text"
                },
                {
                    field: "itemDescription",
                    title: "Description",
                    sortable: "itemDescription",
                    filter: {itemDescription: "number"},
                    show: true,
                    dataType: "text"
                },
                {
                    field: "stockLevel",
                    title: "Stock Level",
                    sortable: "stockLevel",
                    filter: {stockLevel: "number"},
                    show: true,
                    dataType: "text"
                }

            ];

            posItemCtrl.posItemTable = new ngTableParams({
                page: 1,
                count: 10
            }, {
                total: posItemCtrl.items.length,
                getData: function ($defer, params) {
                    posItemCtrl.data = posItemCtrl.items.slice((params.page() - 1) * params.count(), params.page() * params.count());
                    $defer.resolve(posItemCtrl.data);
                }
            });

            posItemCtrl.getPosItemList = function () {
                posItemSrv.listOfPosItem().$promise.then(function (response) {
                    if (response != null) {
                        for (var i = 0; i < response.data.length; i++) {
                            var posItem = {};
                            posItem.id = response.data[i].id;
                            posItem.itemCode = response.data[i].itemCode;
                            posItem.itemUnit = response.data[i].itemUnit;
                            posItem.stockLevel = response.data[i].stockLevel;
                            posItem.minStockLevel = response.data[i].minStockLevel;
                            posItem.costPrice = response.data[i].costPrice;
                            posItem.salesPrice = response.data[i].salesPrice;
                            posItem.location = response.data[i].location;
                            posItem.itemDescription = response.data[i].itemDescription;
                            posItem.supplerId = response.data[i].supplerId;
                            posItem.itemType = response.data[i].itemType;
                            posItem.quantity = response.data[i].quantity;

                            posItemCtrl.items.push(posItem);
                        }
                    }
                    posItemCtrl.posItemTable.reload();
                });
            };

            posItemCtrl.getPosItemList();


            posItemCtrl.searchPosItem = function (typeSearchKey) {
                if (typeSearchKey == null) {
                    typeSearchKey = '';
                }

                var params = {
                    searchKey: typeSearchKey
                };
                posItemSrv.searchPosItem(params).$promise.then(function (response) {
                    if (response != null) {
                        posItemCtrl.items = [];
                        for (var i = 0; i < response.data.length; i++) {
                            var posItem = {};

                            posItem.id = response.data[i].id;
                            posItem.itemCode = response.data[i].itemCode;
                            posItem.itemUnit = response.data[i].itemUnit;
                            posItem.stockLevel = response.data[i].stockLevel;
                            posItem.minStockLevel = response.data[i].minStockLevel;
                            posItem.costPrice = response.data[i].costPrice;
                            posItem.salesPrice = response.data[i].salesPrice;
                            posItem.location = response.data[i].location;
                            posItem.itemDescription = response.data[i].itemDescription;
                            posItem.supplerId = response.data[i].supplerId;
                            posItem.itemType = response.data[i].itemType;
                            posItem.quantity = response.data[i].quantity;

                            posItemCtrl.items.push(posItem);
                        }
                    }
                    posItemCtrl.posItemTable.reload();
                });
            };


            posItemCtrl.addPosItem = function () {
               posItemSrv.addPosItem(posItemCtrl.posItem).$promise.then(function (response) {
                    if (response) {
                        posItemCtrl.getPosItemList();
                    }
                });
            };

            posItemCtrl.openPosItemSlidePanel = function (type, posItem) {
                if (posItem != null) {
                    posItemCtrl.id = posItem.id;
                    posItemCtrl.itemCode = posItem.itemCode;
                    posItemCtrl.itemUnit = posItem.itemUnit;
                    posItemCtrl.stockLevel = posItem.stockLevel;
                    posItemCtrl.minStockLevel = posItem.minStockLevel;
                    posItemCtrl.costPrice = posItem.costPrice;
                    posItemCtrl.salesPrice = posItem.salesPrice;
                    posItemCtrl.location = posItem.location;
                    posItemCtrl.itemDescription = posItem.itemDescription;
                    posItemCtrl.supplerId = posItem.supplerId;
                    posItemCtrl.itemType = posItem.itemType;
                    posItemCtrl.quantity = posItem.quantity;
                }

                posItemCtrl.showPanel = true;
                posItemCtrl.isView = false;
                if (type == 1) {
                    posItemCtrl.slidePanelHeading = "Add Pos Item";
                } else if (type == 2) {
                    posItemCtrl.slidePanelHeading = "View Pos Item";
                    posItemCtrl.isView = true;
                } else {
                    posItemCtrl.slidePanelHeading = "Edit Pos Item";
                }
            };
        }]);


    angular.module('Asasa')
        .service('PosItemGatewayService', ['$resource', function ($resource) {
            var posItemSrv = this;
            return $resource('', {},
                {
                    listOfPosItem: {method: 'GET', isArray: false, url: "/item/list"},

                    addPosItem: {method: 'POST', isArray: false, url: "/item/add"},

                    updatePosItem: {method: 'POST', isArray: false, url: "/item/update"},
                    searchPosItem: {method: 'GET', isArray: false, url: "/item/search/:searchKey"}

                });
        }]);
})();
;