<span id="paymentTypePanel" ng-controller="PaymentTypeController as paymentTypeCtrl">
  <div class="row">
    <div class="col-xs-12">
      <div class="srch-box">
        <div class="row">
          <div class="col-xs-4">
            <div class="c-form-gp pos-rel">
              <label class="c-form-lbl">Payment Types</label>
              <input <%--typeahead-click-open typeahead-min-length="0" ng-model="" ng-required="true"
                   uib-typeahead="driver as driver.label for driver in getDrivers($viewValue)"
                   typeahead-on-select="onSelectDriver($item)" typeahead-no-results="noDrivers" typeahead-wait-ms=1500--%>
                      class="c-form-inpt custSearch" type="text" class="c-form-inpt" ng-disabled="" placeholder="Search Payment Types.."/>
              <%--<span class="ccload loadtca adjCaptLoader" ng-show="drivAdjustCtrl.adjCaptLoader"></span>--%>
              <button class="c-btn c-btn-action cust-add-btn"
                      ng-class=""
                      ng-disabled=""
                      ng-click="paymentTypeCtrl.openPaymentTypeSlidePanel(1)">Add Payment Types</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<div class="row">
  <div class="col-xs-12">
    <div class="cap-adj-cycle">
      <div class="cap-adj-cyc-head">List of Current Payment Types</div>

      <table ng-table="paymentTypeList" class="table" show-filter="true">
        <tr <%--ng-repeat="payment in paymentTypeCtrl.listPaymentList"--%>>
          <td title="'#'">
            <div class="grid-func" ng-click="paymentTypeCtrl.openPaymentTypeSlidePanel(2)">View: <i class="fa fa-eye"></i><br></div>
            <div class="grid-func" ng-click="paymentTypeCtrl.openPaymentTypeSlidePanel(3)">Edit: <i class="fa fa-scissors"></i></div>
          </td>
          <td title="'Name'">
            {{customer.id}}</td>
          <td title="'Payment Type Description'">
            {{customer.firstName}} {{customer.lastName}}</td>
          <td title="'Payment Type Options'">
            {{customer.gender}}</td>
          <td title="'GL Account'">
            {{customer.locationAddress}}</td>
          <td title="'Status #'">
            {{customer.mobileNumber}}</td>
          <td title="'Display Priority #'">
            {{customer.mobileNumber}}</td>
          <td title="'Description #'">
            {{customer.mobileNumber}}</td>

        </tr>
      </table>
    </div>
  </div>
</div>
</span>

