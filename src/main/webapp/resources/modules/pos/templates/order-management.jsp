<div class="col-xs-12"  ng-cloak="" class="md-inline-form inputdemoBasicUsage" id="orderManagementPanel" ng-controller="OrderManagementController as orderCtrl">



    <div id="posdemoparent" ng-style="{'overflow': (parentScrollable && 'scroll'), 'position': (parentRelative && 'relative')}"
         style="border: 1px solid #ccc; padding: 15px;">
        <div class="row">
            <div class="col-xs-4">
                <md-content  layout-gt-sm="row" layout-padding="">
                    <md-input-container>
                <input
                        name="itemCode"
                        ng-model="orderCtrl.item['itemCode']" ng-required="true"
                        uib-typeahead="item for item in orderCtrl.scannedItem($viewValue)"
                        typeahead-no-results="noItems" typeahead-wait-ms=1500
                        placeholder="Scan Area">
                    </md-input-container>
                </md-content>

            </div>
            <div class="col-xs-4">
                <md-content  layout-gt-sm="row" layout-padding="">
                    <md-input-container>
                        <label>Currency</label>
                        <input ng-model="user.title">
                    </md-input-container>
                </md-content>
            </div>
            <div class="col-xs-4">
                <md-content  layout-gt-sm="row" layout-padding="">
                    <md-input-container>
                        <label>Customer</label>
                        <input ng-model="user.title">
                    </md-input-container>
                </md-content>
            </div>
        </div>


        <div class="row">

            <div>
                <table ng-table-dynamic="orderCtrl.itemTable with orderCtrl.cols"
                       class="table table-condensed table-bordered table-striped">
                    <colgroup>
                        <col width="20%" />
                        <col width="60%" />
                        <col width="10%" />
                        <col width="10%" />
                    </colgroup>
                    <tr ng-repeat="row in $data">
                        <td ng-repeat="col in $columns">
                            <span ng-if="col.dataType !== 'command'">{{row[col.field]}}</span>
                            <div ng-if="col.dataType === 'command'">
                                <button class="btn btn-danger btn-sm" ng-click="orderCtrl.deleteItem(row)"><span class="glyphicon glyphicon-trash"></span></button>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-4">
                <md-content layout-gt-sm="row" layout-padding="">
                    <md-input-container>
                        <label>Total Amount</label>
                        <input ng-model="orderCtrl.totalAmount">
                    </md-input-container>
                </md-content>
            </div>
            <div class="col-xs-4">
                <p>Number of Items: <span class="radioValue">{{ orderCtrl.items.length }}</span> </p>
            </div>
        </div>
    </div>

</div>


<%--div ng-app="myApp" class="container-fluid">--%>
<%--<div class="row">--%>
<%--<div class="col-xs-12">--%>
<%--<h2 class="page-header">Base runnable demo (TODO)</h2>--%>
<%--<div class="bs-callout bs-callout-info">--%>
<%--<h4>Overview</h4>--%>
<%--<p>One or two sentances explaining the demo <strong>(TODO)</strong></p>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--<div class="row">--%>
<%--<div class="col-md-6" ng-controller="demoController as demo">--%>
<%--<h3>ngTable directive</h3>--%>
<%--<table ng-table="demo.tableParams" class="table table-condensed table-bordered table-striped">--%>
<%--<tr ng-repeat="row in $data">--%>
<%--<td title="'Name'" filter="{name: 'text'}" sortable="'name'">{{row.name}}</td>--%>
<%--<td title="'Age'" filter="{age: 'number'}" sortable="'age'">{{row.age}}</td>--%>
<%--<td title="'Money'" filter="{money: 'number'}" sortable="'money'">{{row.money}}</td>--%>
<%--</tr>--%>
<%--</table>--%>
<%--</div>--%>
<%--<div class="col-md-6" ng-controller="dynamicDemoController as demo">--%>
<%--<h3>ngTableDynamic directive</h3>--%>
<%--<table ng-table-dynamic="demo.tableParams with demo.cols" class="table table-condensed table-bordered table-striped">--%>
<%--<tr ng-repeat="row in $data">--%>
<%--<td ng-repeat="col in $columns">{{row[col.field]}}</td>--%>
<%--</tr>--%>
<%--</table>--%>
<%--</div>--%>
<%--</div>--%>

<%--</div>--%>