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
						$scope.planilha = [];
						$scope.colunas = "";
						$scope.laudo = [];

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

						$scope.showPreviewChanged = function(files) {

							if ($scope.showPreview) {
								$scope.sheets = [];
								$scope.excelFile = files[0];
								$scope.showJSONPreview = false;
								$scope.isProcessing = true;
								XLSXReaderService.readFile($scope.excelFile,
										$scope.showPreview,
										$scope.showJSONPreview).then(
										function(xlsxData) {
											$scope.sheets = xlsxData.sheets;
											$scope.isProcessing = false;
											$scope.parserLaudos();
										});
							}

						}

						$scope.parserLaudos = function() {
							$scope.planilha = $scope.sheets[$scope.selectedSheetName].data;
							$scope.colunas = [ "Laudo", "Fazenda", "Município",
									"Data de Geração" ];
							$scope.laudo[0] = $scope.planilha[4][8];
							$scope.laudo[1] = $scope.planilha[4][4];
							$scope.laudo[2] = $scope.planilha[4][5];
							$scope.laudo[3] = $scope.planilha[4][2];

						}
					});

})();