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
        .controller('OrderManagementController', ['ngTableParams', 'ItemGateway', function (ngTableParams, itemGateway) {
            var orderCtrl = this;


            orderCtrl.order = {}
            orderCtrl.item = {};
            orderCtrl.items = [];
            orderCtrl.totalAmount = 0;



            orderCtrl.cols = [
                {field: "itemCode", title: "Item Code", sortable: "itemCode", filter: {itemCode: "number"}, show: true,dataType: "text"},
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
                itemGateway.get(params).$promise.then(function (response) {
                    if (response) {
                        orderCtrl.addGridElement(response.data);
                        orderCtrl.calculateTotalAmount();
                    }
                });

            }

            orderCtrl.calculateTotalAmount = function () {
                orderCtrl.totalAmount = 0;
                for (var idx in orderCtrl.items) {
                    var element = orderCtrl.items[idx];
                    orderCtrl.totalAmount = parseFloat(orderCtrl.totalAmount) + parseFloat(element.costPrice);
                }
            }

            orderCtrl.addGridElement = function (itemElement) {
                orderCtrl.items.push(angular.copy(itemElement));
                orderCtrl.itemTable.reload();
            }

            orderCtrl.deleteItem = function (row) {
                _.remove(orderCtrl.items, function(item) {
                    return row === item;
                });
                orderCtrl.itemTable.reload().then(function(data) {
                    if (data.length === 0 && orderCtrl.itemTable.total() > 0) {
                        orderCtrl.items.page(orderCtrl.itemTable.page() - 1);
                        orderCtrl.itemTable.reload();
                    }
                    orderCtrl.calculateTotalAmount();
                });
            };

            var buildOrderObject = function(){
                orderCtrl.order.totalAmount = orderCtrl.totalAmount;
                orderCtrl.order.numberOfItems = orderCtrl.items.length;

                //TODO: need to set the customer ID and Currency Id
                orderCtrl.order.customerId = 1;
                orderCtrl.order.currencyId = 1;

                orderCtrl.order.items = orderCtrl.items;
            }

            orderCtrl.save

        }]);

    angular.module('Asasa')
        .service('ItemGateway', ['$resource', function ($resource) {
            var itemGateway = this;
            return $resource('', {},
                {
                    get: {method: 'GET', isArray: false, url: '/item/get/:itemCode'},
                    saveOrder:{method: 'POST', isArray: false, url: '/order/save'}
                });
        }]);


})();

angular.module("myApp", ["ngTable", "ngTableDemos"]);

(function() {
    "use strict";

    angular.module("myApp").controller("demoController", demoController);
    demoController.$inject = ["NgTableParams", "ngTableSimpleList"];

    function demoController(NgTableParams, simpleList) {
        var self = this;

        var originalData = angular.copy(simpleList);

        self.tableParams = new NgTableParams({}, {
            filterDelay: 0,
            dataset: angular.copy(simpleList)
        });

        self.cancel = cancel;
        self.del = del;
        self.save = save;

        //////////

        function cancel(row, rowForm) {
            var originalRow = resetRow(row, rowForm);
            angular.extend(row, originalRow);
        }

        function del(row) {
            _.remove(self.tableParams.settings().dataset, function(item) {
                return row === item;
            });
            self.tableParams.reload().then(function(data) {
                if (data.length === 0 && self.tableParams.total() > 0) {
                    self.tableParams.page(self.tableParams.page() - 1);
                    self.tableParams.reload();
                }
            });
        }

        function resetRow(row, rowForm){
            row.isEditing = false;
            rowForm.$setPristine();
            self.tableTracker.untrack(row);
            return _.findWhere(originalData, function(r){
                return r.id === row.id;
            });
        }

        function save(row, rowForm) {
            var originalRow = resetRow(row, rowForm);
            angular.extend(originalRow, row);
        }
    }
})();

