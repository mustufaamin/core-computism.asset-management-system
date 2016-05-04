<md-list ng-controller="ArAccountController as arAccountCtrl" ng-cloak="" class="listArAccountControls" ng-app="MyApp">

<md-subheader class="md-no-sticky">Ar Accounts</md-subheader>
  <md-list-item ng-repeat="person in arAccountCtrl.listArAccountCtrl" ng-click="goToPerson(person.customerName, $event)">
    <img alt="{{ person.customerName }}" ng-src="{{ person.accountTypeName }}" class="md-avatar">
    <p>{{ person.customerName }}</p>
    <md-icon md-svg-icon="communication:messenger" ng-click="doSecondaryAction($event)" aria-label="Open Chat" class="md-secondary md-hue-3" ng-class="{'md-primary': person.accountTypeName}"></md-icon>
    <md-divider></md-divider>
  </md-list-item>
</md-list>

