<div ng-show="true">
  <div class="sub-menu">
    <ul class="menuList">
      <li class=""><a class="anime" ng-class="{active: arCtrl.overviewSubModule}" ng-click="arCtrl.openOverviewSubModule()">Overview</a></li>
      <li class=""><a class="anime" ng-class="{active: arCtrl.inquirySubModule}" ng-click="arCtrl.openInquirySubModule()">Inquiry</a></li>
      <li class=""><a class="anime" ng-class="{active: arCtrl.adminSubModule}" ng-click="arCtrl.openAdminSubModule()">Admin</a></li>
      <li class=""><a class="anime" ng-class="{active: arCtrl.processSubModule}" ng-click="arCtrl.openProcessSubModule()">Process</a></li>
      <li class=""><a class="anime active" ui-sref="arPayments" ng-click="arCtrl.openPaymentsSubModule()">Payments</a></li>
      <li class=""><a class="anime" ng-class="{active: arCtrl.adjustmentSubModule}" ng-click="arCtrl.openAdjustmentSubModule()">Adjustment</a></li>
    </ul>
  </div>
	<%--This is the Slide Panel HTML Start--%>
	<div class="slideOverlay" ng-show="false">
	</div>
	<div class="slidePanel" ng-show="false">
		<div class="slidePanelHead">
			<h3 class="sld-panel-heading">Add Payments</h3>
			<span class="options sld-pnl-close anime"><i class="fa fa-close" aria-hidden="true"></i></span>
		</div>
		<div class="sld-panel-cont">
			<div class="adj-sec-module adj-sec-slide-panel col-xs-12">
				<span class="adj-sec-heading col-xs-12">Customer Info:</span>
						<span class="sec-elem-wrap col-xs-6 form-group">
							<span class="sec-elem-heading control-label">Customer</span>
							<input type="text" class="inpt anime" placeholder="Customer Name...">
						</span>
						<span class="sec-elem-wrap col-xs-6 form-group">
							<span class="sec-elem-heading control-label">Customer Type</span>
							<input type="text" class="inpt anime" placeholder="Customer Type...">
						</span>
						<span class="sec-elem-wrap col-xs-6 form-group">
							<span class="sec-elem-heading control-label">Customer Status</span>
							<input type="text" class="inpt anime" placeholder="Customer Status...">
						</span>
			</div>
			<div class="adj-sec-module action-bar col-xs-12">
						<span class="button-wrap">
							<span class="button button-primary">Continue</span>
							<span class="button button">Close</span>
						</span>
			</div>
		</div>
	</div>

	<%--This is the Slide Panel HTML End--%>
  <div class="adj-sec">
    <div class="wid50p">
      <div class="adj-sec-module col-xs-12">
        <span class="adj-sec-heading col-xs-12">Batch Info:</span>
							<span class="sec-elem-wrap col-xs-6 form-group">
								<span class="sec-elem-heading control-label">Batch #</span>
								<input type="text" class="inpt anime" placeholder="Batch #...">
							</span>
							<span class="sec-elem-wrap col-xs-6 form-group">
								<span class="sec-elem-heading control-label">Totals</span>
								<input type="text" class="inpt anime" placeholder="Totals...">
							</span>
							<span class="sec-elem-wrap col-xs-6 form-group">
								<span class="sec-elem-heading control-label">Used</span>
								<input type="text" class="inpt anime" placeholder="Used...">
							</span>
      </div>
      <div class="adj-sec-module col-xs-12">
        <span class="adj-sec-heading col-xs-12">Customer Info:</span>

							<span class="sec-elem-wrap col-xs-6 form-group">
								<span class="sec-elem-heading control-label">Customer</span>
								<datetimepicker
										hour-step="1"
										minute-step="1"
										ng-model="initialDate"
										show-meridian="false"
										date-disabled="false"
										hidden-time="false"
										hidden-date="false"
										<%--name="editSchdBkCtrl.initialDate"--%>
										show-spinners="true"
										readonly-time="false"
										>
								</datetimepicker>
								<%--<input type="text" class="inpt anime" placeholder="Customer Name...">--%>
							</span>
							<span class="sec-elem-wrap col-xs-6 form-group">
								<span class="sec-elem-heading control-label">Customer Type</span>
								<input type="text" class="inpt anime" placeholder="Customer Type...">
							</span>
							<span class="sec-elem-wrap col-xs-6 form-group">
								<span class="sec-elem-heading control-label">Customer Status</span>
								<input type="text" class="inpt anime" placeholder="Customer Status...">
							</span>

      </div>
      <div class="adj-sec-module col-xs-12">
        <span class="adj-sec-heading col-xs-12">Payment Info:</span>

						<span class="sec-elem-wrap col-xs-4 form-group">
							<span class="sec-elem-heading control-label">Payment Date</span>
							<input type="text" class="inpt anime" placeholder="Payment Date...">
						</span>
						<span class="sec-elem-wrap col-xs-4 form-group">
							<span class="sec-elem-heading control-label">Payment Type</span>
							<input type="text" class="inpt anime" placeholder="Payment Type...">
						</span>
						<span class="sec-elem-wrap col-xs-4 form-group">
							<span class="sec-elem-heading control-label">Payment Amount</span>
							<input type="text" class="inpt anime" placeholder="Payment Amount...">
						</span>
      </div>
    </div>
    <div class="wid50p">
      <div class="adj-sec-module col-xs-12">
        <span class="adj-sec-heading col-xs-12">Payment Calculation:</span>

							<span class="sec-elem-wrap col-xs-4 form-group">
								<span class="sec-elem-heading control-label">Receivable Types</span>
								<input type="text" class="inpt anime" placeholder="Receivable Types...">
							</span>
							<span class="sec-elem-wrap col-xs-4 form-group">
								<span class="sec-elem-heading control-label">Amount</span>
								<input type="text" class="inpt anime" placeholder="Amount...">
							</span>
							<span class="sec-elem-wrap col-xs-4 form-group">
								<span class="sec-elem-heading control-label">Description</span>
								<input type="text" class="inpt anime" placeholder="Description...">
							</span>
							<span class="sec-elem-wrap col-xs-4 form-group">
								<span class="sec-elem-heading control-label">Payment Notes</span>
								<input type="text" class="inpt anime" placeholder="Payment Notes...">
							</span>

      </div>
    </div>

  </div>
  </div>
</div>