<span ng-controller="CustomerController as custCtrl">
  <div class="sub-menu">
    <ul class="menuList">
      <li class=""><a class="anime" ng-class="{active: custCtrl.customerListPanel}" ng-click="custCtrl.openCustomerList()">Customer List</a></li>
      <li class=""><a class="anime" ng-class="{active: custCtrl.customerAddPanel}" ng-click="custCtrl.openCustomerAddForm()">Add Customer</a></li>
      <li class=""><a class="anime" ng-class="{active: custCtrl.customerProfilePanel}" ng-click="custCtrl.openCustomerProfile()">Customer Profile</a></li>
    </ul>
  </div>
  <div ng-show="custCtrl.customerListPanel">
    <div class="search-cust list-cust">
        <h3 class="list-cust-head">Current Customers</h3>
        <div>
          <table ng-table-dynamic="orderCtrl.itemTable with orderCtrl.cols"
                 class="table table-condensed table-bordered table-striped">
            <colgroup>
              <col width="20%" />
              <col width="60%" />
              <col width="10%" />
              <col width="10%" />
            </colgroup>
            <tr ng-repeat="row in $data">
              <td ng-repeat="col in $columns">
                <span ng-if="col.dataType !== 'command'">{{row[col.field]}}</span>
                <div ng-if="col.dataType === 'command'">
                  <button class="btn btn-danger btn-sm" ng-click="orderCtrl.deleteItem(row)"><span class="glyphicon glyphicon-trash"></span></button>
                </div>
              </td>
            </tr>
          </table>
        </div>
    </div>
  </div>
  <div ng-show="custCtrl.customerAddPanel">
    <div class="search-cust list-cust">
      <h3 class="list-cust-head">Current Customers</h3>
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
    </div>
    <div class="side-menu">
      <ul class="sm-list">
        <li class=""><a class="anime active">Quotation List</a></li>
        <li class=""><a class="anime">Past Orders</a></li>
        <li class=""><a class="anime">Past Payments</a></li>
      </ul>
    </div>
  </div>
</span>