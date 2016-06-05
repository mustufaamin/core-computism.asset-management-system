/**
 * Created by Muhammad Umer on 3/15/2016.
 */
(function(){
    angular.module('Asasa')
        .directive('accountReceivablePanel', function(){
            return{
                restrict: "E",
                templateUrl: 'resources/modules/account-receivable/templates/account-receivable-panel.jsp'
            }
        });

    angular.module('Asasa')
        .controller('AccountReceivableController', ['$http','$document',  function($http, $document){
            var arCtrl = this;
            arCtrl.adjustmentSubModule = false;
            arCtrl.processSubModule = false;
            arCtrl.paymentsSubModule = false;
            arCtrl.adminSubModule = false;
            arCtrl.inquirySubModule = false;

            angular.element($document).ready(function () {
                arCtrl.openAdjustmentSubModule();
            });

            arCtrl.openImportAdjustmentPanel = function(){
                arCtrl.importAdjustmentPanelOpen = true;
                arCtrl.artAdjustmentPanelOpen = false;
            };

            arCtrl.openArAdjustmentPanel = function(){
                arCtrl.importAdjustmentPanelOpen = false;
                arCtrl.artAdjustmentPanelOpen = true;
            };

            arCtrl.openStatementPanel = function(){
                arCtrl.statementOpen = true;
                arCtrl.transactionOpen = false;
                arCtrl.arAccountOpen = false;
                arCtrl.inquiryBillCodePanel = false;
            };

            arCtrl.openTransactionPanel = function(){
                arCtrl.statementOpen = false;
                arCtrl.transactionOpen = true;
                arCtrl.arAccountOpen = false;
                arCtrl.inquiryBillCodePanel = false;
            };

            arCtrl.openArAccountPanel = function(){
                arCtrl.statementOpen = false;
                arCtrl.transactionOpen = false;
                arCtrl.arAccountOpen = true;
                arCtrl.inquiryBillCodePanel = false;
            };

            arCtrl.openInquiryBillCodesPanel = function(){
                arCtrl.statementOpen = false;
                arCtrl.transactionOpen = false;
                arCtrl.arAccountOpen = false;
                arCtrl.inquiryBillCodePanel = true;
            };

            arCtrl.openAddonChargePanel = function(){
                arCtrl.addonChargeOpen = true;
                arCtrl.addonGroupOpen = false;
                arCtrl.receivableTypeOpen = false;
                arCtrl.batchesOpen = false;
                arCtrl.adminBillCodesOpen = false;
                arCtrl.paymentTypesOpen = false;
                arCtrl.propertiesOpen = false;
                arCtrl.statementPropertiesOpen = false;
            };

            arCtrl.openAddonGroupPanel = function(){
                arCtrl.addonChargeOpen = false;
                arCtrl.addonGroupOpen = true;
                arCtrl.receivableTypeOpen = false;
                arCtrl.batchesOpen = false;
                arCtrl.adminBillCodesOpen = false;
                arCtrl.paymentTypesOpen = false;
                arCtrl.propertiesOpen = false;
                arCtrl.statementPropertiesOpen = false;
            };

            arCtrl.openRecievableTypesPanel = function(){
                arCtrl.addonChargeOpen = false;
                arCtrl.addonGroupOpen = false;
                arCtrl.receivableTypeOpen = true;
                arCtrl.batchesOpen = false;
                arCtrl.adminBillCodesOpen = false;
                arCtrl.paymentTypesOpen = false;
                arCtrl.propertiesOpen = false;
                arCtrl.statementPropertiesOpen = false;
            };

            arCtrl.openBatchesPanel = function(){
                arCtrl.addonChargeOpen = false;
                arCtrl.addonGroupOpen = false;
                arCtrl.receivableTypeOpen = false;
                arCtrl.batchesOpen = true;
                arCtrl.adminBillCodesOpen = false;
                arCtrl.paymentTypesOpen = false;
                arCtrl.propertiesOpen = false;
                arCtrl.statementPropertiesOpen = false;
            };

            arCtrl.openAdminBillCodesPanel = function(){
                arCtrl.addonChargeOpen = false;
                arCtrl.addonGroupOpen = false;
                arCtrl.receivableTypeOpen = false;
                arCtrl.batchesOpen = false;
                arCtrl.adminBillCodesOpen = true;
                arCtrl.paymentTypesOpen = false;
                arCtrl.propertiesOpen = false;
                arCtrl.statementPropertiesOpen = false;
            };

            arCtrl.openPaymentTypesPanel = function(){
                arCtrl.addonChargeOpen = false;
                arCtrl.addonGroupOpen = false;
                arCtrl.receivableTypeOpen = false;
                arCtrl.batchesOpen = false;
                arCtrl.adminBillCodesOpen = false;
                arCtrl.paymentTypesOpen = true;
                arCtrl.propertiesOpen = false;
                arCtrl.statementPropertiesOpen = false;
            };

            arCtrl.openPropertiesPanel = function(){
                arCtrl.addonChargeOpen = false;
                arCtrl.addonGroupOpen = false;
                arCtrl.receivableTypeOpen = false;
                arCtrl.batchesOpen = false;
                arCtrl.adminBillCodesOpen = false;
                arCtrl.paymentTypesOpen = false;
                arCtrl.propertiesOpen = true;
                arCtrl.statementPropertiesOpen = false;
            };

            arCtrl.openStatementPropertiesPanel = function(){
                arCtrl.addonChargeOpen = false;
                arCtrl.addonGroupOpen = false;
                arCtrl.receivableTypeOpen = false;
                arCtrl.batchesOpen = false;
                arCtrl.adminBillCodesOpen = false;
                arCtrl.paymentTypesOpen = false;
                arCtrl.propertiesOpen = false;
                arCtrl.statementPropertiesOpen = true;
            };

            arCtrl.openImportPaymentsPanel = function(){
                arCtrl.importPaymentOpen = true;
                arCtrl.paymentOpen = false;
            };

            arCtrl.openPaymentsPanel = function(){
                arCtrl.importPaymentOpen = false;
                arCtrl.paymentOpen = true;
            };

            arCtrl.openArQuotationPanel = function(){
                arCtrl.arQuotationOpen = true;
                arCtrl.accountCreationOpen = false;
                arCtrl.postingOpen = false;
            };

            arCtrl.openAccountCreationPanel = function(){
                arCtrl.arQuotationOpen = false;
                arCtrl.accountCreationOpen = true;
                arCtrl.postingOpen = false;
            };

            arCtrl.openPostingPanel = function(){
                arCtrl.arQuotationOpen = false;
                arCtrl.accountCreationOpen = false;
                arCtrl.postingOpen = true;
            };

            arCtrl.openAdjustmentSubModule = function(){
                arCtrl.adjustmentSubModule = true;
                arCtrl.processSubModule = false;
                arCtrl.paymentsSubModule = false;
                arCtrl.adminSubModule = false;
                arCtrl.inquirySubModule = false;
            };

            arCtrl.openProcessSubModule = function(){
                arCtrl.adjustmentSubModule = false;
                arCtrl.processSubModule = true;
                arCtrl.paymentsSubModule = false;
                arCtrl.adminSubModule = false;
                arCtrl.inquirySubModule = false;
            };

            arCtrl.openPaymentsSubModule = function(){
                arCtrl.adjustmentSubModule = false;
                arCtrl.processSubModule = false;
                arCtrl.paymentsSubModule = true;
                arCtrl.adminSubModule = false;
                arCtrl.inquirySubModule = false;
            };

            arCtrl.openAdminSubModule = function(){
                arCtrl.adjustmentSubModule = false;
                arCtrl.processSubModule = false;
                arCtrl.paymentsSubModule = false;
                arCtrl.adminSubModule = true;
                arCtrl.inquirySubModule = false;
            };

            arCtrl.openInquirySubModule = function(){
                arCtrl.adjustmentSubModule = false;
                arCtrl.processSubModule = false;
                arCtrl.paymentsSubModule = false;
                arCtrl.adminSubModule = false;
                arCtrl.inquirySubModule = true;
            };


        }]);

})();