(function() {
    "use strict";

    angular.module("myApp").controller("dynamicDemoController", dynamicDemoController);
    dynamicDemoController.$inject = ["NgTableParams", "ngTableSimpleList"];

    function dynamicDemoController(NgTableParams, simpleList) {
        var self = this;

        self.cols = [{
            field: "name",
            title: "Name",
            filter: {
                name: "text"
            },
            sortable: "name",
            dataType: "text"
        }, {
            field: "age",
            title: "Age",
            filter: {
                age: "number"
            },
            sortable: "age",
            dataType: "number"
        }, {
            field: "money",
            title: "Money",
            filter: {
                money: "number"
            },
            sortable: "money",
            dataType: "number"
        }, {
            field: "action",
            title: "action",
            dataType: "command"
        }];

        var originalData = angular.copy(simpleList);

        self.tableParams = new NgTableParams({}, {
            filterDelay: 0,
            dataset: angular.copy(simpleList)
        });

        self.cancel = cancel;
        self.del = del;
        self.save = save;

        //////////

        function cancel(row, rowForm) {
            var originalRow = resetRow(row, rowForm);
            angular.extend(row, originalRow);
        }

        function del(row) {
            _.remove(self.tableParams.settings().dataset, function(item) {
                return row === item;
            });
            self.tableParams.reload().then(function(data) {
                if (data.length === 0 && self.tableParams.total() > 0) {
                    self.tableParams.page(self.tableParams.page() - 1);
                    self.tableParams.reload();
                }
            });
        }

        function resetRow(row, rowForm){
            row.isEditing = false;
            rowForm.$setPristine();
            self.tableTracker.untrack(row);
            return _.findWhere(originalData, function(r){
                return r.id === row.id;
            });
        }

        function save(row, rowForm) {
            var originalRow = resetRow(row, rowForm);
            angular.extend(originalRow, row);
        }
    }
})();


(function() {
    "use strict";

    angular.module("myApp").run(configureDefaults);
    configureDefaults.$inject = ["ngTableDefaults"];

    function configureDefaults(ngTableDefaults) {
        ngTableDefaults.params.count = 5;
        ngTableDefaults.settings.counts = [];
    }
})();

/**********
 The following directives are necessary in order to track dirty state and validity of the rows
 in the table as the user pages within the grid
 ------------------------
 */

(function() {
    angular.module("myApp").directive("demoTrackedTable", demoTrackedTable);

    demoTrackedTable.$inject = [];

    function demoTrackedTable() {
        return {
            restrict: "A",
            priority: -1,
            require: "ngForm",
            controller: demoTrackedTableController
        };
    }

    demoTrackedTableController.$inject = ["$scope", "$parse", "$attrs", "$element"];

    function demoTrackedTableController($scope, $parse, $attrs, $element) {
        var self = this;
        var tableForm = $element.controller("form");
        var dirtyCellsByRow = [];
        var invalidCellsByRow = [];

        init();

        ////////

        function init() {
            var setter = $parse($attrs.demoTrackedTable).assign;
            setter($scope, self);
            $scope.$on("$destroy", function() {
                setter(null);
            });

            self.reset = reset;
            self.isCellDirty = isCellDirty;
            self.setCellDirty = setCellDirty;
            self.setCellInvalid = setCellInvalid;
            self.untrack = untrack;
        }

        function getCellsForRow(row, cellsByRow) {
            return _.find(cellsByRow, function(entry) {
                return entry.row === row;
            })
        }

        function isCellDirty(row, cell) {
            var rowCells = getCellsForRow(row, dirtyCellsByRow);
            return rowCells && rowCells.cells.indexOf(cell) !== -1;
        }

        function reset() {
            dirtyCellsByRow = [];
            invalidCellsByRow = [];
            setInvalid(false);
        }

        function setCellDirty(row, cell, isDirty) {
            setCellStatus(row, cell, isDirty, dirtyCellsByRow);
        }

        function setCellInvalid(row, cell, isInvalid) {
            setCellStatus(row, cell, isInvalid, invalidCellsByRow);
            setInvalid(invalidCellsByRow.length > 0);
        }

        function setCellStatus(row, cell, value, cellsByRow) {
            var rowCells = getCellsForRow(row, cellsByRow);
            if (!rowCells && !value) {
                return;
            }

            if (value) {
                if (!rowCells) {
                    rowCells = {
                        row: row,
                        cells: []
                    };
                    cellsByRow.push(rowCells);
                }
                if (rowCells.cells.indexOf(cell) === -1) {
                    rowCells.cells.push(cell);
                }
            } else {
                _.remove(rowCells.cells, function(item) {
                    return cell === item;
                });
                if (rowCells.cells.length === 0) {
                    _.remove(cellsByRow, function(item) {
                        return rowCells === item;
                    });
                }
            }
        }

        function setInvalid(isInvalid) {
            self.$invalid = isInvalid;
            self.$valid = !isInvalid;
        }

        function untrack(row) {
            _.remove(invalidCellsByRow, function(item) {
                return item.row === row;
            });
            _.remove(dirtyCellsByRow, function(item) {
                return item.row === row;
            });
            setInvalid(invalidCellsByRow.length > 0);
        }
    }
})();

