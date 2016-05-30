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
        .controller('CustomerController', ['ngTableParams', 'CustomerGatewayService', 'CountryService', 'CityService', '$http', function(ngTableParams, custGatewaySrv, countrySrv, citySrv, $http){
            var custCtrl = this;
            custCtrl.showPanel = false;
            custCtrl.isView = false;
            custCtrl.slidePanelHeading = '';
            custCtrl.listCustomer = [];
            custCtrl.listCountry = [];
            custCtrl.listRelevantCities = [];

            custCtrl.customerListPanel = false;
            custCtrl.customerAddPanel = false;
            custCtrl.customerProfilePanel = false;

            custCtrl.openCustomerList = function(){
                custCtrl.customerListPanel = true;
                custCtrl.customerAddPanel = false;
                custCtrl.customerProfilePanel = false;
                custCtrl.getCustomerList();
                custCtrl.getCountries();
            };

            custCtrl.openCustomerAddForm = function(){
                custCtrl.customerListPanel = false;
                custCtrl.customerAddPanel = true;
                custCtrl.customerProfilePanel = false;
            };

            custCtrl.openCustomerProfile = function(){
                custCtrl.customerListPanel = false;
                custCtrl.customerAddPanel = false;
                custCtrl.customerProfilePanel = true;
            };

            custCtrl.cols = [
                {field: "itemCode",title: "Item Code",sortable: "itemCode",filter: {itemCode: "number"},show: true,dataType: "text"},
                {field: "itemDescription",title: "Description ",sortable: "itemDescription",filter: {itemDescription: "text"},show: true,dataType: "text"},
                {field: "costPrice",title: "Price ",sortable: "costPrice",filter: {costPrice: "number"},show: true,dataType: "text"},
                {field: "action",title: "Actions",sortable: "action",filter: {action: "number"},show: true,dataType: "command"}
            ];

            custCtrl.itemTable = new ngTableParams({
                page: 1,
                count: 10
            }, {
                total: custCtrl.listCustomer.length,
                getData: function ($defer, params) {
                    console.log(custCtrl.listCustomer);
                    custCtrl.data = custCtrl.listCustomer.slice((params.page() - 1) * params.count(), params.page() * params.count());
                    $defer.resolve(custCtrl.data);
                }
            });

            custCtrl.getCustomerList = function(){
                custCtrl.listCustomer = [];
                custGatewaySrv.listCustomer().$promise.then(function(response){
                    if(response != null){
                        for(var i = 0; i < response.data.length; i++){
                            var customer = {};
                            customer.id = response.data[i].id;
                            customer.firstName = response.data[i].firstName;
                            customer.lastName = response.data[i].lastName;
                            customer.locationAddress = response.data[i].locationAddress;
                            customer.phoneNumber = response.data[i].phoneNumber;
                            customer.mobileNumber = response.data[i].mobileNumber;
                            customer.email = response.data[i].email;
                            customer.cityId = response.data[i].cityId;

                            custCtrl.listCustomer.push(customer);
                        }
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
