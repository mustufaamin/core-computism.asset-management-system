<div class="sub-item-panel">
  <div class="slideoverlay" ng-show="arAdminCtrl.showAddOnPanel">
  </div>
  <div class="slidepanel" ng-show="arAdminCtrl.showAddOnPanel">
    <div class="panel-heading">
      <label class="panel-heading-lbl">{{arAdminCtrl.slidePanelHeading}} Form</label>
      <div class="panel-close">
        <i class="fa fa-close close-cur" ng-click="arAdminCtrl.showAddOnPanel = false"></i>
      </div>
    </div>
    <div class="cust-panel-content">
      <div class="first-name cust-panel-field-div">
        <label class="panel-lbl">First name:</label>
        <input class="panel-input" ng-model="custCtrl.firstName" placeholder="Enter first name..." ng-class="{disabled: arAdminCtrl.isView}"/>
      </div>
      <div class="last-name cust-panel-field-div">
        <label class="panel-lbl">Last name:</label>
        <input class="panel-input" ng-model="custCtrl.lastName" placeholder="Enter last name..." ng-class="{disabled: arAdminCtrl.isView}"/>
      </div>
      <div class="phone cust-panel-field-div">
        <label class="panel-lbl">Phone number:</label>
        <input class="panel-input" ng-model="custCtrl.phone" placeholder="Enter phone number..." ng-class="{disabled: arAdminCtrl.isView}"/>
      </div>
      <div class="mobile cust-panel-field-div">
        <label class="panel-lbl">Mobile number:</label>
        <input class="panel-input" ng-model="custCtrl.mobile" placeholder="Enter mobile number..." ng-class="{disabled: arAdminCtrl.isView}"/>
      </div>
      <div class="email cust-panel-field-div">
        <label class="panel-lbl">Email:</label>
        <input class="panel-input" ng-model="custCtrl.email" placeholder="Enter email..." ng-class="{disabled: arAdminCtrl.isView}"/>
      </div>
      <div class="loc-address cust-panel-field-div">
        <label class="panel-lbl">Address:</label>
        <input class="panel-input" ng-model="custCtrl.address" placeholder="Enter address..." ng-class="{disabled: arAdminCtrl.isView}"/>
      </div>
      <div class="country cust-panel-field-div">
        <label class="panel-lbl">Country:</label>
        <input class="panel-input" ng-model="custCtrl.address" placeholder="Enter address..." ng-class="{disabled: arAdminCtrl.isView}"/>
      </div>
      <div class="city cust-panel-field-div">
        <label class="panel-lbl">City:</label>
        <input class="panel-input" ng-model="custCtrl.address" placeholder="Enter address..." ng-class="{disabled: arAdminCtrl.isView}"/>
      </div>
    </div>
    <div class="panel-foot">
      <button class="c-btn c-btn-action panel-button"
              ng-class=""
              ng-show="!arAdminCtrl.isView"
              ng-click="arAdminCtrl.addUpdateAddOn()">{{arAdminCtrl.slidePanelHeading}}</button>
      <button class="c-btn c-btn-normal panel-button"
              ng-class=""
              ng-disabled=""
              ng-click="arAdminCtrl.showAddOnPanel = false">Cancel</button>
    </div>
  </div>
</div>
