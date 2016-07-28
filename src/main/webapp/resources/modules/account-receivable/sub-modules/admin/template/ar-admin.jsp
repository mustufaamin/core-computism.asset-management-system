<div ng-show="true">
  <div class="sub-menu">
    <ul class="menuList">
      <li class=""><a class="anime" ng-class="{active: arAdminCtrl.overviewSubModule}" ng-click="arAdminCtrl.openOverviewSubModule()">Overview</a></li>
      <li class=""><a class="anime" ng-class="{active: arAdminCtrl.inquirySubModule}" ng-click="arAdminCtrl.openInquirySubModule()">Inquiry</a></li>
      <li class=""><a class="anime" ng-class="{active: arAdminCtrl.adminSubModule}" ng-click="arAdminCtrl.openAdminSubModule()">Admin</a></li>
      <li class=""><a class="anime" ng-class="{active: arAdminCtrl.processSubModule}" ng-click="arAdminCtrl.openProcessSubModule()">Process</a></li>
      <li class=""><a class="anime active" ui-sref="arPayments" ng-click="arAdminCtrl.openPaymentsSubModule()">Payments</a></li>
      <li class=""><a class="anime" ng-class="{active: arAdminCtrl.adjustmentSubModule}" ng-click="arAdminCtrl.openAdjustmentSubModule()">Adjustment</a></li>
    </ul>
  </div>
  <div class="cont-wrap">
    <div ng-show="arAdminCtrl.receivableTypeOpen">
      <ar-receivable-type></ar-receivable-type>
    </div>
    <div ng-show="arAdminCtrl.batchesOpen">
      <ar-batches></ar-batches>
    </div>
    <div ng-show="arAdminCtrl.adminBillCodesOpen">
      <ar-billcode></ar-billcode>
    </div>
    <div ng-show="arAdminCtrl.paymentTypesOpen">
      <ar-payment-type></ar-payment-type>
    </div>
    <div ng-show="arAdminCtrl.addonChargeOpen">
      <ar-add-on-charge></ar-add-on-charge>
    </div>
    <div ng-show="arAdminCtrl.addonGroupOpen">
      <ar-add-on-group></ar-add-on-group>
    </div>
  </div>
</div>
<div class="side-menu">
  <ul class="sm-list">
    <li class=""><a class="anime" ng-click="arAdminCtrl.openAddonChargePanel()" ng-class="{active: arAdminCtrl.addonChargeOpen}">Addon Charge</a></li>
    <li class=""><a class="anime" ng-click="arAdminCtrl.openAddonGroupPanel()" ng-class="{active: arAdminCtrl.addonGroupOpen}">Addon Group</a></li>
    <li class=""><a class="anime" ng-click="arAdminCtrl.openReceivableTypePanel()" ng-class="{active: arAdminCtrl.receivableTypeOpen}">Receivable Types</a></li>
    <li class=""><a class="anime" ng-click="arAdminCtrl.openBatchesPanel()" ng-class="{active: arAdminCtrl.batchesOpen}">Batches</a></li>
    <li class=""><a class="anime" ng-click="arAdminCtrl.openAdminBillCodesPanel()" ng-class="{active: arAdminCtrl.adminBillCodesOpen}">BillCodes</a></li>
    <li class=""><a class="anime" ng-click="arAdminCtrl.openPaymentTypesPanel()" ng-class="{active: arAdminCtrl.paymentTypesOpen}">Payment Types</a></li>
    <li class=""><a class="anime" ng-click="arAdminCtrl.openPropertiesPanel()" ng-class="{active: arAdminCtrl.propertiesOpen}">Properties</a></li>
    <li class=""><a class="anime" ng-click="arAdminCtrl.openStatementPropertiesPanel()" ng-class="{active: arAdminCtrl.statementPropertiesOpen}">Statement Properties</a></li>
  </ul>
</div>