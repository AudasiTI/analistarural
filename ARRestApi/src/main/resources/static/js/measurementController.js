

//function measurementController($scope,$http,$routeParams,$location)
$app.controller("measurementController",function ($scope,$http,$routeParams,$location) {
	
	
	// lista de measurement
	$scope.rows = null;

	// um measurement
	$scope.row = null;

	// Pagination
	$scope.currentPage = 0;
	$scope.pageSize = 15;

	$scope.numberOfPages =function(){
		return Math.ceil($scope.rows.length/$scope.pageSize);                
	}

	// método de carregamento
	$scope.loadAll = function(){
		$scope.showLoader();
		// Measurement.query(function (data))
		$http.get($scope.server("/measurements")).success(function(data){
			$scope.rows = data;	
			$scope.hideLoader();
		});
	};

	$scope.loadRow = function() {
		if ($routeParams.id != null) {
			$scope.showLoader();
			$http.get($scope.server("/measurement/" + $routeParams.id))
					.success(function(data) {
						$scope.row = data;
						// $scope.row.isUpdate = true;
						$scope.hideLoader();
					});
		} else {
			$scope.row = {}
			$scope.row.idMeasurement = null;
			// $scope.row.isUpdate = false;
			$scope.hideLoader();
		}
	}
	
	$scope.save = function(){
		$scope.showLoader();
		$http.post($scope.server("/measurement/"),$scope.row).success(function(data){
			alert("Salvo com sucesso");
// $scope.row.isUpdate = true;
			$scope.hideLoader();
			$location.path("/measurements");
		});
	}

	$scope.del = function(){
		if (confirm("Deseja excluir a unidade " + $scope.row.name + "?")){
			$http.delete($scope.server("/measurements/"+$routeParams.id)).success(function(s){
				$scope.hideLoader();
				alert("Excluído com sucesso");
				$location.path("/measurements");
			});
		}
	}
 
});
