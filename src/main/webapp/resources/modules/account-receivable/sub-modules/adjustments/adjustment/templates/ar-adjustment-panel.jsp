<div ng-controller="ArAdjustmentController as arAdjustmentCtrl" layout="column" ng-cloak="" class="md-inline-form inputdemoBasicUsage">
  <table>
    <tr>
      <td style="width: 65%" layout-align="center end">
        <md-content md-theme="docs-dark" layout-gt-sm="row" layout-padding="" style="width: 100%">
          <div style="width: 100%">
            <md-input-container>
              <label>Batch #</label>
              <input ng-model="adjustment.batchId">
            </md-input-container>

            <md-input-container>
              <label>Total</label>
              <input ng-model="adjustment.total" type="email">
            </md-input-container>

            <md-input-container>
              <label>Used</label>
              <input ng-model="adjustment.used" type="email">
            </md-input-container>
          </div>
        </md-content>
      </td>
      <td style="width: 100%">
        <md-content class="md-padding" layout-xs="column" layout="row" style="width: 100% ">

          <md-card md-theme="{{dark-purple}}" md-theme-watch="">
            <md-card-title>
              <md-card-title-text>
                <span class="md-headline">Customer image</span>
                <span class="md-subhead">Muhammad Salman</span>
              </md-card-title-text>
              <md-card-title-media>
                <div class="md-media-sm card-media"></div>
              </md-card-title-media>
            </md-card-title>
            <md-card-actions layout="row" layout-align="end center">
              <md-button>Customer Detail</md-button>
            </md-card-actions>
          </md-card>
          <%--<div layout="" layout-padding="" layout-align="center end" style="height:200px">
            <md-checkbox ng-model="showDarkTheme">Use 'Dark' Themed Cards</md-checkbox>
          </div>--%>
        </md-content>
      </td>
    </tr>
  </table>
  <md-content layout-padding="">
    <div>
      <form name="userForm">

        <div layout-gt-xs="row">
          <md-input-container class="md-block" flex-gt-xs="">
            <label>Customer</label>
            <input ng-model="adjustment.customer" <%--disabled=""--%>>
          </md-input-container>

          <md-input-container class="md-block" flex-gt-xs="">
            <label>Customer Type</label>
            <input ng-model="adjustment.customerType" <%--disabled=""--%>>
          </md-input-container>

          <md-input-container class="md-block" flex-gt-xs="">
            <label>Customer Status</label>
            <input ng-model="adjustment.customerStatus" <%--disabled=""--%>>
          </md-input-container>

          <%--<md-datepicker ng-model="user.submissionDate" md-placeholder="Enter date">
          </md-datepicker>--%>
        </div>

          <table style="width: 100%">
              <tr>
                  <td>
                      <md-input-container class="md-block" flex-gt-sm="" >
                          <label>BillCodes</label>
                          <md-select ng-model="adjustment.billCodeId">
                              <md-option ng-repeat="billCode in arAdjustmentCtrl.listBillCodes" value="{{billCode.billCodeId}}">
                                  {{billCode.name}}
                              </md-option>
                          </md-select>
                      </md-input-container>
                  </td>
                  <td>
                      <md-datepicker ng-model="adjustment.adjustmentDate" md-placeholder="Enter date">
                      </md-datepicker>
                  </td>
              </tr>
              <tr>
                  <td colspan="2">
                      <md-input-container class="md-block" >
                          <label>Adjustment notes</label>
                          <textarea ng-model="adjustment.note" md-maxlength="255" rows="5" md-select-on-focus=""></textarea>
                      </md-input-container>
                  </td>
              </tr>
          </table>
          <table style="width: 100%">
              <tr>
                  <td style="width: 50%">
                      <table>
                          <tr>
                              <td style="width: 30%">
                                  <md-input-container class="md-block" flex-gt-sm="">
                                      <label>Statement Description Line1</label>
                                      <input ng-model="adjustment.description" md-maxlength="255">
                                  </md-input-container>
                              </td>
                          </tr>
                          <tr>
                              <td style="width: 30%">
                                  <md-input-container class="md-block" flex-gt-sm="">
                                      <label>Statement Description Line2</label>
                                      <input ng-model="adjustment.statementDescription2" md-maxlength="255">
                                  </md-input-container>
                              </td>
                          </tr>
                      </table>
                  </td>
                  <td style="width: 50%">
                      <md-card>
                          <md-card-title>
                              <table layout-padding="">
                                  <tr>
                                      <td>
                                          <md-card-title-text>
                                              <span class="md-subhead">Adjustment Details</span>
                                          </md-card-title-text>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td colspan="2">
                                          <md-input-container class="md-block">
                                              <label>Adjustment Amount</label>
                                              <input ng-model="adjustment.amount" type="number">
                                          </md-input-container>
                                      </td>
                                  </tr>
                                  <tr>
                                      <td>
                                          <md-input-container class="md-block">
                                              <label>Total</label>
                                          </md-input-container>
                                      </td>
                                      <td>
                                          <md-input-container class="md-block">
                                              <label>{{adjustment.amount}}</label>
                                          </md-input-container>
                                      </td>
                                  </tr>
                              </table>
                          </md-card-title>
                      </md-card>
                  </td>
              </tr>
          </table>

      </form>
    </div>
  </md-content>

</div>

<!--
Copyright 2016 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that can be in foundin the LICENSE file at http://material.angularjs.org/license.
-->