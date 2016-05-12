<div>
  <div class="slideoverlay" ng-show="posItemCtrl.showPanel">
  </div>
  <div class="slidepanel" ng-show="posItemCtrl.showPanel">
    <div class="cust-panel-heading">
      <label class="cust-panel-heading-lbl">{{posItemCtrl.slidePanelHeading}} Form</label>
      <div class="cust-panel-close">
        <i class="fa fa-close close-cur" ng-click="posItemCtrl.showPanel = false"></i>
      </div>
    </div>
    <div class="ar-panel-content">
      <div class="at-name cust-panel-field-div">
        <label class="cust-panel-lbl">Bill Code Type:</label>
        <input class="cust-panel-input" ng-model="posItemCtrl.billCodeType" placeholder="Enter Bill Code Type..." ng-class="{disabled: posItemCtrl.isView}"/>
      </div>
      <div class="at-desc cust-panel-field-div">
        <label class="cust-panel-lbl">AddOn Group Id:</label>
        <input class="cust-panel-input" ng-model="posItemCtrl.addOnGroupId" placeholder="Enter addon group Id..." ng-class="{disabled: posItemCtrl.isView}"/>
      </div>
      <div class="acc-id cust-panel-field-div">
        <label class="cust-panel-lbl">Bill Code Name:</label>
        <input class="cust-panel-input" ng-model="posItemCtrl.name" placeholder="Enter name..." ng-class="{disabled: posItemCtrl.isView}"/>
      </div>
      <div class="priority cust-panel-field-div">
        <label class="cust-panel-lbl"> GL Account:</label>
        <input class="cust-panel-input" ng-model="posItemCtrl.glAccount" placeholder="Enter gl account..." ng-class="{disabled: posItemCtrl.isView}"/>
      </div>
      <div class="status cust-panel-field-div">
        <label class="cust-panel-lbl">Status:</label>
        <input class="cust-panel-input" ng-model="posItemCtrl.status" placeholder="Enter status..." ng-class="{disabled: posItemCtrl.isView}"/>
      </div>
      <div class="at-code cust-panel-field-div">
        <label class="cust-panel-lbl">Description:</label>
        <input class="cust-panel-input" ng-model="posItemCtrl.description" placeholder="Enter description..." ng-class="{disabled: posItemCtrl.isView}"/>
      </div>
      <div class="company-id cust-panel-field-div">
        <label class="cust-panel-lbl">Activation Date:</label>
        <input class="cust-panel-input" ng-model="posItemCtrl.activationDate" placeholder="Enter activation date..." ng-class="{disabled: posItemCtrl.isView}"/>
      </div>
      <div class="priority cust-panel-field-div">
        <label class="cust-panel-lbl">Deactivation Date:</label>
        <input class="cust-panel-input" ng-model="posItemCtrl.deactivationDate" placeholder="Enter deactivation date..." ng-class="{disabled: posItemCtrl.isView}"/>
      </div>
    </div>
    <div class="cust-panel-foot">
      <button class="c-btn c-btn-action cust-add-btn"
              ng-class=""
              ng-show="!posItemCtrl.isView"
              ng-click="posItemCtrl.addBillCode()">{{posItemCtrl.slidePanelHeading}}</button>
      <button class="c-btn cust-add-btn"
              ng-class=""
              ng-disabled=""
              ng-click="posItemCtrl.showPanel = false">Cancel</button>
    </div>
  </div>
</div>