(function() {
    'use strict';

    angular
        .module('analistaRural.fields')
        .factory('fieldsDataService', fieldsDataService);

    /* @ngInject */
    function fieldsDataService($http, $location, $q, exception, logger) {
    	
        var isPrimed = false;
        var primePromise;

        
        var serviceBase = "/api/fields/"

        var service = {
        	getFields: getFields,
        	getFieldById: getFieldById,
        	newField: newField,
        	insertField : insertField,
            ready: ready
        };

        return service;

        function getFields(systemAccount) {
            return $http.get(serviceBase + 'systemaccount/' + systemAccount)
                .then(results)
                .catch(function(message) {
                    exception.catcher('XHR Failed for getFields')(message);
                    $location.url('/');
                });

            function results(data, status, headers, config) {
                return data.data;
            }
        }
        
        function getFieldById(fieldId) {
            return $http.get(serviceBase + fieldId)
                .then(results)
                .catch(function(message) {
                    exception.catcher('XHR Failed for getFields')(message);
                    $location.url('/');
                });

            function results(data, status, headers, config) {
                return data.data;
            }
        }
        

        function insertField(field) {
            return $http.post(serviceBase, field).then(function (results) {
                field.id = results.data.id;
                return results.data;
            });
        };
        
        function newField() {
            return $q.when({id: 0});
        };

        function prime() {
            // This function can only be called once.
            if (primePromise) {
                return primePromise;
            }

            primePromise = $q.when(true).then(success);
            return primePromise;

            function success() {
                isPrimed = true;
                logger.info('Primed data');
            }
        }

        function ready(nextPromises) {
            var readyPromise = primePromise || prime();

            return readyPromise
                .then(function() { return $q.all(nextPromises); })
                .catch(exception.catcher('"ready" function failed'));
        }

    }
})();