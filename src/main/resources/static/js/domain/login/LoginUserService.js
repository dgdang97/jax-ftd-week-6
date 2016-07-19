angular.
module('app').
service('LoginUserService', ['$http', function($http) {
	var url = 'user/'
	this.loginUser = function(user) { return $http.post(url + 'log', user) };
}])