(function() {

	var injectParams = [ '$http', '$rootScope', '$log' ];

	var authFactory = function($http, $rootScope, $log) {
		var serviceBase = '/api/', factory = {
			loginPath : 'login',
			user : {
				isAuthenticated : false,
				roles : null
			}
		};

		factory.login = function(email, password) {
			return $http.post(serviceBase + 'login', {
				userName : email,
				password : password

			}).then(function(results) {
				$log.debug(results.data);
				var loggedIn = results.data.status;

				changeAuth(loggedIn);
				return loggedIn;
			});
		};

		factory.logout = function() {
			return $http.post(serviceBase + 'logout').then(function(results) {
				var loggedIn = !results.data.status;
				changeAuth(loggedIn);
				return loggedIn;
			});
		};

		factory.redirectToLogin = function() {
			$rootScope.$broadcast('redirectToLogin', null);
		};

		function changeAuth(loggedIn) {
			factory.user.isAuthenticated = loggedIn;
			$rootScope.$broadcast('loginStatusChanged', loggedIn);
		}

		return factory;
	};

	authFactory.$inject = injectParams;

	angular.module('infoSoilAdmin').factory('authService', authFactory);

}());