<span ng-controller="AccountReceivableController as arCtrl">
    <div class="sub-menu">
      <ul class="menuList">
          <li class=""><a class="anime" ng-class="{active: arCtrl.overviewSubModule}" ng-click="arCtrl.openOverviewSubModule()">Overview</a></li>
          <li class=""><a class="anime" ng-class="{active: arCtrl.inquirySubModule}" ng-click="arCtrl.openInquirySubModule()">Inquiry</a></li>
          <li class=""><a class="anime" ng-class="{active: arCtrl.adminSubModule}" ng-click="arCtrl.openAdminSubModule()">Admin</a></li>
          <li class=""><a class="anime" ng-class="{active: arCtrl.processSubModule}" ng-click="arCtrl.openProcessSubModule()">Process</a></li>
          <li class=""><a class="anime" ng-class="{active: arCtrl.paymentsSubModule}" ng-click="arCtrl.openPaymentsSubModule()">Payments</a></li>
          <li class=""><a class="anime" ui-sref="arPayments" ng-class="{active: arCtrl.adjustmentSubModule}" ng-click="arCtrl.openAdjustmentSubModule()">Adjustment</a></li>
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
    <div ng-show="arCtrl.paymentsSubModule" ng-controller="ArPaymentController as arPaymentCtrl">
        <ar-payment-panel></ar-payment-panel>
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