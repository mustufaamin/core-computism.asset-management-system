<span ui-view id="paymentTypePanel" ng-controller="PaymentTypeController as paymentTypeCtrl">
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
              <button class="c-btn c-btn-action cust-add-btn open-payment-btn"
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
        <tr ng-repeat="payment in paymentTypeCtrl.listPaymentTypes">
          <td title="'#'">
            <div class="grid-func" ng-click="paymentTypeCtrl.openPaymentTypeSlidePanel(2)">View: <i class="fa fa-eye"></i><br></div>
            <div class="grid-func" ng-click="paymentTypeCtrl.openPaymentTypeSlidePanel(3)">Edit: <i class="fa fa-scissors"></i></div>
          </td>
          <td title="'Id'">
            {{payment.paymentTypeId}}</td>
          <td title="'Payment Type Name'">
            {{payment.paymentTypeName}}</td>
          <td title="'Company Id'">
            {{payment.companyId}}</td>
          <td title="'Payment Type Desc'">
            {{payment.paymentTypeDesc}}</td>
          <td title="'GL Account Id'">
            {{payment.glAccountId}}</td>
          <td title="'Major Account #'">
            {{payment.majorAccountNumber}}</td>

        </tr>
      </table>
    </div>
  </div>
</div>
  <payment-type-slide-panel></payment-type-slide-panel>
</span>

