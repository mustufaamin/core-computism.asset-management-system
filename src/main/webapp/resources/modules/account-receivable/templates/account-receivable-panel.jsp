<span ng-controller="AccountReceivableController as arCtrl">
    <div class="sub-menu">
      <ul class="menuList">
          <li class=""><a class="anime" ng-class="{active: arCtrl.adjustmentSubModule}" ng-click="arCtrl.openAdjustmentSubModule()">Adjustment</a></li>
          <li class=""><a class="anime" ng-class="{active: arCtrl.processSubModule}" ng-click="arCtrl.openProcessSubModule()">Process</a></li>
          <li class=""><a class="anime" ng-class="{active: arCtrl.paymentsSubModule}" ng-click="arCtrl.openPaymentsSubModule()">Payments</a></li>
          <li class=""><a class="anime" ng-class="{active: arCtrl.adminSubModule}" ng-click="arCtrl.openAdminSubModule()">Admin</a></li>
          <li class=""><a class="anime" ng-class="{active: arCtrl.inquirySubModule}" ng-click="arCtrl.openInquirySubModule()">Inquiry</a></li>
      </ul>
    </div>
    <div ng-show="arCtrl.adjustmentSubModule">
        <div class="side-menu">
            <ul class="sm-list">
                <li class=""><a class="anime active">Import Adjustments</a></li>
                <li class=""><a class="anime">Adjustment</a></li>
            </ul>
        </div>
    </div>
    <div ng-show="arCtrl.processSubModule">
        <div class="side-menu">
            <ul class="sm-list">
                <li class=""><a class="anime active">Quotation</a></li>
                <li class=""><a class="anime">Account Creation</a></li>
                <li class=""><a class="anime">Posting</a></li>
            </ul>
        </div>
    </div>
    <div ng-show="arCtrl.paymentsSubModule">
        <div class="side-menu">
            <ul class="sm-list">
                <li class=""><a class="anime active">Import Payments</a></li>
                <li class=""><a class="anime">Payments</a></li>
            </ul>
        </div>
    </div>
    <div ng-show="arCtrl.adminSubModule">
        <div class="side-menu">
            <ul class="sm-list">
                <li class=""><a class="anime active">Add-on Charge</a></li>
                <li class=""><a class="anime">Addon Group</a></li>
                <li class=""><a class="anime">Receivable Types</a></li>
                <li class=""><a class="anime">Batches</a></li>
                <li class=""><a class="anime">BillCodes</a></li>
                <li class=""><a class="anime">Payment Types</a></li>
                <li class=""><a class="anime">Properties</a></li>
                <li class=""><a class="anime">StatementProperties</a></li>
            </ul>
        </div>
    </div>
    <div ng-show="arCtrl.inquirySubModule">
        <div class="side-menu">
            <ul class="sm-list">
                <li class=""><a class="anime active">Statements</a></li>
                <li class=""><a class="anime">Transaction</a></li>
                <li class=""><a class="anime">AR Accounts</a></li>
                <li class=""><a class="anime">BillCodes</a></li>
            </ul>
        </div>
    </div>
</span>