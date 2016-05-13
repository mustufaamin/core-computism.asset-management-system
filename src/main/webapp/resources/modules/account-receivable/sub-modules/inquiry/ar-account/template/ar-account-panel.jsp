<span ui-view id="arAccountPanel" ng-controller="ArAccountController as arAccountCtrl">
  <div class="row">
    <div class="col-xs-12">
      <div class="srch-box">
        <div class="row">
          <div class="col-xs-4">
            <div class="c-form-gp pos-rel">
              <label class="c-form-lbl">Search</label>
              <input  typeahead-min-length="0"
                      uib-typeahead="arAccount for arAccount in arAccountCtrl.searchArAccounts($viewValue)"
                      ng-model="arAccountCtrl.search" ng-required="true"
                      typeahead-no-results="noItems" typeahead-wait-ms=500
                      class="c-form-inpt custSearch" type="text" class="c-form-input" ng-disabled="" placeholder="Search Ar Accounts.."/>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
<div class="row">
  <div class="col-xs-12">
    <div class="cap-adj-cycle">
      <div class="cap-adj-cyc-head">Ar Accounts</div>

      <div>
        <table ng-table-dynamic="arAccountCtrl.arAccountTable with arAccountCtrl.cols"
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
</span>