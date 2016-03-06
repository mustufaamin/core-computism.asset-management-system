assasaApp.service('assasaGateway', function ($resource) {
    return $resource('',{},
        {
            addItem: {method: 'POST',isArray: false,url:'item/:add'},
            addItemType: {method: 'POST',isArray: false,url:'/item/addType/:typeName'},

            /*Supplier Methods*/
            addSupplier:{method: 'POST',isArray: false,url:'/supplier/add'},

            /*Customer Methods*/
            addCustomer:{method: 'POST',isArray: false,url:'/customer/add'}
        });
});
