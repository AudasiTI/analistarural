(function() {
	'use strict';

	angular.module('analistaRural.fields').run(appRun);

	// appRun.$inject = ['routehelper']

	/* @ngInject */
	function appRun(routehelper) {
		routehelper.configureRoutes(getRoutes());
	}

	function getRoutes() {
		return [ {
			url : '/fields',
			config : {
				templateUrl : 'app/fields/fields.html',
				controller : 'FieldsController',
				controllerAs : 'vm'
			}
		}, {
			url : '/fields/add',
			config : {
				templateUrl : 'app/fields/fieldsAdd.html',
				controller : 'FieldsAddController',
				controllerAs : 'vm'
			}
		}, {
			url : '/fields/add/:fieldId',
			config : {
				templateUrl : 'app/fields/fieldsAdd.html',
				controller : 'FieldsAddController',
				controllerAs : 'vm'
			}
		} ];
	}
})();
