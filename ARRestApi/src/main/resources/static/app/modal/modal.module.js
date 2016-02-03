angular.module('analistaRural').controller('ModalInstanceCtrl',
		function($scope, $uibModalInstance) {

			$scope.ok = function() {
				$uibModalInstance.close(true);
			};

			$scope.cancel = function() {
				$uibModalInstance.dismiss('cancel');
			};
		});