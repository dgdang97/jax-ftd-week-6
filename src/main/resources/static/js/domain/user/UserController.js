angular
.module('app')
.controller('UserController', ['UserService', '$routeParams', '$location', function(UserService, $routeParams, $location) {
	var ctrl = this
	ctrl.message = 'Welcome! Please login!'

	UserService.viewLocation($routeParams.id).then(function(result) {
		if (result.data.locationId != null) {
		ctrl.location = result.data
		} else {
			alert("Page not found. Returning to Homepage.")
			$location.path("/home")
		}
	})
	
	ctrl.login = function() {
		if (loggedIn === false) {
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
				
				if (ctrl.data.response != null && ctrl.data.role == '1') {
					loggedInAdmin = true
					$location.path("/admin")
					loggedIn = true
				} else if (ctrl.data.response != null && ctrl.data.role != null) {
					loggedIn = true
				}
			})
		} else {
			ctrl.message = "You are already logged in!"
		}
	}
	
	ctrl.register = function() {
		if (loggedIn === false) {
			if (ctrl.username != null && ctrl.username != "" && ctrl.password != null && ctrl.password != "") {
				var user = {
						"username" : ctrl.username,
						"password" : ctrl.password,
						"locationId" : $routeParams.id
				}
				UserService.newUser(user).then(function(result) {
					ctrl.data = result.data
					alert(ctrl.data.response)
				})
			} else {
				alert("Please fill out the fields before attempting to register!")
			}
		} else {
			ctrl.message = "You are already logged in!"
		}
	}
}]);