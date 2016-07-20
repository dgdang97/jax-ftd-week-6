angular
.module('app')
.controller('UserController', ['UserService', '$routeParams', '$location', function(UserService, $routeParams, $location) {
	var ctrl = this
	ctrl.message = 'Welcome! Please login!'
	UserService.viewLocation($routeParams.id).then(function(result) {
		if (result.data.locationId != null) {
		ctrl.location = result.data
		console.dir(ctrl.location)
		} else {
			alert("Page not found. Returning to Homepage.")
			$location.path("/home")
		}
	})
	
	ctrl.login = function() {
		var locationLogin = {
				"user" : {
					"username" : ctrl.username,
					"password" : ctrl.password
				},
				"locationId" : $routeParams.id
		}
		UserService.login(locationLogin).then(function(result) {
			ctrl.data = result.data
			ctrl.message = ctrl.data.response
		})
	}
	
}]);