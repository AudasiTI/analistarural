app.controller("importController",function($scope,$http){
	var url = "files/reports.txt";
	$http.get(url).success(function(response){
		$scope.reports = response;
	});

});

app.controller("reportsController",function($scope){

});