<div>
  <div class="slideoverlay" ng-show="glAccountTypeCtrl.showPanel">
  </div>
  <div class="slidepanel" ng-show="glAccountTypeCtrl.showPanel">
    <div class="cust-panel-heading">
      <label class="cust-panel-heading-lbl">{{glAccountTypeCtrl.slidePanelHeading}} Form</label>
      <div class="cust-panel-close">
        <i class="fa fa-close close-cur" ng-click="glAccountTypeCtrl.showPanel = false"></i>
      </div>
    </div>
    <div class="ar-panel-content">
      <div class="at-name cust-panel-field-div">
        <label class="cust-panel-lbl">Name:</label>
        <input class="cust-panel-input" ng-model="glAccountTypeCtrl.name" placeholder="Enter GL Account Type Name..." ng-class="{disabled: glAccountTypeCtrl.isView}"/>
      </div>
      <div class="at-desc cust-panel-field-div">
        <label class="cust-panel-lbl">Description:</label>
        <input class="cust-panel-input" ng-model="glAccountTypeCtrl.description" placeholder="Enter description..." ng-class="{disabled: glAccountTypeCtrl.isView}"/>
      </div>
      <div class="acc-id cust-panel-field-div">
        <label class="cust-panel-lbl">Normal Balance Flag:</label>
        <input type="checkbox" ng-model="glAccountTypeCtrl.normalBalanceFlag" ng-class="{disabled: glAccountTypeCtrl.isView}"/>
      </div>
    </div>
    <div class="cust-panel-foot">
      <button class="c-btn c-btn-action cust-add-btn"
              ng-class=""
              ng-show="!glAccountTypeCtrl.isView"
              ng-click="glAccountTypeCtrl.addGlAccountType()">{{glAccountTypeCtrl.slidePanelHeading}}</button>
      <button class="c-btn cust-add-btn"
              ng-class=""
              ng-disabled=""
              ng-click="glAccountTypeCtrl.showPanel = false">Cancel</button>
    </div>
  </div>
</div>