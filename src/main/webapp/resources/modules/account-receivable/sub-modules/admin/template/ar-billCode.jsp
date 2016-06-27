<div class="search-bar-panel">
  <div class="search-bar-wrapper">
        <span class="search-lbl-wrap">
          <label class="search-lbl">BillCode</label>
        </span>
        <span class="search-inpt-wrap">
          <input type="text" class="search-inpt anime" placeholder="Search Bill-Code....">
        </span>
  </div>
  <div class="add-btn-wrap">
    <a class="mainModulebtn add-btn" ng-click=""><span>Add BillCode</span></a>
  </div>
</div>
<div class="tbl-dynamic-div">
  <span class="tbl-dynamic-head"><h3 class="list-head">Current BillCodes</h3></span>
  <table ng-table-dynamic="arAdminCtrl.billCodeTable with arAdminCtrl.billCodeCols"  class="table table-condensed table-bordered table-striped">
    <tr ng-repeat="row in $data">
      <td ng-repeat="col in $columns">
        <span ng-if="col.dataType !== 'command'">{{row[col.field]}}</span>
        <div ng-if="col.dataType === 'command'">
          <span class="tbl-dynamic-cmnd-btn anime"><i class="fa fa-pencil" aria-hidden="true"></i></span>
          <span class="tbl-dynamic-cmnd-btn anime"><i class="fa fa-trash" aria-hidden="true"></i></span>
        </div>
      </td>
    </tr>
  </table>
</div>