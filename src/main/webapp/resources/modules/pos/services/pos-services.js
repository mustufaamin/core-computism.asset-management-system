/**
 * Created by VD on 5/8/2016.
 */
angular.module('Asasa')
    .service('PosOrderGatewayService', ['$resource', function ($resource) {
        var posOrderGatewayService = this;
        return $resource('', {},
            {
                saveOrder:{method: 'POST', isArray: false, url: '/order/save'}
            });
    }]);

angular.module('Asasa')
    .service('PosPaymentGatewayService', ['$resource', function ($resource) {
        var posPaymentGatewayService = this;
        return $resource('', {},
            {
              doPayment:{method: 'POST', isArray: false, url: '/posPayment/add'}

            });
    }]);

angular.module('Asasa')
    .service('PosItemGetewayService', ['$resource', function ($resource) {
        var posItemGatewayService = this;
        return $resource('', {},
            {
                getPosItem: {method: 'GET', isArray: false, url: '/item/get/:itemCode'}
            });
    }]);

