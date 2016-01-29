(function() {
	'use strict';

	angular.module('analistaRural.layout').controller('NavbarController',
			NavbarController);

	NavbarController.$inject = ['$scope', '$location', 'config', 'logger' ];

	function NavbarController($scope, $location, config, logger) {

        var vm = this;
        
		vm.isCollapsed = false;

		vm.highlight = function(path) {
			return $location.path().substr(0, path.length) === path;
		};

		vm.loginOrOut = function() {
			setLoginLogoutText();
			var isAuthenticated = authService.user.isAuthenticated;
			if (isAuthenticated) { // logout
				authService.logout().then(function() {
					$location.path('/');
					return;
				});
			}
			redirectToLogin();
		};

		function redirectToLogin() {
			var path = '/login' + $location.$$path;
			$location.replace();
			$location.path(path);
		}

		$scope.$on('loginStatusChanged', function(loggedIn) {
			setLoginLogoutText(loggedIn);
		});

		$scope.$on('redirectToLogin', function() {
			redirectToLogin();
		});

		function setLoginLogoutText() {
			vm.loginLogoutText = (authService.user.isAuthenticated) ? 'Logout'
					: 'Login';
		}

		setLoginLogoutText();

	}
})();