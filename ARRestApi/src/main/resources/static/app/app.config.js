(function() {

	var app = angular.module('infoSoilAdmin', [ 'ngRoute', 'ngAnimate',
			'ui.bootstrap' ]);

	app.config([ '$routeProvider', function($routeProvider) {

		var viewBase = '/app/';

		$routeProvider.when("/importReports", {
			templateUrl : viewBase + 'report/import.html',
			controller : 'ImportReportController',
			controllerAs : 'vm'
		}).when("/viewReports", {
			templateUrl : viewBase + 'report/view.html',
			controller : 'ViewReportController',
			controllerAs : 'vm',
			secure : true
		// This route requires an authenticated user
		}).when('/login/:redirect*?', {
			controller : 'LoginController',
			templateUrl : viewBase + 'login/login.html',
			controllerAs : 'vm'
		}).otherwise({
			redirectTo : '/importReports'
		})

	} ]);

	app.run([
			'$rootScope',
			'$location',
			'authService',
			function($rootScope, $location, authService) {

				// Client-side security. Server-side framework MUST add it's
				// own security as well since client-based security is easily
				// hacked
				$rootScope.$on("$routeChangeStart", function(event, next,
						current) {
					if (next && next.$$route && next.$$route.secure) {
						if (!authService.user.isAuthenticated) {
							$rootScope.$evalAsync(function() {
								authService.redirectToLogin();
							});
						}
					}
				});

			} ]);
}());