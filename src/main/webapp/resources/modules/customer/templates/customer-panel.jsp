<span id="customerPanel" ng-controller="CustomerController as customerCtrl">
<div class="row">
  <div class="col-xs-12">
    <div class="srch-box">
      <div class="row">
        <div class="col-xs-4">
          <div class="c-form-gp pos-rel">
            <label class="c-form-lbl">Customer</label>
            <input <%--typeahead-click-open typeahead-min-length="0" ng-model="" ng-required="true"
                   uib-typeahead="driver as driver.label for driver in getDrivers($viewValue)"
                   typeahead-on-select="onSelectDriver($item)" typeahead-no-results="noDrivers" typeahead-wait-ms=1500--%>
                    class="c-form-inpt custSearch" type="text" class="c-form-inpt" ng-disabled="" placeholder="Search customer.."/>
            <%--<span class="ccload loadtca adjCaptLoader" ng-show="drivAdjustCtrl.adjCaptLoader"></span>--%>
            <button class="c-btn c-btn-action cust-add-btn"
                    ng-class=""
                    ng-disabled=""
                    ng-click="">Add Customer</button>

            <%--<div class="col-xs-3 pull-right">
              <div class="c-form-gp btn-add-adjst">
                <button class="c-btn c-btn-action"
                        ng-class=""
                        ng-disabled=""
                        ng-click="">Add Customer</button>
              </div>
            </div>--%>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<div class="row">
  <div class="col-xs-12">
    <div class="cap-adj-cycle">
      <div class="cap-adj-cyc-head">List of Current Customers</div>

      <%--<div class="row cap-adj-cyc-th">
        <div class="col-xs-2"><div class="c-th-label"></div></div>
        <div class="col-xs-2"><div class="c-th-label">ID</div></div>
        <div class="col-xs-2"><div class="c-th-label">Name</div></div>
        <div class="col-xs-2"><div class="c-th-label">Gender</div></div>
        <div class="col-xs-2"><div class="c-th-label">Address</div></div>
        <div class="col-xs-2"><div class="c-th-label">Contact#</div></div>
      </div>

      <span class="">
          &lt;%&ndash;<span ng-show="drivAdjustCtrl.listAdjLoader" class="" style="">
            <div class="areaOverlay"></div>
            <div class="areaLoader listAdjLoader"></div>
          </span>&ndash;%&gt;

        <div class="cust-list">
          <div class="col-xs-2 cust-fld-width"><i class="fa fa-eye"></i><i class="fa fa-scissors"></i></div>
          <div class="col-xs-2 cust-fld-width"><div class="c-th-label">ID</div></div>
          <div class="col-xs-2 cust-fld-width"><div class="c-th-label">Name</div></div>
          <div class="col-xs-2 cust-fld-width"><div class="c-th-label">Gender</div></div>
          <div class="col-xs-2 cust-fld-width"><div class="c-th-label">Address</div></div>
          <div class="col-xs-2 cust-fld-width"><div class="c-th-label">Contact#</div></div>
        </div>


        <div class="empt-grid" ng-show="">No Records Found.</div>
        &lt;%&ndash;<div class="cap-adj-cyc-content">
          <div class="row adjust-rw">
            <div class="col-xs-2">Umer</div>
            <div class="col-xs-2">Pakistan</div>
            <div class="col-xs-2">03245</div>
            <div class="col-xs-2">hello</div>
            <div class="col-xs-2">Wallah</div>
          </div>
        </div>&ndash;%&gt;
      </span>--%>
    </div>
  </div>
</div>
<add-edit-customer-slide-panel></add-edit-customer-slide-panel>
  </span>

