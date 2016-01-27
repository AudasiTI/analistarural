(function(undefined) {
	// Get angular app
	var app = angular.module("infoSoilAdmin");

	app.factory("XLSReaderService", [ '$q', '$rootScope',
			function($q, $rootScope) {
				var service = function(data) {
					angular.extend(this, data);
				};

				service.readFile = function(file, readCells, toJSON) {
					var deferred = $q.defer();

					XLSReader(file, readCells, toJSON, function(data) {
						$rootScope.$apply(function() {
							deferred.resolve(data);
						});
					});

					return deferred.promise;
				}

				return service;
			} ]);
}).call(this);