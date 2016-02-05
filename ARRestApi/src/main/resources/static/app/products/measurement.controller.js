(function() {

	'use strict';

	angular.module('analistaRural.measurement').controller(
			'MeasurementController', MeasurementController);

	function MeasurementController(measurementDataService, logger) {

		var vm = this;
		vm.measurements = [];

		activate();

		function activate() {

			return getMeasurements().then(function() {
				logger.info('Activated Measurement View');
			});
		}

		function getMeasurements() {
			return measurementDataService.getMeasurements().then(
					function(data) {
						vm.measurements = data;
						return vm.measurements;
					});
		}

	}
})();
