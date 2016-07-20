angular.module('app').controller('LoginUserController', ['LoginUserService', 'UserService', '$location', function(LoginUserService, UserService, $location) {
	
	UserService.viewLocation(0)
	
	var ctrl = this
	
	ctrl.userLogin = function() {
		var login = {
				"username" : ctrl.username,
				"password" : ctrl.password
		}
		LoginUserService.loginUser(login).then(function(result) {
			ctrl.message = result.data
			console.dir(ctrl.message)
			if (ctrl.message.response === "user") {
				var data = {
						"user" : login,
						"locationId" : 0
					}
					UserService.login(data)
			} else if (ctrl.message.response === "admin") {
				var data = {
						"user" : login,
						"locationId" : 0
					}
					UserService.login(data)
				loggedInAdmin = true
				$location.path("/admin")
			} else {
				alert("login failed!")
			}
		})
	}
	
} ])