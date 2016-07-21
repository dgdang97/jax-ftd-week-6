angular
.module('app')
.service('AdminService',['$http', function($http) {
	this.getAllLocations = function() { return $http.get('allLocations') }
	this.newLocation = function(location) { return $http.post('newLocation', location)}
	this.getViewTimes = function() { return $http.get('allViewTimes') }
}])