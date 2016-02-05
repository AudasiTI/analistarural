(function() {
	'use strict';

	angular.module('analistaRural.measurement').run(appRun);

	// appRun.$inject = ['routehelper']

	/* @ngInject */
	function appRun(routehelper) {
		routehelper.configureRoutes(getRoutes());
	}

	function getRoutes() {
		return [ {
			url : '/measurements',
			config : {
				templateUrl : 'app/products/measurement.html',
				controller : 'MeasurementController',
				controllerAs : 'vm'
			}
		}, {
			url : '/measurements/add',
			config : {
				templateUrl : 'app/products/measurementAdd.html',
				controller : 'MeasurementAddController',
				controllerAs : 'vm'
			}
		}, {
			url : '/measurements/add/:idMeasurement',
			config : {
				templateUrl : 'app/products/measurementAdd.html',
				controller : 'MeasurementAddController',
				controllerAs : 'vm'
			}
		} ];
	}
})();
