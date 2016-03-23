<span id="arTypesPanel" ng-controller="AccountReceivableTypesController as arTypesCtrl">
  <div class="row">
    <div class="col-xs-12">
      <div class="srch-box">
        <div class="row">
          <div class="col-xs-4">
            <div class="c-form-gp pos-rel">
              <label class="c-form-lbl">Account Receivable Types</label>
              <input <%--typeahead-click-open typeahead-min-length="0" ng-model="" ng-required="true"
                   uib-typeahead="driver as driver.label for driver in getDrivers($viewValue)"
                   typeahead-on-select="onSelectDriver($item)" typeahead-no-results="noDrivers" typeahead-wait-ms=1500--%>
                      class="c-form-inpt custSearch" type="text" class="c-form-inpt" ng-disabled="" placeholder="Search AR Types.."/>
              <%--<span class="ccload loadtca adjCaptLoader" ng-show="drivAdjustCtrl.adjCaptLoader"></span>--%>
              <button class="c-btn c-btn-action cust-add-btn"
                      ng-class=""
                      ng-disabled=""
                      ng-click="arTypesCtrl.openARTypeSlidePanel(1)">Add Account Receivable Types</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<div class="row">
  <div class="col-xs-12">
    <div class="cap-adj-cycle">
      <div class="cap-adj-cyc-head">List of Current Account Receivable Types</div>

      <table ng-table="paymentTypeList" class="table" show-filter="true">
        <tr <%--ng-repeat="payment in paymentTypeCtrl.listPaymentList"--%>>
          <td title="'#'">
            <div class="grid-func" ng-click="arTypesCtrl.openARTypeSlidePanel(2)">View: <i class="fa fa-eye"></i><br></div>
            <div class="grid-func" ng-click="arTypesCtrl.openARTypeSlidePanel(3)">Edit: <i class="fa fa-scissors"></i></div>
          </td>
          <td title="'Account Type Name'">
            {{customer.id}}</td>
          <td title="'Account Type Description'">
            {{customer.firstName}} {{customer.lastName}}</td>
          <td title="'GL Account Id'">
            {{customer.gender}}</td>
          <td title="'Status'">
            {{customer.locationAddress}}</td>
          <td title="'Account Type Code'">
            {{customer.mobileNumber}}</td>

        </tr>
      </table>
    </div>
  </div>
</div>
  <ar-types-slide-panel></ar-types-slide-panel>
</span>

