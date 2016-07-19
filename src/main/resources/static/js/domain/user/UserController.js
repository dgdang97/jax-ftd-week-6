angular.
module('app').
controller('UserController', function() {
	if (loggedInUser === false) {
		$location.path('/home')
	}
});