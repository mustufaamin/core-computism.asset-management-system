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
        <label class="cust-panel-lbl">Item Code</label>
        <input class="cust-panel-input" ng-model="posItemCtrl.posItem.itemCode" placeholder="Item Code..." ng-class="{disabled: posItemCtrl.isView}"/>
      </div>
      <div class="at-desc cust-panel-field-div">
        <label class="cust-panel-lbl">Item Unit:</label>
        <input class="cust-panel-input" ng-model="posItemCtrl.posItem.itemUnit" placeholder="Item Unit..." ng-class="{disabled: posItemCtrl.isView}"/>
      </div>
      <div class="acc-id cust-panel-field-div">
        <label class="cust-panel-lbl">Stock Level:</label>
        <input class="cust-panel-input" ng-model="posItemCtrl.posItem.stockLevel" placeholder="Stock Level..." ng-class="{disabled: posItemCtrl.isView}"/>
      </div>
      <div class="priority cust-panel-field-div">
        <label class="cust-panel-lbl"> Minimum Stock Level:</label>
        <input class="cust-panel-input" ng-model="posItemCtrl.posItem.minStockLevel" placeholder="Minimum Stock Level..." ng-class="{disabled: posItemCtrl.isView}"/>
      </div>
      <div class="status cust-panel-field-div">
        <label class="cust-panel-lbl">Cost Price:</label>
        <input class="cust-panel-input" ng-model="posItemCtrl.posItem.costPrice" placeholder="Cost Price..." ng-class="{disabled: posItemCtrl.isView}"/>
      </div>
      <div class="at-code cust-panel-field-div">
        <label class="cust-panel-lbl">Sales Price:</label>
        <input class="cust-panel-input" ng-model="posItemCtrl.posItem.salesPrice" placeholder="Sales Price..." ng-class="{disabled: posItemCtrl.isView}"/>
      </div>
      <div class="company-id cust-panel-field-div">
        <label class="cust-panel-lbl">Location:</label>
        <input class="cust-panel-input" ng-model="posItemCtrl.posItem.location" placeholder="Location..." ng-class="{disabled: posItemCtrl.isView}"/>
      </div>
      <div class="priority cust-panel-field-div">
        <label class="cust-panel-lbl">Description:</label>
        <input class="cust-panel-input" ng-model="posItemCtrl.posItem.itemDescription" placeholder="Description..." ng-class="{disabled: posItemCtrl.isView}"/>
      </div>
      <div class="priority cust-panel-field-div">
        <label class="cust-panel-lbl">Supplier:</label>
        <input class="cust-panel-input" ng-model="posItemCtrl.posItem.supplerId" placeholder="Supplier..." ng-class="{disabled: posItemCtrl.isView}"/>
      </div>
      <div class="priority cust-panel-field-div">
      <label class="cust-panel-lbl">Item Type:</label>
      <input class="cust-panel-input" ng-model="posItemCtrl.posItem.itemType" placeholder="Item Type:..." ng-class="{disabled: posItemCtrl.isView}"/>
     </div>
      <div class="priority cust-panel-field-div">
        <label class="cust-panel-lbl">Item Group:</label>
        <input class="cust-panel-input" ng-model="posItemCtrl.posItem.posItemGroupId" placeholder="Item Group:..." ng-class="{disabled: posItemCtrl.isView}"/>
      </div>
      <div class="priority cust-panel-field-div">
        <label class="cust-panel-lbl">Quantity:</label>
        <input class="cust-panel-input" ng-model="posItemCtrl.posItem.quantity" placeholder="Quantity..." ng-class="{disabled: posItemCtrl.isView}"/>
      </div>
    </div>
    <div class="cust-panel-foot">
      <button class="c-btn c-btn-action cust-add-btn"
              ng-class=""
              ng-show="!posItemCtrl.isView"
              ng-click="posItemCtrl.addPosItem()">{{posItemCtrl.slidePanelHeading}}</button>
      <button class="c-btn cust-add-btn"
              ng-class=""
              ng-disabled=""
              ng-click="posItemCtrl.showPanel = false">Cancel</button>
    </div>
  </div>
</div>