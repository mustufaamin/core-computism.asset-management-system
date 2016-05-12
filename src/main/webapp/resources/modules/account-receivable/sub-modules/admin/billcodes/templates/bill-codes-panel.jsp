<span ui-view id="posItemPanel" ng-controller="BillCodesController as billCodesCtrl">
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
                      class="c-form-inpt custSearch" type="text" class="c-form-inpt" ng-disabled="" placeholder="Search Bill Codes.."/>
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

      <div>
        <table ng-table-dynamic="billCodesCtrl.billCodeListTable with billCodesCtrl.cols"
               class="table table-condensed table-bordered table-striped">
          <%--<colgroup>--%>
            <%--<col width="20%" />--%>
            <%--<col width="60%" />--%>
            <%--<col width="10%" />--%>
            <%--<col width="10%" />--%>
          <%--</colgroup>--%>
          <tr ng-repeat="row in $data">
            <td ng-repeat="col in $columns">
              <span>{{row[col.field]}}</span>
            </td>
          </tr>
        </table>
      </div>
    </div>
  </div>
</div>
  <bill-codes-slide-panel></bill-codes-slide-panel>
</span>

