<span ng-controller="CustomerController as custCtrl">
  <%--<div class="sub-menu" ng-show="!custCtrl.customerListPanel || !custCtrl.customerProfilePanel">
    <ul class="menuList">
      <li class=""><a class="anime" ui-sref="customerList" ng-class="{active: custCtrl.customerListPanel}" ng-click="custCtrl.openCustomerList()">Customer List</a></li>
      <li class=""><a class="anime" ui-sref="customerProfile" ng-class="{active: custCtrl.customerProfilePanel}" ng-click="custCtrl.openCustomerProfile()">Customer Profile</a></li>
    </ul>
  </div>--%>
  <div ng-show="custCtrl.customerListPanel">
    <customer-list></customer-list>
  </div>
  <div ng-show="custCtrl.customerProfilePanel">
    <customer-profile></customer-profile>
  </div>
</span>