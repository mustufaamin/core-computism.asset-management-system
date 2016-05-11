<div class="col-xs-12" ng-cloak="" class="md-inline-form inputdemoBasicUsage" id="arTransactionPanel"
     ng-controller="ArTransactionListController as transactionCtrl">
    <table style="width: 100%">
        <tr>
            <td>
                Ar Transactions
            </td>
        </tr>
    </table>
    <div id="posdemoparent"
         ng-style="{'overflow': (parentScrollable && 'scroll'), 'position': (parentRelative && 'relative')}"
         style="border: 1px solid #ccc; padding: 15px;">
        <table style="width: 100%">
            <tr>
                <td>
                    <div>
                        <div>

                            <table ng-table-dynamic="transactionCtrl.itemTable with transactionCtrl.cols"
                                   class="table table-condensed table-bordered table-striped" style="width: 100%;">
                                <tr>
                                    <td>
                                        <colgroup>
                                            <col width="12%"/>
                                            <col width="15%"/>
                                            <col width="20%"/>
                                            <col width="15%"/>
                                            <col width="10%"/>
                                            <col width="13%"/>
                                        </colgroup>
                                    </td>
                                </tr>
                                <tr ng-repeat="row in $data" show-filter="true">
                                    <td ng-repeat="col in $columns">
                                        <span ng-if="col.dataType !== 'command'">{{row[col.field]}}</span>

                                        <div ng-if="col.dataType === 'command'">
                                            <button class="btn btn-danger btn-sm"
                                                    ng-click="transactionCtrl.deleteItem(row)"><span
                                                    class="glyphicon glyphicon-trash"></span></button>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <md-content layout-gt-sm="row" layout-padding="">
                        <md-input-container>
                            <label>Total Amount</label>
                            <input ng-model="transactionCtrl.totalAmount">
                        </md-input-container>
                    </md-content>
                </td>
            </tr>
        </table>
    </div>
</div>

