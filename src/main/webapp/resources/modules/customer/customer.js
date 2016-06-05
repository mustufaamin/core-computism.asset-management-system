/**
 * Created by Muhammad Umer on 3/12/2016.
 */
(function(){
    angular.module('Asasa')
        .directive('customerPanel', function(){
        return{
            restrict: "E",
            templateUrl: 'resources/modules/customer/templates/customer-panel.jsp'
        }
    });

    angular.module('Asasa')
        .directive('addEditCustomerSlidePanel', function(){
        return{
            restrict: "E",
            templateUrl: 'resources/modules/customer/templates/add-edit-customer-slide-panel.jsp'
        }
    });

    angular.module('Asasa')
        .controller('CustomerController', ['$scope', 'ngTableParams', 'CustomerGatewayService', 'CountryService', 'CityService', '$http', '$timeout', '$document', function($scope, ngTableParams, custGatewaySrv, countrySrv, citySrv, $http, $timeout, $document){
            var custCtrl = this;
            custCtrl.showPanel = false;
            custCtrl.isView = false;
            custCtrl.slidePanelHeading = '';
            custCtrl.listCustomer = [];
            custCtrl.listCountry = [];
            custCtrl.listRelevantCities = [];

            custCtrl.customerListPanel = false;
            custCtrl.customerProfilePanel = false;

            custCtrl.quotationOpen = false;
            custCtrl.pastOrdersOpen = false;
            custCtrl.pastPaymentsOpen = false;
            custCtrl.isCustomerPanelOpen = false;

            angular.element($document).ready(function () {
                if(custCtrl.isCustomerPanelOpen){
                    custCtrl.openCustomerList();
                }
            });


            custCtrl.openQuotationList = function(){
                custCtrl.quotationOpen = true;
                custCtrl.pastOrdersOpen = false;
                custCtrl.pastPaymentsOpen = false;
            };

            custCtrl.openPastOrderList = function(){
                custCtrl.quotationOpen = false;
                custCtrl.pastOrdersOpen = true;
                custCtrl.pastPaymentsOpen = false;
            };

            custCtrl.openPastPaymentsList = function(){
                custCtrl.quotationOpen = false;
                custCtrl.pastOrdersOpen = false;
                custCtrl.pastPaymentsOpen = true;
            };

            custCtrl.openCustomerList = function(){
                custCtrl.customerListPanel = true;
                custCtrl.customerProfilePanel = false;
                custCtrl.getCustomerList();
                custCtrl.getCountries();
            };

            custCtrl.openCustomerProfile = function(){
                custCtrl.customerListPanel = false;
                custCtrl.customerProfilePanel = true;
            };

            custCtrl.cols = [
                {field: "command",title: "",sortable: "command",filter: {command: "command"},show: true,dataType: "command"},
                {field: "firstName",title: "First Name",sortable: "firstName",filter: {firstName: "text"},show: true,dataType: "text"},
                {field: "lastName",title: "Last Name",sortable: "lastName",filter: {lastName: "text"},show: true,dataType: "text"},
                {field: "phoneNumber",title: "Phone Number",sortable: "phoneNumber",filter: {phoneNumber: "number"},show: true,dataType: "number"},
                {field: "mobileNumber",title: "Mobile Number",sortable: "mobileNumber",filter: {mobileNumber: "number"},show: true,dataType: "number"},
                {field: "email",title: "Email",sortable: "email",filter: {email: "text"},show: true,dataType: "text"},
                {field: "locationAddress",title: "Address",sortable: "locationAddress",filter: {locationAddress: "text"},show: true,dataType: "text"},
                {field: "cityId",title: "City Id",sortable: "cityId",filter: {cityId: "number"},show: false,dataType: "number"},
                {field: "cityName",title: "City Name",sortable: "cityName",filter: {cityName: "text"},show: true,dataType: "text"},
                {field: "customerStatus",title: "Status",sortable: "customerStatus",filter: {customerStatus: "number"},show: true,dataType: "number"},
                {field: "customerTypeId",title: "CCT Id",sortable: "customerTypeId",filter: {customerTypeId: "number"},show: false,dataType: "number"},
                {field: "customerTypeName",title: "Customer Type Name",sortable: "customerTypeName",filter: {customerTypeName: "text"},show: true,dataType: "text"}
            ];

            custCtrl.itemTable = new ngTableParams({
                page: 1,
                count: 10
            }, {
                total: custCtrl.listCustomer.length,
                getData: function ($defer, params) {
                    custCtrl.data = custCtrl.listCustomer.slice((params.page() - 1) * params.count(), params.page() * params.count());
                    $defer.resolve(custCtrl.data);
                }
            });

            custCtrl.getCustomerList = function(){
                custCtrl.listCustomer = [];
                custGatewaySrv.listCustomer().$promise.then(function(response){
                    if(response != null){
                        custCtrl.listCustomer = response.data;
                        custCtrl.itemTable.total(custCtrl.listCustomer.length);
                        custCtrl.itemTable.reload();
                    }
                });
            };

            custCtrl.getCountries = function(){
                custCtrl.listCountry = [];
                countrySrv.getCountriesList().$promise.then(function(response){
                    if(response != null){
                        for(var i = 0; i < response.data.length; i++){
                            var country = {};
                            country.id = response.data[i].id;
                            country.name = response.data[i].name;
                            custCtrl.listCountry.push(country);
                        }
                    }
                });
            };

            custCtrl.onSelectCountry = function(country){
                if(country != null){
                    if(country.id != null){
                        custCtrl.listRelevantCities = [];
                        citySrv.getRelevantCities({countryId:country.id}).$promise.then(function(response){
                            if(response != null){
                                for(var i = 0; i < response.data.length; i++){
                                    var city = {};
                                    city.id = response.data[i].id;
                                    city.name = response.data[i].name;
                                    city.state = response.data[i].state;
                                    city.countryId = response.data[i].country_id;
                                    custCtrl.listRelevantCities.push(city);
                                }
                            }
                        });
                    }
                }
            };

            custCtrl.addUpdateCustomer = function (){
                var customer = {};
                customer.firstName = custCtrl.firstName;
                customer.lastName = custCtrl.lastName;
                customer.phoneNumber = custCtrl.phone;
                customer.mobileNumber = custCtrl.mobile;
                customer.email = custCtrl.email;
                customer.locationAddress = custCtrl.address;
                customer.cityId = custCtrl.city.id;
                customer.city = custCtrl.city.name;
                if(custCtrl.type == 1){
                    custGatewaySrv.addCustomer(customer).$promise.then(function(response){
                        if(response.success){
                            custCtrl.showPanel = false;
                            custCtrl.getCustomerList();
                        }
                    });
                }else{
                    custGatewaySrv.updateCustomer(customer).$promise.then(function(response){
                        if(response.success){
                            custCtrl.showPanel = false;
                            custCtrl.getCustomerList();
                        }
                    });
                }

            };

            custCtrl.openCustomerSlidePanel = function(type, customer){
                custCtrl.type = type;
                if(customer != null){
                    custCtrl.firstName = customer.firstName;
                    custCtrl.lastName = customer.lastName;
                    custCtrl.phone = customer.phoneNumber;
                    custCtrl.mobile = customer.mobileNumber;
                    custCtrl.email = customer.email;
                    custCtrl.address = customer.locationAddress;
                    custCtrl.city = custCtrl.getCityModel(customer.cityId);
                    custCtrl.country = custCtrl.getCountryModel(customer.countryId);
                }
                custCtrl.showPanel = true;
                custCtrl.isView = false;
                if(type == 1){
                    custCtrl.slidePanelHeading = "Add Customer";
                }else if(type == 2){
                    custCtrl.slidePanelHeading = "View Customer";
                    custCtrl.isView = true;
                }else{
                    custCtrl.slidePanelHeading = "Edit Customer";
                }
            };

            custCtrl.getCountryModel = function(countryId){
                for(var i = 0; i < custCtrl.listCountry.length; i++){
                    if(custCtrl.listCountry[i].id == countryId){
                        return custCtrl.listCountry[i];
                    }
                }
            };

            custCtrl.getCityModel = function(cityId){
                for(var i = 0; i < custCtrl.listRelevantCities.length; i++){
                    if(custCtrl.listRelevantCities[i].id == cityId){
                        return custCtrl.listRelevantCities[i];
                    }
                }
            };

            $scope.$on("OPEN_CUSTOMER_PANEL", function(events, args){
                custCtrl.isCustomerPanelOpen = true;
            });
    }]);


    /*Customer Gateway*/
    angular.module('Asasa')
        .service('CustomerGatewayService',['$resource' ,function ($resource) {
            var custGatewaySrv = this;
            return $resource('',{},
            {
                listCustomer: {method: 'GET', isArray: false, url: '/customer/list'},

                addCustomer: {method: 'POST', isArray: false, url: '/customer/add'},

                updateCustomer: {method: 'POST', isArray: false, url: '/customer/update'}
            });
    }]);

    angular.module('Asasa')
        .service('CountryService',['$resource' ,function ($resource) {
            var countrySrv = this;
            return $resource('',{},
                {
                    getCountriesList: {method: 'GET', isArray: false, url: '/country/getAll'}

                });
        }]);

    angular.module('Asasa')
        .service('CityService',['$resource' ,function ($resource) {
            var citySrv = this;
            return $resource('',{},
                {
                    getRelevantCities: {method: 'GET', isArray: false, url: '/city/getCities/:countryId'}

                });
        }]);



})();
