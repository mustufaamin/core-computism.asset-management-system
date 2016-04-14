<span id="arPanel" ng-controller="AccountReceivableController as arCtrl">

    <div class="row-fluid hideInIE8 circleStats"  ng-show="!arCtrl.showPaymentsTypePanel && !arCtrl.showArTypesPanel">
        <div class="span2" onTablet="span4" onDesktop="span2">
            <div class="ar-subPanel">
                <div class="ar-subHeading">Adjustments<span class="ar-symbolPanelHead"><i class="fa fa-pie-chart"></i></span></div>
                <div class="ar-subPanelCenter">
                    <i class="fa fa-arrow-up"></i>
                    <label>Hover Here!</label>
                </div>
                <div class="ar-slidingOpt">
                    <div class="ar-optBox">
                        <ul class="ar-optList">
                            <li class="ar-option"><label class=""><i class="fa fa-arrow-right"></i> Adjustments</label></li>
                            <li class="ar-option"><label class=""><i class="fa fa-arrow-right"></i> Import Adjustments</label></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="span2" onTablet="span4" onDesktop="span2">
            <div class="ar-subPanel">
                <div class="ar-subHeading">EOM<span class="ar-symbolPanelHead"><i class="fa fa-calendar"></i></span></div>
                <div class="ar-subPanelCenter">
                    <i class="fa fa-arrow-up"></i>
                    <label>Hover Here!</label>
                </div>
                <div class="ar-slidingOpt">
                    <div class="ar-optBox">
                        <ul class="ar-optList">
                            <li class="ar-option"><label class=""><i class="fa fa-arrow-right"></i> EOM Wizard</label></li>
                            <li class="ar-option"><label class=""><i class="fa fa-arrow-right"></i> Posting</label></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="span2" onTablet="span4" onDesktop="span2">
            <div class="ar-subPanel">
                <div class="ar-subHeading">Payments<span class="ar-symbolPanelHead"><i class="fa fa-usd"></i></span></div>
                <div class="ar-subPanelCenter">
                    <i class="fa fa-arrow-up"></i>
                    <label>Hover Here!</label>
                </div>
                <div class="ar-slidingOpt">
                    <div class="ar-optBox">
                        <ul class="ar-optList">
                            <li class="ar-option"><label class=""><i class="fa fa-arrow-right"></i> Import Payments</label></li>
                            <li class="ar-option" ui-sref="paymentTypes" ng-click="arCtrl.showPaymentsTypePanel = !arCtrl.showPaymentsTypePanel"><label class=""><i class="fa fa-arrow-right"></i> Payments</label></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="span2" onTablet="span4" onDesktop="span2">
            <div class="ar-subPanel">
                <div class="ar-subHeading">Admin<span class="ar-symbolPanelHead"><i class="fa fa-key"></i></span></div>
                <div class="ar-subPanelCenter">
                    <i class="fa fa-arrow-up"></i>
                    <label>Hover Here!</label>
                </div>
                <div class="ar-slidingOpt">
                    <div class="ar-optBox">
                        <ul class="ar-optList">
                            <li class="ar-option"><label class=""><i class="fa fa-arrow-right"></i> Add On Charge</label></li>
                            <li class="ar-option"><label class=""><i class="fa fa-arrow-right"></i> Add On Group</label></li>
                            <li class="ar-option" ui-sref="arTypes" ng-click="arCtrl.showArTypesPanel = !arCtrl.showArTypesPanel"><label class=""><i class="fa fa-arrow-right"></i> AR Types</label></li>
                            <li class="ar-option"><label class=""><i class="fa fa-arrow-right"></i> Batches</label></li>
                            <li class="ar-option" ui-sref="billCodes" ng-click="arCtrl.showBillCodesPanel = !arCtrl.showBillCodesPanel"><label class=""><i class="fa fa-arrow-right"></i> Bill Code</label></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="span2" onTablet="span4" onDesktop="span2">
            <div class="ar-subPanel">
                <div class="ar-subHeading">Inquiry<span class="ar-symbolPanelHead"><i class="fa fa-phone"></i></span></div>
                <div class="ar-subPanelCenter">
                    <i class="fa fa-arrow-up"></i>
                    <label>Hover Here!</label>
                </div>
                <div class="ar-slidingOpt">
                    <div class="ar-optBox">
                        <ul class="ar-optList">
                            <li class="ar-option"><label class=""><i class="fa fa-arrow-right"></i> AR Account</label></li>
                            <li class="ar-option"><label class=""><i class="fa fa-arrow-right"></i> Bill Codes</label></li>
                            <li class="ar-option"><label class=""><i class="fa fa-arrow-right"></i> Bill Run</label></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="span2" onTablet="span4" onDesktop="span2">
            <div class="ar-subPanel">
                <div class="ar-subHeading">Processes<span class="ar-symbolPanelHead"><i class="fa fa-cog"></i></span></div>
                <div class="ar-subPanelCenter">
                    <i class="fa fa-arrow-up"></i>
                    <label>Hover Here!</label>
                </div>
                <div class="ar-slidingOpt">
                    <div class="ar-optBox">
                        <ul class="ar-optList">
                            <li class="ar-option"><label class=""><i class="fa fa-arrow-right"></i> Account Creation</label></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <div ng-show="arCtrl.showPaymentsTypePanel">
        <payment-type-panel></payment-type-panel>
    </div>
    <div ng-show="arCtrl.showArTypesPanel">
        <ar-types-panel></ar-types-panel>
    </div>
</span>