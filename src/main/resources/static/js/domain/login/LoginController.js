angular
.module('app')
.controller('LoginController', ['LoginService', '$routeParams', '$location', function(LoginService, $routeParams, $location) {
	var ctrl = this
	ctrl.message = 'Welcome! Please login!'

	LoginService.viewLocation($routeParams.id).then(function(result) {
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
			LoginService.login(locationLogin).then(function(result) {
				ctrl.data = result.data
				ctrl.message = ctrl.data.response
				console.dir(result.data)
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
				LoginService.newUser(user).then(function(result) {
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