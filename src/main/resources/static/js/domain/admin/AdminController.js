angular.
module('app').
controller('AdminController', ['AdminService', '$location', 'allLocations', function(AdminService, $location, allLocations) {
//	if (loggedInAdmin === false) {
//		$location.path('/home')
//	}
//	
	var ctrl = this
	ctrl.url = "/login"
	
	ctrl.locations = allLocations.data
	console.dir(ctrl.urls)
	
	ctrl.newLocation = function() {
		if (ctrl.name != null)
		var location = {
				"locationName" : ctrl.name,
				"locationDetails" : ctrl.details
		}
		AdminService.newLocation(location).then(function(result) {
			ctrl.message = result.data
			alert(ctrl.message.response)
		})
	}
}]);