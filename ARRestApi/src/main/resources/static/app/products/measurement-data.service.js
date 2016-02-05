(function() {
    'use strict';

    angular
        .module('analistaRural.measurement')
        .factory('measurementDataService', measurementDataService);

    /* @ngInject */
    function measurementDataService($http, $location, $q, exception, logger) {
    	
        var isPrimed = false;
        var primePromise;

        
        var serviceBase = "/api/measurements/"

        var service = {
        	getMeasurements: getMeasurements,
        	getMeasurementById: getMeasurementById,
        	newMeasurement: newMeasurement,
        	insertMeasurement : insertMeasurement,
        	deleteMeasurement : deleteMeasurement,
            ready: ready
        };

        return service;

        function getMeasurements() {
            return $http.get(serviceBase)
                .then(results)
                .catch(function(message) {
                    exception.catcher('XHR Failed for getMeasurements')(message);
                    $location.url('/');
                });

            function results(data, status, headers, config) {
                return data.data;
           }
        }
        
        function getMeasurementById(idMeasurement) {
            return $http.get(serviceBase + idMeasurement)
                .then(results)
                .catch(function(message) {
                    exception.catcher('XHR Failed for getMeasurementById')(message);
                    $location.url('/');
                });

            function results(data, status, headers, config) {
                return data.data;
            }
        }
        

        function insertMeasurement(measurement) {
            return $http.post(serviceBase, measurement).then(function (results) {
                measurement.idMeasurement = results.data.idMeasurement;
                return results.data;
            });
        };
        

        function deleteMeasurement(idMeasurement) {
            return $http.delete(serviceBase + idMeasurement).then(function (results) {
                return results.data;
            });
        };
        
        function newMeasurement() {
            return $q.when({idMeasurement: 0});
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