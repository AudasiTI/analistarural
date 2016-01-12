(function() {

	'use strict';

	angular
			.module('infoSoilAdmin')
			.controller(
					'ImportReportController',
					function($scope, XLSXReaderService) {

						var vm = this;

						$scope.showPreview = true;
						$scope.showJSONPreview = false;
						$scope.json_string = "";
						$scope.selectedSheetName = "Planilha1";
						$scope.colunas = "";

						$scope.listaLaudos = [];

						$scope.fileChanged = function(files) {
							$scope.isProcessing = true;
							$scope.sheets = [];
							$scope.excelFile = files[0];
							XLSXReaderService.readFile($scope.excelFile,
									$scope.showPreview, $scope.showJSONPreview)
									.then(function(xlsxData) {
										$scope.sheets = xlsxData.sheets;
										$scope.isProcessing = false;
									});

						}

						$scope.updateJSONString = function() {

							$scope.json_string = JSON.stringify(
									$scope.sheets[$scope.selectedSheetName],
									null, 2);
						}

						// $scope.showPreviewChanged = function(files) {
						//
						// if ($scope.showPreview) {
						// $scope.sheets = [];
						// $scope.excelFile = files[0];
						// $scope.showJSONPreview = false;
						// $scope.isProcessing = true;
						// XLSXReaderService.readFile($scope.excelFile,
						// $scope.showPreview,
						// $scope.showJSONPreview).then(
						// function(xlsxData) {
						// $scope.sheets = xlsxData.sheets;
						// $scope.isProcessing = false;
						// $scope.parserLaudos();
						// });
						// }
						//
						// }

						$scope.showPreviewChanged2 = function(files) {

							if ($scope.showPreview) {
								$scope.sheets = [];
								$scope.showJSONPreview = false;
								$scope.isProcessing = true;
								$scope.colunas = [ "Laudo", "Fazenda",
										"Município", "Data de Geração",
										"Importar", "Status" ];

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
														$scope.laudo = {
															numero : $scope.planilha[4][8],
															fazenda : $scope.planilha[4][4],
															municipio : $scope.planilha[4][5],
															geracao : $scope.planilha[4][2],
															impotar : true,
															status : ""
														};

														$scope.listaLaudos
																.push($scope.laudo);

													});

								}

							}
						}
						$scope.reportParser = function(file) {

						}
					});

})();