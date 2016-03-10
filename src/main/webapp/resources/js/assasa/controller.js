/**
 * Created by VD on 2/20/2016.
 */


var testController = function ($scope,assasaGateway){
    //var testController = function ($scope,Item){
    $scope.customers = "This is customer";

    $scope.getList = function(){
        console.log('There a');
        var data = {
            agentId:'1234'
        };
        $scope.items = assasaGateway.add({add:'123'},data);
    };

    $scope.addType = function(){

        var pathVariables = {
            typeName:'Shalwar'
        };


        assasaGateway.addType(pathVariables,{});
    };

    $scope.addSupplier = function(){


        var postBody = {
            name: 'Abc Supplier',
            mobileNumber: '03142039839',
            phoneNumber: '02112545414',
            officeNumber: '0215415115',
            locationAddress: 'aslaslfkjsflk',
            city: 'Karachi',
            country: 'Pakistan'
        };

        assasaGateway.addSupplier(postBody);

    };
};

assasaApp.controller('testController',testController);

