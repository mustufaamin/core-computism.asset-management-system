<div ng-show="arPaymentCtrl.paymentOpen">
  <div class="sub-menu">
    <ul class="menuList">
      <li class=""><a class="anime" ng-class="{active: arCtrl.overviewSubModule}" ng-click="arCtrl.openOverviewSubModule()">Overview</a></li>
      <li class=""><a class="anime" ng-class="{active: arCtrl.inquirySubModule}" ng-click="arCtrl.openInquirySubModule()">Inquiry</a></li>
      <li class=""><a class="anime" ng-class="{active: arCtrl.adminSubModule}" ng-click="arCtrl.openAdminSubModule()">Admin</a></li>
      <li class=""><a class="anime" ng-class="{active: arCtrl.processSubModule}" ng-click="arCtrl.openProcessSubModule()">Process</a></li>
      <li class=""><a class="anime active" ui-sref="arPayments" ng-click="arCtrl.openPaymentsSubModule()">Payments</a></li>
      <li class=""><a class="anime" ng-class="{active: arCtrl.adjustmentSubModule}" ng-click="arCtrl.openAdjustmentSubModule()">Adjustment</a></li>
    </ul>
  </div>
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
      <table ng-table-dynamic="arPaymentCtrl.paymentItemTable with arPaymentCtrl.paymentCols"  class="table table-condensed table-bordered table-striped">
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
    <li class=""><a class="anime" ng-click="arPaymentCtrl.openImportPaymentsPanel()" ng-class="{active: arPaymentCtrl.importPaymentOpen}">Import Payments</a></li>
    <li class=""><a class="anime" ng-click="arPaymentCtrl.openPaymentsPanel()" ng-class="{active: arPaymentCtrl.paymentOpen}">Payments</a></li>
  </ul>
</div>