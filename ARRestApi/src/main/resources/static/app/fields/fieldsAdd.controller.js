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

		$scope.items = [ 'item1', 'item2', 'item3' ];

		$scope.animationsEnabled = true;

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
				if (!vm.field.id) {
					fieldsDataService.insertField(vm.field).then(
							processSuccess, processError);
				} else {
					fieldsDataService.updateField(vm.field).then(
							processSuccess, processError);
				}
			}
		};

		$scope.open = function(size) {
			var modalInstance = $uibModal.open({
				animation : $scope.animationsEnabled,
				templateUrl : 'app/modal/modal.html',
				controller : 'ModalInstanceCtrl',
				size : size,
				resolve : {
					items : function() {
						return $scope.items;
					}
				}
			});

			modalInstance.result.then(function(selectedItem) {
				$scope.selected = selectedItem;
			}, function() {
				$log.info('Modal dismissed at: ' + new Date());
			});

		}
		vm.deleteField = function() {

			$scope.open('lg');
			var fieldName = vm.field.name;

			var modalOptions = {
				closeButtonText : 'Cancelar',
				actionButtonText : 'Delete Área',
				headerText : 'Delete ' + fieldName + '?',
				bodyText : 'Tem certeza que deseja deletar essa área?'
			};

			// modalService.showModal({}, modalOptions).then(function(result) {
			// if (result === 'ok') {
			// fieldDataService.deleteField(vm.field.id).then(function() {
			// onRouteChangeOff(); // Stop listening for location
			// // changes
			// $location.path('/fields');
			// }, processError);
			// }
			// });

		};

		activate();

		function routeChange(event, newUrl, oldUrl) {
			// Navigate to newUrl if the form isn't dirty
			if (!vm.editForm || !vm.editForm.$dirty)
				return;

			var modalOptions = {
				closeButtonText : 'Cancel',
				actionButtonText : 'Ignore Changes',
				headerText : 'Unsaved Changes',
				bodyText : 'You have unsaved changes. Leave the page?'
			};

			modalService.showModal({}, modalOptions).then(function(result) {
				if (result === 'ok') {
					onRouteChangeOff(); // Stop listening for location changes
					$location.path($location.url(newUrl).hash()); // Go to
					// page
					// they're
					// interested
					// in
				}
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
			}, 3000);
		}

	}
})();
