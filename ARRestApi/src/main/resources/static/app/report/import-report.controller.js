(function() {

	'use strict';

	angular
			.module('infoSoilAdmin')
			.controller(
					'ImportReportController',
					function($scope, XLSReaderService, reportService, $window,
							$log) {

						var vm = this;

						vm.reports = [];

						$scope.selectedSheetNameFolha = "Resultados Folha";
						$scope.selectedSheetNameSolo = "Planilha1";
						$scope.colunas = "";

						$scope.dynamic = 0;

						$scope.listaLaudos = [];

						$scope.showPreviewChanged2 = function(files) {

							$scope.sheets = [];
							$scope.showJSONPreview = false;
							$scope.isProcessing = true;
							$scope.colunas = [ "Laudo", "Tipo", "Fazenda",
									"Município", "E-mail Principal",
									"E-mail Secundário", "Status", "Importar" ];

							$scope.tamanho = files.length;

							var i = 0;

							for (i = 0; i < files.length; i++) {

								$scope.planilha = [];
								$scope.excelFile = files[i];
								XLSReaderService
										.readFile($scope.excelFile, true, false)
										.then(
												function(xlsxData) {
													$scope.laudo = "";
													$scope.sheets = xlsxData.sheets;
													$scope.isProcessing = false;
													$scope.isCollapsed = true;

													if ($scope.sheets[$scope.selectedSheetNameSolo] != null) {
														if (vm
																.validateFile($scope.sheets[$scope.selectedSheetNameSolo].data)) {

															$scope.planilha = $scope.sheets[$scope.selectedSheetNameSolo].data;

															$scope.laudo = {
																numero : $scope.planilha[7][8],
																tipo : "Solo",
																fazenda : $scope.planilha[7][4],
																municipio : $scope.planilha[7][5],
																emailSecundario : $scope.planilha[2][1],
																emailPrincipal : $scope.planilha[3][1],
																status : null,
																exceptions : null,
																importar : true,
																planilha : $scope.planilha

															};
															$scope.listaLaudos
																	.push($scope.laudo);
														}
													} else {
														if (vm
																.validateFile($scope.sheets[$scope.selectedSheetNameFolha].data)) {
															$scope.planilha = $scope.sheets[$scope.selectedSheetNameFolha].data;

															$scope.laudo = {
																numero : $scope.planilha[6][6],
																tipo : "Foliar",
																fazenda : $scope.planilha[6][2],
																municipio : $scope.planilha[6][3],
																emailPrincipal : $scope.planilha[2][1],
																emailSecundario : $scope.planilha[3][1],
																status : null,
																exceptions : null,
																importar : true,
																planilha : $scope.planilha
															};
															$scope.listaLaudos
																	.push($scope.laudo);
														}
													}

												});

							}

						}
						vm.addReport = function(indice) {
							reportService
									.insertReport(
											$scope.listaLaudos[indice].planilha)
									.then(
											function(data) {
												$scope.listaLaudos[indice].status = data.message;
												$scope.listaLaudos[indice].exceptions = data.exceptions;
												$scope.dynamic += 1;
												$log.debug(data);
											});
						}

						$scope.importarLaudos = function() {

							var item;

							$scope.dynamic = 0;

							for (item in $scope.listaLaudos) {
								if ($scope.listaLaudos[item].importar == true) {
									vm.addReport(item);
								}

							}
						}

						vm.validateFile = function(file) {

							var validFile = false;

							if (file[2][0] == "Email Cliente:"
									|| file[2][0] == "Email Solicitante:") {
								if (file[6][0] == "Lab" || file[5][0] == "Lab") {
									validFile = true;
								}
							}
							return validFile;
						}

					});

})();