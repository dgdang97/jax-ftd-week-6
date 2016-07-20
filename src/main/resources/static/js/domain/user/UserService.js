angular.module('app').service('UserService', [ '$http', function($http) {
	this.viewLocation = function(id) { return $http.post('viewLocation', id) }
	this.login = function(data) { return $http.post('login', data) }
	this.newUser = function(user) { return $http.post('newUser', user) }
}])
