(function() {

	'use strict';

	angular.module('analistaRural.fields').controller('FieldsAddController',
			FieldsAddController);

	function FieldsAddController(fieldsDataService, farmsDataService,
			$routeParams, $scope, $location, $timeout, logger, $uibModal, $log) {

		var vm = this;
		var fieldId = ($routeParams.fieldId) ? parseInt($routeParams.fieldId)
				: 0;
		var systemAccount = 1;
		var onRouteChangeOff;
		var timer;

		vm.field = {};
		vm.farms = [];
		vm.groupField = [];
		vm.title = (fieldId > 0) ? 'Editar' : 'Adicionar';
		vm.buttonText = (fieldId > 0) ? 'Atualizar' : 'Adicionar';
		vm.updateStatus = false;
		vm.errorMessage = '';
		vm.shouldDeleteField = false;

		vm.animationsEnabled = true;

		function activate() {
			getFarms().then(
					function() {
						if (fieldId > 0) {
							fieldsDataService.getFieldById(fieldId).then(
									function(field) {
										vm.field = field;
									}, processError);
						} else {
							fieldsDataService.newField().then(function(field) {
								vm.field = field;
							});
						}
					});

			// Make sure they're warned if they made a change but didn't save it
			// Call to $on returns a "deregistration" function that can be
			// called to
			// remove the listener (see routeChange() for an example of using
			// it)
			onRouteChangeOff = $scope.$on('$locationChangeStart', routeChange);
		}

		vm.isFarmSelected = function(fieldFarmId, farmId) {
			return fieldFarmId === farmId;
		};

		vm.saveField = function() {

			vm.field.systemAccount = systemAccount;

			if ($scope.editForm.$valid) {
				// if (!vm.field.id) {
					fieldsDataService.insertField(vm.field).then(
							processSuccess, processError);
				} // else {
					// fieldsDataService.updateField(vm.field).then(
						// processSuccess, processError);
				// }
			//}
		};

		vm.modalOpenDelete = function() {
			var modalInstance = $uibModal.open({
				animation : $scope.animationsEnabled,
				templateUrl : 'myModalContent.html',
				controller : 'ModalInstanceCtrl',
				size : null,
				resolve : {

				}
			});

			modalInstance.result.then(function() {
				vm.deleteField();
			}, function() {
				$log.info('Modal dismissed at: ' + new Date());
			});

		};

		vm.deleteField = function() {
			// if (vm.shouldDeleteField) {
			fieldsDataService.deleteField(vm.field.id).then(function() {
				onRouteChangeOff(); // Stop listening for location
				// changes
				$location.path('/fields');
			}, processError);
			// }
		}

		activate();

		function routeChange(event, newUrl, oldUrl) {
			// Navigate to newUrl if the form isn't dirty
			if (!vm.editForm || !vm.editForm.$dirty)
				return;

			var modalInstance = $uibModal.open({
				animation : $scope.animationsEnabled,
				templateUrl : 'myModalContent.html',
				controller : 'ModalInstanceCtrl',
				size : null,
				resolve : {

				}
			});

			modalInstance.result.then(function() {
				onRouteChangeOff(); // Stop listening for location changes
				$location.path($location.url(newUrl).hash()); // Go to
				// page
				// they're
				// interested
				// in
			}, function() {
				$log.info('Modal dismissed at: ' + new Date());
			});

			// prevent navigation by default since we'll handle it
			// once the user selects a dialog option
			event.preventDefault();
			return;
		}

		function getFarms() {
			return farmsDataService.getFarms(systemAccount).then(
					function(farms) {
						vm.farms = farms;
					}, processError);
		}

		function processSuccess() {
			$scope.editForm.$dirty = false;
			vm.updateStatus = true;
			vm.title = 'Editar';
			vm.buttonText = 'Atualizar';
			startTimer();
		}

		function processError(error) {
			vm.errorMessage = error.message;
			startTimer();
		}

		function startTimer() {
			timer = $timeout(function() {
				$timeout.cancel(timer);
				vm.errorMessage = '';
				vm.updateStatus = false;
				$location.path('/fields');
			}, 1000);
		}

	}
})();
