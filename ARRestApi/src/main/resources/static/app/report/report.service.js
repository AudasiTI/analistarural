(function() {

	var injectParams = [ '$http', '$q' ];

	var reportFactory = function($http, $q) {

		var serviceBase = '/api/reports/', factory = {};

		factory.getReportsByEmail = function(email) {
			return $http.get(serviceBase + email).then(function(results) {
				return results.data;
			});
		};
		
		factory.getReports = function() {
			return $http.get(serviceBase).then(function(results) {
				return results.data;
			});
		};

		factory.insertReport = function(file) {
			return $http.post('/api/relatorio/', file).then(function(results) {
				// report.id = results.data.id;
				return results.data;
			});
		};

		return factory;
	};

	reportFactory.$inject = injectParams;

	angular.module('infoSoilAdmin').factory('reportService', reportFactory);

}());