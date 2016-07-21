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
	ctrl.views = ["Anonymous", "User", "Total"]
	ctrl.selectedView = "Total"
	ctrl.index = allLocations.data.length
		
	ctrl.selectView = function(view) {
		for (var i = 0; i < ctrl.index; i++) {
			document.getElementById(ctrl.selectedView + i).style.display = "none";
			document.getElementById(view + i).style.display = "table-cell";
		}
		ctrl.selectedView = view;
	}
		
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