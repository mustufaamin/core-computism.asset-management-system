<div>
  <div class="slideoverlay" ng-show="paymentTypeCtrl.showPanel">
  </div>
  <div class="slidepanel" ng-show="paymentTypeCtrl.showPanel">
    <div class="cust-panel-heading">
      <label class="cust-panel-heading-lbl">{{paymentTypeCtrl.slidePanelHeading}} Form</label>
      <div class="cust-panel-close">
        <i class="fa fa-close close-cur" ng-click="paymentTypeCtrl.showPanel = false"></i>
      </div>
    </div>
    <div class="cust-panel-content">
      <div class="pt-name cust-panel-field-div">
        <label class="cust-panel-lbl">Payment Type Name:</label>
        <input class="cust-panel-input" placeholder="Enter payment type name..." ng-class="{disabled: paymentTypeCtrl.isView}"/>
      </div>
      <div class="pt-desc cust-panel-field-div">
        <label class="cust-panel-lbl">Payment Type Description:</label>
        <input class="cust-panel-input" placeholder="Enter payment type description..." ng-class="{disabled: paymentTypeCtrl.isView}"/>
      </div>
      <div class="acc-id cust-panel-field-div">
        <label class="cust-panel-lbl">GL Account Id:</label>
        <input class="cust-panel-input" placeholder="Enter GL A/C Id..." ng-class="{disabled: paymentTypeCtrl.isView}"/>
      </div>
      <div class="status cust-panel-field-div">
        <label class="cust-panel-lbl">Status:</label>
        <input class="cust-panel-input" placeholder="Enter status..." ng-class="{disabled: paymentTypeCtrl.isView}"/>
      </div>
      <div class="module-id cust-panel-field-div">
        <label class="cust-panel-lbl">Module Id:</label>
        <input class="cust-panel-input" placeholder="Enter module Id..." ng-class="{disabled: paymentTypeCtrl.isView}"/>
      </div>
      <div class="company-id cust-panel-field-div">
        <label class="cust-panel-lbl">Company Id:</label>
        <input class="cust-panel-input" placeholder="Enter company Id..." ng-class="{disabled: paymentTypeCtrl.isView}"/>
      </div>
      <div class="addon cust-panel-field-div">
        <label class="cust-panel-lbl">AddOn Group Id:</label>
        <input class="cust-panel-input" placeholder="Enter addon group Id..." ng-class="{disabled: paymentTypeCtrl.isView}"/>
      </div>
      <div class="display-priority cust-panel-field-div">
        <label class="cust-panel-lbl">Display Priority:</label>
        <input class="cust-panel-input" placeholder="Enter display priority ..." ng-class="{disabled: paymentTypeCtrl.isView}"/>
      </div>
      <div class="description cust-panel-field-div">
        <label class="cust-panel-lbl">Description:</label>
        <input class="cust-panel-input" placeholder="Enter description..." ng-class="{disabled: paymentTypeCtrl.isView}"/>
      </div>
    </div>
    <div class="cust-panel-foot">
      <button class="c-btn c-btn-action cust-add-btn"
              ng-class=""
              ng-show="!paymentTypeCtrl.isView"
              ng-click="">{{paymentTypeCtrl.slidePanelHeading}}</button>
      <button class="c-btn cust-add-btn"
              ng-class=""
              ng-disabled=""
              ng-click="paymentTypeCtrl.showPanel = false">Cancel</button>
    </div>
  </div>
</div>