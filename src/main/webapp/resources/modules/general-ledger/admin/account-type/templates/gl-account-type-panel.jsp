<span id="glAccountTypePanel" ng-controller="GLAccountTypeController as glAccountTypeCtrl">
<div class="row">
    <div class="col-xs-12">
        <div class="srch-box">
            <div class="row">
                <div class="col-xs-4">
                    <div class="c-form-gp pos-rel">
                        <label class="c-form-lbl">GL Account Type</label>
                        <input <%--typeahead-click-open typeahead-min-length="0" ng-model="" ng-required="true"
                   uib-typeahead="driver as driver.label for driver in getDrivers($viewValue)"
                   typeahead-on-select="onSelectDriver($item)" typeahead-no-results="noDrivers" typeahead-wait-ms=1500--%>
                                class="c-form-inpt custSearch" type="text" class="c-form-inpt" ng-disabled="" placeholder="Search GL Account Types.."/>
                        <%--<span class="ccload loadtca adjCaptLoader" ng-show="drivAdjustCtrl.adjCaptLoader"></span>--%>
                        <button class="c-btn c-btn-action cust-add-btn open-gl-btn"
                                ng-class=""
                                ng-disabled=""
                                ng-click="glAccountTypeCtrl.openAccountTypeSlidePanel(1)">Add GL Account Type</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
    <div class="row">
        <div class="col-xs-12">
            <div class="cap-adj-cycle">
                <div class="cap-adj-cyc-head">Gl Account Types</div>

                <table ng-table="glAccountTypeList" class="table" show-filter="true">
                    <tr ng-repeat="accountType in glAccountTypeCtrl.listGlAccountType">
                        <td title="'#'">
                            <div class="grid-func" ng-click="glAccountTypeCtrl.openAccountTypeSlidePanel(2, accountType)">View: <i class="fa fa-eye"></i><br></div>
                            <div class="grid-func" ng-click="glAccountTypeCtrl.openAccountTypeSlidePanel(3, accountType)">Edit: <i class="fa fa-scissors"></i></div>
                        </td>
                        <td title="'Account Type Name'">
                            {{accountType.name}}</td>
                        <td title="'Description'">
                            {{accountType.description}}</td>
                        <td title="'Normal Balance Flag'">
                            <input type="checkbox" ng-checked="accountType.normalBalanceFlag" ng-disabled="accountType.normalBalanceFlag" />
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <gl-account-type-slide-panel></gl-account-type-slide-panel>
</span>