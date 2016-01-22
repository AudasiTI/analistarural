(function() {

	'use strict';

	angular.module('infoSoilAdmin').controller(
			'ViewReportController',

			function($scope, reportService, $window) {

				var vm = this;

				vm.filtro = "";

				vm.textopesquisa = "";

				$scope.reports = [];

				$scope.colunas = "";

				$scope.buscarLaudos = function() {

					$scope.colunas = [ "Laudo", "Fazenda", "E-mail Principal",
							"E-mail Secundário", "Detalhes", "Remover" ];

					vm.getReports();

				}

				vm.getReports = function() {
					reportService.getReports().then(
							function(data) {
								$scope.reports = data;
							},
							function(error) {
								$window.alert('Sorry, an error occurred: '
										+ error.data.message);
							});
				}

				vm.exibirDetalhes = function(code) {
				}
			});

})();