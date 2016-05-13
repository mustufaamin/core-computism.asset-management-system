<span ui-view id="posItemPanel" ng-controller="PosItemController as posItemCtrl">
  <div class="row">
    <div class="col-xs-12">
      <div class="srch-box">
        <div class="row">
          <div class="col-xs-4">
            <div class="c-form-gp pos-rel">
              <label class="c-form-lbl">Search</label>
              <input  typeahead-min-length="0"
                      uib-typeahead="posItem for posItem in posItemCtrl.searchPosItem($viewValue)"
                      ng-model="billCodesCtrl.search" ng-required="true"
                      typeahead-no-results="noItems" typeahead-wait-ms=500
                      class="c-form-inpt custSearch" type="text" class="c-form-input" ng-disabled="" placeholder="Search Pos Item.."/>

              <button class="c-btn c-btn-action cust-add-btn open-pos-btn"
                      ng-class=""
                      ng-disabled=""
                      ng-click="posItemCtrl.openPosItemSlidePanel(1)">Add ITem</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<div class="row">
  <div class="col-xs-12">
    <div class="cap-adj-cycle">
      <div class="cap-adj-cyc-head">List POS Item</div>
      <table ng-table-dynamic="posItemCtrl.posItemTable with posItemCtrl.cols"
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
  <pos-item-slide-panel></pos-item-slide-panel>

</span>

