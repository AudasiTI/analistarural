(function() {

	'use strict';

	angular.module('analistaRural.measurement').controller(
			'MeasurementAddController', MeasurementAddController);

	function MeasurementAddController(measurementDataService, $routeParams,
			$scope, $location, $timeout, logger, $uibModal, $log) {

		var vm = this;
		var idMeasurement = ($routeParams.idMeasurement) ? parseInt($routeParams.idMeasurement)
				: 0;
		//var idMeasurement = $routeParams.idMeasurement;
		var onRouteChangeOff;
		var timer;

		vm.measurement = {};
		vm.title = (idMeasurement > 0) ? 'Editar' : 'Adicionar';
		vm.buttonText = (idMeasurement > 0) ? 'Atualizar' : 'Adicionar';
		vm.updateStatus = false;
		vm.errorMessage = '';
		vm.shouldDeleteMeasurement = false;

		vm.animationsEnabled = true;

		function activate() {
			if (idMeasurement > 0) {
				measurementDataService.getMeasurementById(idMeasurement).then(
						function(measurement) {
							vm.measurement = measurement;
						}, processError);
			} else {
				measurementDataService.newMeasurement().then(
						function(measurement) {
							vm.measurement = measurement;
						});

			}
			;

			// Make sure they're warned if they made a change but didn't save it
			// Call to $on returns a "deregistration" function that can be
			// called to
			// remove the listener (see routeChange() for an example of using
			// it)
			onRouteChangeOff = $scope.$on('$locationChangeStart', routeChange);
		}
		;

		vm.saveMeasurement = function() {

			// vm.field.systemAccount = systemAccount;

			if ($scope.editForm.$valid) {
				//if (!vm.measurement.id) {
					measurementDataService.insertMeasurement(vm.measurement)
							.then(processSuccess, processError);
				//} else {
					//measurementDataService.updateMeasurement(vm.measurement)
						//	.then(processSuccess, processError);
				//}
			}
			
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
				vm.deleteMeasurement();
			}, function() {
				$log.info('Modal dismissed at: ' + new Date());
			});

		};

		vm.deleteMeasurement = function() {
			// if (vm.shouldDeleteField) {
			measurementDataService.deleteMeasurement(
					vm.measurement.idMeasurement).then(function() {
				onRouteChangeOff(); // Stop listening for location
				// changes
				$location.path('/measurements');
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
				$location.path('/measurements');
			}, 1000);
		}

	}
})();
