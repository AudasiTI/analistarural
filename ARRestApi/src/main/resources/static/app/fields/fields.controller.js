(function() {

	'use strict';

	angular.module('analistaRural.fields').controller('FieldsController',
			FieldsController);

	function FieldsController(fieldsDataService, farmsDataService, logger) {

		var vm = this;
		vm.farms = [];
		vm.fields = [];
		vm.systemAccount = 1;

		activate();

		function activate() {

			return getFarms().then(function() {
				logger.info('Activated fields View');
			});
		}

		function getFarms() {
			return farmsDataService.getFarms(vm.systemAccount).then(
					function(data) {
						vm.farms = data;
						return vm.farms;
					});
		}

		vm.getFields = function(farmID) {
			return fieldsDataService.getFields(farmID).then(function(data) {
				vm.fields = data;
				return vm.fields;
			});
		}

	}
})();
