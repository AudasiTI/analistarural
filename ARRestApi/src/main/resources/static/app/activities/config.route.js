(function() {
	'use strict';

	angular.module('analistaRural.activities').run(appRun);

	// appRun.$inject = ['routehelper']

	/* @ngInject */
	function appRun(routehelper) {
		routehelper.configureRoutes(getRoutes());
	}

	function getRoutes() {
		return [ {
			url : '/activities',
			config : {
				templateUrl : 'app/activities/activities.html',
				controller : 'ActivitiesController',
				controllerAs : 'vm'
			}
		} ];
	}
})();
