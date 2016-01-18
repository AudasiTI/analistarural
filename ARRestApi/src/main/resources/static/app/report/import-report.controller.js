(function() {

	'use strict';

	angular
			.module('infoSoilAdmin')
			.controller(
					'ImportReportController',
					function($scope, XLSXReaderService, reportService, $window) {

						var vm = this;

						vm.reports = [];

						$scope.showPreview = true;
						$scope.showJSONPreview = false;
						$scope.json_string = "";
						$scope.selectedSheetName = "Planilha1";
						$scope.colunas = "";

						$scope.listaLaudos = [];

						$scope.showPreviewChanged2 = function(files) {

							if ($scope.showPreview) {
								$scope.sheets = [];
								$scope.showJSONPreview = false;
								$scope.isProcessing = true;
								$scope.colunas = [ "Laudo", "Fazenda",
										"Município", "Data de Geração",
										"Status", "Importar" ];

								$scope.tamanho = files.length;
								var i = 0;
								for (i = 0; i < files.length; i++) {
									$scope.planilha = [];
									$scope.excelFile = files[i];

									XLSXReaderService
											.readFile($scope.excelFile,
													$scope.showPreview,
													$scope.showJSONPreview)
											.then(
													function(xlsxData) {
														$scope.laudo = "";
														$scope.sheets = xlsxData.sheets;
														$scope.isProcessing = false;
														$scope.planilha = $scope.sheets[$scope.selectedSheetName].data;
														vm
																.addReport($scope.planilha);
														$scope.laudo = {
															numero : $scope.planilha[4][8],
															fazenda : $scope.planilha[4][4],
															municipio : $scope.planilha[4][5],
															geracao : $scope.planilha[4][2],
															impotar : true
														};

														$scope.listaLaudos
																.push($scope.laudo);

													});

								}

							}
							// vm.getReports("joao");

						}

						// vm.getReports = function(email) {
						// reportService
						// .getReports(email)
						// .then(
						// function(data) {
						// vm.reports = data;
						// },
						// function(error) {
						// $window
						// .alert('Sorry, an error occurred: '
						// + error.data.message);
						// });
						//
						// }
						vm.resultado = "";
						vm.addReport = function(file) {
							reportService.insertReport(file).then(
									function(data) {
										vm.resultado = data;
									});
						}
					});

})();