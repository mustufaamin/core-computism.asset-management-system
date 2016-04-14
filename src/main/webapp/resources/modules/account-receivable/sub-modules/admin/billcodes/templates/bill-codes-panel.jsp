<span ui-view id="billCodesPanel" ng-controller="BillCodesController as billCodesCtrl">
  <div class="row">
    <div class="col-xs-12">
      <div class="srch-box">
        <div class="row">
          <div class="col-xs-4">
            <div class="c-form-gp pos-rel">
              <label class="c-form-lbl">Bill Codes</label>
              <input <%--typeahead-click-open typeahead-min-length="0" ng-model="" ng-required="true"
                   uib-typeahead="driver as driver.label for driver in getDrivers($viewValue)"
                   typeahead-on-select="onSelectDriver($item)" typeahead-no-results="noDrivers" typeahead-wait-ms=1500--%>
                      class="c-form-inpt custSearch" type="text" class="c-form-inpt" ng-disabled="" placeholder="Search AR Types.."/>
              <%--<span class="ccload loadtca adjCaptLoader" ng-show="drivAdjustCtrl.adjCaptLoader"></span>--%>
              <button class="c-btn c-btn-action cust-add-btn"
                      ng-class=""
                      ng-disabled=""
                      ng-click="billCodesCtrl.openBillCodesSlidePanel(1)">Add Bill Codes</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<div class="row">
  <div class="col-xs-12">
    <div class="cap-adj-cycle">
      <div class="cap-adj-cyc-head">List of Current Bill Codes</div>

      <table ng-table="billCodeList" class="table" show-filter="true">
        <tr ng-repeat="billCode in billCodesCtrl.listBillCodes">
          <td title="'#'">
            <div class="grid-func" ng-click="billCodesCtrl.openBillCodesSlidePanel(2, billCode)">View: <i class="fa fa-eye"></i><br></div>
            <div class="grid-func" ng-click="billCodesCtrl.openBillCodesSlidePanel(3, billCode)">Edit: <i class="fa fa-scissors"></i></div>
          </td>
          <td title="'Bill Code Type'">
            {{billCode.billCodeType}}</td>
          <td title="'Bill Code Name'">
            {{billCode.name}}</td>
          <td title="'AddOn Group Id'">
            {{billCode.addOnGroupId}}</td>
          <td title="'Status'">
            {{billCode.status}}</td>
          <td title="'Description'">
            {{billCode.description}}</td>
          <td title="'Activation Date'">
            {{billCode.activationDate}}</td>
          <td title="'Deactivation Date'">
            {{billCode.deactivationDate}}</td>

        </tr>
      </table>
    </div>
  </div>
</div>
  <bill-codes-slide-panel></bill-codes-slide-panel>
</span>

