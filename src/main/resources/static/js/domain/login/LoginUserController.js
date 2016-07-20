angular.module('app').controller('LoginUserController', ['LoginUserService', '$location', function(LoginUserService, $location) {
	
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
				$location.path("/user")
			} else if (ctrl.message.response === "admin") {
				loggedInAdmin = true
				$location.path("/admin")
			} else {
				alert("login failed!")
			}
		})
	}
	
} ])