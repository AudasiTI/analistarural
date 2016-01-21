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
						$scope.selectedSheetNameFolha = "Resultados Folha";
						$scope.selectedSheetNameSolo = "Planilha1";
						$scope.colunas = "";

						$scope.teste;

						$scope.listaLaudos = [];

						$scope.showPreviewChanged2 = function(files) {

							if ($scope.showPreview) {
								$scope.sheets = [];
								$scope.showJSONPreview = false;
								$scope.isProcessing = true;
								$scope.colunas = [ "Laudo", "Tipo", "Fazenda",
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

														if ($scope.sheets[$scope.selectedSheetNameSolo] != null) {

															$scope.planilha = $scope.sheets[$scope.selectedSheetNameSolo].data;

															$scope.laudo = {
																numero : $scope.planilha[4][8],
																tipo : "Solo",
																fazenda : $scope.planilha[4][4],
																municipio : $scope.planilha[4][5],
																geracao : new Date(
																		$scope.planilha[4][2]),
																status : null,
																importar : true,
																planilha : $scope.planilha

															};
														} else {

															$scope.planilha = $scope.sheets[$scope.selectedSheetNameFolha].data;

															$scope.laudo = {
																numero : $scope.planilha[6][6],
																tipo : "Foliar",
																fazenda : $scope.planilha[6][2],
																municipio : $scope.planilha[6][3],
																geracao : "",
																status : null,
																importar : true,
																planilha : $scope.planilha
															};
														}

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

						vm.addReport = function(indice) {
							reportService
									.insertReport(
											$scope.listaLaudos[indice].planilha)
									.then(
											function(data) {
												$scope.listaLaudos[indice].status = data.Message;
											});
						}

						$scope.importarLaudos = function() {

							var item;

							for (item in $scope.listaLaudos) {
								if ($scope.listaLaudos[item].importar == true) {
									vm.addReport(item);
								}
							}
						}
					});

})();