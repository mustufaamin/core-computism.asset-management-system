			<span class="moduleWrapper" ng-controller="ModuleController as moduleCtrl">
				<span class="col-xs-3">
					<div class="flip-container mainModule" ontouchstart="this.classList.toggle('hover');">
                        <div class="flipper">
                            <div class="front">
								<span class="moduleTitle">
									<h2 class="moduleHeading">Customer</h2>
								</span>
								<span class="modulePicCont">
									<img class="modulePic" src="resources/images/customer.svg">
								</span>
                                <!-- front content -->
                            </div>
                            <div class="back">
                                <span class="options"><i class="fa fa-ellipsis-v" aria-hidden="true"></i></span>
								<span class="description txtLeft">
									  <span class="boxInfoWrap"><span class="col-xs-12  boxLabel">CUSTOMERS BALANCE</span><span class="col-xs-12  boxCont">$20,200,00</span></span>
									  <span class="boxInfoWrap"><span class="col-xs-12  boxLabel">TOTAL CUSTOMERS</span><span class="col-xs-12  boxCont">30,300</span></span>
									  <span class="boxInfoWrap"><span class="col-xs-12  boxLabel">CUSTOMERS PAYABLE %</span><span class="col-xs-12  boxCont">45%</span></span>
								</span>
                                <a class="mainModulebtn" ui-sref="customer" ng-click="moduleCtrl.openCustomerModule()"><span>Details</span></a>
                            </div>
                        </div>
                    </div>
				</span>
				<span class="col-xs-3">
					<div class="flip-container mainModule" ontouchstart="this.classList.toggle('hover');">
                        <div class="flipper">
                            <div class="front">
								<span class="moduleTitle">
									<h2 class="moduleHeading">Account Receivable</h2>
								</span>
								<span class="modulePicCont">
									<img class="modulePic" src="resources/images/ar.svg">
								</span>
                            </div>
                            <div class="back">
                                <span class="options"><i class="fa fa-ellipsis-v" aria-hidden="true"></i></span>
								<span class="description txtLeft">
									  <span class="boxInfoWrap"><span class="col-xs-12  boxLabel">TOTAL BALANCE</span><span class="col-xs-12  boxCont">$20,200,00</span></span>
									  <span class="boxInfoWrap"><span class="col-xs-12  boxLabel">TOTAL DEBIT AMOUNT</span><span class="col-xs-12  boxCont">$30,300</span></span>
									  <span class="boxInfoWrap"><span class="col-xs-12  boxLabel">DEBIT %</span><span class="col-xs-12  boxCont">33%</span></span>
								</span>
								<a class="mainModulebtn" ui-sref="ar" ng-click="moduleCtrl.openArModule()"><span>Details</span></a>
                            </div>
                        </div>
                    </div>
				</span>
				<span class="col-xs-3">
					<div class="flip-container mainModule" ontouchstart="this.classList.toggle('hover');">
                        <div class="flipper">
                            <div class="front">
								<span class="moduleTitle">
									<h2 class="moduleHeading">Account Payable</h2>
								</span>
								<span class="modulePicCont">
									<img class="modulePic" src="resources/images/ap.svg">
								</span>
                                <!-- front content -->
                            </div>
                            <div class="back">
                                <span class="options"><i class="fa fa-ellipsis-v" aria-hidden="true"></i></span>
								<span class="description txtLeft">
									  <span class="boxInfoWrap"><span class="col-xs-12  boxLabel">TOTAL BALANCE</span><span class="col-xs-12  boxCont">$20,200,00</span></span>
									  <span class="boxInfoWrap"><span class="col-xs-12  boxLabel">TOTAL CREDIT AMOUNT</span><span class="col-xs-12  boxCont">$45,300</span></span>
									  <span class="boxInfoWrap"><span class="col-xs-12  boxLabel">CREDIT %</span><span class="col-xs-12  boxCont">57%</span></span>
								</span>
                                <a class="mainModulebtn" href="customer.html"><span>Details</span></a>
                                <!-- back content -->
                            </div>
                        </div>
                    </div>
				</span>
				<span class="col-xs-3">
					<div class="flip-container mainModule" ontouchstart="this.classList.toggle('hover');">
                        <div class="flipper">
                            <div class="front">
								<span class="moduleTitle">
									<h2 class="moduleHeading">Point Of Sale</h2>
								</span>
								<span class="modulePicCont">
									<img class="modulePic" src="resources/images/pos.svg">
								</span>
                                <!-- front content -->
                            </div>
                            <div class="back">
                                <span class="options"><i class="fa fa-ellipsis-v" aria-hidden="true"></i></span>
								<span class="description txtLeft">
									  <span class="boxInfoWrap"><span class="col-xs-12  boxLabel">TOTAL INVOICES</span><span class="col-xs-12  boxCont">20,200,00</span></span>
									  <span class="boxInfoWrap"><span class="col-xs-12  boxLabel">TOTAL RECIEPTS</span><span class="col-xs-12  boxCont">36,000</span></span>
									  <span class="boxInfoWrap"><span class="col-xs-12  boxLabel">INVENTORY VALUE</span><span class="col-xs-12  boxCont">$32,800</span></span>
								</span>
                                <a class="mainModulebtn" href="customer.html"><span>Details</span></a>
                                <!-- back content -->
                            </div>
                        </div>
                    </div>
				</span>
				<span class="col-xs-3">
					<div class="flip-container mainModule" ontouchstart="this.classList.toggle('hover');">
                        <div class="flipper">
                            <div class="front">
								<span class="moduleTitle">
									<h2 class="moduleHeading">Inventory</h2>
								</span>
								<span class="modulePicCont">
									<img class="modulePic" src="resources/images/inventory.png">
								</span>
                                <!-- front content -->
                            </div>
                            <div class="back">
                                <span class="options"><i class="fa fa-ellipsis-v" aria-hidden="true"></i></span>
								<span class="description txtLeft">
									  <span class="boxInfoWrap"><span class="col-xs-12  boxLabel">TOTAL INVOICES</span><span class="col-xs-12  boxCont">20,200,00</span></span>
									  <span class="boxInfoWrap"><span class="col-xs-12  boxLabel">TOTAL INVENTORY</span><span class="col-xs-12  boxCont">36,000</span></span>
									  <span class="boxInfoWrap"><span class="col-xs-12  boxLabel">INVENTORY VALUE</span><span class="col-xs-12  boxCont">$32,800</span></span>
								</span>
                                <a class="mainModulebtn" href="customer.html"><span>Details</span></a>
                                <!-- back content -->
                            </div>
                        </div>
                    </div>
				</span>
			</span>