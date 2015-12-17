var app = angular.module("soilApp",["ngRoute"]);

app.config(["$routeProvider", function($routeProvider){
	$routeProvider.when("/importReports",{
		templateUrl:'views/html/import.html',
		controller:'importController'
	}).when("/reports",{
		templateUrl:'views/html/reports.html',
		controller:'reportsController'
	}).otherwise({
		redirectTo:'/reports'
	});
}]);