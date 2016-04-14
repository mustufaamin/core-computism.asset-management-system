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
        .controller('CustomerController', ['CustomerGatewayService', 'CountryService', 'CityService', '$http', function(custGatewaySrv, countrySrv, citySrv, $http){
            var custCtrl = this;
            custCtrl.showPanel = false;
            custCtrl.isView = false;
            custCtrl.slidePanelHeading = '';
            custCtrl.listCustomer = [];
            custCtrl.listCountry = [];
            custCtrl.listRelevantCities = [];

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

            custCtrl.getCustomerList();
            custCtrl.getCountries();

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

            custCtrl.addCustomer = function (){
                var customer = {};
                customer.firstName = custCtrl.firstName;
                customer.lastName = custCtrl.lastName;
                customer.phoneNumber = custCtrl.phone;
                customer.mobileNumber = custCtrl.mobile;
                customer.email = custCtrl.email;
                customer.locationAddress = custCtrl.address;
                customer.cityId = custCtrl.city.id;
                customer.city = custCtrl.city.name;
                custGatewaySrv.addCustomer(customer).$promise.then(function(response){
                    if(response){

                    }
                });
            };

            custCtrl.openCustomerSlidePanel = function(type, customer){
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

                addCustomer: {method: 'POST', isArray: false, url: '/customer/add'}
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
