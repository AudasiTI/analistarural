//var app = angular.module("soilApp",["ngRoute"]);
//
//app.config(["$routeProvider", function($routeProvider){
//	$routeProvider.when("/importReports",{
//		templateUrl:'views/html/import.html',
//		controller:'importController'
//	}).when("/reports",{
//		templateUrl:'views/html/reports.html',
//		controller:'reportsController'
//	}).otherwise({
//		redirectTo:'/reports'
//	});
//}]);

(function() {

	var app = angular.module('infoSoilAdmin', [ 'ngRoute' ]);

	app.config([ '$routeProvider', function($routeProvider) {

		var viewBase = '/app/';

		$routeProvider.when("/importReports", {
			templateUrl : viewBase + 'report/import.html',
			controller : 'ImportReportController',
			controllerAs : 'vm'
		}).otherwise({
			redirectTo : '/importReports'
		})

	} ]);
}());