(function() {
    angular.module("myApp").directive("demoTrackedTableRow", demoTrackedTableRow);

    demoTrackedTableRow.$inject = [];

    function demoTrackedTableRow() {
        return {
            restrict: "A",
            priority: -1,
            require: ["^demoTrackedTable", "ngForm"],
            controller: demoTrackedTableRowController
        };
    }

    demoTrackedTableRowController.$inject = ["$attrs", "$element", "$parse", "$scope"];

    function demoTrackedTableRowController($attrs, $element, $parse, $scope) {
        var self = this;
        var row = $parse($attrs.demoTrackedTableRow)($scope);
        var rowFormCtrl = $element.controller("form");
        var trackedTableCtrl = $element.controller("demoTrackedTable");

        self.isCellDirty = isCellDirty;
        self.setCellDirty = setCellDirty;
        self.setCellInvalid = setCellInvalid;

        function isCellDirty(cell) {
            return trackedTableCtrl.isCellDirty(row, cell);
        }

        function setCellDirty(cell, isDirty) {
            trackedTableCtrl.setCellDirty(row, cell, isDirty)
        }

        function setCellInvalid(cell, isInvalid) {
            trackedTableCtrl.setCellInvalid(row, cell, isInvalid)
        }
    }
})();

(function() {
    angular.module("myApp").directive("demoTrackedTableCell", demoTrackedTableCell);

    demoTrackedTableCell.$inject = [];

    function demoTrackedTableCell() {
        return {
            restrict: "A",
            priority: -1,
            scope: true,
            require: ["^demoTrackedTableRow", "ngForm"],
            controller: demoTrackedTableCellController
        };
    }

    demoTrackedTableCellController.$inject = ["$attrs", "$element", "$scope"];

    function demoTrackedTableCellController($attrs, $element, $scope) {
        var self = this;
        var cellFormCtrl = $element.controller("form");
        var cellName = cellFormCtrl.$name;
        var trackedTableRowCtrl = $element.controller("demoTrackedTableRow");

        if (trackedTableRowCtrl.isCellDirty(cellName)) {
            cellFormCtrl.$setDirty();
        } else {
            cellFormCtrl.$setPristine();
        }
        // note: we don't have to force setting validaty as angular will run validations
        // when we page back to a row that contains invalid data

        $scope.$watch(function() {
            return cellFormCtrl.$dirty;
        }, function(newValue, oldValue) {
            if (newValue === oldValue) return;

            trackedTableRowCtrl.setCellDirty(cellName, newValue);
        });

        $scope.$watch(function() {
            return cellFormCtrl.$invalid;
        }, function(newValue, oldValue) {
            if (newValue === oldValue) return;

            trackedTableRowCtrl.setCellInvalid(cellName, newValue);
        });
    }
})();
