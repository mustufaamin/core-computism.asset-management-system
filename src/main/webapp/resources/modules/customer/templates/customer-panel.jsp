<span ng-controller="CustomerController as custCtrl">
  <div class="sub-menu">
    <ul class="menuList">
      <li class=""><a class="anime" ng-class="{active: custCtrl.customerListPanel}" ng-click="custCtrl.openCustomerList()">Customer List</a></li>
      <li class=""><a class="anime" ng-class="{active: custCtrl.customerProfilePanel}" ng-click="custCtrl.openCustomerProfile()">Customer Profile</a></li>
    </ul>
  </div>
  <div ng-show="custCtrl.customerListPanel">
    <div class="search-bar-panel">
      <div class="search-bar-wrapper">
        <span class="search-lbl-wrap">
          <label class="search-lbl">Customer</label>
        </span>
        <span class="search-inpt-wrap">
          <input type="text" class="search-inpt anime" placeholder="Search Customer">
        </span>
      </div>
      <div class="add-btn-wrap">
        <a class="mainModulebtn add-btn" ng-click=""><span>Add Customer</span></a>
      </div>
    </div>
    <div class="tbl-dynamic-div">
      <span class="tbl-dynamic-head"><h3 class="list-head">Current Customers</h3></span>
      <table ng-table-dynamic="custCtrl.itemTable with custCtrl.cols"  class="table table-condensed table-bordered table-striped">
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
  </div>
  <div ng-show="custCtrl.customerProfilePanel">
    <div class="cont-wrap">
      <div class="search-cust">
        <span class="srch-wrap">
          <span class="srch-cust-cont">
            <input class="srch-cust-inpt anime" type="text" placeholder="Search Customer...">
          </span>
        </span>
      </div>
      <div class="profile">
        <div class="profile-desc">
          <div class="col-xs-12"><h3 class="stats-heading">Profile Information</h3></div>
          <div class="general-info col-xs-6">
          <span class="profile-img-cont">
            <img src="resources/images/umer.jpg">
          </span>
          <span class="cust-p-info">
            <span class="cust-name">Muhammad Umer</span>
            <span class="country-info">Karachi, Pakistan</span>
          </span>
          </div>
          <div class="contact-info  col-xs-6">
          <span class="contact-wrap">
            <ul class="contact-list">
              <li>
                <span class="cnt-li-items"><i class="fa fa-map-marker"></i>House# 12D, Street# 35, Tariq Road, Karachi, Pakistan</span>
              </li>
              <li>
                <span class="cnt-li-items"><i class="fa fa-envelope"></i>umermuhammadkhan@gmail.com</span></li>
              <li>
                <span class="cnt-li-items"><i class="fa fa-phone"></i>+923458948938</span>
              </li>
            </ul>
          </span>
          </div>
        </div>
        <div class="stats">
          <div class="col-xs-12"><h3 class="stats-heading">General Statistics</h3></div>
          <div class="stats-panel col-xs-12">
            <ul class="stats-items">
              <li>
                <span class="stats-item-head">Total Quotations</span>
                <span class="stats-item-cont">32</span>
              </li>
              <li>
                <span class="stats-item-head">Amount Orders</span>
                <span class="stats-item-cont">3500</span>
              </li>
              <li>
                <span class="stats-item-head">Credit Amount</span>
                <span class="stats-item-cont">$782000</span>
              </li>
              <li>
                <span class="stats-item-head">Debit Amount</span>
                <span class="stats-item-cont">$542000</span>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <div class="cust-side-items-pnl-wrap">
        <div ng-show="custCtrl.quotationOpen">
          <div class="search-bar-panel">
            <div class="search-bar-wrapper">
        <span class="search-lbl-wrap">
          <label class="search-lbl">Quotation</label>
        </span>
        <span class="search-inpt-wrap">
          <input type="text" class="search-inpt anime" placeholder="Search Quotation">
        </span>
            </div>
            <div class="add-btn-wrap">
              <a class="mainModulebtn add-btn" ng-click=""><span>Add Quotation</span></a>
            </div>
          </div>
          <div class="tbl-dynamic-div">
            <span class="tbl-dynamic-head"><h3 class="list-head">Current Quotations</h3></span>
            <table ng-table-dynamic="custCtrl.itemTable with custCtrl.cols"  class="table table-condensed table-bordered table-striped">
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
        </div>
        <div ng-show="custCtrl.pastOrdersOpen">
          <div class="search-bar-panel">
            <div class="search-bar-wrapper">
        <span class="search-lbl-wrap">
          <label class="search-lbl">Past Orders</label>
        </span>
        <span class="search-inpt-wrap">
          <input type="text" class="search-inpt anime" placeholder="Search Past Orders">
        </span>
            </div>
            <div class="add-btn-wrap">
              <a class="mainModulebtn add-btn" ng-click=""><span>Add Past Order</span></a>
            </div>
          </div>
          <div class="tbl-dynamic-div">
            <span class="tbl-dynamic-head"><h3 class="list-head">Current Past Orders</h3></span>
            <table ng-table-dynamic="custCtrl.itemTable with custCtrl.cols"  class="table table-condensed table-bordered table-striped">
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
        </div>
        <div ng-show="custCtrl.pastPaymentsOpen">
          <div class="search-bar-panel">
            <div class="search-bar-wrapper">
        <span class="search-lbl-wrap">
          <label class="search-lbl">Past Payments</label>
        </span>
        <span class="search-inpt-wrap">
          <input type="text" class="search-inpt anime" placeholder="Search Past Payments">
        </span>
            </div>
            <div class="add-btn-wrap">
              <a class="mainModulebtn add-btn" ng-click=""><span>Add Past Payment</span></a>
            </div>
          </div>
          <div class="tbl-dynamic-div">
            <span class="tbl-dynamic-head"><h3 class="list-head">Current Past Payments</h3></span>
            <table ng-table-dynamic="custCtrl.itemTable with custCtrl.cols"  class="table table-condensed table-bordered table-striped">
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
        </div>
      </div>
    </div>
    <div class="side-menu">
      <ul class="sm-list">
        <li class=""><a class="anime" ng-click="custCtrl.openQuotationList()" ng-class="{active: custCtrl.quotationOpen}">Quotation List</a></li>
        <li class=""><a class="anime" ng-click="custCtrl.openPastOrderList()" ng-class="{active: custCtrl.pastOrdersOpen}">Past Orders</a></li>
        <li class=""><a class="anime" ng-click="custCtrl.openPastPaymentsList()" ng-class="{active: custCtrl.pastPaymentsOpen}">Past Payments</a></li>
      </ul>
    </div>
  </div>
</span>