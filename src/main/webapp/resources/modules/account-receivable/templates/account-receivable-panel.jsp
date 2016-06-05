<span ng-controller="AccountReceivableController as arCtrl">
    <div class="sub-menu">
      <ul class="menuList">
          <li class=""><a class="anime" ng-class="{active: arCtrl.overviewSubModule}" ng-click="arCtrl.openOverviewSubModule()">Overview</a></li>
          <li class=""><a class="anime" ng-class="{active: arCtrl.inquirySubModule}" ng-click="arCtrl.openInquirySubModule()">Inquiry</a></li>
          <li class=""><a class="anime" ng-class="{active: arCtrl.adminSubModule}" ng-click="arCtrl.openAdminSubModule()">Admin</a></li>
          <li class=""><a class="anime" ng-class="{active: arCtrl.processSubModule}" ng-click="arCtrl.openProcessSubModule()">Process</a></li>
          <li class=""><a class="anime" ng-class="{active: arCtrl.paymentsSubModule}" ng-click="arCtrl.openPaymentsSubModule()">Payments</a></li>
          <li class=""><a class="anime" ng-class="{active: arCtrl.adjustmentSubModule}" ng-click="arCtrl.openAdjustmentSubModule()">Adjustment</a></li>
      </ul>
    </div>
    <div ng-show="arCtrl.adjustmentSubModule">
        <div class="side-menu">
            <ul class="sm-list">
                <li class=""><a class="anime" ng-click="arCtrl.openImportAdjustmentPanel()" ng-class="{active: arCtrl.importAdjustmentPanelOpen}">Import Adjustments</a></li>
                <li class=""><a class="anime" ng-click="arCtrl.openArAdjustmentPanel()" ng-class="{active: arCtrl.artAdjustmentPanelOpen}">Adjustment</a></li>
            </ul>
        </div>
    </div>
    <div ng-show="arCtrl.processSubModule">
        <div class="side-menu">
            <ul class="sm-list">
                <li class=""><a class="anime" ng-click="arCtrl.openArQuotationPanel()" ng-class="{active: arCtrl.arQuotationOpen}">Quotation</a></li>
                <li class=""><a class="anime" ng-click="arCtrl.openAccountCreationPanel()" ng-class="{active: arCtrl.accountCreationOpen}">Account Creation</a></li>
                <li class=""><a class="anime" ng-click="arCtrl.openPostingPanel()" ng-class="{active: arCtrl.postingOpen}">Posting</a></li>
            </ul>
        </div>
    </div>
    <div ng-show="arCtrl.paymentsSubModule">
        <div ng-show="arCtrl.paymentOpen">
            <div class="cont-wrap">
                <div class="search-bar-panel">
                    <div class="search-bar-wrapper">
                        <span class="search-lbl-wrap">
                          <label class="search-lbl">Payments</label>
                        </span>
                        <span class="search-inpt-wrap">
                          <input type="text" class="search-inpt anime" placeholder="Search Payments">
                        </span>
                    </div>
                    <div class="add-btn-wrap">
                        <a class="mainModulebtn add-btn" ng-click=""><span>Add Payments</span></a>
                    </div>
                </div>
                <div class="tbl-dynamic-div">
                    <span class="tbl-dynamic-head"><h3 class="list-head">Current Payments</h3></span>
                    <table ng-table-dynamic="arCtrl.paymentItemTable with arCtrl.paymentCols"  class="table table-condensed table-bordered table-striped">
                        <tr ng-repeat="row in $data">
                            <td ng-repeat="col in $columns">
                                <span ng-if="col.dataType !== 'command'">{{row[col.field]}}</span>
                                <div ng-if="col.dataType === 'command'">
                                    <span class="tbl-dynamic-cmnd-btn anime"><i class="fa fa-pencil" aria-hidden="true"></i></span>
                                    <span class="tbl-dynamic-cmnd-btn anime"><i class="fa fa-trash" aria-hidden="true"></i></span>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <div class="side-menu">
            <ul class="sm-list">
                <li class=""><a class="anime" ng-click="arCtrl.openImportPaymentsPanel()" ng-class="{active: arCtrl.importPaymentOpen}">Import Payments</a></li>
                <li class=""><a class="anime" ng-click="arCtrl.openPaymentsPanel()" ng-class="{active: arCtrl.paymentOpen}">Payments</a></li>
            </ul>
        </div>
    </div>
    <div ng-show="arCtrl.adminSubModule">
        <div class="side-menu">
            <ul class="sm-list">
                <li class=""><a class="anime" ng-click="arCtrl.openAddonChargePanel()" ng-class="{active: arCtrl.addonChargeOpen}">Add-on Charge</a></li>
                <li class=""><a class="anime" ng-click="arCtrl.openAddonGroupPanel()" ng-class="{active: arCtrl.addonGroupOpen}">Addon Group</a></li>
                <li class=""><a class="anime" ng-click="arCtrl.openRecievableTypesPanel()" ng-class="{active: arCtrl.receivableTypeOpen}">Receivable Types</a></li>
                <li class=""><a class="anime" ng-click="arCtrl.openBatchesPanel()" ng-class="{active: arCtrl.batchesOpen}">Batches</a></li>
                <li class=""><a class="anime" ng-click="arCtrl.openAdminBillCodesPanel()" ng-class="{active: arCtrl.adminBillCodesOpen}">BillCodes</a></li>
                <li class=""><a class="anime" ng-click="arCtrl.openPaymentTypesPanel()" ng-class="{active: arCtrl.paymentTypesOpen}">Payment Types</a></li>
                <li class=""><a class="anime" ng-click="arCtrl.openPropertiesPanel()" ng-class="{active: arCtrl.propertiesOpen}">Properties</a></li>
                <li class=""><a class="anime" ng-click="arCtrl.openStatementPropertiesPanel()" ng-class="{active: arCtrl.statementPropertiesOpen}">Statement Properties</a></li>
            </ul>
        </div>
    </div>
    <div ng-show="arCtrl.inquirySubModule">
        <div class="side-menu">
            <ul class="sm-list">
                <li class=""><a class="anime" ng-click="arCtrl.openStatementPanel()" ng-class="{active: arCtrl.statementOpen}">Statements</a></li>
                <li class=""><a class="anime" ng-click="arCtrl.openTransactionPanel()" ng-class="{active: arCtrl.transactionOpen}">Transaction</a></li>
                <li class=""><a class="anime" ng-click="arCtrl.openArAccountPanel()" ng-class="{active: arCtrl.arAccountOpen}">AR Accounts</a></li>
                <li class=""><a class="anime" ng-click="arCtrl.openInquiryBillCodesPanel()" ng-class="{active: arCtrl.inquiryBillCodePanel}">BillCodes</a></li>
            </ul>
        </div>
    </div>
</span>