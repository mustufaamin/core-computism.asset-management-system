<div>
  <div class="slideoverlay" ng-show="arTypesCtrl.showPanel">
  </div>
  <div class="slidepanel" ng-show="arTypesCtrl.showPanel">
    <div class="cust-panel-heading">
      <label class="cust-panel-heading-lbl">{{arTypesCtrl.slidePanelHeading}} Form</label>
      <div class="cust-panel-close">
        <i class="fa fa-close close-cur" ng-click="arTypesCtrl.showPanel = false"></i>
      </div>
    </div>
    <div class="ar-panel-content">
      <div class="at-name cust-panel-field-div">
        <label class="cust-panel-lbl">Account Type Name:</label>
        <input class="cust-panel-input" placeholder="Enter Account Type name..." ng-class="{disabled: arTypesCtrl.isView}"/>
      </div>
      <div class="at-desc cust-panel-field-div">
        <label class="cust-panel-lbl">Account Type Description:</label>
        <input class="cust-panel-input" placeholder="Enter Account Type description..." ng-class="{disabled: arTypesCtrl.isView}"/>
      </div>
      <div class="acc-id cust-panel-field-div">
        <label class="cust-panel-lbl">GL Account Id:</label>
        <input class="cust-panel-input" placeholder="Enter GL A/C Id..." ng-class="{disabled: arTypesCtrl.isView}"/>
      </div>
      <div class="status cust-panel-field-div">
        <label class="cust-panel-lbl">Status:</label>
        <input class="cust-panel-input" placeholder="Enter status..." ng-class="{disabled: arTypesCtrl.isView}"/>
      </div>
      <div class="at-code cust-panel-field-div">
        <label class="cust-panel-lbl">Account Type Code:</label>
        <input class="cust-panel-input" placeholder="Enter account type code..." ng-class="{disabled: arTypesCtrl.isView}"/>
      </div>
      <div class="company-id cust-panel-field-div">
        <label class="cust-panel-lbl">Company Id:</label>
        <input class="cust-panel-input" placeholder="Enter company Id..." ng-class="{disabled: arTypesCtrl.isView}"/>
      </div>
      <div class="priority cust-panel-field-div">
        <label class="cust-panel-lbl">Priority:</label>
        <input class="cust-panel-input" placeholder="Enter priority..." ng-class="{disabled: arTypesCtrl.isView}"/>
      </div>
      <div class="over30Message cust-panel-field-div">
        <label class="cust-panel-lbl">Over 30 Message:</label>
        <input class="cust-panel-input" placeholder="Enter message..." ng-class="{disabled: arTypesCtrl.isView}"/>
      </div>
      <div class="over60Message cust-panel-field-div">
        <label class="cust-panel-lbl">Over 60 Message:</label>
        <input class="cust-panel-input" placeholder="Enter message ..." ng-class="{disabled: arTypesCtrl.isView}"/>
      </div>
      <div class="over90Message cust-panel-field-div">
        <label class="cust-panel-lbl">Over 90 Message:</label>
        <input class="cust-panel-input" placeholder="Enter message..." ng-class="{disabled: arTypesCtrl.isView}"/>
      </div>
      <div class="over120Message cust-panel-field-div">
        <label class="cust-panel-lbl">Over 120 Message:</label>
        <input class="cust-panel-input" placeholder="Enter message..." ng-class="{disabled: arTypesCtrl.isView}"/>
      </div>
      <div class="leftOverAmount cust-panel-field-div">
        <label class="cust-panel-lbl">Leftover Amount:</label>
        <input type="checkbox" ng-class="{disabled: arTypesCtrl.isView}"/>
      </div>
      <div class="requiredStatus cust-panel-field-div">
        <label class="cust-panel-lbl">Required Status:</label>
        <input type="checkbox" ng-class="{disabled: arTypesCtrl.isView}"/>
      </div>
    </div>
    <div class="cust-panel-foot">
      <button class="c-btn c-btn-action cust-add-btn"
              ng-class=""
              ng-show="!arTypesCtrl.isView"
              ng-click="">{{arTypesCtrl.slidePanelHeading}}</button>
      <button class="c-btn cust-add-btn"
              ng-class=""
              ng-disabled=""
              ng-click="arTypesCtrl.showPanel = false">Cancel</button>
    </div>
  </div>
</div>