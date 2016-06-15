<div ng-show="true">
  <div class="sub-menu">
    <ul class="menuList">
      <li class=""><a class="anime active" ui-sref="arOverview" ng-class="{active: arCtrl.overviewSubModule}" ng-click="arCtrl.openOverviewSubModule()">Overview</a></li>
      <li class=""><a class="anime" ng-class="{active: arCtrl.inquirySubModule}" ng-click="arCtrl.openInquirySubModule()">Inquiry</a></li>
      <li class=""><a class="anime" ng-class="{active: arCtrl.adminSubModule}" ng-click="arCtrl.openAdminSubModule()">Admin</a></li>
      <li class=""><a class="anime" ng-class="{active: arCtrl.processSubModule}" ng-click="arCtrl.openProcessSubModule()">Process</a></li>
      <li class=""><a class="anime" ui-sref="arPayments" ng-click="arCtrl.openPaymentsSubModule()">Payments</a></li>
      <li class=""><a class="anime" ng-class="{active: arCtrl.adjustmentSubModule}" ng-click="arCtrl.openAdjustmentSubModule()">Adjustment</a></li>
    </ul>
  </div>
  <div class="cont-wrap">
  </div>
</div>
<div class="side-menu">
  <ul class="sm-list">
    <li class=""><a class="anime" ng-click="arPaymentCtrl.openImportPaymentsPanel()" ng-class="{active: arPaymentCtrl.importPaymentOpen}">Import Payments</a></li>
    <li class=""><a class="anime" ng-click="arPaymentCtrl.openPaymentsPanel()" ng-class="{active: arPaymentCtrl.paymentOpen}">Payments</a></li>
  </ul>
</div>