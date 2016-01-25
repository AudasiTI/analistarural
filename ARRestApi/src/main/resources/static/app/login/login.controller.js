(function() {

	var injectParams = [ '$location', '$routeParams', 'authService', '$log'];

	var LoginController = function($location, $routeParams, authService, $log) {
		var vm = this, path = '/';

		vm.email = null;
		vm.password = null;
		vm.errorMessage = null;

		vm.login = function() {
			authService.login(vm.email, vm.password).then(function(status) {
				if (!status) {
					vm.errorMessage = 'Unable to login';
					return;
				}

				if (status && $routeParams && $routeParams.redirect) {
					path = path + $routeParams.redirect;
				}

				$location.path(path);
			});
		};
	};

	LoginController.$inject = injectParams;

	angular.module('infoSoilAdmin').controller('LoginController',
			LoginController);

}());