<div>
  <div class="slideoverlay" ng-show="custCtrl.showPanel">
  </div>
  <div class="slidepanel" ng-show="custCtrl.showPanel">
    <div class="cust-panel-heading">
      <label class="cust-panel-heading-lbl">{{custCtrl.slidePanelHeading}} Form</label>
      <div class="cust-panel-close">
        <i class="fa fa-close close-cur" ng-click="custCtrl.showPanel = false"></i>
      </div>
    </div>
    <div class="cust-panel-content">
      <div class="first-name cust-panel-field-div">
        <label class="cust-panel-lbl">First name:</label>
        <input class="cust-panel-input" placeholder="Enter first name..." ng-class="{disabled: custCtrl.isView}"/>
      </div>
      <div class="last-name cust-panel-field-div">
        <label class="cust-panel-lbl">Last name:</label>
        <input class="cust-panel-input" placeholder="Enter last name..." ng-class="{disabled: custCtrl.isView}"/>
      </div>
      <div class="phone cust-panel-field-div">
        <label class="cust-panel-lbl">Phone number:</label>
        <input class="cust-panel-input" placeholder="Enter phone number..." ng-class="{disabled: custCtrl.isView}"/>
      </div>
      <div class="mobile cust-panel-field-div">
        <label class="cust-panel-lbl">Mobile number:</label>
        <input class="cust-panel-input" placeholder="Enter mobile number..." ng-class="{disabled: custCtrl.isView}"/>
      </div>
      <div class="email cust-panel-field-div">
        <label class="cust-panel-lbl">Email:</label>
        <input class="cust-panel-input" placeholder="Enter email..." ng-class="{disabled: custCtrl.isView}"/>
      </div>
      <div class="loc-address cust-panel-field-div">
        <label class="cust-panel-lbl">Address:</label>
        <input class="cust-panel-input" placeholder="Enter address..." ng-class="{disabled: custCtrl.isView}"/>
      </div>
      <div class="city cust-panel-field-div">
        <label class="cust-panel-lbl">City:</label>
        <input class="cust-panel-input" placeholder="Enter city..." ng-class="{disabled: custCtrl.isView}"/>
      </div>
      <div class="country cust-panel-field-div">
        <label class="cust-panel-lbl">Country:</label>
        <input class="cust-panel-input" placeholder="Enter country..." ng-class="{disabled: custCtrl.isView}"/>
      </div>
    </div>
    <div class="cust-panel-foot">
      <button class="c-btn c-btn-action cust-add-btn"
              ng-class=""
              ng-show="!custCtrl.isView"
              ng-click="">{{custCtrl.slidePanelHeading}}</button>
      <button class="c-btn cust-add-btn"
              ng-class=""
              ng-disabled=""
              ng-click="custCtrl.showPanel = false">Cancel</button>
    </div>
  </div>
</div>