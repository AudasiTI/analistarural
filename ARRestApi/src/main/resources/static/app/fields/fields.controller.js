(function() {

	'use strict';

	angular.module('analistaRural.fields').controller('FieldsController',
			FieldsController);

	function FieldsController(fieldsDataService, farmsDataService, logger) {

		var vm = this;
		vm.fields = [];
		vm.systemAccount = 1;

		activate();

		function activate() {

			return getFarms(vm.systemAccount).then(function() {
				logger.info('Activated fields View');
			});
		}

		function getFarms(accountID) {
			return farmsDataService.getFarms(accountID).then(function(data) {
				vm.farms = data;
				return vm.farms;
			});
		}

		function getFields(systemAccount) {
			return fieldsDataService.getFields(systemAccount).then(
					function(data) {
						vm.fields = data;
						return vm.fields;
					});
		}

	}
})();
