angular
.module('app')
.controller('UserController', ['UserService', '$location', function(UserService, $location) {
	if (loggedIn === false) {
		$location.path('/home')
	}
}])